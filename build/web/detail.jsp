<%-- 
    Document   : detail
    Created on : Jan 13, 2021, 10:23:00 AM
    Author     : QH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Detail</title>
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
                width: 30%;
            }
            .product-entry {
                width: 250px;
                margin-left: 100px;
                height: 150px;
            }

            .product-body .product-image{
                width: 50px;
                height: 100px;
            }

            .product-image img{
                width: 600px;
                height: 500px;
            }

            .product-body .product-detal{
                position: absolute;
                right:   0;

            }
            .product-body{
                position: relative;
                margin-top: -120px;
                margin: 0 50px;
                margin-left: 150px;
            }
            .product-image{
                width: 50%;
                padding-top: 200px;
                margin-top: -120px;
            }
            .product-detal{
                width: 50%;
                height: 450px;
                padding-top: 20px;
                padding-left: 20px;
                margin-right: 60px;
                font-size: 15px;
                font-weight: 300;
                letter-spacing: 1px;
            }

            .btn-addtocart{
                border: 1px solid gray;
                background-color:white;
                height: 40px;
                width: 135px;
                cursor: pointer;
                transition: 0.3s;
            }
            .btn-addtocart:hover{
                background-color: black;
                color: white;
                border: 1px solid white;
                transition: 0.3s;
            }
        </style>

    </head>
    <body>
        <c:if test="${not empty sessionScope.DTO}">
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

            <div class="product-body">
                <form action="DispatchServlet" style="height: 10px;" method="POST">
                    <c:set var="dto" value="${sessionScope.DTO}"/>
                    <div class="product-image">
                        <img src="${dto.image}">
                    </div>
                    <div class="product-detal">
                        <p>Name: ${dto.nameFood}</p>
                        <p>Description: ${dto.description}</p>
                        <p>Price: ${dto.price}</p>
                        <p>Create date: ${dto.createDate}</p>
                        <p>Invalidate: ${dto.invalidDate}</p>
                        <p>Quantity: ${dto.quantity}</p>
                        <input type="number" min="1" max="${dto.quantity}" name="txtQuantity" value="${sessionScope.QUANTITY}"/><br/>
                        <input type="hidden" name="txtFoodID" value="${dto.idFood}"/>
                        <a href="DispatchServlet?txtSearchValue=${sessionScope.SEARCHVALUE}&btAction=Search&dropList=${sessionScope.CATE}&txtMin=${sessionScope.MIN}&txtMax=${sessionScope.MAX}&index=${sessionScope.INDEX}">Back to shopping</a>
                        <c:if test="${not empty sessionScope.FULLNAME}">
                            <c:if test="${empty sessionScope.ADMIN}">
                                <input class="btn-addtocart" type="submit" value="Add to cart" name="btAction"/>
                            </c:if>
                        </c:if>
                    </div>
                </form>
            </div>

        </c:if>
        <c:if test="${empty sessionScope.DTO}">
            <c:import url="wrong.jsp"/>
        </c:if>
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
