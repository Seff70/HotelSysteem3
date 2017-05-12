$('#datepicker').datepicker({
    todayBtn: true,
    todayHighlight: true,
    language: 'nl',
    format: 'dd-mm-yyyy'
});
$('#start').datepicker('update', new Date());

$.get("api/bookings", function (result) {

    console.table(result);
    var table = $('#availableRooms').DataTable({
        columns: [
<<<<<<< HEAD
            {data: "room.roomType"},
            {data: "room.roomNumber"},
=======
            {data: "bookingNumber"},
            {data: "start"},
            {data: "end"},
            {data: "room"}
>>>>>>> origin/master
        ],
        data: result
    });

});


$("#submitagenda").click(function(event){
    $('#availableRooms').show();
});