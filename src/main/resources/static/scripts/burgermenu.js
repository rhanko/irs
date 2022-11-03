function burgermenuFunction(y) {
    y.classList.toggle("change");

    let x = document.getElementById("menubarlinks");
    if (x.style.display === "block") {
        x.style.display = "";

    } else {
        x.style.display = "block";
    }
}