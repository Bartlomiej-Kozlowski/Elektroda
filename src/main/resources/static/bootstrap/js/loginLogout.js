if (getCookie("authenticationToken")) {
    document.getElementById("LoginSpanForLoginDetection").setHTML("Logout");
}
function loginLogout()
{
    if (getCookie("authenticationToken")) {
        setCookie("authenticationToken", "", 0);
    }else{
        window.location="/login";
    }
}