$.get("api/bookings", function(result) {
    console.log("start van booking.js, get all bookings: ");
    console.table(result);

    //zodat we stap 1 en twee overslaan, en direct naar gast-kiezen gaan.
    toGuestSelect();

    $("#availableRooms tbody").on('click', 'tr', function () {
        event.preventDefault();
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

    $("#GuestPickerTable").show();

    console.log("hiero");

    $("#GuestPickerTable tbody").on('click', 'tr', function () {
           event.preventDefault();
           console.log("tot hier")
           var table = $("#GuestPickerTable").DataTable();
           var guest = table.row( this ).data();
           table.search(guest.name).draw();
           toConfirmBooking();
    });
}

function toConfirmBooking () {
    $("#ConfirmBooking").show();
    $("#confirmBookingButton").click(function(){

        var guestTable = $("#GuestPickerTable").DataTable();
        var roomTable = $("availableRooms").DataTable();
        var newBooking = {
//            start   : $("#start").val(),
//            end     : $("#end").val(),
//            room    : roomTable.row(0).data(),
            start   :
            end     :
            room    : $.get("/api/rooms/50"),
            guest   : guestTable.row(0).data(),
        };

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

