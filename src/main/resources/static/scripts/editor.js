function editNameUniversity(idbutton) {
    let name = prompt("Zadajte nový názov univerzity:");
    let id = idbutton.substring(10);
    if (name != null) {
        $.post("http://localhost:8080/university/save",
            {
                "id" : id,
                "nameUniversity" : name
            },
        ).done(function() {
            window.open("http://localhost:8080/settings?university_successfully_edited", "_self")
        });
    }
}

function newUniversity() {
    let name = prompt("Zadajte názov Univerzity:");
    if (name != null) {
        $.post("http://localhost:8080/university/save",
            {
                "nameUniversity" : name,
            },
        ).done(function () {
           window.open("http://localhost:8080/settings?university_successfully_created", "_self")
        });
    }
}

function editNameFaculty() {
    let name = prompt("Zadajte nový názov fakulty:");
    let id = idbutton.substring(7);
    if (name != null) {
        $.post("http://localhost:8080/faculty/save",
            {
                "id" : id,
                "name" : name
            },
        ).done(function() {
            window.open("http://localhost:8080/settings?faculty_successfully_edited", "_self")
        });
    }
}

function newFaculty() {
    let name = prompt("Zadajte názov Fakulty:");
    let universityID = prompt("Zadajte id univerzity", "0");
    if (name != null) {
        $.post("http://localhost:8080/faculty/save",
            {
                "name" : name,
                "university.id" : universityID
            },
        ).done(function () {
            window.open("http://localhost:8080/settings?faculty_successfully_created", "_self")
        });
    }
}