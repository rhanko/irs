function loggedUserName() {
    const xhttp = new XMLHttpRequest();

    xhttp.onload = function() {
        document.getElementById("university").innerHTML = this.reposneText;
    }
}