$.get("api/bookings", function(result) {
    console.log("start van booking.js, get all bookings: ");
    console.table(result);

    //zodat we stap 1 en twee overslaan, en direct naar gast-kiezen gaan.
    toGuestSelect();
//    var dataSet = [];
//
//    for (var i = 0; i<result.length; i++) {
//     console.log("result: "+  result);
//     console.log("result[0]: " + result[0] + " "+ result[0].guest.name);
//
//     var start = ""
//      if(result[i].start != null) {
//        start += result[i].start[2]+ "-" + result[i].start[1] + "-" + result[i].start[0]
//      }
//     var eind = ""
//      if(result[i].eind != null) {
//      eind += result[i].eind[2]+ "-" + result[i].eind[1] + "-" + result[i].eind[0]
//      }
//
//     dataSet.push([result[i].bookingNumber, result[i].guest.name, result[i].guest.address, start, eind, result[i].room.roomNumber, result[i].room.roomType]);
//    }
//
//    $("#bookings").DataTable( {
//            data: dataSet
//        });

    $("#availableRooms tbody").on('click', 'tr', function () {
        event.preventDefault();
        var table = $("#availableRooms").DataTable();
        var room = table.row( this ).data();
        console.log("room: " + room + ", roomnr " + room.roomNumber);
    });

});

function toDateSelect () {
        $("#datetimepicker1").show();
        $("#datetimepicker2").show();

}

function toRoomSelect() {

}

function toGuestSelect() {
    $.get("/api/guests",function (result){
        console.table("toGuestSelect: "+ result);
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

    $("#GuestPickerTable").show();

    console.log("hiero");

    $("#GuestPickerTable tbody").on('click', 'tr', function () {
           event.preventDefault();
           console.log("tot hier")
           var table = $("#GuestPickerTable").DataTable();
           var guest = table.row( this ).data();
           table.search(guest.guestID).draw();
           toConfirmBooking(guest);
    });
}

function toConfirmBooking () {
    console.log("toConfirmBooking")
    $("#ConfirmBooking").show();
    $("#confirmBookingButton").click(function(){
        console.log("start.val() = " + $("#start").val());
        var guestTable = $("#GuestPickerTable").DataTable();
        var roomTable = $("#availableRooms").DataTable();
        var newBooking = {
            start   : $("#start").datepicker("getDate"),
            end     : $("#end").datepicker("getDate"),
            room    : roomTable.rows({"filter":"applied"}).data()[0],
//            start   : "12-12-12",
//            end     :   "13-12-12",
//            room    : $.get("/api/rooms/50"),
            guest   : guestTable.rows( {"filter":"applied"} ).data()[0]           //guestTable.row(0).data()
        };
        console.log("toConfirmBooking, nu table van nieuwe booking");
        console.table(newBooking);
        console.log("roomNumber in boeking " +newBooking.room.roomNumber);

        $.ajax({
            contentType: "application/json",
            type: "POST",
            url:"/api/addbooking",
            data: JSON.stringify(newBooking),
            success: function(result) {
                        console.log(result);
                        toDateSelect();
            },
            error: function(e){
                  console.log(e);
                  var e = ("Het is niet gelukt om een boeking toe te voegen")
            }
        });
    });
}

