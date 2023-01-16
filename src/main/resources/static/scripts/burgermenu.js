function burgermenuFunction(y) {
    y.classList.toggle("change");

    let x = document.getElementById("menubarlinks");
    if (x.style.display === "block") {
        x.style.display = "";

    } else {
        x.style.display = "block";
    }
}

function burgermenuFunction2(y) {
    y.classList.toggle("change");

    let z = document.getElementById("main");
    let x = document.getElementById("menubarlinks");

    if (x.style.display === "block") {
        x.style.display = "";
        z.style.marginTop = "95px";
    } else {
        x.style.display = "block";
        z.style.marginTop = "300px";
    }
}