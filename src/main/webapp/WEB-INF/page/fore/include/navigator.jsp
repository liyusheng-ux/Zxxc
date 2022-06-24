<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/fore/fore_nav.css"/>
<script>
    $(function () {
        $(".quick_li").find("li").hover(
            function () {
                $(this).find(".sn_menu").addClass("sn_menu_hover");
                $(this).find(".quick_menu,.quick_qrcode,.quick_DirectPromoDiv,.quick_sitmap_div").css("display", "block");
            }, function () {
                $(this).find(".sn_menu").removeClass("sn_menu_hover");
                $(this).find(".quick_menu,.quick_qrcode,.quick_DirectPromoDiv,.quick_sitmap_div").css("display", "none");
            }
        );
    });
</script>
<div id="nav">
    <div class="nav_main">
        <p id="container_login">
            <c:choose>
                <c:when test="${requestScope.user.user_name==null}">
                    <em>嘿，欢迎来到在线鞋城</em>
                    <a href="${pageContext.request.contextPath}/login">请登录</a>
                    <a href="${pageContext.request.contextPath}/register">免费注册</a>
                    <a href="https://gitee.com/li-yusheng1/Zxxc.git">码云项目地址</a>
                </c:when>
                <c:otherwise>
                    <em>Hi，</em>
                    <a href="${pageContext.request.contextPath}/userDetails" class="userName"
                       target="_blank">${requestScope.user.user_name}</a>
                    <a href="${pageContext.request.contextPath}/login/logout">退出</a>
                </c:otherwise>
            </c:choose>
        </p>
        <ul class="quick_li">
            <li class="quick_li_MyTaobao">
                <div class="sn_menu">
                    <a href="${pageContext.request.contextPath}/userDetails">我的鞋城<b></b></a>
                    <div class="quick_menu">
                        <a href="${pageContext.request.contextPath}/order/0/10">已买到的宝贝</a>
                        <a href="#">已卖出的宝贝</a>
                    </div>
                </div>
            </li>
            <li class="quick_li_cart">
                <img src="${pageContext.request.contextPath}/res/images/fore/WebsiteImage/buyCar.png">
                <a href="${pageContext.request.contextPath}/cart">购物车</a>
            </li>
            <li class="quick_li_menuItem">
                <div class="sn_menu">
                    <a href="#">收藏夹<b></b></a>
                    <div class="quick_menu">
                        <a href="#">收藏的宝贝</a>
                        <a href="#">收藏的店铺</a>
                    </div>
                </div>
            </li>
            <li class="quick_li_separator"></li>
            <li class="quick_li_mobile">
                <img src="${pageContext.request.contextPath}/res/images/fore/WebsiteImage/mobile.png">
                <a href="#" title="天猫无线">手机版</a>
                <div class="quick_qrcode">
                    <b></b>
                </div>
            </li>
            <li class="quick_home"><a href="${pageContext.request.contextPath}">鞋城网</a></li>
            <li class="quick_DirectPromo">
                <div class="sn_menu">
                    <a href="#">商家支持<b></b></a>
                    <div class="quick_DirectPromoDiv">
                        <ul>
                            <li>
                                <h3>商家：</h3>
                                <a href="">商家中心</a>
                                <a href="">商家入驻</a>
                                <a href="">运营服务</a>
                                <a href="">商家品控</a>
                                <a href="">商家工具</a>
                            </li>
                            <li>
                                <h3>帮助：</h3>
                                <a href="">帮助中心</a>
                                <a href="">问鞋友</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </li>
            <li class="quick_sitemap">
                <div class="sn_menu">
                    <a>网站导航<b></b></a>
                    <div class="quick_sitmap_div">
                        <div class="site-hot">
                            <h2>热点推荐<span>Hot</span></h2>
                            <ul>
                                <li><a href="">特步</a></li>
                                <li><a href="">安踏</a></li>
                                <li><a href="">李宁</a></li>
                                <li><a href="">乔丹</a></li>
                                <li><a href="">361°</a></li>
                                <li><a href="">回力</a></li>
                                <li><a href="">花花公子</a></li>
                                <li><a href="">木林森</a></li>
                                <li><a href="">阿迪达斯</a></li>
                                <li><a href="">鸿星尔克</a></li>
                                <li><a href="">JEEP</a></li>
                                <li><a href="">卡帝乐鳄鱼</a></li>
                                <li><a href="">红蜻蜓</a></li>
                                <li><a href="">彪马</a></li>
                                <li><a href="">匹克</a></li>
                            </ul>
                        </div>
                        <div class="site-market">
                            <h2>品牌市场<span>Market</span></h2>
                            <ul>
                                <li><a href="">特步</a></li>
                                <li><a href="">安踏</a></li>
                                <li><a href="">李宁</a></li>
                                <li><a href="">乔丹</a></li>
                                <li><a href="">361°</a></li>
                                <li><a href="">回力</a></li>
                                <li><a href="">花花公子</a></li>
                                <li><a href="">木林森</a></li>
                                <li><a href="">阿迪达斯</a></li>
                                <li><a href="">鸿星尔克</a></li>
                                <li><a href="">JEEP</a></li>
                                <li><a href="">卡帝乐鳄鱼</a></li>
                                <li><a href="">红蜻蜓</a></li>
                                <li><a href="">彪马</a></li>
                                <li><a href="">匹克</a></li>
                            </ul>
                        </div>
                        <div class="site-brand">
                            <h2>品牌风尚<span>Brand</span></h2>
                            <ul>
                                <li><a href="">尚鞋城</a></li>
                                <li><a href="">大牌街</a></li>
                                <li><a href="">潮牌街</a></li>
                                <li><a href="">什么牌子好</a></li>
                            </ul>
                        </div>
                        <div class="site-help">
                            <h2>服务指南<span>Help</span></h2>
                            <ul>
                                <li><a href="">帮助中心</a></li>
                                <li><a href="">品质保障</a></li>
                                <li><a href="">特色服务</a></li>
                                <li><a href="">7天退换货</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>