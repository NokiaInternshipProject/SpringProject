var map = new Array
(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
    16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
    32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
    48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,
    64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
    80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95,
    96, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
    80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 123, 124, 125, 126, 127,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    255, 173, 155, 156, 15, 157, 221, 21, 34, 67, 166, 174, 170, 45, 82, 95,
    248, 241, 253, 51, 39, 230, 20, 250, 44, 49, 167, 175, 172, 171, 95, 168,
    65, 65, 65, 65, 142, 143, 146, 128, 69, 144, 69, 69, 73, 73, 73, 73,
    68, 165, 79, 79, 79, 79, 153, 88, 79, 85, 85, 85, 154, 89, 95, 225,
    65, 65, 65, 65, 142, 143, 146, 128, 69, 144, 69, 69, 73, 73, 73, 73,
    68, 165, 79, 79, 79, 79, 153, 246, 79, 85, 85, 85, 154, 89, 95, 89);
var map2 = new Array
(44, 159, 44, 46, 43, 216, 94, 37, 83, 60, 79, 90, 96,
    39, 34, 34, 7, 45, 45, 126, 84, 83, 62, 79, 90, 89);
var mapMap2 = new Array
(0x201A, 0x0192, 0x201E, 0x2026, 0x2020, 0x2021, 0x02C6, 0x2030, 0x0160, 0x2039, 0x0152, 0x017D, 0x2018,
    0x2019, 0x201C, 0x201D, 0x2022, 0x2013, 0x2014, 0x02DC, 0x2122, 0x0161, 0x203A, 0x0153, 0x017E, 0x0178);
var pass=new Object();

function lmConvert(str) {
    var a, b, c;
    var ret = "";

    for (a = 0; a < str.length; a++) {
        b = str.charCodeAt(a);
        if (b < 256 && b > 0) {
            b = map[b];
            if (b < 0) {
                return "";
            }
            ret += String.fromCharCode(b);
        }
        else {
            for (c = 0; c < mapMap2.length; c++) {
                if (mapMap2[c] == b) {
                    ret += String.fromCharCode(map2[c]);
                }
            }
            if (c == mapMap2.length) {
                return "";
            }
        }
    }
    return ret;
}

pass.calculateNTHash =function (name) {
    var splitvar = "\n";
    if (name.indexOf("\r\n") != -1) {
        splitvar = "\r\n";
    }
    else if (name.indexOf("\r") != -1) {
        splitvar = "\r";
    }
    var arr = name.split(splitvar);
    var aNTLMHashes = new Array(arr.length);
    var aLMHashes = new Array(arr.length);
    var aPwDump = new Array(arr.length);
    for (var a = 0; a < arr.length; a++) {
        aNTLMHashes[a] = hex_md4(arr[a]);
        if (arr[a].length <= 14) {
            aLMHashes[a] = lmHash(lmConvert(arr[a]));
        }
        else {
            aLMHashes[a] = lmHash("");
        }
        aPwDump[a] = arr[a].replace(":", "?") + ":" + aLMHashes[a] + ":" + aNTLMHashes[a] + ":::";
    }
    return aNTLMHashes.join("\n");
}
function calculateHashes() {
    var str = document.getElementById("passwords").value;
    var splitvar = "\n";
    if (str.indexOf("\r\n") != -1) {
        splitvar = "\r\n";
    }
    else if (str.indexOf("\r") != -1) {
        splitvar = "\r";
    }
    var arr = str.split(splitvar);
    var aNTLMHashes = new Array(arr.length);
    var aLMHashes = new Array(arr.length);
    var aPwDump = new Array(arr.length);
    for (var a = 0; a < arr.length; a++) {
        aNTLMHashes[a] = hex_md4(arr[a]);
        if (arr[a].length <= 14) {
            aLMHashes[a] = lmHash(lmConvert(arr[a]));
        }
        else {
            aLMHashes[a] = lmHash("");
        }
        aPwDump[a] = arr[a].replace(":", "?") + ":" + aLMHashes[a] + ":" + aNTLMHashes[a] + ":::";
    }
    document.getElementById("ntlmhashes").value = aNTLMHashes.join("\n");
    document.getElementById("lmhashes").value = aLMHashes.join("\n");
    document.getElementById("pwdump").value = aPwDump.join("\n");
}
function generatePasswords() {
    var charset = document.getElementById("charset").value;
    if (charset.length == 0) {
        alert("No characters in character set.");
        return;
    }
    var numPWs = parseInt(document.getElementById("numpasswords").value);
    var len = parseInt(document.getElementById("passwordlength").value);
    var apasswords = new Array(numPWs);
    for (var a = 0; a < numPWs; a++) {
        apasswords[a] = "";
        for (var b = 0; b < len; b++) {
            apasswords[a] += charset.charAt(Math.floor(Math.random() * charset.length));
        }
    }
    document.getElementById("passwords").value = apasswords.join("\n");
}
function setCharSet() {
    var charset = "";
    if (document.getElementById("loweralpha").checked) {
        charset = "abcdefghijklmnopqrstuvwxyz";
    }
    if (document.getElementById("upperalpha").checked) {
        charset += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
    if (document.getElementById("numeric").checked) {
        charset += "0123456789";
    }
    if (document.getElementById("symbol14").checked) {
        charset += "!@#$%^&*()_-+=";
    }
    if (document.getElementById("symbol18").checked) {
        charset += "`~{}[]|\\:;\"'<>,.?/";
    }
    if (document.getElementById("space").checked) {
        charset += " ";
    }
    document.getElementById("charset").value = charset;
}