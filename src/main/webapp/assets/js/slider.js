$.fn.Slider = function(options) {
    var defaults = {
        speed: 400,
        mode: 'horizontal'
    };
    var config = $.extend( {}, defaults, options );

    var Slider = function(settings) {
        this.o = this;
        this.settings = config;
        this.slider = $('#main-slider');
        this.children = this.slider.children();
        this.activeSlide = this.children.first().addClass('active');
        this.slideNumber = this.children.length;
        this.sliderOuterWrapper;
        this.sliderWrapper;
        this.sliderArrow;
        this.actualPosition;
        this.windowHeight = $(window).height();

        function changeSlide(elem) {
            this.nextSlide = elem.next();
            this.prevSlide = elem.prev();
        };

        this.init = function() {

            // Variables
            //––––––––––––––––––
            var outerWidth = window.outerWidth;
            this.actualPosition = 0;

            this.slider.children().remove();
            this.slider.html('<div class="slider-wrapper-outer"></div><div class="slider-controls"></div>');

            this.sliderOuterWrapper = this.slider.find('.slider-wrapper-outer');
            this.sliderOuterWrapper.html('<div class="slider-wrapper"></div>');

            this.sliderWrapper = this.sliderOuterWrapper.find('.slider-wrapper');
            this.sliderWrapper.html(this.children);

            var sliderControls = this.slider.find('.slider-controls');
            var arrowLeft = '<div class="arrow arrow-left"></div>';
            var arrowRight = '<div class="arrow arrow-right"></div>';

            sliderControls.html(arrowLeft + arrowRight);

            this.children.addClass('slider-item').css('width', outerWidth);
            this.children = this.sliderWrapper.children();
            this.sliderArrow = {
                right : this.slider.find('.arrow.arrow-right'),
                left : this.slider.find('.arrow.arrow-left')
            };
            this.sliderWrapper.css("transform", 'translate3d(0px, 0px, 0px)');
            if ( this.settings.mode == 'horizontal' ) {
                this.sliderWrapper.css( 'width', this.slideNumber * outerWidth );
            } else {
                this.sliderWrapper.css( 'width', outerWidth );
            }
            events(this);
        };
        var events = function(el) {

            var ob = el.o;

            // Slider Right
            el.sliderArrow.right.click(function() {
                ob.goToNextSlide();
            });
            // Slider Left
            el.sliderArrow.left.click(function() {
                ob.goToPrevSlide();
            });
            // Resize
            $(window).resize(function() {
                ob.resize();
            });
        };
        var setActiveSlide = function(el, direction) {
            el.activeSlide = el.sliderWrapper.find('.active').removeClass('active');

            if (direction == 'next')
                el.activeSlide = new changeSlide(el.activeSlide).nextSlide;
            else if (direction == 'prev')
                el.activeSlide = new changeSlide(el.activeSlide).prevSlide;

            el.activeSlide.addClass('active');
        };
        var transitionHorizontal = function(el) {
            el.sliderWrapper.css({
                'transition': 'all ' + el.settings.speed + 'ms',
                'transform': "translate3d(" + parseInt(el.actualPosition) + "px, 0px, 0px)",
            });
        };
        var transitionVertical = function(el) {
            el.sliderWrapper.css({
                'transition': 'all ' + el.settings.speed + 'ms',
                'transform': "translate3d(0px," + parseInt(el.actualPosition) + "px, 0px)",
            });
        };
        this.goToNextSlide = function() {
            // Set actual childrens
            this.children = this.sliderWrapper.children();

            // Core Function
            if ( this.settings.mode == 'horizontal') {
                this.actualPosition = this.actualPosition - outerWidth;
                transitionHorizontal(this);
            } else if( this.settings.mode == 'vertical') {
                this.actualPosition = this.actualPosition - this.windowHeight;
                transitionVertical(this);
            }
            if ( this.activeSlide.index() + 1 == this.slideNumber ) {
                // Go To Start
                this.goToStart();
            } else {
                // Change active slide
                setActiveSlide(this, 'next');
            }
        };
        this.goToPrevSlide = function() {

            // Set actual childrens
            this.children = this.sliderWrapper.children();
            if ( this.settings.mode == 'horizontal' ) {
                this.actualPosition = this.actualPosition + outerWidth;
                transitionHorizontal(this);
            } else {
                this.actualPosition = this.actualPosition + this.windowHeight;
                transitionVertical(this);
            }
            if ( this.activeSlide.index() == 0 ) {
                // Go To End
                this.goToEnd();
            } else {
                // Change active slide
                setActiveSlide(this, 'prev');
            }
        };
        this.goToStart = function() {

            this.actualPosition = 0;
            this.sliderWrapper.css({
                'transition': 'all 1000ms',
                'transform': "translate3d(" + parseInt(this.actualPosition) + "px, 0px, 0px)",
            });
            this.sliderWrapper.find('.active').removeClass('active');
            this.activeSlide = this.children.first().addClass('active');
        }
        this.goToEnd = function() {

            this.sliderWrapper.css('transition', 'all 1000ms');

            if ( this.settings.mode == "horizontal" ) {
                this.actualPosition = -(this.slideNumber - 1) * outerWidth;
                this.sliderWrapper.css(
                    'transform', "translate3d(" + parseInt(this.actualPosition) + "px, 0px, 0px)"
                );
            } else if ( this.settings.mode == "vertical" ) {
                this.actualPosition = -(this.slideNumber - 1) * this.windowHeight;
                this.sliderWrapper.css(
                    'transform', "translate3d(0px," + parseInt(this.actualPosition) + "px, 0px)"
                );
            }

            this.sliderWrapper.find('.active').removeClass('active');
            this.activeSlide = this.children.last().addClass('active');
        };
        this.resize = function() {
            // outerWidth = $(window).outerWidth();
            this.sliderWrapper.css('transform', 'all 0ms');
            if ( this.settings.mode == 'horizontal') {
                this.actualPosition = ((-this.activeSlide.index()) * outerWidth);
                this.sliderWrapper.css({
                    'width': this.slideNumber * outerWidth,
                    'transform': "translate3d(" + this.actualPosition + "px, 0px, 0px)",
                });
            } else if ( this.settings.mode == 'vertical') {
                this.windowHeight = $(window).height();
                this.actualPosition = ((-this.activeSlide.index()) * this.windowHeight);
                this.sliderWrapper.css({
                    'transition': 'all 0ms',
                    'transform': "translate3d(0px," + this.actualPosition + "px, 0px)",
                });
            }
            this.children.css({
                'width': outerWidth,
                'transition': 'all 0ms'
            });
        };
        this.init();
    };
    var slider = new Slider(options);
}
