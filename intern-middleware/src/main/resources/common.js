// Copyright Â© 2011 Steve Thomas

function ge(a) {
    return document.getElementById(a)
}
function getParentByTag(o, a) {
    var o = o.parentNode;
    while (o != null && o.nodeName.toLowerCase() != a) {
        o = o.parentNode
    }
    return o
}
function toggleAll(b) {
    var o = ge(b + "a");
    var a, objs, expand;
    toggleClass(o, "expanded");
    expand = hasClass(o, "expanded");
    objs = document.getElementsByTagName("a");
    for (a = 0; a < objs.length; a++) {
        if (objs[a].id.substr(0, b.length) == b && objs[a].id != b + "Link") {
            if (expand) {
                addClass(objs[a], "expanded")
            } else {
                removeClass(objs[a], "expanded")
            }
        }
    }
    objs = document.getElementsByTagName("div");
    for (a = 0; a < objs.length; a++) {
        if (objs[a].id.substr(0, b.length) == b && objs[a].id != b + "Tab") {
            if (expand) {
                removeClass(objs[a], "hidden")
            } else {
                addClass(objs[a], "hidden")
            }
        }
    }
    return false
}
function toggle(a) {
    toggleClass(ge(a + "d"), "hidden");
    toggleClass(ge(a + "a"), "expanded");
    return false
}
function toggleClass(o, a) {
    if (o) {
        if (o.className) {
            if (hasClass(o, a)) {
                removeClass(o, a)
            } else {
                o.className += " " + a
            }
        } else {
            o.className = a
        }
    }
}
function addClass(o, a) {
    if (o) {
        if (o.className) {
            if (!hasClass(o, a)) {
                o.className += " " + a
            }
        } else {
            o.className = a
        }
    }
}
function hasClass(o, a) {
    return o && o.className && o.className.search(new RegExp("\\b" + a + "\\b")) != -1
}
function removeClass(o, a) {
    if (o && o.className) {
        o.className = o.className.replace(new RegExp("\\b" + a + "\\b"), "").replace("  ", " ")
    }
}
function val(n) {
    return Number(n)
}
function isFloat(n) {
    var a = String(n);
    return a != "" && (isInt(n) || a.search(/^[-+]{0,1}([0-9]+|[0-9]+\.[0-9]*|[0-9]*\.[0-9]+)(e[-+]{0,1}[0-9]+){0,1}$/) == 0)
}
function isInt(n) {
    var a = String(n);
    return a != "" && (a.search(/^[-+]{0,1}[0-9]+$/) == 0 || a.search(/^0x[0-9A-Fa-f]+$/) == 0)
}
function isBigInt(n) {
    return isInt(n) || (isFloat(n) && Math.floor(n) == n)
}
function formatNum(n, a) {
    var b, i, f, tmp, sep = "'";
    if (!isFloat(n)) {
        return n
    }
    b = 1.1;
    tmp = b.toFixed(1).charAt(1);
    if (tmp == ".") {
        sep = ","
    } else if (tmp == ",") {
        sep = "."
    }
    b = val(n).toFixed(a);
    if (a == 0) {
        i = b;
        f = ""
    } else {
        i = b.substr(0, b.length - a - 1);
        f = b.substr(b.length - a - 1)
    }
    tmp = sep + i.substr((i.length - 1) % 3 + 1);
    tmp = tmp.replace(/(\d{3})/g, "$1" + sep);
    return i.substr(0, (i.length - 1) % 3 + 1) + tmp.substr(0, tmp.length - 1) + f
}
function formatSize(a) {
    if (a < 1024) {
        a = formatNum(a, 0) + " Bytes"
    } else if (a < 1048576) {
        a = formatNum(a / 1024, 2) + " KiB"
    } else if (a < 1073741824) {
        a = formatNum(a / 1048576, 2) + " MiB"
    } else if (a < 1099511627776) {
        a = formatNum(a / 1073741824, 2) + " GiB"
    } else if (a < 1125899906842624) {
        a = formatNum(a / 1099511627776, 2) + " TiB"
    } else if (a < 1152921504606846976) {
        a = formatNum(a / 1125899906842624, 2) + " PiB"
    } else {
        a = formatNum(a / 1152921504606846976, 2) + " EiB"
    }
    return a
}
function formatTime(a) {
    if (a < 60) {
        a = val(a);
        a = a.toFixed(3) + " s"
    } else if (a < 3600) {
        t1 = Math.floor(a / 60);
        a = t1 + " m " + Math.round(a - 60 * t1) + " s"
    } else if (a < 86400) {
        t1 = Math.floor(a / 3600);
        a = t1 + " h " + Math.round((a - 3600 * t1) / 60) + " m"
    } else if (a < 31536000) {
        t1 = Math.floor(a / 86400);
        a = t1 + " d " + Math.round((a - 86400 * t1) / 3600) + " h"
    } else if (a < 3153600000) {
        t1 = Math.floor(a / 31536000);
        a = t1 + " y " + Math.round((a - 31536000 * t1) / 86400) + " d"
    } else {
        a = Math.round(a / 31536000) + " y"
    }
    return a
}
function urlEncode(b) {
    var c = '';
    var d = '0123456789ABCDEF';
    for (var a = 0; a < b.length; a++) {
        var e = b.charCodeAt(a);
        if (e < 128) {
            if (e >= 97 && e <= 122 || e >= 65 && e <= 90 || e >= 48 && e <= 57 || e == 45 || e == 46 || e == 95) {
                c += String.fromCharCode(e)
            } else if (e == 32) {
                c += '+'
            } else {
                c += '%' + d.charAt(e >> 4) + d.charAt(e & 15)
            }
        } else if (e < 2048) {
            c += '%' + d.charAt((e >> 10) | 12) + d.charAt((e >> 6) & 15) + '%' + d.charAt(((e >> 4) & 3) | 8) + d.charAt(e & 15)
        } else if (e < 0xD800 || e > 0xDFFF && e < 0x10000) {
            c += '%E' + d.charAt(e >> 12) + '%' + d.charAt(((e >> 10) & 3) | 8) + d.charAt((e >> 6) & 15) + '%' + d.charAt(((e >> 4) & 3) | 8) + d.charAt(e & 15)
        } else if (e < 0x10000 && a < b.length - 1) {
            var f = b.charCodeAt(a + 1);
            if (e >= 0xD800 && e <= 0xDFFF && f >= 0xDC00 && f <= 0xDFFF) {
                e -= 0xD7C0;
                f -= 0xDC00;
                c += '%F' + d.charAt(e >> 8) + '%' + d.charAt(((e >> 6) & 3) | 8) + d.charAt((e >> 2) & 15) + '%' + d.charAt((e & 3) | 8) + d.charAt((f >> 6) & 15) + '%' + d.charAt(((f >> 4) & 3) | 8) + d.charAt(f & 15);
                a++
            } else {
                c += '%3F'
            }
        } else {
            c += '%3F'
        }
    }
    return c
}