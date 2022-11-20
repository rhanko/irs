const regExpMail= /^[A-Za-z0-9@._-]+$/;
const regExpUsername= /^[A-Za-z0-9]+$/;
const regExpName= /^$|^[A-Za-z]+$/;

function usernameValidate() {
    let testedValue = document.forms["RegisterForm"]["uname"].value;
    let error = document.getElementById("errorUsername");

    //znaky
    if (!regExpUsername.test(testedValue)) {
        error.innerText = "Obsahuje znaky, ktoré nie sú dovolené. Dovolené znaky: a-z, A-Z a 0-9";
        return false;
    } else
    //dlzka
    if (!(testedValue.length >= 4 && testedValue.length <= 20)) {
        error.innerText = "Dĺžka musí mať aspoň 4 a najviac 20 znakov";
        return false;
    } else {
        error.innerText = "";
        return true;
    }
}

function firstnameValidate() {
    let testedValue = document.forms["RegisterForm"]["fname"].value;
    let error = document.getElementById("errorFirstname");

    //znaky
    if (!regExpName.test(testedValue)) {
        error.innerText = "Obsahuje znaky, ktoré nie sú dovolené. Dovolené znaky: a-z a A-Z";
        return false;
    } else
        //dlzka
    if (testedValue.length > 20) {
        error.innerText = "Dĺžka musí môže mať najviac 20 znakov";
        return false;
    } else {
        error.innerText = "";
        return true;
    }
}

function lastnameValidate() {
    let testedValue = document.forms["RegisterForm"]["sname"].value;
    let error = document.getElementById("errorSurname");

    //znaky
    if (!regExpName.test(testedValue)) {
        error.innerText = "Obsahuje znaky, ktoré nie sú dovolené. Dovolené znaky: a-z a A-Z";
        return false;
    } else
        //dlzka
    if (testedValue.length > 20) {
        error.innerText = "Dĺžka musí môže mať najviac 20 znakov";
        return false;
    } else {
        error.innerText = "";
        return true;
    }
}

function emailValidate() {
    let testedValue = document.forms["RegisterForm"]["email"].value;
    let error = document.getElementById("errorEmail");

    //znaky
    if (!regExpMail.test(testedValue)) {
        error.innerText = "Obsahuje znaky, ktoré nie sú dovolené. Dovolené znaky: a-z, A-Z, 0-9 \"@\" a \".\"";
        return false;
    } else
        //dlzka
    if (!(testedValue.length <= 30)) {
        error.innerText = "Dĺžka môže mať najviac 30 znakov";
        return false;
    } else {
        error.innerText = "";
        return true;
    }
}

function passwordValidate() {
    let testedValue = document.forms["RegisterForm"]["password"].value;
    let error = document.getElementById("errorPassword");

    //dlzka
    if (!(testedValue.length >= 6 && testedValue.length <= 20)) {
        error.innerText = "Dĺžka musí byť aspoň 6 a najviac 30 znakov";
        return false;
    } else {
        error.innerText = "";
        return true;
    }
}

function canSubmit() {
    if (usernameValidate() && passwordValidate() && emailValidate() && firstnameValidate() && lastnameValidate())  {
        return true;
    }
    return false;
}