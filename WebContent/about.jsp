<%--
  Created by IntelliJ IDEA.
  User: hmy
  Date: 2017/7/16
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>

<html>

<head>

    <%--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />--%>

    <%--<meta charset="utf-8">--%>

    <%--<!-- Description, Keywords and Author -->--%>

    <%--<meta name="description" content="">--%>

    <%--<meta name="author" content="">--%>



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



    <title>:: OMEGA ::</title>

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
        <a href="information.jsp">Info</a>
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
<!-- header -->

<!-- main -->

<main role="main-inner-wrapper" class="container">



    <div class="row">



        <section class="col-xs-12 col-sm-6 col-md-6 col-lg-6 ">

            <article role="pge-title-content">

                <header>

                    <h2><span>We Do</span> What we love to do.</h2>

                </header>

                <p>The group consists of five members for development work.</p>

            </article>

        </section>



        <section class="col-xs-12 col-sm-6 col-md-6 col-lg-6">

            <article class="about-content">

                <p>Leader:1511 Kevin Lee</br>
                    Team members:1511 Minyang Hu</br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1504(Japanese class) Annie An</br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1511 Jiaqi Xiao</br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1511 Xiao Ma</br></p>

            </article>

        </section>



        <div class="clearfix"></div>



        <!-- thumbnails -->

        <div class="thumbnails-pan">

            <section class="col-xs-12 col-sm-4 col-md-4 col-lg-4 ">

                <figure>

                    <img src="images/about-images/about-image-1.jpg" class="img-responsive"/>

                    <figcaption>

                        <h3>John Doe</h3>

                        <h5>The designer</h5>

                    </figcaption>

                </figure>

            </section>

            <section class="col-xs-12 col-sm-4 col-md-4 col-lg-4 ">

                <figure>

                    <img src="images/about-images/about-image-2.jpg" class="img-responsive"/>

                    <figcaption>

                        <h3>Kevin Lee</h3>

                        <h5>The Leader</h5>

                    </figcaption>

                </figure>

            </section>

            <section class="col-xs-12 col-sm-4 col-md-4 col-lg-4 ">

                <figure>

                    <img src="images/about-images/about-image-3.jpg" class="img-responsive"/>

                    <figcaption>

                        <h3>Jason takas</h3>

                        <h5>The Founder</h5>

                    </figcaption>

                </figure>

            </section>





        </div>

        <!-- thumbnails -->





    </div>

</main>

<!-- main -->

<!-- footer -->

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
