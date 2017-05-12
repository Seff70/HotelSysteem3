$('#datepicker').datepicker({});

$.get("api/bookings", function (result) {

    console.table(result);
    var table = $('#availableRooms').DataTable({
        columns: [
            {data: "bookingNumber"},
            {data: "room.roomType"},
            {data: "guest.name"},
            {data: "start"},
            {data: "eind"}

        ],
        data: result
    });

    });

 $.ajax({
        contentType: "application/json",
        type: "get",
        url: "api/bookings",
        success: function (result) {
            console.log(result);

               },
        error: function (e) {
            console.log(e);
            $("#confirmaddroom").text("Uw invoer is niet correct.");
        }

    });
