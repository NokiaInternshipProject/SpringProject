var centerWp = function () {
    var area = $(window).height() - $(".header").outerHeight() - $(".footer").outerHeight();
    var marginTopVal = (area - $(".wrapperType01").outerHeight()) / 2;
    if (marginTopVal > 25) {
        $(".wrapperType01").css("margin-top", marginTopVal);
    } else {
        $(".wrapperType01").css("margin-top", 25);
    }
};
var tab = function (index) {
    $(".tabContent .container").hide()
    $(".tabContent .container").eq(index).show();
    $(".tabLink li").removeClass("selected");
    $(".tabLink li").eq(index).addClass("selected");
};
var backgroundSize = function () {
    $(".pageBackground, .backstretch, .backstretch img").css("height", 0);
    var height = $(document).height() - $(".header").outerHeight() - $(".footer").outerHeight();
    $(".pageBackground").css("height", height);
    $('.pageBackground').backstretch("resize");
};
var countDown = function (count) {
    var _this = this;
    this.currentTimeLeft = count;
    this.timeInterval;
    this.startTime = new Date().getTime();
    this.countInterval = function () {
        var returnValue = "";
        var currentTime = new Date().getTime();
        var diff = currentTime - _this.startTime;
        var remainingSeconds = _this.currentTimeLeft - Math.floor(diff / 1000);

        if (remainingSeconds > 0) {
            var wholeSeconds = remainingSeconds;
            var wholeMinutes = wholeSeconds / 60;
            var seconds = parseInt(wholeSeconds % 60);
            var minutes = parseInt(wholeMinutes % 60);
            if (minutes < 10) {
                minutes = "0" + minutes;
            }
            if (seconds < 10) {
                seconds = "0" + seconds;
            }
            returnValue += minutes + ':' + seconds;

        } else {
            returnValue = '00:00';
            window.clearInterval(_this.timeInterval);
        }
        $(".remainingTime").html(returnValue);
    };
    _this.countInterval();
    _this.timeInterval = setInterval(function () {
        _this.countInterval();
    }, 500);
}
$(document).ready(function () {
    $(".sozlesme input.custom").ezMark();
    $("input.custom-checkbox").ezMark({
        checkboxCls: 'customCheckBox',
        checkedCls: 'customChecked'
    });
    $(".formArea input.custom").ezMark({
        checkboxCls: 'formCheckBox',
        checkedCls: 'formChecked'
    });
    /*
    $(".tabLink li").each(function () {
    if ($(this).hasClass("selected")) {
    tab($(this).index());
    }
    });
    $(".tabLink li a").click(function () {
    $(".tabLink li").removeClass("selected");
    $(this).parent().addClass("selected");
    var _index = $(this).parent().index();
    tab(_index);
    });
    */
    $(".inputWrap input").focus(function () {
        $(this).parent().find(".tooltip").fadeIn();
    });
    $(".inputWrap input").blur(function () {
        $(this).parent().find(".tooltip").fadeOut();
    });
    $("#teksifre").change(function () {
        if (!$(this).is(":checked")) {
            $(".iframeArea").addClass("deactive");
        } else {
            $(".iframeArea").removeClass("deactive");
        }
        centerWp();
        $(".iframeErrorMessage").hide();
    });
    if (!$("#teksifre").is(":checked")) {
        $(".iframeArea").addClass("deactive");
    }
    $('.pageBackground').backstretch(usedDomain+"/public/assets/images/page-bg.jpg", { speed: 0 });
    $(window).resize(function () {
        centerWp();
        backgroundSize();
        if ($("body .wrapper").width() > 320) {
            $(".mobileMenuIcon").removeClass("open");
            $(".mobileMenu").hide();
        }
    });
    $(window).load(function () {
        centerWp();
        backgroundSize();
    });
    centerWp();
    backgroundSize();
    $(".iframeArea .mask").click(function () {
        $(".iframeErrorMessage").show();
    });
    $(".inputArea input[type=text], .formArea input[type=text]").each(function () {
        var beforeValue = $(this).attr('data-holder');
        var generatedThis = $(this);
        generatedThis.focus(function () {
            if (generatedThis.val() == beforeValue) {
                generatedThis.val("");
            }
        });
        generatedThis.blur(function () {
            if (generatedThis.val() == "") {
                generatedThis.val(beforeValue);
            }
        });
        if (generatedThis.val() == "") {
            generatedThis.val(beforeValue)
        }
    });
    $(".formArea input[type=password]").each(function () {
        var beforeValue = $(this).attr('data-holder');
        var generatedThis = $(this);
        if (parseInt($.browser.version) < 9 && $.browser.msie == true) {
            generatedThis.attr("title", beforeValue);
        } else {
            generatedThis.focus(function () {
                if (generatedThis.val() == beforeValue) {
                    generatedThis.val("");
                    generatedThis.attr("type", "password");
                }
            });
            generatedThis.blur(function () {
                if (generatedThis.val() == "") {
                    generatedThis.val(beforeValue);
                    generatedThis.attr("type", "text");
                }
            });
            if (generatedThis.val() == "") {
                generatedThis.val(beforeValue);
                generatedThis.attr("type", "text");
            }
        }
    });
    if ($(".remainingTime").length > 0) {
        var time = parseInt($(".remainingTime").attr("data-time"));
        countDown(time);
    }
    $(".infoIcon").mouseenter(function () {
        $(this).find("span").stop(true, true).fadeIn();
    });
    $(".infoIcon").mouseleave(function () {
        $(this).find("span").stop(true, true).fadeOut();
    });
    $(".header").append('<a href="javascript:;" class="mobileMenuIcon">Mobil Menü</a>');
    var menuHTML = '<div class="mobileMenu"><ul>';
    menuHTML += $("ul.mainMenu").html();
    menuHTML += '</ul></div>';
    $(".header").append(menuHTML);
    $(document).on("click", ".mobileMenuIcon", function () {
        if ($(this).hasClass("open")) {
            $(this).removeClass("open");
            $(".mobileMenu").slideUp();
        } else {
            $(this).addClass("open");
            $(".mobileMenu").slideDown();
        }
    });
    if ($(".faqLink").length > 0) {
        $(".faqLink li a").click(function () {
            var _this = $(this);
            if (!_this.hasClass("selected")) {
                $(".faqLink li a").removeClass("selected");
                _this.addClass("selected");
                var openIndex = _this.parent().index();
                $(".faqContent").hide();
                $(".accordionContent").hide();
                $(".accordionTitle").removeClass("open");
                $(".openCloseBtn").removeClass("opened");
                $(".faqContent").eq(openIndex).show();
                centerWp();
                backgroundSize();
            }
        });
        if ($(".faqLink li a.selected").length > 0) {
            var accordionIndex = $(".faqLink li a.selected").parent().index();
            $(".faqContent").eq(accordionIndex).show();
        } else {
            $(".faqContent").eq(0).show();
        }
        $(".accordion").each(function () {
            var currentAccordion = $(this);
            currentAccordion.find(".accordionTitle").click(function () {
                var clickElement = $(this);
                if (clickElement.hasClass("open")) {
                    currentAccordion.find(".accordionContent").slideUp(function () {
                        clickElement.removeClass("open");
                        backgroundSize();
                    });
                } else {
                    currentAccordion.find(".accordionContent").slideDown(function () {
                        backgroundSize();
                    });
                    clickElement.addClass("open");
                }

            });
        });
        $(".openCloseBtn").click(function () {
            var openTabIndex = $(".faqLink li a.selected").parent().index();
            if ($(this).hasClass("opened")) {
                $(".faqContent").eq(openTabIndex).find(".accordionContent").slideUp(function () {
                    backgroundSize();
                });
                $(".faqContent").eq(openTabIndex).find(".accordionTitle").removeClass("open");
                $(this).removeClass("opened");
            } else {
                $(".faqContent").eq(openTabIndex).find(".accordionContent").slideDown(function () {
                    backgroundSize();
                });
                $(".faqContent").eq(openTabIndex).find(".accordionTitle").addClass("open");
                $(this).addClass("opened");
            }
        });
    }
    $(".ajaxLink").click(function () {
        var _this = $(this);
        $(".ajaxPopup").remove();
        $.get(_this.attr("href"), function (data) {
            $("body").append('<div class="ajaxPopup"><div class="popup"><div class="content">' + data + '</div><a href="javascript:;" class="close"></a></div></div>');
            $(".ajaxPopup .close").click(function () {
                $(".ajaxPopup").remove();
            });
        });
        return false;
    });
    $(".fonLogin").click(function () {
        if ($(".fonLicense").is(":checked")) {
            $(".fonErrorLicense").hide();
        } else {
            $(".fonErrorLicense").show();
        }
        backgroundSize();
    });
});
