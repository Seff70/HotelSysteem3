$.get("/api/rooms", function (result) {
    console.table(result);
    var table = $('#tableRooms').DataTable({

        columns: [
//            {data: "roomID"},
            {data: "roomNumber"},
            {data: "roomType"},
            {data: "available"}

            ],
        data: result
    });

    $('#tableRooms tbody').on('click', 'tr', function () {
            var data = table.row(this).data();
            console.log('API row values : ', data);
            $("#newroom").removeClass('hidden');
            $("#addroom").addClass('hidden');
            $("#submit").addClass('hidden');
            $("#delete").removeClass('hidden');
            $("#edit").removeClass('hidden');
            $("#backToPrevious").removeClass('hidden');
            $("#inputaddnumber").val(data.roomNumber);
            $("#inputaddtype").val(data.roomType);
            $("#inputboolean").prop('checked', data.available);
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
    $("#newroom").removeClass('hidden');
    $("#addroom").addClass('hidden');
    $("#submit").removeClass('hidden');
    $("#backToPrevious").removeClass('hidden');
    $("#edit").addClass('hidden');
    $("#delete").addClass('hidden');

    $("#submit").click(function (event) {
        event.preventDefault();
        addroom();

    });

});

function editRoom(data) {
    var edit = {
        roomID: data.roomID,
        roomNumber: $("#inputaddnumber").val(),
        roomType: $("#inputaddtype").val(),
        available: $("#inputboolean").is(':checked')
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
        url: "/api/rooms/" + data.roomID,
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

function addroom(data) {
var startdate = new Date ($("#startDate").val());

console.log(startdate);
    $.ajax({
        contentType: "application/json",
        type: "POST",
        url: "/api/rooms",
        data: JSON.stringify({
            roomNumber: $("#inputaddnumber").val(),
            roomType: $("#inputaddtype").val(),
            available: $("#inputboolean").is(':checked'),
            startDate: startdate
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
//    var roomID = $("#tf1").val();
//    console.log("Kamernummer = " + roomID);
//
//    $.ajax({
//
//        contentType: "application/json",
//        type: "GET",
//        url: "/api/rooms/" + roomID,
//        success: function (result) {
//            console.log(result);
//            $("#content").text("Kamer " + result.roomID + " is een " + result.roomType + " kamer ");
//        },
//        error: function (e) {
//            console.log(e);
//            $("#content").text("Dit is geen geldig kamernummer!");
//        }
//
//    });
//});



