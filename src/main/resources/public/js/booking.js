$.get("api/bookings", function(result) {
    console.table(result);

    //zodat we stap 1 en twee overslaan, en direct naar gast-kiezen gaan.
    toGuestSelect();
//    var dataSet = [];
//
//    for (var i = 0; i<result.length; i++) {
//     console.log("result: "+  result);
//     console.log("result[0]: " + result[0] + " "+ result[0].guest.name);
//     var start = "" + result[i].start[2]+ "-" + result[i].start[1] + "-" + result[i].start[0]
//     var eind = "" + result[i].eind[2]+ "-" + result[i].eind[1] + "-" + result[i].eind[0]
//
//     dataSet.push([result[i].bookingNumber, result[i].guest.name, result[i].guest.address, start, eind, result[i].room.roomNumber, result[i].room.roomType]);
//    }
//
//    $("#bookings").DataTable( {
//            data: dataSet
//        });

    $("#availableRooms tbody").on('click', 'tr', function () {
        event.preventDefault();
        var room = table.row( this ).data();
        console.log("room: " + room + ", roomnr " + room.roomNumber);
    });

});
//to room select
function toDateSelect () {
        $("#datetimepicker1").show();
        $("#datetimepicker2").show();
}

function toRoomSelect() {

}

function toGuestSelect() {
    $("#GuestPickerTable").show();

    $.get("/api/guests",function (result){
        console.table(result);
        var table = $('#GuestPickerTable').DataTable({
            columns: [
                {data: "guestID"},
                {data: "name"},
                {data: "address"},
                {data: "zipcode"},
                {data: "city"},
                {data: "country"},
                {data: "phonenumber"},
                {data: "special"}
            ],
            data: result
        });
    });

    $("#GuestPickerTable tbody").on('click', 'tr', function () {
           event.preventDefault();
           console.log("tot hier")
           var table = $("#GuestPickerTable").DataTable();
           var guest = table.row( this ).data();
           table.search(guest.name).draw();
    });
}

function toConfirmBooking () {
    $("#ConfirmBooking").show();
}

