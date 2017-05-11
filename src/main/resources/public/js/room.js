$.get("/api/rooms", function (result) {
    console.table(result);
    var table = $('#tableRooms').DataTable({
        columns: [
            {data: "roomNumber"},
            {data: "roomType"}
        ],
        data: result
    });

    $('#tableRooms tbody').on('click', 'tr', function () {
            var data = table.row(this).data();
            console.log('API row values : ', data);
            $("#newroom").show();
            $("#tableRooms").hide();
            $("#inputaddnumber").hide();
            $("#inputaddtype").val(data.roomType);
            $("#btn2").click(function (event) {
                event.preventDefault();
                editRoom(data);
            });

            $("#btn3").click(function (event) {
                event.preventDefault();
                deleteRoom(data);
            })

        }
    );
});

function editRoom(data) {
    $.ajax({
        contentType: "application/json",
        type: "POST",
        url: "/api/rooms",
        data: JSON.stringify({
            roomNumber: data.roomNumber,
            roomType: $("#inputaddtype").val()
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

function deleteRoom(data) {
    $.ajax({
        contentType: "application/json",
        type: "DELETE",
        url: "/api/rooms/" + data.roomNumber,
        data: JSON.stringify(k),
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

//nieuwe kamer toevoegen
$("#btn4").click(function (event) {
    $("#newroom").show();
    $("#btn3").hide();
    console.log("teskltj");
});

//bestaande kamer opzoeken
$("#btn1").click(function (event) {
    event.preventDefault();
    var roomNumber = $("#tf1").val();
    console.log("Kamernummer = " + roomNumber);

    $.ajax({

        contentType: "application/json",
        type: "GET",
        url: "/api/rooms/" + roomNumber,
        success: function (result) {
            console.log(result);
            $("#content").text("Kamer " + result.roomNumber + " is een " + result.roomType + " kamer ");
        },
        error: function (e) {
            console.log(e);
            $("#content").text("Dit is geen geldig kamernummer!");
        }

    });
});



