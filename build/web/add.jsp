<%-- 
    Document   : add
    Created on : Jan 19, 2021, 12:54:27 PM
    Author     : QH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Page</title>
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
                cursor: pointer;
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
        <c:set var="fullname" value="${sessionScope.FULLNAME}" />
        <c:set var="isAdmin" value="${sessionScope.ADMIN}" />
        <c:if test="${not empty isAdmin}">
            <div id="page">

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

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>

            <div class="product-body container">
                <form action="DispatchServlet" style="height: 10px;" method="POST">
                    <div class="product-image">
                        <img src="${param.txtImageAdd}">
                    </div>
                    <div class="product-detal">
                        <c:set var="error" value="${sessionScope.ERRORADD}"/>
                        <p>Name:
                            <c:if test="${not empty error}">
                                <font style="color:red">${error.nameFoodError}</font>
                            </c:if>
                        </p>
                        <input type="text" name="txtNameAdd" value="${param.txtNameAdd}" placeholder="Name..."/><br/>
                        <p>Link image:
                            <c:if test="${not empty error}">
                                <font style="color:red">${error.imageError}</font>
                            </c:if>
                        </p>
                        <input type="text" name="txtImageAdd" value="${param.txtImageAdd}" placeholder="link image..." /><br/>
                        <p>Description:
                            <c:if test="${not empty error}">
                                <font style="color:red">${error.descriptionError}</font>
                            </c:if>
                        </p> 
                        <input type="text" name="txtDescriptionAdd" value="${param.txtDescriptionAdd}" placeholder="Description..." /> <br/>
                        <p>Price: 
                            <c:if test="${not empty error}">
                                <font style="color:red">${error.priceError}</font>
                            </c:if>
                        </p>
                        <input type="number" min="1" name="txtPriceAdd" value="${param.txtPriceAdd}" placeholder="Price..." /> 
                        <p>Quantity: 
                            <c:if test="${not empty error}">
                                <font style="color:red">${error.quantityError}</font>
                            </c:if>
                        </p>
                        <input type="number" min="0" name="txtQuantityAdd" value="${param.txtQuantityAdd}" placeholder="Quantity..." /><br/> 
                        <p>Category: </p>
                        <select name="dropCateAdd">
                            <option>Food</option>
                            <option>Drink</option>
                        </select>

                        <p>Create date: </p>
                        <input type="date" name="txtCreateDateAdd" value="${sessionScope.NOW}" readonly/>
                        <p>Invalidate: 
                            <c:if test="${not empty error}">
                                <font style="color:red">${error.invalidDateError}</font>
                            </c:if>
                        </p>
                        <input type="date" name="txtInvaliDateAdd" value="${param.txtInvaliDateAdd}" />
                        <input type="text" name="txtStatusAdd" value="Active" readonly="readonly" />
                        <a href="DispatchServlet?txtSearchManager=${sessionScope.SEARCHVALUEMANAGER}&btAction=Search product&dropListManager=${sessionScope.CATEMANAGER}&txtMinManager=${sessionScope.MINMANAGER}&txtMaxManager=${sessionScope.MAXMANAGER}&indexManager=${sessionScope.INDEXMANAGER}">Back to manager's page   </a>
                        <input class="btn-addtocart" type="submit" value="Add new" name="btAction"/>
                    </div>
                </form>
            </div>             
        </c:if>
        <c:if test="${empty isAdmin}">
            <c:import url="invalid.jsp"/>
        </c:if>
    </body>
</html>
