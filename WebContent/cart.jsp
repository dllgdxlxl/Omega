<%--
  Created by IntelliJ IDEA.
  User: hmy
  Date: 2017/7/16
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="cn.ssdut.omega.entity.*"%>
<%@ page import="cn.ssdut.omega.management.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/bootstrap2.css" rel="stylesheet" type="text/css" media="all" />
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery2.min.js"></script>
    <!-- Custom Theme files -->
    <!--theme-style-->
    <link href="css/style2.css" rel="stylesheet" type="text/css" media="all" />
    <!--//theme-style-->
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>


        <style type="text/css">
            .pos_input{position:absolute;left:800px;top:80px}
            .pos_search{position:absolute;left:1130px;top:80px}
            .kuan input{ width:330px; height:35px; background:white no-repeat; border:none; float:left }
            .an input{ width:120px; height:35px;  background:black no-repeat; color:white; border:none;  float:left}

            #me_list{
                padding-top:80px;
                padding-bottom:39px;
            }

            #me_list li{
                display: inline;
                font-weight:800;
                font-size:42px;
                margin: 70px;
            }

            #me_list li a{
                display: inline;
                line-height:72px;
                color:#404040;
                /*margin: 50px;*/
            }

            #me_list li.nav-active a{
                text-decoration:none;
                color:#fb5353;
            }

            .dropbtn {
                background: none;
                color: #404040;
                padding: 0px;
                font-size: 42px;
                border: none;
                cursor: pointer;
            }

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: white;
                min-width: 150px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            }

            .dropdown-content a {
                color: black;
                padding: 16px 24px;
                text-decoration: none;
                display: block;
            }

            .dropdown-content a:hover {background-color: #f1f1f1}

            .dropdown:hover .dropdown-content {
                display: block;
            }

            .dropdown:hover .dropbtn {
                background: none;
            }


            h1.pos_fixed
            {
                position:relative;
                /*width: 50%;
                height: 50%;*/
                top:60px;
                left:40px;
            }

            div.pos_fixed_d{
                position:relative;
                width: 40%;
                height: 40%;
                top:65px;
                left:700px;
                /*float: right;*/
            }

            div.pos_fixed_i{
                position:relative;
                width: 40%;
                height: 40%;
                top:80px;
                left:700px;
            }

            .div{
                /*padding-top: 20px;
                opacity: 0.2;*/
                /*width: 40%;
                height: 40%;*/
                /*float: right;*/
                left: 10px;
                position: relative;
                padding-top: 20px;
            }

            .div_h{
                /*padding-top: 20px;
                opacity: 0.2;*/
                /*width: 40%;
                height: 40%;*/
                /*float: right;*/
                left: 10px;
                /*position: relative;*/
                padding-top: 20px;
                /*color: #0d0d0d;*/
                font-size: medium;
            }

        </style>


        <title>Cart-Omega</title>

        <link rel="shortcut icon" href="images/logo1.png" width=70px height=50px type="image/x-icon">

        <!-- 搜索框 -->
        <link rel="stylesheet" href="http://s4.ui.cn/fonts/iconfont.css?v=1500208402">
        <%--<link rel="stylesheet" href="http://s4.ui.cn/css/all/uicn.v1.css?v=1500208402">--%>
        <%--<link rel="stylesheet" href="http://s4.ui.cn/css/all/footer.v1.css?v=1500208402">--%>
        <link rel="stylesheet" href="http://s4.ui.cn/css/all/nivo-slider.css?v=1500208402">
        <link rel="stylesheet" href="http://s4.ui.cn/css/all/modal.css?v=1500208402">
        <link rel="stylesheet" href="http://s4.ui.cn/css/all/post.css?v=1500208402">

        <link href="css/header.v1.css" rel="stylesheet" type="text/css"/>



        <!-- style -->

        <link href="css/style_code9.css" rel="stylesheet" type="text/css">

        <!-- style -->

        <!-- bootstrap -->

        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

        <!-- responsive -->

        <link href="css/responsive.css" rel="stylesheet" type="text/css">

        <!-- font-awesome -->

        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- font-awesome -->

        <link href="css/effects/set2.css" rel="stylesheet" type="text/css">

        <link href="css/effects/normalize.css" rel="stylesheet" type="text/css">

        <link href="css/effects/component.css"  rel="stylesheet" type="text/css" >



        <!-- JS -->
        <script src="http://s3.ui.cn/js/jquery.js?v=1500208402"></script>
        <script src="http://s3.ui.cn/js/msgTip.js?v=1500208402"></script>
        <script src="http://s3.ui.cn/js/home/header.v1.js?v=1500208402"></script>
        <script src="http://s3.ui.cn/js/home/home.v1.js?v=1500208402"></script>
        <script src="http://s3.ui.cn/js/home/works.js?v=1500208402"></script>

        <script src="http://s3.ui.cn/js/home/footer.v1.js?v=1500208402"></script>
        <script src="http://s3.ui.cn/js/home/post.js?v=1500208402"></script>

        <script src="http://s3.ui.cn/js/LazyLoad.js?v=1500208402"></script>
        <script src="http://s3.ui.cn/js/contentover.js?v=1500208402"></script>
        <script src="/Public/js/cnzz.js?v=1500208402"></script>



    <!--fonts-->
    <link href='https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
    <!-- start menu -->
    <link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/memenu.js"></script>
    <script>$(document).ready(function(){$(".memenu").memenu();});</script>
    <script src="js/simpleCart.min.js"> </script>

</head>

<body>
<header role="header">
    <div class="container">
        <h1 class="pos_fixed">
            <a href="main.jsp" title="Omega"><img src="images/logo1.png" width=70px height=50px title="Omega" alt="Omega"/></a>
        </h1>
       <div style="position:absolute;font-size:15px;padding-top:0px;margin-left:720px;margin-top:85px">
         <form action="GoodsList.jsp">
        <input type="text" style="height:25px;float:left;"name="content">
       <input type="submit" style="background-color:gray;margin-left:10px;padding:4px" value="搜索">
        </form>
        </div>
        <div style="position:absolute;float:left;margin-top:85px;font-size:17px; margin-left:970px">
        <%
         String type=(String)session.getAttribute("type");
        if(type==null||type.length()==0){
        	%>
         <a  href="login.jsp">Login</a>|
        <a  href="register.jsp">Register</a>
        	<%
        }else{%>
       <a href='<s:url action="logout"/>'>Logout</a>|
        <a href="myorder.jsp">Order</a>
        <% 
        }
        %>
        </div>
        <div id="me_list">
            <nav  class="navy">
                <ul>
                    <li><a href="main.jsp">Home</a></li>
                    <li><a href="recommend.jsp">Recommendation List</a></li>
                    <li ><a href="GoodsList.jsp">Good List</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<form name='form1'>
    <div class="container">

        <div class="check">
            <h1>My Shopping Cart</h1>
            <div class="col-md-9 cart-items">
</form>
<form name='form1'>
    <div class="cart-header">
        <div class="close1"> </div>
        <div class="cart-sec simpleCart_shelfItem">
<%
User_Omega user = (User_Omega)session.getAttribute("user");
double cost=0;
if(user!=null){
 CartManagement_Omega cartmanage = new CartManagement_Omega();
  Cart_Omega cart =cartmanage.findByUserId(user.getId());
  if(cart==null){
	  cart= new Cart_Omega();
	  cart.setCost(0);
	  cart.setUser(user);
	  cartmanage.buildCart(cart);
  }
cart.setUpdateState(1);
List<Product_Omega> products = cart.getProducts();
if(products!=null&&products.size()>0){
	for(Product_Omega product:products){
		cost=cost+product.getNum()*product.getPrice();
%>
            <div class="cart-item cyc">
                <img src="./upload/<%=product.getImg_id() %>.jpg" class="img-responsive" alt=""/>

            </div>
            <div class="cart-item-info">

                <h3><%=product.getName() %><span>Model No: <%=product.getId() %></span></h3>
                <input type='checkbox' name='VoteOption1' value=1>
                <ul class="qty">
                    <li><p>Price : <%=product.getPrice() %></p></li>
                    <li><p>Num : <%=product.getNum() %></p></li>
                </ul>

                <div class="delivery">
                    <p>Service Charges : Rs.100.00</p>
                    <span style="font-color:black;background-color:white">
                    <form action="deleteProduct">
<input type="hidden" value="" name="id">
<input type="submit" style="font-color:black;font-size:20px;background-color:white"value="Delete"> </form></span>

                    <div class="clearfix"></div>
                </div>
            </div>

<%} }}%>
            <div class="clearfix"></div>

        </div>
    </div>
    </div>
</form>
<div class="col-md-3 cart-total">
    <a class="continue" href="main.jsp">Continue to shopping</a>
    <div class="price-details">
        <h3>Price Details</h3>
        <span>Total</span>
        <span class="total1"><%=cost %></span>
        <span>Discount</span>
        <span class="total1">---</span>
        <span>Delivery Charges</span>
        <span class="total1">150.00</span>
        <div class="clearfix"></div>
    </div>
    <ul class="total_price">
        <li class="last_price"> <h4>TOTAL</h4></li>
        <li class="last_price"><span><%=cost %></span></li>
        <div class="clearfix"> </div>
    </ul>


    <div class="clearfix"></div>
    <a class="order" href="payOff">PayOff</a>
</div>

<div class="clearfix"> </div>
</div>
</div>


<!--//content-->
<footer role="footer">

    <!-- logo -->

    <h1>
        <a href="Shopping_List.jsp" title="avana LLC"><img src="images/logo1.png" width="70" height="50" title="avana LLC" alt="avana LLC"/></a>
    </h1>

    <!-- logo -->

    <!-- nav -->

    <nav role="footer-nav">

        <ul>

            <li class="nav-active"><a href="index.html" title="Work">Login</a></li>

            <li><a href="blog.html" title="Blog">recommendation</a></li>

            <li><a href="about.html" title="About">about</a></li>

            <li><a href="contact.html" title="Contact">Contact</a></li>

        </ul>

    </nav>

    <!-- nav -->

    <ul role="social-icons">

        <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>

        <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>

        <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>

        <li><a href="#"><i class="fa fa-flickr" aria-hidden="true"></i></a></li>

    </ul>

    <p class="copy-right">&copy; 2017  Omega.. All rights Resved.More Templates <a href="about.jsp" target="_blank" title="欧米伽">欧米伽</a> - Collect from <a href="http://www.cssmoban.com/" title="SSDUT" target="_blank">SSDUT</a></p>

</footer>




<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<script src="js/jquery.min.js" type="text/javascript"></script>

<!-- custom -->

<script src="js/nav.js" type="text/javascript"></script>

<script src="js/custom.js" type="text/javascript"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->

<script src="js/bootstrap.min.js" type="text/javascript"></script>

<script src="js/effects/masonry.pkgd.min.js"  type="text/javascript"></script>

<script src="js/effects/imagesloaded.js"  type="text/javascript"></script>

<script src="js/effects/classie.js"  type="text/javascript"></script>

<script src="js/effects/AnimOnScroll.js"  type="text/javascript"></script>

<script src="js/effects/modernizr.custom.js"></script>

<!-- jquery.countdown -->

<script src="js/html5shiv.js" type="text/javascript"></script>



</body>
</html>

