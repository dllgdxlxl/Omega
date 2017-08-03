<%--
  Created by IntelliJ IDEA.
  User: hmy
  Date: 2017/7/16
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@page import="cn.ssdut.omega.management.*"%>
<%@page import="cn.ssdut.omega.entity.*"%>
<%@page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>

<html>

<head>

    <title>Recommend-Omega</title>

    <link rel="shortcut icon" href="images/logo1.png" width="70" height="50" type="image/x-icon">



    <!-- style -->

    <link href="css/style_code9.css" rel="stylesheet" type="text/css">

    <!-- style -->

    <!-- bootstrap -->

    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- responsive -->

    <link href="css/responsive.css" rel="stylesheet" type="text/css">

    <!-- font-awesome -->

    <link href="css/fonts.css" rel="stylesheet" type="text/css">

    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- font-awesome -->

    <link href="css/effects/normalize.css" rel="stylesheet" type="text/css">

    <link href="css/effects/component.css"  rel="stylesheet" type="text/css" >


    <style>

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
            top:60px;
            left:40px;
        }

    </style>




</head>



<body>



<!-- header -->

<header role="header">

    <div class="container">

        <!-- logo -->

        <h1 class="pos_fixed">

            <a href="main.jsp" title="Omega"><img src="images/logo1.png" width=70px height=50px title="Omega" alt="Omega"/></a>

        </h1>

        <!-- logo -->

        <!-- nav -->

        <div id="me_list">
            <nav  class="navy">
                <ul>

                    <li class="active"><a href="main.jsp">Home</a></li>

                    <li><a href="recommend.jsp">Recommendation List</a></li>

                    <li><a href="GoodsList.jsp">Good List</a></li>

                </ul>
            </nav>

        </div>

        <!-- nav -->

    </div>

</header>

<!-- header -->

<!-- main -->

<main role="main-inner-wrapper" class="container">



    <div class="row">



        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 ">

            <article role="pge-title-content" class="blog-header">

                <header>

                    <h2><span>Goods</span> Recommended By Omega</h2>

                </header>

                <p>Get all information about our goods from latest page.</p>

            </article>

            <ul class="grid-lod effect-2" id="grid">
            <%
              ProductManagement_Omega management = new ProductManagement_Omega();
              List<Product_Omega> products =management.findPopularProducts(20);
              for(int i=0;i<products.size()/2;i++){
               Product_Omega product=products.get(i);
            %>
                      <li>

                    <section class="blog-content">

                        <a href="product_details.jsp?id=<%=product.getId()%>">

                            <figure>

                                <div class="post-date">

                                    <span>18</span> July 2017

                                </div>

                                <img src="./upload/<%=product.getImg_id()%>.jpg" alt="" class="img-responsive"/>

                            </figure>

                        </a>

                        <article>

                            <%=product.getName()%>
                            <br/>
                            <%=product.getDescription() %>

                        </article>

                    </section>

                </li>
            
            <% }%>
     
            </ul>

        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">

              <ul class="grid-lod effect-2" id="grid">
            <%
            for(int i=products.size()/2+1;i<products.size();i++){
                Product_Omega product=products.get(i);
            %>
                      <li>

                    <section class="blog-content">

                        <a href="product_details.jsp?id=<%=product.getId()%>">

                            <figure>

                                <div class="post-date">

                                    <span>18</span> July 2017

                                </div>

                                <img src="./upload/<%=product.getImg_id()%>.jpg" alt="" class="img-responsive"/>

                            </figure>

                        </a>

                        <article>

                            <%=product.getName()%>
                            <br/>
                            <%=product.getDescription() %>

                        </article>

                    </section>

                </li>
            
            <% }%>
     
            </ul>
        </div>
    </div>

</main>

 <footer role="footer">
            <nav role="footer-nav">
            	<ul>
                	<li><a href="index.jsp" title="Work">Work</a></li>
                    <li><a href="about.jsp" title="About">About</a></li>
                    <li><a href="http://blog.csdn.net/dllgdxlxl" title="Blog">Blog</a></li>
                    <li><a href="http://www.ssdut.cn" title="Contact">Contact</a></li>
                </ul>
            </nav>
            <ul role="social-icons">
            	<li><a href="#" ><i class="fa fa-twitter" aria-hidden="true"  style="margin-top:10px"></i></a></li>
                <li><a href="#"><i class="fa fa-facebook" aria-hidden="true" style="margin-top:10px"></i></a></li>
                <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"  style="margin-top:10px"></i></a></li>
                <li><a href="#"><i class="fa fa-flickr" aria-hidden="true"  style="margin-top:10px"></i></a></li>
            </ul>
            <p class="copy-right">&copy; 2017  Omega. All rights Resved.More Information <a href="http://www.ssdur.cn" target="_blank" title="ssdut">Java进修小分队</a>
        </footer>
<!-- footer -->



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
