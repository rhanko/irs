let form = document.forms["RegisterForm"];

function usernameValidator() {
    let username = form["uname"].value;
    let error = document.getElementById("errorUsername");

    //sem daj kontrolu vstupu a hotovo
    error.style.display = ""
    error.innerText = "HELLO";
}

