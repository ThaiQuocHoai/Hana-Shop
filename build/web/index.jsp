<%-- 
    Document   : index
    Created on : Jan 7, 2021, 10:29:59 AM
    Author     : QH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Hana Food Court</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
              integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
              crossorigin="anonymous" />

        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Rokkitt:100,300,400,700" rel="stylesheet">

        <!-- Animate.css -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="css/icomoon.css">
        <!-- Ion Icon Fonts-->
        <link rel="stylesheet" href="css/ionicons.min.css">
        <!-- Bootstrap  -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Magnific Popup -->
        <link rel="stylesheet" href="css/magnific-popup.css">

        <!-- Flexslider  -->
        <link rel="stylesheet" href="css/flexslider.css">

        <!-- Owl Carousel -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">

        <!-- Date Picker -->
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <!-- Flaticons  -->
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <!-- Theme style  -->
        <link rel="stylesheet" href="css/style.css">
        <style>
            .service {
                background-color: white;
                display: flex;
                justify-content: space-around;
                text-align: center;
                height: 150px;
            }

            .service .service-content i {
                width: 50px;
                height: 50px;
                font-size: 70px;
                color: gray;
                margin-top: 20px;
            }

            .service .service-content p {
                margin-top: 30px;
                font-size: 20px;
                text-align: center;
                font-weight: 600;
            }

            .service-content {
                position: relative;
            }

            .service-content .first {
                opacity: 1;
                transition: 0.5s;

            }

            .service-content:hover .first {
                opacity: 0;
                transition: 0.5s;
            }

            .service .service-content .next {
                position: absolute;
                top: 0;
                left: 0;
                transition: 0.5s;
                opacity: 0;

            }

            .service-content:hover .next {
                opacity: 1;
                transition: 0.5s;
            }

            .service-content .next #fast {
                font-size: 18px;
            }

            .service-content .next p {
                font-style: italic;
                font-weight: 300;
            }
        </style>

    </head>

    <body>

        <div class="colorlib-loader"></div>

        <div id="page">
            <c:set var="fullname" value="${sessionScope.FULLNAME}" />
            <c:set var="isAdmin" value="${sessionScope.ADMIN}" />
            <nav class="colorlib-nav" role="navigation">
                <div class="top-menu">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-7 col-md-9">
                                <div id="colorlib-logo"><a href="DispatchServlet?btAction=Home">Hana Food Court</a></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 text-left menu-1">
                                <ul>
                                    <li>
                                        <a href="DispatchServlet?btAction=Home">Home</a>
                                    </li>
                                    <li>
                                        <a href="DispatchServlet?txtSearchValue=${sessionScope.SEARCHVALUE}&btAction=Search&dropList=${sessionScope.CATE}&txtMin=${sessionScope.MIN}&txtMax=${sessionScope.MAX}">Shopping</a>
                                    </li>
                                    <c:if test="${not empty fullname}">

                                        <li>
                                            ${fullname}
                                        </li>
                                        <c:if test="${not empty isAdmin}">
                                            <li>
                                                <a href="DispatchServlet?btAction=manager">Manager</a>
                                            </li>
                                        </c:if>
                                        <li>
                                            <a href="DispatchServlet?btAction=Logout">Logout</a>
                                        </li>
                                    </c:if> 
                                    <c:if test="${empty fullname}">
                                        <li>
                                            <a href="DispatchServlet?btAction=login">Login</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${not empty fullname}">
                                        <c:if test="${empty isAdmin}">
                                            <li class="cart">
                                                <a href="DispatchServlet?btAction=View cart">
                                                    <i class="icon-shopping-cart"></i> Cart [<c:if test="${not empty sessionScope.COUNTCART}"><font style="color: red">${sessionScope.COUNTCART}</font></c:if>]
                                                    </a>
                                                </li>
                                            <c:if test="${not empty sessionScope.FULLNAME}">
                                                <li class="cart">
                                                    <a href="DispatchServlet?btAction=View history&txtHistoryName=&txtDate="><i class="icon-shopping-cart"></i> View history </a>
                                                </li>
                                            </c:if>
                                        </c:if>
                                    </c:if>

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

            </nav>
            <aside id="colorlib-hero">
                <div class="flexslider">
                    <ul class="slides">
                        <li
                            style="background-image: url(https://www.vvsupremo.com/wp-content/uploads/2018/05/Pepperoni-Pizza-1.jpg);">
                            <div class="overlay"></div>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-6 offset-sm-3 text-center slider-text">
                                        <div class="slider-text-inner">
                                            <div class="desc">
                                                <h1 class="head-1">Hana Food Court</h1>
                                                <h2 class="head-2">Diverse menu</h2>
                                                <p class="category"><span>Always make you satific</span></p>
                                                <p><a href="DispatchServlet?txtSearchValue=${sessionScope.SEARCHVALUE}&btAction=Search&dropList=${sessionScope.CATE}&txtMin=${sessionScope.MIN}&txtMax=${sessionScope.MAX}" class="btn btn-primary">Go shopping</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li style="background-image: url(https://wallpaperaccess.com/full/1312727.jpg);">
                            <div class="overlay"></div>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-6 offset-sm-3 text-center slider-text">
                                        <div class="slider-text-inner">
                                            <div class="desc">
                                                <h1 class="head-1">Fastfood</h1>
                                                <h2 class="head-2">Sale everyday</h2>
                                                <p><a href="DispatchServlet?txtSearchValue=${sessionScope.SEARCHVALUE}&btAction=Search&dropList=${sessionScope.CATE}&txtMin=${sessionScope.MIN}&txtMax=${sessionScope.MAX}" class="btn btn-primary">Shop Collection</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li
                            style="background-image: url(https://ivcdn.vnecdn.net/ngoisao/images/web/2020/07/29/bst-16-lon-coca-cola-lay-cam-hung-tu-nhac-viet-1596006591.jpg?w=750&h=450&q=100&dpr=1&fit=crop&s=6pnJIG_uscxoX1FDV_m_Rg);">
                            <div class="overlay"></div>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-6 offset-sm-3 text-center slider-text">
                                        <div class="slider-text-inner">
                                            <div class="desc">
                                                <h1 class="head-1">Drinking</h1>
                                                <h2 class="head-2">Buy 2 get 1</h2>
                                                <p><a href="DispatchServlet?txtSearchValue=${sessionScope.SEARCHVALUE}&btAction=Search&dropList=${sessionScope.CATE}&txtMin=${sessionScope.MIN}&txtMax=${sessionScope.MAX}" class="btn btn-primary">Shop Collection</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </aside>

        </div>
        <div class="colorlib-partner">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 offset-sm-2 text-center colorlib-heading colorlib-heading-sm">
                        <h2>Respect customers</h2>
                    </div>
                </div>
                <div class="service">
                    <div class="service-content">
                        <div class="first">
                            <i class="fa fa-smile-beam"></i>
                            <p>
                                Happy client
                            </p>
                        </div>
                        <div class="next">
                            <p>Your satisfaction is our goal<br /> ...</p>
                        </div>
                    </div>
                    <div class="service-content">
                        <div class="first">
                            <i class="fa fa-bolt"></i>
                            <p>
                                Fast delivery
                            </p>
                        </div>
                        <div class="next">
                            <p id="fast">If you are afraid to order online, please choose us, we do not disappoint you
                                <br />...
                            </p>
                        </div>

                    </div>
                    <div class="service-content">

                        <div class="first">
                            <i class="fa fa-check"></i>
                            <p>
                                Good quality
                            </p>
                        </div>
                        <div class="next">
                            <p id="fast">Read their ratings and contact them with any questions <br />...</p>
                        </div>

                    </div>
                    <div class="service-content">

                        <div class="first">
                            <i class="fa fa-phone"></i>
                            <p>
                                24/7 online support
                            </p>
                        </div>
                        <div class="next">
                            <p>We are always waiting for help you <br />...</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer id="colorlib-footer" role="contentinfo">
            <div class="container">
                <div class="row row-pb-md">
                    <div class="col footer-col colorlib-widget">
                        <h4>About Hana Food Court</h4>
                        <p>Even the all-powerful Pointing has no control about the blind texts it is an almost
                            unorthographic life</p>
                        <p>
                        <ul class="colorlib-social-icons">
                            <li><a href="#"><i class="icon-twitter"></i></a></li>
                            <li><a href="#"><i class="icon-facebook"></i></a></li>
                            <li><a href="#"><i class="icon-linkedin"></i></a></li>
                            <li><a href="#"><i class="icon-dribbble"></i></a></li>
                        </ul>
                        </p>
                    </div>
                    <div class="col footer-col colorlib-widget">
                        <h4>Customer Care</h4>
                        <p>
                        <ul class="colorlib-footer-links">
                            <li><a href="#">Contact</a></li>
                            <li><a href="#">Gift Voucher</a></li>
                            <li><a href="#">Special</a></li>
                            <li><a href="#">Customer Services</a></li>
                        </ul>
                        </p>
                    </div>
                    <div class="col footer-col colorlib-widget">
                        <h4>Information</h4>
                        <p>
                        <ul class="colorlib-footer-links">
                            <li><a href="#">About us</a></li>
                            <li><a href="#">Delivery Information</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Support</a></li>
                            <li><a href="#">Order Tracking</a></li>
                        </ul>
                        </p>
                    </div>
                    <div class="col footer-col">
                        <h4>Contact Information</h4>
                        <ul class="colorlib-footer-links">
                            <li>9 District - Ho Chi Minh City, <br> Hightech 9 district</li>
                            <li><a href="tel://1234567920">84+ 917970830</a></li>
                            <li><a href="mailto:info@yoursite.com">hoaitqSE140980@fpt.edu.vn</a></li>
                            <li><a href="#">hanafoodcourt.com</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>

        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <!-- popper -->
        <script src="js/popper.min.js"></script>
        <!-- bootstrap 4.1 -->
        <script src="js/bootstrap.min.js"></script>
        <!-- jQuery easing -->
        <script src="js/jquery.easing.1.3.js"></script>
        <!-- Waypoints -->
        <script src="js/jquery.waypoints.min.js"></script>
        <!-- Flexslider -->
        <script src="js/jquery.flexslider-min.js"></script>
        <!-- Owl carousel -->
        <script src="js/owl.carousel.min.js"></script>
        <!-- Magnific Popup -->
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/magnific-popup-options.js"></script>
        <!-- Date Picker -->
        <script src="js/bootstrap-datepicker.js"></script>
        <!-- Stellar Parallax -->
        <script src="js/jquery.stellar.min.js"></script>
        <!-- Main -->
        <script src="js/main.js"></script>

    </body>

</html>


