<%-- 
    Document   : shop
    Created on : Jan 7, 2021, 9:52:29 AM
    Author     : QH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Shopping Page</title>
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
            .search-bar .form-inline .btn{
                background: #595959;
                color: white;
                text-transform: uppercase;
                font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
            }

            .search-bar .form-inline{
                margin-left: 100px;
            }

            .form-before{
                height: 60px;
                background: #595959;
                text-align: left;
            }

            .form-before .search-bar #txt-search{
                margin-top: 8px;
                border-radius: 10px;
                margin-left: 20px;
            }

            .form-before .search-bar #btn-search{
                border-radius: 10px;
                padding-left: 10px;
                padding-right: 10px;
            }

            .form-before .search-bar #btn-search:hover{
                background: #999999;
                color: white;
            }

            li{
                list-style: none;
            }

            .filter-all .ul-general{
                font-size: 20px;
            }
            .filter-all .li-generall{
                margin-left: 60px;
            }

            .filter-all{
                border-right:  2px solid gray;
                width: 250px;
                border-bottom:   2px solid gray;
                height: 450px;
            }
            .colorlib-product{
                width: 1300px;
            }
            .total{
                display: flex;
                width: 100%;
                margin-left: 80px;
            }
            #txt-search-price{
                border-radius: 10px;
                padding-left: 10px;
                padding-right: 10px;
            }
            .filter #btn-search{
                border-radius: 10px;
                padding-left: 10px;
                padding-right: 10px;
            }

            .filter #btn-search:hover{
                background: #999999;
                color: gray;
            }
            .filter #drop-list{
                height: 30px;
                border-radius: 5px;
                font-size: 20px;
                margin-bottom: 20px;
                margin-top: 20px;
            }
            .filter{
                text-align: center;
            }
            .paging{
                text-align: center;
            }
            .paging a{
                padding: 0 20px;
                font-size: 20px;
                border: 1px solid gray;
                margin: 0 10px;
                transition: 0.3s;
            }
            .paging a:hover{
                transition: 0.3s;
                background-color: black;
                color: white;
            }
            .model-h2{
                margin-left: 10px;
            }
            .modal-content{
                width: 700px;
            }
            .model-h2 h2{   
                color: gray;
            }
            .form-body{
                display: block;
                width: 25%;
            }
            .product-entry {
                width: 250px;
                height: 150px;
                margin-left: 10px;  
            }

            .btn-viewdetail{
                border: 1px solid gray;
                background-color:white;
                height: 40px;
                width: 135px;
                cursor: pointer;
                transition: 0.3s;
                margin-bottom: 10px;
            }
            .btn-viewdetail:hover{
                background-color: black;
                color: white;
                border: 1px solid white;
                transition: 0.3s;
            }
            .total{
                width: 100%;
            }

        </style>

    </head>
    <body>
        <%-- nav --%>
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
        <%--  --%>

        <form action="DispatchServlet" method="POST">
            <div class="form-before">
                <div class="search-bar">
                    <input id="txt-search" size="30" type="text" name="txtSearchValue" value="${sessionScope.SEARCHVALUE}" placeholder="Search..."/>
                    <input id="btn-search" type="submit" value="Search" name="btAction" />

                </div>
            </div>
            <div class="filter">

                <select name="dropList" id="drop-list">
                    <option value="All">All</option>
                    <c:forEach items="${sessionScope.LISTCATE}" var="cate">
                        <option <c:if test="${cate eq sessionScope.CATE}">selected</c:if>>${cate}</option>
                    </c:forEach>
                </select>
                <br/>
                <input id="txt-search-price"size="10" type="number" min="0" name="txtMin" value="${sessionScope.MIN}" placeholder="Min price"/>
                <input id="txt-search-price" size="10" type="number" max="1000000" name="txtMax" value="${sessionScope.MAX}" placeholder="Max price"/>

            </div>
        </form>

        <%--shop--%>
        <div class="total">
            <c:if test="${not empty requestScope.SUC}">
                <font style="color: green; text-align: center;">${requestScope.SUC}</font>
            </c:if>
            <c:set var="searchValue" value="${param.txtSearchValue}"/>
            <div class="colorlib-product">
                <div class="container">
                    <c:set var="listSearch" value="${sessionScope.LISTSEARCH}"/>
                    <c:if test="${empty listSearch}">
                        <h2>No record match</h2><br/>
                    </c:if>
                    <c:if test="${not empty listSearch}">
                        <div class="row ">
                            <c:forEach var="dto" items="${listSearch}">
                                <form action="DispatchServlet" class="form-body container" method="POST">
                                    <div class="col-md-3">
                                        <div class=" mb-4 text-center">
                                            <div class="product-entry border">
                                                <a href="#" class="prod-img">
                                                    <img style="min-height: 200px; max-height: 200px;" src="${dto.image}" class="img-fluid">
                                                </a>
                                                <div class="desc">
                                                    <h2><a href="#">${dto.nameFood}</a></h2>
                                                    <span class="price">${dto.price}</span>
                                                </div>
                                                <input type="submit" class="btn-viewdetail" value="View detail" name="btAction"/>
                                                <input type="hidden" name="txtID" value="${dto.idFood}" />

                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </c:forEach>
                        </div>
                    </c:if>
                </div>
                <div class="paging">
                    <c:if test="${sessionScope.END > 1}">
                        <c:forEach begin="1" end="${sessionScope.END}" var="i">
                            <a href="DispatchServlet?txtSearchValue=${sessionScope.SEARCHVALUE}&btAction=Search&dropList=${sessionScope.CATE}&txtMin=${sessionScope.MIN}&txtMax=${sessionScope.MAX}&index=${i}">${i}   </a>
                        </c:forEach>
                    </c:if>
                </div>

            </div>
        </div>
    </div>

    <%----%>


    <%-- footer --%>
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
    <%--  --%>
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
</html>
