function pagename() {
    let path = window.location.pathname;
    let page = path.split("/").pop();

    for (let i = 0; i < page.length; i++) {
        if (page.at(i) === "_") {
            page = setCharAt(page, i, " ")
        }
    }

    let title = document.getElementById("title");
    title.innerText = page;
}

function setCharAt(str,index,chr) {
    if(index > str.length-1) return str;

    if(index == 0) return str.toLocaleUpperCase;

    return str.substring(0,index) + chr + str.substring(index+1);
}