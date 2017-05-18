$.get("api/bookings", function(result) {
    console.log("start van booking.js, get all bookings: ");
    toCurrentBookings();
});

function toCurrentBookings() {
    $("#currentBookingsBig").show();
    $("#datepicker").hide();
    $("#submitagenda").hide();
    $("#availableRoomsBig").hide();
    $("#GuestPickerTableBig").hide();
    $("#ConfirmBooking").hide();

    $.get("api/bookings", function(result) {
        console.log(result);
        var table = $('#currentBookings').DataTable({
           columns: [
               {data: "startString"},
               {data: "endString"},
               {data: "duration"},
               {data: "roomNumber"},
               {data: "guestName"}
           ],
           data: result
        });
    });

    $("#newBooking").click(function(event){
        toDateSelect();
    });

    $("#currentBookings tbody").on('click', 'tr', function () {
                    event.preventDefault();
                    var table = $("#currentBookings").DataTable();
                    toEditBooking();
    });
}

function toDateSelect () {
        $("#currentBookingsBig").hide();
        $("#datepicker").show();
        $("#submitagenda").show();
        $("#availableRoomsBig").hide();
        $("#GuestPickerTableBig").hide();
        $("#ConfirmBooking").hide();

//        var table = $("#GuestPickerTable").DataTable();
//        table.search("").draw();
//        table = $("#availableRooms").DataTable();
//        table.search("").draw();

        $('#datepicker').datepicker({
            todayBtn: true,
            todayHighlight: true,
            language: 'nl',
            format: 'dd-mm-yyyy'
        });

        $('#start').datepicker('update', new Date());

        $("#submitagenda").click(function(event){
            $('#availableRooms').show();
            toRoomSelect();
        });
}

function parseDate(d) {
        var month;
        console.log(d.getMonth());
         if (d.getMonth()<9) {
            month = "0"+(d.getMonth()+1);
         } else {
            month = "" + (d.getMonth()+1);
         }

        console.log(d.getDate());
         var day;
         if (d.getDate()<10){
            day = "0" + d.getDate();
         } else {
            day = "" + d.getDate();
         }

         return day + month + d.getFullYear();
}

function toRoomSelect() {
        $("#currentBookingsBig").hide();
        $("#datepicker").show();
        $("#submitagenda").hide();
        $("#availableRoomsBig").show();
        $("#GuestPickerTableBig").hide();
        $("#ConfirmBooking").hide();
//          "/api/rooms/{startDate}&{endDate}&{roomType}"
        var start = $("#start").datepicker("getDate");
        var end = $("#end").datepicker("getDate");
        var type = $("#typeroom").val();
        if (type == "Geen voorkeur") { type = "Geenvoorkeur";}
        console.log("start, end, type " + start + ", " + end + ", "+type);
        console.log("parsedate "+parseDate(start));
        start = parseDate(start);
        end = parseDate(end);
        console.log(start);

        $.get("api/rooms/"+start+"/"+end+"/"+type, function (result) {

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
                console.log("jajass")
                event.preventDefault();
                var table = $("#availableRooms").DataTable();
                var room = table.row( this ).data();
                console.log("room: " + room + ", roomnr " + room.roomNumber);
                table.search(room.roomNumber).draw();
                toGuestSelect();
        });
}

function toGuestSelect() {
        console.log("in guestselect");
        $("#currentBookingsBig").hide();
        $("#datepicker").show();
        $("#submitagenda").hide();
        $("#availableRoomsBig").show();
        $("#GuestPickerTableBig").show();
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
           toConfirmBooking();
    });
}

function toConfirmBooking () {
    $("#currentBookingsBig").hide();
    $("#datepicker").show();
    $("#submitagenda").hide();
    $("#availableRoomsBig").show();
    $("#GuestPickerTableBig").show();
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
            room    : roomTable.rows( {"filter":"applied"}).data()[0],
            guest   : guestTable.rows({"filter":"applied"}).data()[0]           //guestTable.row(0).data()
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
        guestTable.search("");
        roomTable.search("");
        guestTable.draw();
        roomTable.draw();
        location.href="booking.html";
    });

    function toEditBooking() {
//        $("#currentBookingsBig").hide();
//        $("#datepicker").show();
//        $("#submitagenda").hide();
//        $("#availableRoomsBig").show();
//        $("#GuestPickerTableBig").show();
//        $("#ConfirmBooking").show();
        console.log("TOEDITBOOKING IS NOG NIET GEIMPLEMENTEERD")
    }
}

