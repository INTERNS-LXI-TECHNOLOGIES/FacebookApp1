$(document).ready(function(){
    $("#change-lock").hover(function(){
        $(this).attr("src","images/lock_open.png");
        $(".p-animation").hide();
    },
    function(){
    	$(this).attr("src","images/lock.png");
    	$(".p-animation").show();
    }); 
});
$(function(){
  $('.bxslider').bxSlider({
    mode: 'fade',
    captions: true,
    slideWidth: 800,
  });
});
$(function(){
    $('#question-timer').countdowntimer({
        minutes :1,
        seconds : 10,
        size : "lg",
        displayFormat : "MS",
        expiryUrl : "play?doorId="+doorId,
    });
});
var doorId;
function popupWarningWindow(id) {
    doorId=id;
    document.getElementById('warning-message').style.display='block';
}
function getAccess(id,number) {
    if(number>0){
        window.location="hjhk";
    }
}
function redirect() {
    window.location="question.jsp?doorId="+doorId;
}
function start(id) {
    doorId=id;
    checkCookie();
}