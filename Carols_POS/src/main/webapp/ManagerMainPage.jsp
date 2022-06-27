<%-- 
    Document   : ManagerMainPage
    Created on : 19 Jun 2022, 13:47:29
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Manager main page</title>
    <style>
        #topsellingempspage table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #topsellingempspage td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        #topsellingempspage tr:nth-child(even) {
            background-color: #dddddd;
        }
        #topsellingempspage button{
            
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
        #topsellingempspage .bars{
            font-size:25px;
            width:400px;
        }
        #topsellingempspage label{
            font-size:30px;
        }
        #acheivedtargetpage table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #acheivedtargetpage td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        #acheivedtargetpage tr:nth-child(even) {
            background-color: #dddddd;
        }
        #acheivedtargetpage button{
            
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
        #acheivedtargetpage .bars{
            font-size:25px;
            width:400px;
        }
        #acheivedtargetpage label{
            font-size:30px;
        }
        #topsellingproductspage table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #topsellingproductspage td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        #topsellingproductspage tr:nth-child(even) {
            background-color: #dddddd;
        }
        #topsellingproductspage button{
            
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
        #topsellingproductspage .bars{
            font-size:25px;
            width:400px;
        }
        #topsellingproductspage label{
            font-size:30px;
        }
        #leastperformingpage table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #leastperformingpage td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        #leastperformingpage tr:nth-child(even) {
            background-color: #dddddd;
        }
        #leastperformingpage button{
            
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
        #leastperformingpage .bars{
            font-size:25px;
            width:400px;
        }
        #leastperformingpage label{
            font-size:30px;
        }
        #productreportpage table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #productreportpage td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        #productreportpage tr:nth-child(even) {
            background-color: #dddddd;
        }
        #productreportpage button{
            
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
        #productreportpage .bars{
            font-size:25px;
            width:400px;
        }
        #productreportpage label{
            font-size:30px;
        }
        #dailysalespage table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #dailysalespage td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        #dailysalespage tr:nth-child(even) {
            background-color: #dddddd;
        }
        #dailysalespage button{
            
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
        #dailysalespage .bars{
            font-size:25px;
            width:400px;
        }
        #dailysalespage label{
            font-size:30px;
        }
        #monthlysalespage table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #monthlysalespage td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        #monthlysalespage tr:nth-child(even) {
            background-color: #dddddd;
        }
        #monthlysalespage button{
            
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
        #monthlysalespage .bars{
            font-size:25px;
            width:400px;
        }
        #monthlysalespage label{
            font-size:30px;
        }
        #viewtopemppage table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #viewtopemppage td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        #viewtopemppage tr:nth-child(even) {
            background-color: #dddddd;
        }
        #viewtopemppage button{
            
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

        #returnpage label {
            font-size: 30px;
        }

        #returnpage button {
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

        #returnpage .bars {
            font-size: 30px;
        }

        #returnpage table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #returnpage td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        #returnpage tr:nth-child(even) {
            background-color: #dddddd;
        }

        #lineitemspage label {
            font-size: 25px;
        }

        #lineitemspage .bars {
            font-size: 30px;
        }

        #lineitemspage button {
            background-color: rgb(0, 128, 117);
            color: white;
            text-align: center;
            text-decoration: none;
            transition-duration: all 0.1s;
            cursor: pointer;
            font-size: 20px;
            width: 250px;
            height: 50px;
            border-style: solid;
            border-color: white;
            border-width: 3px;
            border-radius: 8px;
        }

        #lineitemspage table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #lineitemspage td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        #lineitemspage tr:nth-child(even) {
            background-color: #dddddd;
        }

        #removefromstockpage label {
            font-size: 30px;
        }

        #removefromstockpage .bars {
            font-size: 20px;
            width: 500px;
            height: 50px;
        }

        #removefromstockpage button {
            background-color: rgb(0, 128, 117);
            color: white;
            text-align: center;
            text-decoration: none;
            transition-duration: all 0.1s;
            cursor: pointer;
            font-size: 30px;
            width: 300px;
            height: 100px;
            border-style: solid;
            border-color: white;
            border-width: 3px;
            border-radius: 8px;
        }

        #addtostockpage label {
            font-size: 30px;
        }

        #addtostockpage .bars {
            font-size: 20px;
            width: 500px;
            height: 50px;
        }

        #addtostockpage button {
            background-color: rgb(0, 128, 117);
            color: white;
            text-align: center;
            text-decoration: none;
            transition-duration: all 0.1s;
            cursor: pointer;
            font-size: 30px;
            width: 300px;
            height: 100px;
            border-style: solid;
            border-color: white;
            border-width: 3px;
            border-radius: 8px;
        }

        #deleteproductpage label {
            font-size: 30px;
        }

        #deleteproductpage .bars {
            font-size: 20px;
            width: 500px;
            height: 50px;
        }

        #deleteproductpage button {
            background-color: rgb(0, 128, 117);
            color: white;
            text-align: center;
            text-decoration: none;
            transition-duration: all 0.1s;
            cursor: pointer;
            font-size: 30px;
            width: 300px;
            height: 100px;
            border-style: solid;
            border-color: white;
            border-width: 3px;
            border-radius: 8px;
        }

        #createproductpage label {
            font-size: 30px;
        }

        #createproductpage .bars {
            font-size: 25px;
            height: 60px;
            width: 400px;
        }

        #createproductpage button {
            background-color: rgb(0, 128, 117);
            color: white;
            text-align: center;
            text-decoration: none;
            transition-duration: all 0.1s;
            cursor: pointer;
            font-size: 30px;
            width: 300px;
            height: 100px;
            border-style: solid;
            border-color: white;
            border-width: 3px;
            border-radius: 8px;
        }

        h1,
        h2 {
            font-size: 35px;
        }

        .searchbutton {
            width: 100px;
            height: 40px;
        }

        #ibtrequestpage .bars {
            font-size: 40px;
            text-align: center;
        }

        #ibtrequestpage label {
            font-size: 35px;
        }

        #ibtrequestpage button {
            background-color: rgb(0, 128, 117);
            color: white;
            text-align: center;
            text-decoration: none;
            transition-duration: all 0.1s;
            cursor: pointer;

            border-style: solid;
            border-color: white;
            border-width: 3px;
            border-radius: 8px;
        }

        #updateemployeepage .bars {
            font-size: 30px;
            text-align: center;
        }

        #updateemployeepage label {
            font-size: 25px;
        }

        #updateemployeepage button {
            background-color: rgb(0, 128, 117);
            color: white;
            text-align: center;
            text-decoration: none;
            font-size: 40px;
            height: 150px;
            width: 600px;

            transition-duration: all 0.1s;
            cursor: pointer;

            border-style: solid;
            border-color: white;
            border-width: 3px;
            border-radius: 8px;
        }

        #registeremployeepage .bars {
            text-align: center;
            border-radius: 5px 100px;
        }

        #registeremployeepage label {
            font-size: 25px;
        }

        #registeremployeepage .bars {
            font-size: 30px;
        }

        #registeremployeepage button {
            background-color: rgb(0, 128, 117);
            color: white;
            text-align: center;
            text-decoration: none;
            font-size: 18px;
            height: 80px;
            width: 400px;
            transition-duration: all 0.1s;
            cursor: pointer;

            border-style: solid;
            border-color: white;
            border-width: 3px;
            border-radius: 8px;
        }

        #registerstorepage .bars {
            text-align: center;
            border-radius: 5px 100px;
        }

        #registerstorepage label {
            font-size: 25px;
        }

        #registerstorepage .bars {
            font-size: 30px;
        }

        #registerstorepage button {
            background-color: rgb(0, 128, 117);
            color: white;
            text-align: center;
            text-decoration: none;
            font-size: 18px;
            height: 80px;
            width: 400px;
            transition-duration: all 0.1s;
            cursor: pointer;

            border-style: solid;
            border-color: white;
            border-width: 3px;
            border-radius: 8px;
        }

        #ckapage button {
            background-color: rgb(0, 128, 117);

            color: white;


            text-align: center;
            text-decoration: none;
            font-size: 18px;
            height: 80px;
            width: 250px;
            transition-duration: all 0.1s;
            cursor: pointer;

            border-style: solid;
            border-color: white;
            border-width: 3px;
            border-radius: 8px;
        }

        #ckapage label {
            font-size: 30px;
        }

        #ckapage .bars {

            width: 800px;
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
            height: 80px;
            width: 100%;
            cursor: pointer;
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
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
</head>

<body
    style="background-image:url('https://lh3.googleusercontent.com/pw/AM-JKLXMO5yDb4rwt4sEQrgiQOMODT_pJfb1SL2dd8vpb9xK6qq-v0-sLTcA7ci2YTgbCEc9EH-VWq56ksYL1wsRQOFNAtSXfc6cmCOwCtpfS-Hbcj4rYphCA-b4AYxOAjboLEyfbJ4HxwYWuwhl5jRgETc=w1095-h657-no?authuser=0'); background-size:cover;">
    <label id="heading">Carol's Boutique</label>
    <div id="side">
        <button class="c" id="keepaside" name="button" onclick="openCity(event, 'Keepasidebar')">keep aside</button>
        <button class="c" id="viewreport" name="button" onclick="openCity(event, 'Reportbar')">view report </button>

        <button class="c" id="registerstore" name="button" onclick="openCity(event, 'storebar')">Store</button>
        <button class="c" id="updateemploye" name="button" onclick="openCity(event, 'employeebar')">Employee</button>
        <button class="c" id="ibt" name="button" onclick="openCity(event, 'IBTbar')">IBT</button>
        <button class="c" id="stock" name="button" onclick="openCity(event, 'Stockbar')">Stock</button>
        <button class="c" id="sale" name="button" onclick="openCity(event, 'Salebar')">Sale</button>
    </div>
    <div id="Salebar" class="sideside">
        <button id="Exchangedb" class="b" name="button" value="Exchanged page"
            onclick="changePage(event, 'exchangepage')">Exchanged</button>
        <button id="Returnb" class="b" name="button" value="Return page"
            onclick="changePage(event, 'returnpage')">Return</button>
        <button id="LineItemsb" class="b" name="button" value="LineItems page"
            onclick="changePage(event, 'lineitemspage')">LineItems</button>
    </div>
    <div id="storebar" class="sideside">
        <button id="registerstoreb" class="b" name="button" value="registerstorepage"
            onclick="changePage(event, 'registerstorepage')">register store</button>
    </div>
    <div id="employeebar" class="sideside">
        <button id="registeremployeeb" class="b" name="button" value="registerstorepage"
            onclick="changePage(event, 'registeremployeepage')">Register Employee</button>
        <button id="registeremployeeb" class="b" name="button" value="registerstorepage"
            onclick="changePage(event, 'updateemployeepage')">Update Employee</button>
    </div>
    <div id="Keepasidebar" class="sideside">
        <button id="createkeepasideb" class="b" name="button" value="create keep aside page"
            onclick="changePage(event, 'ckapage')">create keep aside</button>
    </div>
    <div id="Stockbar" class="sideside">
        <button id="createproductb" class="b" name="button" value="createproduct page"
            onclick="changePage(event, 'createproductpage')">create product</button>
        <button id="deleteproductb" class="b" name="button" value="delete product page"
            onclick="changePage(event, 'deleteproductpage')">delete product</button>
        <button id="addtostockb" class="b" name="button" value="add to stock page"
            onclick="changePage(event, 'addtostockpage')">add to stock</button>
        <button id="removefromstockb" class="b" name="button" value="remove from stock page"
            onclick="changePage(event, 'removefromstockpage')">remove from stock</button>
    </div>
    <div id="Reportbar" class="sideside">
        <button id="viewtopempb" class="b" name="button" value="view top employees page"
            onclick="changePage(event, 'viewtopemppage')">view top employees page</button>
        <button id="monthlysalesb" class="b" name="button" value="view monthly sales page"
            onclick="changePage(event, 'monthlysalespage')">view monthly sales</button>
        <button id="topsellingempsb" class="b" name="button" value="view top selling employees page"
            onclick="changePage(event,'topsellingempspage')">view top selling employees</button>
        <button id="achievedtargetb" class="b" name="button" value="view stores that achieved target page"
            onclick="changePage(event,'acheivedtargetpage')">View stores that achieved target page</button>
        <button id="topsellingproductsb" class="b" name="button" value="view top selling products page"
            onclick="changePage(event,'topsellingproductspage')">View top selling products</button>
        <button id="leastperformingstoresb" class="b" name="button" value="view least performing stores page"
            onclick="changePage(event,'leastperformingpage')">View least performing stores</button>
        <button id="productsreportb" class="b" name="button" value="view product report page"
            onclick="changePage(event, 'productreportpage')">View product report</button>
        <button id="dailysalesb" class="b" name="button" value="view daily sales page"
            onclick="changePage(event, 'dailysalespage')">View daily sales page</button>
    </div>
    <div id="IBTbar" class="sideside">

        <button id="ibtrequestb" class="b" name="button" value="IBT Requests page"
            onclick="changePage(event, 'ibtrequestpage')">IBT Requests</button>
    </div>

    <label id="copyright">Carols Boutique pty.Ltd.<br>Reg.131 482 9132</label>
    <div class="mid" id="ckapage">
        <h2 style="font-size:30px;">Create keep aside</h2>

        <label>ProductID:</label>
        <br>
        <br>
        <input style="font-size:30px" class="bars" type="text" name="productID">
        <br>
        <br>
        <label>Amount:</label>
        <br><br>
        <input style="font-size:30px" class="bars" type="number" min="0" name="amount">
        <br>
        <br>
        <label style="font-size:30px"><br>is success:??yes??<br></label>
        <br>

        <button id="createkeepaside" class="ckab" name="button" value="create keep aside">create keep aside</button>
        <button id="clear" class="ckab">clear</button>
    </div>
    <div id="ibtrequestpage" class="mid">
        <h1>Request IBT</h1><br>
        <input type="text" class="searchbar" name="storelocation" placeholder="Search...">
        <button class="searchbutton" name="button" value="text">Submit</button>
        <br><br><label>Product id</label><br>
        <input type="text" class="bars" name="ProductID"><br><br>

        <br><br>
        <label>Amount of products</label><br>
        <input type="number" class="bars" name="button" value="productamount" min="0"><br><br>
        <label
            style="background-color:rgb(10, 102, 102); border-style:solid; border-color:black;border-width:1px;color:white">??result??</label><br><br>
        <button style="width:300px;height:100px;font-size:20px">Request Transfer</button><br>
    </div>
    <div id="registerstorepage" class="mid">
        <h1 id="H">Carols Boutique</h1>
        <br>
        <label>Store name:</label><br>
        <input type="text" class="bars" id="fname" name="name" placeholder="name"><br><br>
        <label>Location:</label><br>
        <input type="text" class="bars" id="flocation" name="location"
            placeholder="province/city/suburb/street"><br><br>
        <label>Target:</label><br>
        <input type="text" class="bars" id="ftarget" name="ftarget" placeholder="R20000"><br><br>
        <label>Password:</label><br>
        <input type="text" class="bars" id="fpassword" name="fname" placeholder="password"><br><br>
        <div id="aline"></div>
        <label>Your Store Id, do not forget.</label><br><br>
        <label>??is succsess??</label>
        <label class="a" id="id">??id??</label><br>
        <br>
        <button type="button" id="signup" name="button" value="Register">register</button><br>
        <br>
    </div>
    <div id="registeremployeepage" class="mid">
        <h1>Register employee</h1>
        <br>
        <label>Name:</label><br>
        <input type="text" class="bars" id="reName" name="reName" placeholder="name"><br><br>
        <label>Surname:</label><br>
        <input type="text" class="bars" id="reSurname" name="reSurname" placeholder="surname"><br><br>
        <label>Password:</label><br>
        <input type="text" class="bars" id="rePassword" name="reName" placeholder="password"><br><br>
        <label>??is success??</label>
        <label>Your Employee Id, do not forget.</label><br><br>
        <label class="a" id="id">??id??</label><br>
        <br>
        <button class="button" id="reSignup" name="reButton" value="Register">Register storeS</button>
        <br>
    </div>

    <div id="viewtopemppage" class="mid">
        <h1>View top employee</h1><br>
        <label>Enter Date</label><br>
        <input type ="month" class="bars" name ="toppageempdate" id="topemployeedate"><br><br>
        <label>Store ID(optional)</label><br>
        <input type ="text" name ="StoreID" class="bars" id="topemployeestoreid"><br><br>
        <button name="button" value="topempresults">Get Results</button><br><br>
        <h2>View top employee for ??Month??</h2><br>
        <table style="width:100%">
            <tr>
                <th>StoreID</th>
                <th>EmployeeID</th>
                <th>Total</th>
            </tr>
            <tr>
                <td>StoreID</td>
                <td>EmployeeID</td>
                <td>Total</td>
            </tr>    
        </table>
        <br>
        <canvas id="pieChart" style="max-height:500px;max-width:500px;"></canvas><br>
        <canvas id="barChart" style="max-height:500px;max-width:500px;"></canvas>
        <br>
    </div>
    <div id="monthlysalespage" class="mid">
        <h1>View top employee</h1><br>
        <label>Enter Date</label><br>
        <input type ="month" class="bars" name ="toppageempdate"><br><br>
        <label>Store ID(optional)</label><br>
        <input type ="text" name ="StoreID" class="bars"><br><br>
        <button name="button" value="topempresults">Get Results</button><br><br>
        <h2>View top employee for ??Month??</h2><br>
        <table style="width:100%">
            <tr>
                <th>StoreID</th>
                <th>EmployeeID</th>
                <th>Total</th>
            </tr>
            <tr>
                <td>StoreID</td>
                <td>EmployeeID</td>
                <td>Total</td>
            </tr>    
        </table>
        <br>
        <canvas id="pieChart" style="max-height:500px;max-width:500px;"></canvas><br>
        <canvas id="barChart" style="max-height:500px;max-width:500px;"></canvas>
        <br>
    </div>
    <div id="topsellingempspage" class="mid">
        <h1>View top employee</h1><br>
        <label>Enter Date</label><br>
        <input type ="month" class="bars" name ="toppageempdate"><br><br>
        <label>Store ID(optional)</label><br>
        <input type ="text" name ="StoreID" class="bars"><br><br>
        <button name="button" value="topempresults">Get Results</button><br><br>
        <h2>View top employee for ??Month??</h2><br>
        <table style="width:100%">
            <tr>
                <th>StoreID</th>
                <th>EmployeeID</th>
                <th>Total</th>
            </tr>
            <tr>
                <td>StoreID</td>
                <td>EmployeeID</td>
                <td>Total</td>
            </tr>    
        </table>
        <br>
        <canvas id="pieChart" style="max-height:500px;max-width:500px;"></canvas><br>
        <canvas id="barChart" style="max-height:500px;max-width:500px;"></canvas>
        <br>
    </div>
    <div id="acheivedtargetpage" class="mid">
        <h1>View top employee</h1><br>
        <label>Enter Date</label><br>
        <input type ="month" class="bars" name ="toppageempdate"><br><br>
        <label>Store ID(optional)</label><br>
        <input type ="text" name ="StoreID" class="bars"><br><br>
        <button name="button" value="topempresults">Get Results</button><br><br>
        <h2>View top employee for ??Month??</h2><br>
        <table style="width:100%">
            <tr>
                <th>StoreID</th>
                <th>EmployeeID</th>
                <th>Total</th>
            </tr>
            <tr>
                <td>StoreID</td>
                <td>EmployeeID</td>
                <td>Total</td>
            </tr>    
        </table>
        <br>
        <canvas id="pieChart" style="max-height:500px;max-width:500px;"></canvas><br>
        <canvas id="barChart" style="max-height:500px;max-width:500px;"></canvas>
        <br>
    </div>
    <div id="topsellingproductspage" class="mid">
        <h1>View top employee</h1><br>
        <label>Enter Date</label><br>
        <input type ="month" class="bars" name ="toppageempdate"><br><br>
        <label>Store ID(optional)</label><br>
        <input type ="text" name ="StoreID" class="bars"><br><br>
        <button name="button" value="topempresults">Get Results</button><br><br>
        <h2>View top employee for ??Month??</h2><br>
        <table style="width:100%">
            <tr>
                <th>StoreID</th>
                <th>EmployeeID</th>
                <th>Total</th>
            </tr>
            <tr>
                <td>StoreID</td>
                <td>EmployeeID</td>
                <td>Total</td>
            </tr>    
        </table>
        <br>
        <canvas id="pieChart" style="max-height:500px;max-width:500px;"></canvas><br>
        <canvas id="barChart" style="max-height:500px;max-width:500px;"></canvas>
        <br>
    </div>
    <div id="leastperformingpage" class="mid">
        <h1>View top employee</h1><br>
        <label>Enter Date</label><br>
        <input type ="month" class="bars" name ="toppageempdate"><br><br>
        <label>Store ID(optional)</label><br>
        <input type ="text" name ="StoreID" class="bars"><br><br>
        <button name="button" value="topempresults">Get Results</button><br><br>
        <h2>View top employee for ??Month??</h2><br>
        <table style="width:100%">
            <tr>
                <th>StoreID</th>
                <th>EmployeeID</th>
                <th>Total</th>
            </tr>
            <tr>
                <td>StoreID</td>
                <td>EmployeeID</td>
                <td>Total</td>
            </tr>    
        </table>
        <br>
        <canvas id="pieChart" style="max-height:500px;max-width:500px;"></canvas><br>
        <canvas id="barChart" style="max-height:500px;max-width:500px;"></canvas>
        <br>
    </div>
    <div id="productreportpage" class="mid">
        <h1>View top employee</h1><br>
        <label>Enter Date</label><br>
        <input type ="month" class="bars" name ="toppageempdate"><br><br>
        <label>Store ID(optional)</label><br>
        <input type ="text" name ="StoreID" class="bars"><br><br>
        <button name="button" value="topempresults">Get Results</button><br><br>
        <h2>View top employee for ??Month??</h2><br>
        <table style="width:100%">
            <tr>
                <th>StoreID</th>
                <th>EmployeeID</th>
                <th>Total</th>
            </tr>
            <tr>
                <td>StoreID</td>
                <td>EmployeeID</td>
                <td>Total</td>
            </tr>    
        </table>
        <br>
        <canvas id="pieChart" style="max-height:500px;max-width:500px;"></canvas><br>
        <canvas id="barChart" style="max-height:500px;max-width:500px;"></canvas>
        <br>
    </div>
    <div id="dailysalespage" class="mid">
        <h1>View top employee</h1><br>
        <label>Enter Date</label><br>
        <input type ="month" class="bars" name ="toppageempdate"><br><br>
        <label>Store ID(optional)</label><br>
        <input type ="text" name ="StoreID" class="bars"><br><br>
        <button name="button" value="topempresults">Get Results</button><br><br>
        <h2>View top employee for ??Month??</h2><br>
        <table style="width:100%">
            <tr>
                <th>StoreID</th>
                <th>EmployeeID</th>
                <th>Total</th>
            </tr>
            <tr>
                <td>StoreID</td>
                <td>EmployeeID</td>
                <td>Total</td>
            </tr>    
        </table>
        <br>
        <canvas id="pieChart" style="max-height:500px;max-width:500px;"></canvas><br>
        <canvas id="barChart" style="max-height:500px;max-width:500px;"></canvas>
        <br>
    </div>
    <div id="lineitemspage" class="mid">
        <h1>Line Items</h1>
        <table>
            <tr>
                <th>ProductID
                </th>
                <th>Item
                </th>
                <th>Size
                </th>
                <th>Qty</th>
                <th>Price
                </th>
            </tr>
            <tr>
                <td>?id??</td>
                <td>??item??</td>
                <td>??size??</td>
                <td>??QTY??</td>
                <td>??Price??</td>
            </tr>
            <tr>
                <td>Total:</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
        <button style="position:absolute;left:500px;" name="button" value="Scan">Scan</button>
        <button style="position:absolute;left:0px;" name="button"
            value="InputintoLineItems">Input</button><br><br><br><br>
        <label style="position:absolute;left:0px;">ProductID</label><br><br>
        <Input style="position:absolute;left:0px;" type="text" name="ProductID" class="bars"> <br><br><br><br>
        <button style="position:absolute;left:0px;" name="button" value="ProceedtoCheckout">Proceed to
            checkout</button><br><br><br><br>
        <button style="position:absolute;left:0px;" name="button" value="Cash">Cash</button>
        <button style="position:absolute;left:500px;" name="button" value="Card">Card</button>
    </div>
    <div id="exchangepage" class="mid">
        <h1>Return</h1><br>
        <label>Receipt ID<label><br>
                <input type="text" name="button" class="bars" name="ReceiptID"><br>
                <button>search</button><br>
                <button>Scan</button>
                <br><br>
                <label>??result??</label><br><br>
                <table>
                    <tr>
                        <th>ProductID</th>
                        <th>Item</th>
                        <th>Size</th>
                        <th>Qty</th>
                        <th>Price</th>
                    </tr>

                    <tr>
                        <td>?ProductID?
                        </td>
                        <td>??item??
                        </td>
                        <td>??size??
                        </td>
                        <td>??Qty??</td>
                        <td>??Price??
                        </td>
                    </tr>
                    <tr style="background-color:red">
                        <td>?ProductID?
                        </td>
                        <td>??-item??
                        </td>
                        <td>??size??
                        </td>
                        <td>??Qty??</td>
                        <td>??Price??
                        </td>
                    </tr>
                    <tr style="background-color:green">
                        <td>?ProductID?
                        </td>
                        <td>??+item??
                        </td>
                        <td>??size??
                        </td>
                        <td>??Qty??</td>
                        <td>??Price??
                        </td>
                    </tr>
                </table><br>
                <label style>ProductID</label><br>
                <input type="text" name="ProductID" class="bars">
                <br><br>
                <button name="button" value="addwithproductID">add with productID</button><br><br>
                <button name="button" value="addwithScan">add with Scan</button><br><br>
                <button name="button" value="exchangedItem">Select item that is being exchanged</button><br><br>
                <button name="button" value="ConfirmExchange">Confirm Exchange</button>


    </div>
    <div id="returnpage" class="mid">
        <h1>Return</h1><br>
        <label>Receipt ID<label><br>
                <input type="text" name="ReceiptID" class="bars"><br>
                <button>search</button><br>
                <button>Scan</button>
                <br><br>
                <label>??result??</label><br><br>
                <table>
                    <tr>
                        <th>ProductID</th>
                        <th>Item</th>
                        <th>Size</th>
                        <th>Qty</th>
                        <th>Price</th>
                    </tr>
                    <tr>
                        <td>?ProductID?
                        </td>
                        <td>??item??
                        </td>
                        <td>??item??
                        </td>
                        <td>Qty</td>
                        <td>??item??
                        </td>
                    </tr>
                </table>
                <br><br>
                <label>Customer's Email Adress</label><br>
                <input type="text" name="Email" class="bars"><br><br>
                <button name="button" value="removeitem">remove item</button><br>
                <button name="button" value="ConfirmReturn">Confirm</button>


    </div>
    <div id="addtostockpage" class="mid">
        <h2>add to stock</h2><br>
        <label>enter in the id number</label><br>
        <input type="text" name="stockid" class="bars"><br><br>
        <label>enter in the amount you want to add to stock</label><br>
        <input type="number" min="0" name="amount" class="bars"><br><br>
        <button name="button" value="addtostock">add to stock</button>
    </div>
    <div id="createproductpage" class="mid">
        <div id="mid">
            <h2>Create Product</h2><br>
            <label>Name</label><br>
            <input type="text" name="name" class="bars"><br><br>
            <label>Description</label><br>
            <input type="text" name="description" class="bars"><br><br>
            <label>Price</label><br>
            <input type="number" min="0" name="price" class="bars"><br><br>
            <label>size</label><br>
            <input type="text" name="size" class="bars"><br><br><label>??success??</label><br><br>
            <button name="button" value="createproduct">Create product</button>
        </div>
    </div>
    <div id="deleteproductpage" class="mid">
        <h1>Delete Product</h1><br>
        <label>ProductID</label><br>
        <input type="text" name="productID" class="bars"><br><br>
        <label>??success??</label><br><br><br>
        <button name="button" value="deleteproduct">Delete product</button>

    </div>
    <div id="removefromstockpage" class="mid">
        <h2>Remove from stock</h2><br>
        <label>enter in the id number of the product</label><br>
        <input type="text" name="stockid" class="bars"><br><br>
        <label>enter in the amount you want to remove from stock</label><br>
        <input type="number" min="0" name="amount" class="bars"><br><br>
        <button name="button" value="removefromstock">remove from stock</button>
    </div>
    <div id="updateemployeepage" class="mid">
        <h1>Update Employee</h1>
        <br>
        <label>enter the employees id whom you want to promote</label>
        <br><br>
        <input type="text" value="employee id" class="bars" placeholder="emp4363">
        <br><br>
        <label>??is success??</label>
        <br><br>
        <button name="button" values="updateemployee">update employee</button>
    </div>
    <script>
        
        var xValues = ["Italy", "France", "Spain", "USA", "Argentina"];
        var yValues = [55, 49, 44, 24, 15];
        var barColors = ["red", "green", "blue", "orange", "brown"];
        var xValues = ["Italy", "France", "Spain", "USA", "Argentina"];
        var yValues = [55, 49, 44, 24, 15];
        var barColors = [
            "#b91d47",
            "#00aba9",
            "#2b5797",
            "#e8c3b9",
            "#1e7145"
        ];

        new Chart("pieChart", {
            type: "pie",
            data: {
                labels: xValues,
                datasets: [{
                    backgroundColor: barColors,
                    data: yValues
                }]
            },
            options: {
                title: {
                    display: true,
                    text: "World Wide Wine Production 2018"
                }
            }
        });
        new Chart("barChart", {
            type: "bar",
            data: {

                labels: xValues,
                datasets: [{
                    backgroundColor: barColors,
                    data: yValues
                }]
            },
            options: {
                legend: { display: false },
                title: {
                    display: true,
                    text: "World Wine Production 2018"
                }
            }
        });
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


        document.getElementById("viewreport").click();
        document.getElementById("viewtopempb").click();
        function changePage(evt, pagename) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("mid");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("b");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(pagename).style.display = "block";
            evt.currentTarget.className += " active";
        }
        function resultfortopemp(){
            var xhr = new XMLHttpRequest(),date= document.getElementById('topemployeedate').value,storeid=document.getElementById('topemployeestoreid').value;
                    xhr.open('GET','http://localhost:8080/Carols_Boutique-1.0-SNAPSHOT/pos/store/loginStore',true);
                    xhr.setRequestHeader('Content-type','application/json;charset=UTF-8');
                    report= "{date:"+date+"storeid:"+storeid+"}";
                    xhr.send(report);
        }
        function clearEverything(){
            
        }
        function filltable(){
            
        }


    </script>
</body>
</html>
