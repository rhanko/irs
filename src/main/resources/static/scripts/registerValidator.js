const regExpMail= /^[A-Za-z0-9@._-]+$/;
const regExpUsername= /^[A-Za-z0-9]+$/;
const regExpName= /^$|^[A-Za-z]+$/;

let username = 0;
let email = 0;
let password = 0;
let firstname = 1;
let lastname = 1;

function usernameValidate() {
    let testedValue = document.forms["RegisterForm"]["uname"].value;
    let error = document.getElementById("errorUsername");

    //znaky
    if (!regExpUsername.test(testedValue)) {
        error.innerText = "Obsahuje znaky, ktoré nie sú dovolené. Dovolené znaky: a-z, A-Z a 0-9";
        username = 0;
    } else
    //dlzka
    if (!(testedValue.length >= 4 && testedValue.length <= 20)) {
        error.innerText = "Dĺžka musí mať aspoň 4 a najviac 20 znakov";
        username = 0;
    } else {
        error.innerText = "";
        username = 1;
    }
    canSubmit();
}

function firstnameValidate() {
    let testedValue = document.forms["RegisterForm"]["fname"].value;
    let error = document.getElementById("errorFirstname");

    //znaky
    if (!regExpName.test(testedValue)) {
        error.innerText = "Obsahuje znaky, ktoré nie sú dovolené. Dovolené znaky: a-z a A-Z";
        firstname = 0;
    } else
        //dlzka
    if (testedValue.length > 20) {
        error.innerText = "Dĺžka musí môže mať najviac 20 znakov";
        firstname = 0;
    } else {
        error.innerText = "";
        firstname = 1;
    }
    canSubmit();
}

function lastnameValidate() {
    let testedValue = document.forms["RegisterForm"]["sname"].value;
    let error = document.getElementById("errorSurname");

    //znaky
    if (!regExpName.test(testedValue)) {
        error.innerText = "Obsahuje znaky, ktoré nie sú dovolené. Dovolené znaky: a-z a A-Z";
        lastname = 0;
    } else
        //dlzka
    if (testedValue.length > 20) {
        error.innerText = "Dĺžka musí môže mať najviac 20 znakov";
        lastname = 0;
    } else {
        error.innerText = "";
        lastname = 1;
    }
    canSubmit();
}

function emailValidate() {
    let testedValue = document.forms["RegisterForm"]["email"].value;
    let error = document.getElementById("errorEmail");

    //znaky
    if (!regExpMail.test(testedValue)) {
        error.innerText = "Obsahuje znaky, ktoré nie sú dovolené. Dovolené znaky: a-z, A-Z, 0-9 \"@\" a \".\"";
        email = 0;
    } else
        //dlzka
    if (!(testedValue.length <= 30)) {
        error.innerText = "Dĺžka môže mať najviac 30 znakov";
        email = 0;
    } else {
        error.innerText = "";
        email = 1;
    }
    canSubmit();
}

function  passwordValidate() {
    let testedValue = document.forms["RegisterForm"]["password"].value;
    let error = document.getElementById("errorPassword");

    //dlzka
    if (!(testedValue.length >= 6 && testedValue.length <= 20)) {
        error.innerText = "Dĺžka musí byť aspoň 6 a najviac 30 znakov";
        email = 0;
    } else {
        error.innerText = "";
        email = 1;
    }
    canSubmit();
}

function canSubmit() {
    let sucet = username + firstname + lastname + password + email;
    let button = document.getElementById("registerbutton");

    if (sucet === 5) {
        button.style.pointerEvents = "unset";
    }
    else {
        button.style.pointerEvents = "none";
    }
}