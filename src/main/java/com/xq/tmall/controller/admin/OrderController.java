package com.xq.tmall.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xq.tmall.controller.BaseController;
import com.xq.tmall.entity.ProductOrder;
import com.xq.tmall.service.AddressService;
import com.xq.tmall.service.ProductOrderItemService;
import com.xq.tmall.service.ProductOrderService;
import com.xq.tmall.service.UserService;
import com.xq.tmall.util.OrderUtil;
import com.xq.tmall.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 后台管理-订单页
 */
@Controller
public class OrderController extends BaseController{
    @Resource(name="productOrderService")
    private ProductOrderService productOrderService;
    @Resource(name = "addressService")
    private AddressService addressService;
    @Resource(name="userService")
    private UserService userService;
    @Resource(name = "productOrderItemService")
    private ProductOrderItemService productOrderItemService;

    //转到后台管理-订单页-ajax
    @RequestMapping("admin/order")
    public String goToPage(HttpSession session, Map<String, Object> map){
        logger.info("检查管理员权限");
        Object adminId = checkAdmin(session);
        if(adminId == null){
            return null;
        }

        logger.info("获取前10条订单列表");
        List<ProductOrder> productOrderList=productOrderService.getList(null,null,null,new PageUtil(1,10));
        map.put("productOrderList",productOrderList);
        logger.info("获取订单总数量");
        Integer productOrderCount = productOrderService.getTotal(null, null);
        map.put("productOrderCount", productOrderCount);

        logger.info("转到后台管理-订单页-ajax方式");
        return "admin/orderManagePage";
    }

    //转到后台管理-订单详情页-ajax
    @RequestMapping("admin/order/{oid}")
    public String getOrderByOid(HttpSession session,Map<String, Object> map, @PathVariable Integer oid/* 订单ID */){
        logger.info("检查管理员权限");
        Object adminId = checkAdmin(session);
        if(adminId == null){
            return null;
        }

        logger.info("获取order_id为{}的订单信息",oid);
        ProductOrder order = productOrderService.get(oid);
        logger.info("获取订单详情-地址信息");
        order.setProductOrder_address(addressService.get(order.getProductOrder_address().getAddress_areaId()));
        logger.info("获取订单详情-用户信息");
        order.setProductOrder_user(userService.get(order.getProductOrder_user().getUser_id()));
        logger.info("获取订单详情-订单项信息");
        order.setProductOrderItemList(productOrderItemService.getListByOrderId(oid,new PageUtil(1,5)));
        map.put("order",order);

        logger.info("转到后台管理-订单详情页-ajax方式");
        return "admin/include/orderDetails";
    }

    //按条件查询订单-ajax
    @ResponseBody
    @RequestMapping(value = "admin/order/{index}/{count}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getOrderBySearch(@RequestParam(required = false) String productOrder_code/* 订单号 */,
                                   @RequestParam(required = false) String productOrder_post/* 订单邮政编码 */,
                                   @RequestParam(required = false) Byte[] productOrder_status_array/* 订单状态数组 */,
                                   @RequestParam(required = false) String orderBy/* 排序字段 */,
                                   @RequestParam(required = false,defaultValue = "true") Boolean isDesc/* 是否倒序 */,
                                   @PathVariable Integer index/* 页数 */,
                                   @PathVariable Integer count/* 行数 */){
        //移除不必要条件
        if (productOrder_status_array != null && (productOrder_status_array.length <= 0 || productOrder_status_array.length >=5)) {
            productOrder_status_array = null;
        }
        if (productOrder_code != null){
            productOrder_code = productOrder_code.equals("") ? null : productOrder_code;
        }
        if(productOrder_post != null){
            productOrder_post = productOrder_post.equals("") ? null : productOrder_post;
        }
        if(orderBy != null && orderBy.equals("")){
            orderBy = null;
        }
        //封装查询条件
        ProductOrder productOrder = new ProductOrder()
                .setProductOrder_code(productOrder_code)
                .setProductOrder_post(productOrder_post);
        OrderUtil orderUtil = null;
        if (orderBy != null) {
            logger.info("根据{}排序，是否倒序:{}",orderBy,isDesc);
            orderUtil = new OrderUtil(orderBy, isDesc);
        }

        JSONObject object = new JSONObject();
        logger.info("按条件获取第{}页的{}条订单",index,count);
        List<ProductOrder> productOrderList = productOrderService.getList(productOrder,productOrder_status_array,orderUtil,new PageUtil(1,10));
        object.put("productOrderList", JSONArray.parseArray(JSON.toJSONString(productOrderList)));
        logger.info("按条件获取订单总数量");
        Integer productOrderCount = productOrderService.getTotal(productOrder, productOrder_status_array);
        object.put("productOrderCount", productOrderCount);

        return object.toJSONString();
    }

    //根据order_id更新订单
    @ResponseBody
    @RequestMapping(value = "admin/order/{order_id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public String OrderUpdate(@PathVariable("order_id") String order_id) {

        logger.info("创建order_id为{}的订单对象", order_id);
        ProductOrder productOrder = new ProductOrder()
                .setProductOrder_id(Integer.valueOf(order_id))
                .setProductOrder_status((byte) 2);

        logger.info("订单更新中...");
        JSONObject jsonObject = new JSONObject();
        if (productOrderService.update(productOrder)) {
            jsonObject.put("success", true);
            logger.info("订单更新成功！");
        } else {
            logger.info("订单更新失败！");
            jsonObject.put("success", false);
        }
        return jsonObject.toJSONString();
    }
}
