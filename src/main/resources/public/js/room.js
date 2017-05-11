$.get("/api/rooms", function (result) {
    console.table(result);
    var table = $('#tableRooms').DataTable({
        columns: [
            {data: "roomNumberreal"},
            {data: "roomType"},
            {data: "availability"}
        ],
        data: result
    });

    $('#tableRooms tbody').on('click', 'tr', function () {
            var data = table.row(this).data();
            console.log('API row values : ', data);
            $("#newroom").show();
            $("#tableRooms").show();
            $("#submit").hide();
            $("#addroom").hide();
            $("#inputaddnumber").val(data.roomNumberreal);
            $("#inputaddtype").val(data.roomType);
            $("#inputboolean").prop('checked', data.availability)
            $("#edit").click(function (event) {
                event.preventDefault();
                editRoom(data);
            });

            $("#delete").click(function (event) {
                event.preventDefault();
                deleteRoom(data);
            })

        }
    );
});

//nieuwe kamer toevoegen
$("#addroom").click(function (event) {
    $("#newroom").show();
    $("#delete").hide();
    $("#edit").hide();
    $("#addroom").hide();

     $("#submit").click(function (event) {
     event.preventDefault();
     addroom();

    });

});

function editRoom(data) {
    var edit ={ roomNumber: data.roomNumber,
                roomNumberreal: $("#inputaddnumber").val(),
                roomType: $("#inputaddtype").val(),
                availability: $("#inputboolean").is(':checked')
                };

    $.ajax({
        contentType: "application/json",
        type: "POST",
        url: "/api/rooms",
        data: JSON.stringify(edit),
        success: function (result) {
            console.log(result);

            location.href = "room.html"
        },
        error: function (e) {
            console.log(e);
            $("#confirmaddroom").text("Uw invoer is niet correct.");
        }

    });

}

function deleteRoom(data) {
    $.ajax({
        contentType: "application/json",
        type: "DELETE",
        url: "/api/rooms/" + data.roomNumber,
        success: function (result) {
            console.log(result);
            location.href = "room.html"
        },
        error: function (e) {
            console.log(e);
            $("#confirmaddroom").text("Uw invoer is niet correct.");
        }

    });
}

function addroom() {

    $.ajax({
        contentType: "application/json",
        type: "POST",
        url: "/api/rooms",
        data: JSON.stringify({
                    roomNumberreal: $("#inputaddnumber").val(),
                    roomType: $("#inputaddtype").val(),
                    availability: $("#inputboolean").is(':checked')
                           }),
        success: function (result) {
            console.log(result);
            location.href = "room.html"
        },
        error: function (e) {
            console.log(e);
            $("#confirmaddroom").text("Uw invoer is niet correct.");
        }

    });
}



























//bestaande kamer opzoeken
//$("#zoek").click(function (event) {
//    event.preventDefault();
//    var roomNumber = $("#tf1").val();
//    console.log("Kamernummer = " + roomNumber);
//
//    $.ajax({
//
//        contentType: "application/json",
//        type: "GET",
//        url: "/api/rooms/" + roomNumber,
//        success: function (result) {
//            console.log(result);
//            $("#content").text("Kamer " + result.roomNumber + " is een " + result.roomType + " kamer ");
//        },
//        error: function (e) {
//            console.log(e);
//            $("#content").text("Dit is geen geldig kamernummer!");
//        }
//
//    });
//});



