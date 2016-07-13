/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 30.01.2015
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */

var failAttempt = 0;
var captchaRequired = false;
var captchaId = "";
setErrorMsg = function (textValue) {
    var $usernamePasswordMsg = $('#usernamePasswordMsg');
    $usernamePasswordMsg.css('display', 'block');
    $usernamePasswordMsg.find("img:last-child").remove();
    $usernamePasswordMsg.append("<ul id='errorText'><li >" + textValue + "</li></ul>");
};

setLoadingImg = function () {
    var $usernamePasswordMsg = $('#usernamePasswordMsg');
    $usernamePasswordMsg.css('display', 'block');
    $usernamePasswordMsg.text("");
    $usernamePasswordMsg.append("<img src=" +  "../../resources/alu/img/loading.gif>");
};
doLogin = function () {
    $('#loginButton').click(function (event) {

        if ($('#fonCheckBox').prop('checked')) {
            $('#usernamePasswordMsg').css('display', 'none');

            setLoadingImg();
            if (captchaRequired) {
                var captchaVal = $('#captchaValue').val();
                $.get('../captcha', {captchaId: captchaId, captchaValue: captchaVal}, function (responseText) {
                    if (responseText.indexOf("true") > -1) {
                        letLogin();
                    } else {
                        $('#loadingMsg').css('display', 'none');
                        setErrorMsg('Wrong Captcha Value')
                        redirectCaptcha();
                        return;
                    }
                });
            } else {
                setCookie("foncheckedBox", "true", 3);
                letLogin();
            }
        }
    });
};


letLogin = function () {
    var username = $('#fonusername').val();
    var password = $('#fonpassword').val();

    $.get('intern', {fonUser: username, fonPass: password}, function (responseText) {

        if ($('#rememberMeCheckBox').prop('checked')) {
            setCookie("fonusername", username, 3);
            setCookie("fonpassword", password, 3);
        } else {
            deleteCookie("fonusername");
            deleteCookie("fonpassword");
        }
        $('#loadingMsg').css('display', 'none');

        if((responseText == 'invalidCredentials')||(responseText.indexOf("Error=") > -1)){

            if (responseText == 'invalidCredentials') {
                setErrorMsg("Username/password is incorrect");
            } else if (responseText.indexOf("Error=") > -1) {
                var split = responseText.split("Error=");
                setErrorMsg(split[1]);
            }

            failAttempt = failAttempt + 1;
            if (failAttempt > 2) {
                redirectCaptcha();
            }
        } else {
            window.location.replace(responseText);
        }

    });
};


var invocation = new XMLHttpRequest();
var url = 'http://ttnetwififon.portal.com.tr/ttnetWifiFon/public/index.jsp';
var body = '<?xml version="1.0"?><person><name>Arun</name></person>';

function callOtherDomain() {
    if (invocation) {
        invocation.open('POST', url, true);
        invocation.setRequestHeader('X-PINGOTHER', 'pingpong');
        invocation.setRequestHeader('Content-Type', 'application/xml');
        invocation.onreadystatechange = onreadystateFunc;
        invocation.send(body);
    }
}

redirectCaptcha = function () {
//    window.location.replace(usedDomain+"/public/captcha");
    $.get('../captcha', {}, function (responseText) {
        if (responseText.indexOf("id") > -1) {
            $("#captchaImg").attr("src", "http://captcha.portal.com.tr/captcha/captcha.jpg?" + responseText);
            $('#captcha').css('display', 'block')
            captchaId = responseText;
            captchaRequired = true;
        } else {
            window.location.replace(responseText);
        }
    });
};

playCaptchaSound = function () {
    var $captchaVoice = $('#captchaVoice');
    $captchaVoice.attr('src', 'http://captcha.portal.com.tr/captcha/captcha.wav?' + captchaId)
    $captchaVoice.get(0).play();
};

