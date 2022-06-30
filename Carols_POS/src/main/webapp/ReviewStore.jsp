<%-- 
    Document   : ReviewStore
    Created on : 29 Jun 2022, 10:08:28
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Review Store</title>
        <style>
            h1{
                font-size:40px;
            }
            .radiolabels{
                font-size: medium;
            }
            button{
                background-color: rgb(0, 0, 128);
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;

                font-size: 18px;

                width:300px;
                transition-duration: all 0.1s;
                cursor: pointer;

            }
            




        </style>    
    </head>
    <body style ="text-align: center;">
        <form action="" method =get>
        
        <h1>Carol's Boutique</h1><br><br>  
        <label id="first">Click on the rating, you want to give to our store</label><br><br>
        <div id = "radiocontainer">
        <label class="radiolabels">1:</label>
        <input id ="1" type="radio" name ="radiogroup" value ="1" class="rg"><br><br>
        <label class="radiolabels">2:</label>
        <input id ="2" type="radio" name ="radiogroup" value ="2" class="rg"><br><br>
        <label class="radiolabels">3:</label>
        <input id ="3" type="radio" name ="radiogroup" value ="3" class="rg"><br><br>
        <label class="radiolabels">4:</label>
        <input id ="4" type="radio" name ="radiogroup" value ="4" class="rg"><br><br>
        <label class="radiolabels">5:</label>
        <input id ="5" type="radio" name ="radiogroup" value ="5" class="rg"><br><br>
        <label class="radiolabels">6:</label>
        <input id ="6" type="radio" name ="radiogroup" value ="6" class="rg"><br><br>
        <label class="radiolabels">7:</label>
        <input id ="7" type="radio" name ="radiogroup" value ="7" class="rg"><br><br>
        <label class="radiolabels">8:</label>
        <input id ="8" type="radio" name ="radiogroup" value ="8" class="rg"><br><br>
        <label class="radiolabels">9:</label>
        <input id ="9" type="radio" name ="radiogroup" value ="9" class="rg"><br><br>
        <label class="radiolabels">10:</label>
        <input id ="10" type="radio" name ="radiogroup" value ="10" class="rg"><br><br>
        </div>
        <label id="commentlabel">Please enter a comment</label><br><br> 
        <input type="text" class="bars" name="reviewComment"><br><br>
        <button type="submit">Send Review</button>
        </form>
    </body>
</html>
