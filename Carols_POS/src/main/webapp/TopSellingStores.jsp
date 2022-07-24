<%-- 
    Document   : TopSellingStores
    Created on : 30 Jun 2022, 02:29:47
    Author     : HP
--%>

<%@page import="za.co.carols_boutique_pos.models.piechart"%>
<%@page import="za.co.carols_boutique.models.Employee"%>
<%@page import="za.co.carols_boutique.models.StoreSale"%>
<%@page import="za.co.carols_boutique_pos.models.StoreSales"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="za.co.carols_boutique_pos.models.Report"%>
<%@page import="za.co.carols_boutique.models.EmpSale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Top Selling Store</title>
        
        <style>
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
         #reportpage table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #reportpage td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        #reportpage tr:nth-child(even) {
            background-color: #dddddd;
        }
        #reportpage button{
            
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
        #reportpage .bars{
            font-size:25px;
            width:400px;
        }
        #reportpage label{
            font-size:30px;
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
        
        
        
        
        
        
        
        
        .graph {
	       margin-bottom:1em;
               font:normal 100%/150% arial,helvetica,sans-serif;
            }

            .graph caption {
	        font:bold 150%/120% arial,helvetica,sans-serif;
	        padding-bottom:0.33em;
            }

            .graph tbody th {
	       text-align:right;
            }



		.graph {
		    display:block;
                    width:600px;
                    height:300px;
		}

		.graph caption {
			display:block;
		}

		.graph thead {
			display:none;
		}

		.graph tbody {
			position:relative;
			display:grid;
			grid-template-columns:repeat(auto-fit, minmax(2em, 1fr));
			column-gap:2.5%;
			align-items:end;
			height:100%;
			margin:3em 0 1em 2.8em;
			padding:0 1em;
			border-bottom:2px solid rgba(0,0,0,0.5);
			background:repeating-linear-gradient(
				180deg,
				rgba(170,170,170,0.7) 0,
				rgba(170,170,170,0.7) 1px,
				transparent 1px,
				transparent 20%
			);
		}

		.graph tbody:before,
		.graph tbody:after {
			position:absolute;
			left:-3.2em;
			width:2.8em;
			text-align:right;
			font:bold 80%/120% arial,helvetica,sans-serif;
		}

		.graph tbody:before {
			
			top:-0.6em;
		}

		.graph tbody:after {
			content:"0";
			bottom:-0.6em;
		}

		.graph tr {
			position:relative;
			display:block;
		}

		

		.graph th,
		.graph td {
			display:block;
			text-align:center;
		}

		.graph tbody th {
			position:absolute;
			top:-3em;
			left:0;
			width:100%;
			font-weight:normal;
			text-align:center;
                        white-space:nowrap;
			text-indent:0;
			transform:rotate(-45deg);
		}

		

		.graph td {
			width:100%;
			height:100%;
			background:#F63;
			border-radius:0.5em 0.5em 0 0;
			transition:background 0.5s;
		}
            #my-pie-chart {
             border-radius: 50%;
            }
            #my-pie-chart {
            height: 500px;
            width: 500px;
            }
        </style>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    </head>
    <body style="background-image:url('https://lh3.googleusercontent.com/pw/AM-JKLXMO5yDb4rwt4sEQrgiQOMODT_pJfb1SL2dd8vpb9xK6qq-v0-sLTcA7ci2YTgbCEc9EH-VWq56ksYL1wsRQOFNAtSXfc6cmCOwCtpfS-Hbcj4rYphCA-b4AYxOAjboLEyfbJ4HxwYWuwhl5jRgETc=w1095-h657-no?authuser=0'); background-size:cover;">
        <label id="heading">Carol's Boutique</label>
    <%Employee emp=(Employee)session.getAttribute("employee");%>
    <div id="side">
        <%if(emp.getIsManager()==true){%>
        <button class="c" id="keepaside" name="button" onclick="openCity(event, 'Keepasidebar')">keep aside</button>
        <button class="c" id="viewreport" name="button" onclick="openCity(event, 'Reportbar')">view report </button>
        <button class="c" id="registerstore" name="button" onclick="openCity(event, 'storebar')">Store</button>
        <button class="c" id="updateemploye" name="button" onclick="openCity(event, 'employeebar')">Employee</button>
        <button class="c" id="ibt" name="button" onclick="openCity(event, 'IBTbar')">IBT</button>
        <button class="c" id="stock" name="button" onclick="openCity(event, 'Stockbar')">Stock</button>
        <button class="c" id="sale" name="button" onclick="openCity(event, 'Salebar')">Sale</button>
        <%}else{%>
        <button class="c" id="keepasideemp" name="button" onclick="openCity(event, 'Keepasidebar')">keep aside</button>
        <button class="c" id="ibtemp" name="button" onclick="openCity(event, 'IBTbar')">IBT</button>
        <button class="c" id="saleemp" name="button" onclick="openCity(event, 'Salebar')">Sale</button>
        <%}%>
    </div>
        
          
        
    <div id="Salebar" class="sideside">
        <a href="Exchange.jsp" id="Exchangedb" class="b" name="button" value="Exchanged page"
            >Exchanged</a><br>
        <a href="Return.jsp" id="Returnb" class="b" name="button" value="Return page"
            >Return</a><br>
        <a href="createSale.jsp"id="LineItemsb" class="b" name="button" value="LineItems page"
            >Create Sale</a>
    </div>
    <div id="storebar" class="sideside">
        <a href="RegisterStore.jsp" id="registerstoreb" class="b" name="button" value="registerstorepage"
            >register store</a>
    </div>
    <div id="employeebar" class="sideside">
        <a href="RegisterEmployee.jsp" id="registeremployeeb" class="b" name="button" value="registerstorepage"
            >Register Employee</a><br>
        
    </div>
    <div id="Keepasidebar" class="sideside">
        <a href="CreateKeepAside.jsp" id="createkeepasideb" class="b" name="button" value="createkeepasidepage"
            >create keep aside</a>
    </div>
    <div id="Stockbar" class="sideside">
        <a href ="CreateProduct.jsp" id="createproductb" class="b" name="button" value="createproduct page"
            >create product</a><br>
        
        <a href="AddToStock.jsp" id="addtostockb" class="b" name="button" value="add to stock page"
            >add to stock</a><br>
        <a href ="RemoveFromStock.jsp" id="removefromstockb" class="b" name="button" value="remove from stock page"
            >remove from stock</a>
    </div>
    <div id="Reportbar" class="sideside">
        <a href="TopSellingStores.jsp" id="viewtopstoreb" class="b" name="button" value="view top employees page"
            >view top Achieving Stores page</a><br>
        
        <a href ="CustomerReviewReport.jsp" id="topreviewsb" class="b" name="button" value="view top selling employees page"
            >view top selling employees</a><br>
        <a href ="AcheivedTarget.jsp"id="achievedtargetb" class="b" name="button" value="view stores that achieved target page"
            >View stores that achieved target page</a><br>
        <a href ="TopSellingEmployees.jsp" id="topsellingproductsb" class="b" name="button" value="view top selling products page"
            >View top selling Employees</a><br>
        <a href="LeastPerformingStores.jsp" id="leastperformingstoresb" class="b" name="button" value="view least performing stores page"
            >View least performing stores</a><br>
        <a href="ProductReport.jsp" id="productsreportb" class="b" name="button" value="view product report page"
            >View product report</a><br>
        <a href="ViewDailySales.jsp" id="dailysalesb" class="b" name="button" value="view daily sales page"
            >View daily sales page</a>
        <a href="TopSellingProducts.jsp" id="topsellingproductsb" class="b" 
            >Top Selling Products</a>    
    </div>
    <div id="IBTbar" class="sideside">

        <a href ="RequestIBT.jsp" id="ibtrequestb" class="b" name="button" value="IBT Requests page"
            >Request IBT</a>
    </div>
    <%Report report1 = (Report)request.getAttribute("TopSellingStoreReport");
    Report report2 = (Report)request.getAttribute("LeastSellingStoreReport");
    Report report = null;
    if(report1 != null){
    report = report1;
    }
    if(report2 != null){
    report = report2;
    }
    List<String> xval=new ArrayList<>(); List<Float> yval = new ArrayList<>();List<String> colors=new ArrayList<>();%>
        
    <div id="reportpage" class="mid">
        <form action="ReportServlet" method =get>
            <%if(report1 !=null){%>
        <h1>Top Selling Stores</h1><br>
        <%}else{%>
         <h1>least performing Stores</h1>
         <%}%>
        <label>Enter Date</label><br>
        <input type ="text" class="bars" list="monthList" name ="TopSellingStoremonth">
        <datalist  id ="monthList">
            <option value="January">
            <option value="February">
            <option value="March">
            <option value="April">
            <option value="May">
            <option value="June">
            <option value="July">
            <option value="August">
            <option value="September">
            <option value="October">    
            <option value ="November">
            <option value="December">
        </datalist><br><br>
        <button name="button" value="TopSellingStorebutton">Get Results</button><br><br>
        </form>
        <%if(report!=null){%>
        <%if(report1 !=null){%>
        <h2 >table of top selling stores</h2><br>
        <%}else{%>
        <h2 >table of least performing stores</h2><br>
        <%}%>
        <table style="width:100%">
            <tr>
                <th>Store ID</th>
                <th>sale Total</th>
                
            </tr>
            <%for(StoreSale ss :report.getStoreSales()){%>
            <tr><%xval.add(ss.getStoreID());yval.add(ss.getSaleTotal());%>
                <%colors.add("rgb("+(int)Math.random()*256+","+(int)Math.random()*256+","+(int)Math.random()*256+")");%>
                <td> <%= ss.getStoreID() %> </td>
                <td> <%= ss.getSaleTotal() %> </td>
                
            </tr>
            <%}%>
        </table>
        <br>
        <br>
        <button class="bars" onclick="showbar()">Show bar graph</button>
        <button onclick="showpie()" class="bars">show pie chart</button><br>
        <br>
        <br>
        <%piechart pie = new piechart(xval,yval);%>
        <%float start =0f;%>
        
        <%if(report1 !=null){%>
        <h1 id="piechartheading">Pie Chart of top selling stores</h1>
        <%}else{%>
        <h1 id="piechartheading">Pie Chart of least performing stores</h1>
        <%}%>
        <div id="my-pie-chart" style="background: conic-gradient(black 0.00%,<%for(int i =0; i<pie.getName().size();i++){%>
             <%=pie.getColours().get(i)%>  
             <%=start%>%  
             <%=pie.getPercentagePosition().get(i)%>%  
             <%start=pie.getPercentagePosition().get(i);%> 
            <%if(i!=pie.getName().size()-1){%>
            ,
            <%}%>
        <%}%>);"></div>
        <br>
        
        <table style="width:100px" id="tablecolors">
            <tr style="background-color:black; color:white;border: 1px solid black">
                <td>Names</td>
            </tr>
            <%for(int i =0; i<pie.getName().size();i++){%>
            <tr style="background-color:<%=pie.getColours().get(i)%>;">
                <td><%=pie.getName().get(i)%></td>
            </tr>
            <%}%>
        </table>
        <br>
        
        <table class="graph" id ="barchartgraph">
	
        <%if(report1 !=null){%>
        <caption>Bar Chart of top selling stores</caption>
        <%}else{%>
        <caption>Bar Chart of least performing stores</caption>
        <%}%>
	<thead>
		<tr>
			<th scope="col">Item</th>
			<th scope="col">Percent</th>
		</tr>
	</thead><tbody >
                <%for(int i =0; i<pie.getName().size();i++){%>
                <tr style ="height:<%=pie.getTablePercentage().get(i)%>%">
                <th scope="row"><%=pie.getName().get(i)%></th>
                <td><span><%=pie.getFvalues().get(i)%></span></td>
                </tr>
                <%}%>
	</tbody>
        </table>
        
        <br><br><br><br><br><br><br><br><br><br><br>
        <a onclick="this.href='data:text/html;charset=UTF-8,'+encodeURIComponent(document.documentElement.outerHTML)" href="topSellingStoresReport.pdf" download="topSellingStoresReport.pdf">Download Report</a></p>
        <%}%>
    </div>    
        
        
    <label id="copyright">Carols Boutique pty.Ltd.<br>Reg.131 482 9132</label>
    
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
        
        
        function showbar(){
                document.getElementById("piechartheading").style.display = "none";
                document.getElementById("tablecolors").style.display = "none";
                document.getElementById("my-pie-chart").style.display = "none";
                document.getElementById("barchartgraph").style.display = "";
            }
            function showpie(){
                document.getElementById("piechartheading").style.display = "";
                document.getElementById("tablecolors").style.display = "";
                document.getElementById("my-pie-chart").style.display = "";
                document.getElementById("barchartgraph").style.display = "none";
            }
            document.getElementById("piechartheading").style.display = "none";
            document.getElementById("tablecolors").style.display = "none";
            document.getElementById("my-pie-chart").style.display = "none";
            document.getElementById("barchartgraph").style.display = "none";
        
    </script>
    </body>
</html>
