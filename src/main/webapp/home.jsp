<%@ page language = "java" contentType = "text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Form Demo</title>
</head>
<body>
    <h1 align = "center" id = "bidd">${bidder}</h1>
    <br>


    <form action="/setBidder" method="post">
        <input type="text" id="bid" name="bid" placeholder="Enter Bid">  <input type="submit">
    </form>
</body>

<script>

    //const delay = (ms = 1000) => new Promise(r => setTimeout(r, ms));

    setInterval(async function(){
       //await delay();
       var response = await fetch('/data');
       var myJson = await response.json();

       document.getElementById("bid").innerHTML = myJson.data;
    },1000);
</script>
</html>