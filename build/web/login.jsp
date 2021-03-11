<%-- 
    Document   : login
    Created on : Jan 7, 2021, 10:09:25 AM
    Author     : QH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
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
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

        <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

        <style>

            a{
                text-decoration:none !important;
            }
            h1,h2,h3{
                font-family: 'Kaushan Script', cursive;
            }
            .myform{
                position: relative;
                display: -ms-flexbox;
                display: flex;
                padding: 1rem;
                -ms-flex-direction: column;
                flex-direction: column;
                width: 100%;
                pointer-events: auto;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid rgba(0,0,0,.2);
                border-radius: 1.1rem;
                outline: 0;
                max-width: 500px;
                margin-top: 60px;
            }
            .tx-tfm{
                text-transform:uppercase;
            }
            .mybtn{
                border-radius:50px;
            }

            .login-or {
                position: relative;
                color: #aaa;
                margin-top: 10px;
                margin-bottom: 10px;
                padding-top: 10px;
                padding-bottom: 10px;
            }
            .span-or {
                display: block;
                position: absolute;
                left: 50%;
                top: -2px;
                margin-left: -25px;
                background-color: #fff;
                width: 50px;
                text-align: center;
            }
            .hr-or {
                height: 1px;
                margin-top: 0px !important;
                margin-bottom: 0px !important;
            }
            .google {
                color:#666;
                width:100%;
                height:40px;
                text-align:center;
                outline:none;
                border: 1px solid lightgrey;
            }
            form .error {
                color: #ff0000;
            }
            #second{display:none;}
        </style>

    </head>
    <body>
        <c:set var="fullname" value="${sessionScope.FULLNAME}"/>
        <c:set var="isAdmin" value="${sessionScope.ADMIN}" />
        <c:set var="invalid" value="${sessionScope.INVALID}"/>
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
        </div>

        <%--login form--%>

        <div class="container">
            <div class="row">
                <div class="col-md-5 mx-auto">
                    <div id="first">
                        <div class="myform form ">
                            <div class="logo mb-3">
                                <div class="col-md-12 text-center">
                                    <h1>Login</h1>
                                </div>
                            </div>
                            <form action="DispatchServlet" method="POST">
                                <c:if test="${not empty invalid}">
                                    <font style="color: red; size: 30px;">${invalid}</font>
                                </c:if>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Username</label>
                                    <input type="text" name="txtUsername" value="" class="form-control" id="email" placeholder="Enter username">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Password</label>
                                    <input type="password" name="txtPassword" value="" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Enter Password">
                                </div>

                                <div class="col-md-12 text-center ">
                                    <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm" name="btAction" value="Login">Login</button>
                                </div>
                                <div class="col-md-12 ">
                                    <div class="login-or">
                                        <hr class="hr-or">
                                        <span class="span-or">or</span>
                                    </div>
                                </div>
                                <div class="col-md-12 mb-3">
                                    <p class="text-center">
                                        <a href="javascript:void();" class="google btn mybtn"><i class="fa fa-google-plus">
                                            </i> Signup using Google
                                        </a>
                                    </p>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%----%>


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
        <script src="js/main.js"></script></body>

</body>
</html>
