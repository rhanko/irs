$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/universities",
        datatype: "JSON",
        success: function (universities) {
            let uni = $('#uniinput');

            uni.append($('<option>', {
                value: 0,
                text: 'Vyberte si:'
            }));

            for (let i in universities) {
                uni.append($('<option>', {
                    value: universities[i].id,
                    text: universities[i].nameUniversity
                }));
            }
        }
    });
});

$(document).ready(function() {
    $('#uniinput').on("change", function() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/faculties/university/" + $("#uniinput").val(),
            datatype: "JSON",
            success: function (faculties) {
                let fac = $('#facinput');

                fac
                    .find('option')
                    .remove()
                    .end()
                    .append($('<option>', {
                        value: 0,
                        text: 'Vyberte si:'
                }));

                for (let i in faculties) {
                    fac.append($('<option>', {
                        value: faculties[i].id,
                        text: faculties[i].name
                    }));
                }
            },
        });
    });
});

$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/roles",
        datatype: "JSON",
        success: function (roles) {
            for (let i in roles) {
                $('#roleinput').append($('<option>', {
                    value: roles[i].id,
                    text: roles[i].name
                }));
            }
        }
    });
});