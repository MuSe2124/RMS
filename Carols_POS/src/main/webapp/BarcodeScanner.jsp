<%-- 
    Document   : BarcodeScanner
    Created on : 27 Jun 2022, 08:43:27
    Author     : muaad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <script type="text/javascript" src="instascan.js.min"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="col-md-6">
                <div class="row">
                    <video id="preview" width="100%"></video>
                </div>
                <div class="col-md-6">
                    <label>SCAN QR CODE</label>
                    <form>
                        <label>QR CODE: <input type="text" id="text"></label>
                    </form>
                </div>
            </div>
        </div>

        <script>
            let scanner = new Instascan.Scanner({video: document.getElementById('preview')});
            scanner.addListener('scan', function(c){
                document.getElementById('text').value=c;
            });
            
            Instascan.Camera.getCameras().then(function(cameras){
                if(cameras.length > 0) {
                    scanner.start(cameras[0]);
                }else{
                    alert('no cameras found');
                }               
            }).catch(function(e){
                console.error(e);
            });            
        </script>

    </body>
</html>
