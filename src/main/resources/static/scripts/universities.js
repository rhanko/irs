$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/universities",
        datatype: "JSON",
        success: function (universities) {
            $('#uniinput').append($('<option>', {
                value: 0,
                text: 'Vyberte si:'
            }));

            for (let i in universities) {
                $('#uniinput').append($('<option>', {
                    value: universities[i].id,
                    text: universities[i].nameUniversity
                }));
            }
        },
    });
});

$(document).ready(function() {
    $('#uniinput').on("change", function() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/faculties/university/" + $("#uniinput").val(),
            datatype: "JSON",
            success: function (faculties) {
                $('#facinput')
                    .find('option')
                    .remove()
                    .end()
                    .append($('<option>', {
                        value: 0,
                        text: 'Vyberte si:'
                }));

                for (let i in faculties) {
                    $('#facinput').append($('<option>', {
                        value: faculties[i].id,
                        text: faculties[i].name
                    }));
                }
            },
        });
    });
});
