$.get("api/bookings", function(result) {
    console.log("start van booking.js, get all bookings: ");
    console.table(result);

    toDateSelect();
    //zodat we stap 1 en twee overslaan, en direct naar gast-kiezen gaan.
    //toGuestSelect();
});


function toDateSelect () {
        $("#datepicker").show();
        $("#availableRooms").hide();
        $("#GuestPickerTable").hide();
        $("#ConfirmBooking").hide();

        $('#datepicker').datepicker({
            todayBtn: true,
            todayHighlight: true,
            language: 'nl',
            format: 'dd-mm-yyyy'
        });

        $('#start').datepicker('update', new Date());

        $("#submitagenda").click(function(event){
            $('#availableRooms').show();
        });
}

function toRoomSelect() {
        $("#datepicker").show();
        $("#availableRooms").show();
        $("#GuestPickerTable").hide();
        $("#ConfirmBooking").hide();

        $.get("api/rooms", function (result) {

            console.table(result);
            var table = $('#availableRooms').DataTable({
                columns: [
                    {data: "roomType"},
                    {data: "roomNumber"},
                ],
                data: result
            });

        });

        $("#availableRooms tbody").on('click', 'tr', function () {
                event.preventDefault();
                var table = $("#availableRooms").DataTable();
                var room = table.row( this ).data();
                console.log("room: " + room + ", roomnr " + room.roomNumber);
        });
}

function toGuestSelect() {
        $("#datepicker").show();
        $("#availableRooms").show();
        $("#GuestPickerTable").show();
        $("#ConfirmBooking").hide();

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
    $("#datepicker").show();
    $("#availableRooms").show();
    $("#GuestPickerTable").show();
    $("#ConfirmBooking").show();

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
        toDateSelect();
    });
}

