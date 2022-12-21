function dropdown(x) {
    let dropdownElement = document.getElementById(x)

    if (dropdownElement.style.display === "block") {
        dropdownElement.style.display = "none";
    } else {
        dropdownElement.style.display = "block";
    }

}