# 在线鞋城
### 源文件
本平台是改编自贤趣所制作的天猫电商平台
### 介绍
在线鞋城是一个基于Spring Boot的综合性B2C电商平台，需求设计主要参考天猫商城的购物流程：用户从注册开始，到完成登录，浏览商品，加入购物车，进行下单，确认收货，评价等一系列操作。
作为迷你天猫商城的核心组成部分之一，鞋城数据管理后台包含商品管理，订单管理，类别管理，用户管理和交易额统计等模块，实现了对整个商城的一站式管理和维护。

所有页面均兼容IE10及以上现代浏览器。

### 部署方式
1. 项目使用IntelliJ IDEA开发，请使用IntelliJ IDEA的版本控制检出功能，输入“<https://gitee.com/li-yusheng1/online-shoe-city.git>”拉取项目即可。
2. 项目数据库为MySQL 5.7.9版本，在**sqls文件夹**中找到SQL文件并导入到数据库中。
3. 使用IDEA打开项目后，在maven面板刷新项目，下载依赖包。
4. 配置数据库连接并启动SpringBootApplication即可。

### 项目默认运行地址
+ 前台地址：<http://localhost:8080/tmall>
+ 后台地址：<http://localhost:8080/tmall/admin>

### 注意事项：
1. 后台管理界面的订单图表没有数据为正常现象，该图表显示的为近7天的交易额。
2. 该项目同时兼容eclipse，但如有自行扩展代码的意愿，建议使用IDEA。
3. 该项目是北京软通动力实训项目，用较少的代码实现一个完整MVC模式，Spring Boot体系的电商项目，相关领域大神们可以给我们建议，让我们做得更好。

### 项目界面
+ ##### 后台界面(部分)---
![主页](src\main\webapp\res\images\dome\主页.jpg)
![所有产品](src\main\webapp\res\images\dome\所有产品.jpg)
![产品详情](src\main\webapp\res\images\dome\产品详情.jpg)
![产品分类](src\main\webapp\res\images\dome\产品分类.jpg)
![分类详情](src\main\webapp\res\images\dome\分类详情.jpg)
![用户管理](src\main\webapp\res\images\dome\用户管理.jpg)
![用户详情](src\main\webapp\res\images\dome\用户详情.jpg)
![订单列表](src\main\webapp\res\images\dome\订单列表.jpg)
![订单详情](src\main\webapp\res\images\dome\订单详情.jpg)
![我的账户](src\main\webapp\res\images\dome\我的账户.jpg)
+ ##### 前台界面(部分)---
![登陆界面](src\main\webapp\res\images\demo2\登陆页面.jpg)
![首页](src\main\webapp\res\images\demo2\首页.jpg)
![产品详情](src\main\webapp\res\images\demo2\产品详情.jpg)
![下单界面](src\main\webapp\res\images\demo2\下单页面.jpg)
![订单列表](src\main\webapp\res\images\demo2\订单页面.jpg)
![确认收货](src\main\webapp\res\images\demo2\确认收货.jpg)
![产品列表](src\main\webapp\res\images\demo2\产品列表.jpg)
![购物车](src\main\webapp\res\images\demo2\购物车.jpg)

### 作者的话

首先感谢您看到这里

本项目是我担任组长与组员一起根据贤趣做的天猫商城完成的一个在线鞋城商城demo

前后台业务代码，做了大部分的修改，后台是贤趣专门设计的样式，前台是参考天猫自行开发界面

非常感谢贤趣提供了一个模板供我们学习和借鉴# Zxxc
