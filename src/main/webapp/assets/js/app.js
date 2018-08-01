$(document).ready(function() {

    // Basic Functions
    //––––––––––––––––––
    function windowWidth() {
        var winWidth = $(window).width();
        // console.log(winWidth);
        return winWidth;
    };
    function windowHeight() {
        var winHeight = $(window).height();
        // console.log(winHeight);
        return winHeight;
    };

    // Slider Init
    //––––––––––––––––––––
    $('body').css('height', windowHeight());

    // var slider = new Slider();
    $('#main-slider').Slider({
        speed: 800,
        mode: 'vertical',
    });

    // Functions onResize
    //––––––––––––––––––––
    $(window).resize(function() {
        $('body').css('height', windowHeight());
    });
})
