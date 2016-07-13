/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 25.11.2014
 * Time: 12:08
 * To change this template use File | Settings | File Templates.
 */
function redirectSessionUser() {

    var loc = window.location.toString(), params = loc.split('?')[1];
    console.log("loc =" + loc);
    console.log(params);
    window.location.replace(usedDomain + "/public/intern" + "?" + params);
}
function manageCheckBox(checkBox) {
    console.log("entered");

    console.log("isChecked = " + checkBox.checked);
    var elementById = document.getElementById('iframeBlocker');
    var contractCheckById = document.getElementById('checkboxMsg');
    if (checkBox.checked) {
        elementById.style.display = 'none';
        contractCheckById.style.display = 'none';
    } else {
        elementById.style.display = 'block';
    }
    console.log("display = " + elementById.style.display);
};

function manageErrorMsg() {
    var elementById = document.getElementById('iframeBlocker');
    var contractCheckById = document.getElementById('checkboxMsg');
    document.getElementById('iframeBlocker');
    console.log("elementById.style.display = " + elementById.style.display);
    if (elementById.style.display === "block") {
        contractCheckById.style.display = 'block';
//                contractCheckById.innerHTML = "Please accept the contract ! ";
    }
    /* else {
     contractCheckById.style.display = 'none';
     }*/
};


function getGoogle() {
    var xmlHttp = null;

    xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", 'https://www.google.com', false);
    xmlHttp.send(null);
    console.log(xmlHttp.responseText);
};

function getTest() {
    var xmlHttp = null;

    xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", 'https://www.google.com', false);
    xmlHttp.send(null);
    console.log(xmlHttp.responseText);
};

function setIframeURL() {
    var iframeObj = document.getElementById('ssoiframe');

    var loc = window.location.toString(), params = loc.split('?')[1];
    console.log(loc);
    console.log(params);
    iframeObj.src = iframeObj.src + '?' + params;
    console.log(iframeObj.src);
};
