/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 25.11.2014
 * Time: 12:08
 * To change this template use File | Settings | File Templates.
 */

var urlDomain = "https://ttnetwififon.portal.com.tr/ttnetWifiFon";
var ppUrlDomain = "https://wififon-pp.portal.com.tr/ttnetWifiFon";
var localDomain = "http://localhost:8080";

var usedDomain = urlDomain;

var logoutUrl = "http://teksifre.portal.com.tr/kullanici-islemleri/cikis/?ref=6f469c1d-25c8-4aac-89b8-7846716c2e2e";
var ppLogoutUrl = "http://teksifre-ssopp.portal.com.tr/kullanici-islemleri/cikis/?ref=6f469c1d-25c8-4aac-89b8-7846716c2e2e";
var localLogoutUrl = "https://ttnetwififon.portal.com.tr/ttnetWifiFon/ssoLogout";
var usedLogoutUrl = logoutUrl;

function manageTOSCheckbox(checkbox) {
    if(checkbox.checked){
        setCookie("isTOMChecked","true",3);
    }else{
        deleteCookie("isTOMChecked");
    }
}

function setCookie(name, value, days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        var expires = "; expires=" + date.toGMTString();
    }
    else var expires = "";
    document.cookie = name + "=" + value + expires + "; path=/";
}

function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}
function deleteCookie(name) {
    document.cookie = name + '=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

function redirectLocale(folder, page, lg) {
    var url = usedDomain + "/public/locale" + "?folder=" + folder + "&page=" + page + "&lg=" + lg;
    window.location.replace(url);
}

function redirectServlet() {

    var fonCheckBoxById = document.getElementById('fonCheckBox');
    var fonUsernameValue = document.getElementById("fonusername").value;
    var fonPasswordValue = document.getElementById("fonpassword").value;
    var b = (fonUsernameValue === null || fonUsernameValue.length < 1) || (fonPasswordValue === null || fonPasswordValue.length < 1);

    if (fonCheckBoxById.checked && !b) {

        console.log("fonUsernameValue " + fonUsernameValue);
        console.log("fonPasswordValue " + fonPasswordValue);
        var loc = window.location.toString(), params = loc.split('?')[1];
        console.log("loc =" + loc);
        console.log(params);
        insertParam('fonUsernameValue', fonUsernameValue);
        insertParam('fonPasswordValue', fonPasswordValue);
        params = params + "&fonUsernameValue=" + fonUsernameValue + "&fonPasswordValue=" + fonPasswordValue;
        window.location.replace(usedDomain + "/public/intern" + "?" + params);

    } else {

        manageFonMsg()

    }

}

function redirectPage(page) {
    if (page.indexOf("http") > -1) {
        window.location.replace(page);
    } else {
        window.location.replace(usedDomain + "/" + page);
    }
}

function redirectSignUp() {
    window.location.replace(usedDomain + "/pages/smpSignUp");
}

function manageFonMsg() {
    console.log("entered");
    var fonCheckBoxById = document.getElementById('fonCheckBox');
    var usernamePasswordMsgById = document.getElementById('usernamePasswordMsg');
    var fonCheckBoxMsgById = document.getElementById('fonCheckBoxMsg');
    var usernameById = document.getElementById('fonusername').value;
    var passwordById = document.getElementById('fonpassword').value;
    if ((usernameById === null || usernameById.length < 1) || (passwordById === null || passwordById.length < 1)) {
        usernamePasswordMsgById.style.display = 'block';
    } else {
        usernamePasswordMsgById.style.display = 'none';
    }
    if (fonCheckBoxById.checked) {
        fonCheckBoxMsgById.style.display = 'none';
    } else {
        fonCheckBoxMsgById.style.display = 'block';
//        fonCheckBoxMsgById.innerHTML = 'Please approve the license agreement';
    }
};

function manageFonCheckBox(checkBox) {
    console.log("entered");
    console.log("isChecked = " + checkBox.checked);
    var fonCheckBoxMsgById = document.getElementById('fonCheckBoxMsg');
    if (checkBox.checked) {
        fonCheckBoxMsgById.style.display = 'none';
    }
};

function setTtnetURLParams() {
    var loc = window.location.toString(), params = loc.split('?')[1];
    var ttnetTabById = document.getElementById('ttnetTab');
    var fonTabById = document.getElementById('fonTab');
    ttnetTabById.href = ttnetTabById.href + '?' + params;
    fonTabById.href = fonTabById.href + '?' + params;

    console.log("ttnetTabById.href " + ttnetTabById.href);
    console.log("fonTabById.href " + fonTabById.href);
};

function setFonURLParams() {
    var loc = window.location.toString(), params = loc.split('?')[1];

    var fonttnetTabById = document.getElementById('fon_ttnetTab');
    var fonfonTabById = document.getElementById('fon_fonTab');

    fonttnetTabById.href = fonttnetTabById.href + '?' + params;
    fonfonTabById.href = fonfonTabById.href + '?' + params;
    console.log("fonttnetTabById.href " + fonttnetTabById.href);
    console.log("fonfonTabById.href " + fonfonTabById.href);
};


function insertParam(key, value) {
    key = encodeURI(key);
    value = encodeURI(value);

    var kvp = document.location.search.substr(1).split('&');

    var i = kvp.length;
    var x;
    while (i--) {
        x = kvp[i].split('=');

        if (x[0] == key) {
            x[1] = value;
            kvp[i] = x.join('=');
            break;
        }
    }

    if (i < 0) {
        kvp[kvp.length] = [key, value].join('=');
    }

    //this will reload the page, it's likely better to store this until finished
    document.location.search = kvp.join('&');
}

function ssoLogout() {
    window.location.replace(usedLogoutUrl);
}

function fonLogout() {
    window.location.replace(usedDomain + "/public/fonLogout");
}

function fonMainPage() {
    window.location.replace(usedDomain + "/public/intern/intern-tab.jsp");
}

function ttnetMainPage() {
    window.location.replace(usedDomain + "/public/index.jsp");
}

function redirectTargetTop(page) {
    console.log(page);
    window.top.location.replace(page);
}

