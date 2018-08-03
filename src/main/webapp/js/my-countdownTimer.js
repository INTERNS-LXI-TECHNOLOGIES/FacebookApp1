/*<!DOCTYPE html>
<html>
<head>
<script>*/

function setCookie(cname,cvalue) {
    var d = new Date();
    d.setTime(d.getTime() + 120000);
    var expires = "expires=" + d.toGMTString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function resetCookie() {
    
    document.cookie = "time=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function checkCookie() {
    var time=getCookie("time");
    if (time != "") {
        //alert("Welcome again " + user);
    } else {
       //user = prompt("Please enter your name:","");
       time=new Date().getTime();
       if (time !="" && time != null) {
           setCookie("time", time);
       }
    }
}
// Set the date we're counting down to
var countDownDate = parseInt(getCookie("time"))+120000;
//alert(countDownDate);

// Update the count down every 1 second
var x = setInterval(function() {

    // Get todays date and time
    var now = new Date().getTime();
    
    // Find the distance between now an the count down date
    var distance = countDownDate - now;
    //console.log(distance);
    
    // Time calculations for days, hours, minutes and seconds
    //var days = Math.floor(distance / (1000 * 60 * 60 * 24));
    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
    // Output the result in an element with id="demo"
    var timer;
    if(isNaN(hours)||isNaN(minutes)||isNaN(seconds)) {
        timer="Timer";
    }
    else
        timer=""+ minutes + "m " + seconds + "s ";
    document.getElementById("timer").innerHTML = timer;
    if(hours==0 && minutes==0 && seconds<15)
    {
        document.getElementById("timer").style.color='red';
    }
    
    // If the count down is over, write some text 
    if (distance < 0) {
        clearInterval(x);
        document.getElementById("timer").innerHTML = "OVER";
        window.location="gameover.jsp";
    }
}, 1000);