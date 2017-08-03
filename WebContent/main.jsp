<%--
  Created by IntelliJ IDEA.
  User: hmy
  Date: 2017/7/15
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>

<html>

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

    <meta charset="utf-8">

    <!-- Description, Keywords and Author -->

    <meta name="description" content="">

    <meta name="author" content="">

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

    </style>


    <title>OMEGA</title>

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

<main role="main-home-wrapper" class="container">



    <div class="row">



        <section class="col-xs-12 col-sm-6 col-md-6 col-lg-6 ">

            <article role="pge-title-content">

                <header>

                    <h2><span>Omega</span>Online Shopping.</h2>

                </header>

                <p>This is a convenient and stylish online shopping platform.</p>

            </article>

        </section>



        <section class="col-xs-12 col-sm-6 col-md-6 col-lg-6 grid">

            <figure class="effect-oscar">

                <img src="images/home-images/image_1.jpg" alt="" class="img-responsive"/>

                <figcaption>

                    <h2>Boutique<span> Books</span></h2>

                    <p>200 boutique books arbitrarily selected.</p>

                    <a href="GoodsList.jsp?type=book">View more</a>

                </figcaption>

            </figure>

        </section>



        <div class="clearfix"></div>



        <section class="col-xs-12 col-sm-6 col-md-6 col-lg-6 grid">

            <ul class="grid-lod effect-2" id="grid">

                <li>

                    <figure class="effect-oscar">

                        <img src="images/home-images/image_2.jpg" alt="" class="img-responsive"/>

                        <figcaption>



                            <h2>Brand<span> Package</span></h2>

                            <p>Casual alphabet printed hemp canvas bag shoulder bag</p>

                            <a href="GoodsList.jsp?type=package">View more</a>



                        </figcaption>

                    </figure>

                </li>



                <li>

                    <figure class="effect-oscar">

                        <img src="images/home-images/image_4.jpg" alt="" class="img-responsive"/>

                        <figcaption>

                            <h2>Office<span> Supplies</span></h2>

                            <p>Office supplies to the audience as low as 50% off sale.</p>

                            <a href="GoodsList.jsp?type=supply">View more</a>

                        </figcaption>

                    </figure>

                </li>

                <li>

                    <figure class="effect-oscar">

                        <img src="images/home-images/image_6.jpg" alt="" class="img-responsive"/>

                        <figcaption>

                            <h2>Fine small<span> appliances</span></h2>

                            <p>40 home appliance brands to choose from.</p>

                            <a href="GoodsList.jsp?type=appliance">View more</a>

                        </figcaption>

                    </figure>

                </li>

                <li>

                    <figure class="effect-oscar">

                        <img src="images/home-images/image_16.jpg" alt="" class="img-responsive"/>

                        <figcaption>

                            <h2>imported<span> food</span></h2>

                            <p>More than 20 different types of imported food.</p>

                            <a href="GoodsList.jsp?type=food">View more</a>

                        </figcaption>

                    </figure>

                </li>

                <li>

                    <figure class="effect-oscar">

                        <img src="images/home-images/image_17.jpg" alt="" class="img-responsive"/>

                        <figcaption>

                            <h2>Customized boutique<span> shoes</span></h2>

                            <p>More than 4000 shoes available for selection, there must be a suitable one.</p>

                            <a href="GoodsList.jsp?type=shoe">View more</a>

                        </figcaption>

                    </figure>

                </li>

          
            </ul>


        </section>



        <section class="col-xs-12 col-sm-6 col-md-6 col-lg-6 grid">

            <ul class="grid-lod effect-2" id="grid">

                <li>

                    <figure class="effect-oscar">

                        <img src="images/home-images/image_3.jpg" alt="" class="img-responsive"/>

                        <figcaption>

                            <h2>Light luxury<span> daily necessities</span></h2>

                            <p>High-end necessities low discount to enjoy</p>

                            <a href="GoodsList.jsp?type=daily">View more</a>

                        </figcaption>

                    </figure>

                </li>

                <li>
                    <figure class="effect-oscar">
                        <img src="images/home-images/image_5.jpg" alt="" class="img-responsive"/>
                        <figcaption>
                            <h2>Brand new style<span> women's clothing</span></h2>
                            <p>More than 400 items of annual sales promotions</p>
                            <a href="GoodsList.jsp?type=clothing">View more</a>
                        </figcaption>
                    </figure>
                </li>
                <li>
                    <figure class="effect-oscar">
                        <img src="images/home-images/image_7.jpg" alt="" class="img-responsive"/>
                        <figcaption>
                            <h2>Green<span> plants</span></h2>
                            <p>A variety of green plants shipped by air</p>
                            <a href="GoodsList.jsp?type=plant">View more</a>
                        </figcaption>
                    </figure>
                </li>
                <li>
                    <figure class="effect-oscar">
                        <img src="images/home-images/image_8.jpg" alt="" class="img-responsive"/>
                        <figcaption>
                            <h2>Fine audio and video<span> supplies</span></h2>
                            <p>Bringing the ultimate visual and auditory experience.</p>
                            <a href="GoodsList.jsp?type=supply">View more</a>
                        </figcaption>
                    </figure>
                </li>
                <li>
                    <figure class="effect-oscar">
                        <img src="images/home-images/image_18.jpg" alt="" class="img-responsive"/>
                        <figcaption>
                            <h2>Natural<span> cosmetics</span></h2>
                            <p>Luxury brand to bring fine skin care products and cosmetics.</p>
                            <a href="GoodsList.jsp?type=cosmetic">View more</a>
                        </figcaption>
                    </figure>
                </li>
            </ul>
        </section>
        <div class="clearfix"></div>
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
