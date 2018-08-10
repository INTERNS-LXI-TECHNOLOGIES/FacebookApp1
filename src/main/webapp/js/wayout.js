var doorId;
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
/*$(function(){
    $('#question-timer').countdowntimer({
        seconds : 20,
        size : "lg",
        displayFormat : "S",
        expiryUrl : "play?doorId="+doorId+"\&isAccessDenied=true",
    });
});*/
function popupWarningWindow(id) {
    doorId=id;
    document.getElementById('warning-message').style.display='block';
}
function noAccess() {
/*    var audio = new Audio('../audio/windows_xp_error.mp3');
    audio.play();*/
    var audio=document.getElementById('warning-sound');
    audio.play();
    document.getElementById('warning').style.display='block';
}
function noOpen() {
    document.getElementById('no-hall').style.display='block';
}
function redirect() {
    window.location="question.jsp?doorId="+doorId;
}
function start(id) {
    doorId=id;
    $('#question-timer').countdowntimer({
        seconds : 20,
        size : "lg",
        displayFormat : "S",
        expiryUrl : "play?doorId="+doorId+"\&isAccessDenied=true",
    });
}
window.onload=checkCookie;