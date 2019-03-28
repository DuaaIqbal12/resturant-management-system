<%-- 
    Document   : index
    Created on : 24-Mar-2019, 21:20:35
    Author     : Saman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/header.jsp"%>
<script>
  function toggleOverlay(){
      var overlay = document.getElementById('overlay');
      var specialBox = document.getElementById('specialBox');
      overlay.style.opacity = .8;
      if(overlay.style.display === "block"){
        overlay.style.display = "none";
        specialBox.style.display = "none";
      } else {
        overlay.style.display = "block";
        specialBox.style.display = "block";
      }
    }
    </script>
<style>
    body {
  background-color: #000;
  margin: 0;
  padding: 0;

  color: white;
}

.box {
   width: 900px;
  padding: 40px;
  position: absolute;
  top: 50%;
  left: 50%; 
   transform: translate(-50%, -50%); 
  background: #191919;
  text-align: center;
}

.box h1 {
  color: white;
  text-transform: uppercase;
  font-weight: 500;
}

.box input[type="text"],
.box input[type="number"],
.box input[type="password"] {
  border: 0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #3498db;
  border-radius: 24px;
  padding: 14px 10px;
  width: 200px;
  outline: none;
  color: white;
  transition: 0.25s;
}

.box input[type="text"]:focus,
.box input[type="number"]:focus,
.box input[type="password"]:focus {
  width: 280px;
  border-color: #2ecc71;
}

.box input[type="submit"] {
  border: 0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #2ecc71;
  border-radius: 24px;
  padding: 14px 40px;
  outline: none;
  color: white;
  transition: 0.25s;
  cursor: pointer;
}

.box input[type="submit"]:hover {
  background-color: #2ecc71;
}



/* overlay */

div#overlay {
  display: none;
  z-index: 2;
  background: #000;
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0px;
  left: 0px;
  text-align: center;
}

div#specialBox {
  display: none;
  position: relative;
  z-index: 3;
  margin: 150px auto 0px auto;
  width: 500px;
  height: 300px;
  background: #FFF;
  color: #000;
}

div#wrapper {
  position: absolute;
  top: 0px;
  left: 0px;
  padding-left: 24px;
}

    </style>
<body>
  <!-- End Overlay -->
  <!-- Start Special Centered Box -->
 
    <form action="/resturantSystem/insert" method="post" class="box">
      <h1>Add menu</h1>
      <input type="text" name="" placeholder="Dish item" name="@dishItem">
      <input type="number" name="" placeholder="Price" name="price">
      <input type="text" name="" placeholder="Type" name="type">
      <input type="submit" value="Add" name="">
      <input type="submit" Value="Back" onmousedown="toggleOverlay()">
    </form>

  <!-- End Special Centered Box -->
  <!-- Start Normal Page Content -->
  
</body>

</html>

