<%-- 
    Document   : Exchange
    Created on : 27 Jun 2022, 09:14:13
    Author     : HP
--%>

<%@page import="za.co.carols_boutique_pos.models.Product"%>
<%@page import="za.co.carols_boutique_pos.models.Sale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exchange</title>
        <style>
            #viewtopemppage .bars{
                font-size:25px;
                width:400px;
            }
            #viewtopemppage label{
                font-size:30px;
            }
            #exchangepage label {
                font-size: 30px;
            }

            #exchangepage button {
                background-color: rgb(0, 128, 117);
                color: white;
                text-align: center;
                text-decoration: none;
                transition-duration: all 0.1s;
                cursor: pointer;
                font-size: 20px;
                width: 300px;
                height: 60px;
                border-style: solid;
                border-color: white;
                border-width: 3px;
                border-radius: 8px;
            }

            #exchangepage .bars {
                font-size: 30px;
            }

            #exchangepage table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #exchangepage td,
            th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            #exchangepage tr:nth-child(even) {
                background-color: #dddddd;
            }
            .mid {
                text-align: center;
                background-color: white;
                width: 950px;
                height: 500px;
                position: absolute;
                top: 80px;
                left: 305px;
                border-style: solid;
                border-width: 1px;
                border-color: grey;
                overflow: auto;
            }
            #heading {
                position: absolute;

                top: 0;
                left: 550px;
                font-family: Papyrus;
                font-size: 40px;
                font-style: italic;
                font-weight: bolder;
                letter-spacing: 6px;
                text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
                text-align: center;
                color: #a3881d;
                padding: 20px;
            }
            h1,
            h2 {
                font-size: 35px;
            }
            .b:hover {
                background-color: rgb(0, 0, 80);
            }

            .b.active {
                background-color: rgb(0, 0, 128);
            }

            .c:hover {
                background-color: rgb(0, 0, 80);
            }

            .c.active {
                background-color: rgb(0, 0, 50);
            }

            .mid button:hover {
                box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24);
            }
            .sideside {
                background-color: rgb(0, 0, 50);
                width: 100px;
                height: 100%;
                position: fixed;
                top: 0px;
                left: 120px;
                text-align: left;
            }

            .b {
                border: none;
                background-color: rgb(0, 0, 50);
                color: white;
                transition-duration: all 0.1s;
                font-size:14px;
                padding: 20px 10px;
                width:80px;
                height:40px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                cursor: pointer;
                text-decoration: none;
            }

            #copyright {
                Position: absolute;
                top: 600px;
                left: 680px;
            }

            .c {
                background-color: rgb(0, 0, 128);
                border: none;
                color: white;

                text-align: left;
                text-decoration: none;
                font-size: 18px;
                height: 70px;
                width: 120px;
                transition-duration: all 0.1s;
                cursor: pointer;
            }

            #side {
                align: right;

                height: 100%;
                width: 120px;
                position: fixed;
                z-index: 1;
                top: 0;
                left: 0;
                background-color: rgb(0, 0, 128);
                overflow-x: hidden;
                padding-top: 10px;
            }
        </style>  
    </head>
    <body style="background-image:url('https://lh3.googleusercontent.com/pw/AM-JKLXMO5yDb4rwt4sEQrgiQOMODT_pJfb1SL2dd8vpb9xK6qq-v0-sLTcA7ci2YTgbCEc9EH-VWq56ksYL1wsRQOFNAtSXfc6cmCOwCtpfS-Hbcj4rYphCA-b4AYxOAjboLEyfbJ4HxwYWuwhl5jRgETc=w1095-h657-no?authuser=0'); background-size:cover;">
        <label id="heading">Carol's Boutique</label>
        <div id="side">
            <button class="c" id="keepaside" name="submit" onclick="openCity(event, 'Keepasidebar')">keep aside</button>
            <button class="c" id="viewreport" name="submit" onclick="openCity(event, 'Reportbar')">view report </button>

            <button class="c" id="registerstore" name="submit" onclick="openCity(event, 'storebar')">Store</button>
            <button class="c" id="updateemploye" name="submit" onclick="openCity(event, 'employeebar')">Employee</button>
            <button class="c" id="ibt" name="submit" onclick="openCity(event, 'IBTbar')">IBT</button>
            <button class="c" id="stock" name="submit" onclick="openCity(event, 'Stockbar')">Stock</button>
            <button class="c" id="sale" name="submit" onclick="openCity(event, 'Salebar')">Sale</button>
        </div>
        <div id="Salebar" class="sideside">
            <a href="Exchange.jsp" id="Exchangedb" class="b" name="button" value="Exchanged page"
               >Exchanged</a><br>
            <a href="Return.jsp" id="Returnb" class="b" name="button" value="Return page"
               >Return</a><br>
            <a href="createSale.jsp"id="LineItemsb" class="b" name="submit" value="LineItems page"
               >Create Sale</a>
        </div>
        <div id="storebar" class="sideside">
            <a href="RegisterStore.jsp" id="registerstoreb" class="b" name="submit" value="registerstorepage"
               >register store</a>
        </div>
        <div id="employeebar" class="sideside">
            <a href="RegisterEmployee.jsp" id="registeremployeeb" class="b" name="submit" value="registerstorepage"
               >Register Employee</a><br>
            <a href="UpdateEmployee.jsp" id="registeremployeeb" class="b" name="submit" value="registerstorepage"
               >Update Employee</a>
        </div>
        <div id="Keepasidebar" class="sideside">
            <a href="CreateKeepAside.jsp" id="createkeepasideb" class="b" name="submit" value="createkeepasidepage"
               >create keep aside</a>
        </div>
        <div id="Stockbar" class="sideside">
            <a href ="CreateProduct.jsp" id="createproductb" class="b" name="submit" value="createproduct page"
               >create product</a><br>
            <a href="DeleteProduct.jsp" id="deleteproductb" class="b" name="submit" value="delete product page"
               >delete product</a><br>
            <a href="AddToStock.jsp" id="addtostockb" class="b" name="submit" value="add to stock page"
               >add to stock</a><br>
            <a href ="RemoveFromStock.jsp" id="removefromstockb" class="b" name="submit" value="remove from stock page"
               >remove from stock</a>
        </div>
        <div id="Reportbar" class="sideside">
            <a href="ViewTopEmployee.jsp" id="viewtopempb" class="b" name="submit" value="view top employees page"
               >view top employees page</a><br>
            <a href="MonthlySales.jsp" id="monthlysalesb" class="b" name="submit" value="view monthly sales page"
               >view monthly sales</a><br>
            <a href ="ViewTopSellingEmployees.jsp" id="topsellingempsb" class="b" name="submit" value="view top selling employees page"
               >view top selling employees</a><br>
            <a href ="AcheivedTarget.jsp"id="achievedtargetb" class="b" name="submit" value="view stores that achieved target page"
               >View stores that achieved target page</a><br>
            <a href ="ViewTopSellingEmployees.jsp" id="topsellingproductsb" class="b" name="submit" value="view top selling products page"
               >View top selling products</a><br>
            <a href="LeastTopEmployees.jsp" id="leastperformingstoresb" class="b" name="submit" value="view least performing stores page"
               >View least performing stores</a><br>
            <a href="ProductReport.jsp" id="productsreportb" class="b" name="submit" value="view product report page"
               >View product report</a><br>
            <a href="ViewDailySales.jsp" id="dailysalesb" class="b" name="submit" value="view daily sales page"
               >View daily sales page</a>
        </div>
        <div id="IBTbar" class="sideside">

            <a href ="RequestIBT.jsp" id="ibtrequestb" class="b" name="submit" value="IBT Requests page"
               >Request IBT</a>
        </div>

        <label id="copyright">Carols Boutique pty.Ltd.<br>Reg.131 482 9132</label>
        <div id="exchangepage" class="mid">
            <form>
                <h1>Exchange</h1><br>
                <label>Receipt ID<label><br>
                        <%
                            Sale sale = (Sale) request.getAttribute("s");
                            String saleResponse = (String) request.getAttribute("noSale");
                            Product prod = (Product) request.getAttribute("product1");
                            String prodResponse = (String) request.getAttribute("noProduct");
                            Product prod1 = (Product) request.getAttribute("product2");
                        %>
                        <input type="text" name="ReceiptID" class="bars"><br>
                        <button name="submit" value="receiptID">search</button><br>
                        <br><br>
                        <label></label><br><br>
                        
                        <label style>Return ProductID</label><br>
                        <input type="text" name="returnProductID" class="bars"><br>
                        <input type="text" name="returnAmount" class="bars"><br>
                        <label>Exchange ProductID</label><br>
                        <input type="text" name="exchangeProductID" class="bars">
                        <input type="text" name="exchangeAmount" class="bars">
                        <br><br>
                        
                        <table>
                            <tr>
                                <th>ProductID</th>
                                <th>Item</th>
                                <th>Size</th>
                                <th>Qty</th>
                                <th>Price</th>
                            </tr>
                            <td>?ProductID?
                            </td>
                            <td>??-item??
                            </td>
                            <td>??size??
                            </td>
                            <td>??Qty??</td>
                            <td>??Price??
                            </td> 
                            <tr>

                            </tr>
                            <tr style="background-color:red">

                                <td><%=prod.getId()%>
                                </td>
                                <td><%=prod.getName()%>
                                </td>
                                <td><%=prod.getSize()%>
                                </td>
                                <td>??Qty??</td>
                                <td><%=prod.getPrice()%>
                                </td>
                            </tr>
                            <tr style="background-color:green">
                                <td><%=prod1.getId()%>
                                </td>
                                <td><%=prod1.getName()%>
                                </td>
                                <td><%=prod1.getSize()%>
                                </td>
                                <td>??Qty??</td>
                                <td><%=prod1.getPrice()%>
                                </td>
                            </tr>
                            <tr>
                                <td>Total: </td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <%Float total = prod1.getPrice() - prod.getPrice();%>
                                <td><%= total%></td>                            
                            </tr>
                        </table><br>
                        
                        <button name="submit" value="ConfirmExchange">Confirm Exchange</button>


                        </div> 
                                </form>   
                        <script>
                            function openCity(evt, cityName) {
                                var i, tabcontent, tablinks;
                                tabcontent = document.getElementsByClassName("sideside");
                                for (i = 0; i < tabcontent.length; i++) {
                                    tabcontent[i].style.display = "none";
                                }
                                tablinks = document.getElementsByClassName("c");
                                for (i = 0; i < tablinks.length; i++) {
                                    tablinks[i].className = tablinks[i].className.replace(" active", "");
                                }
                                document.getElementById(cityName).style.display = "block";
                                evt.currentTarget.className += " active";
                            }
                        </script>    
                        
                        </body>

                        </html>
