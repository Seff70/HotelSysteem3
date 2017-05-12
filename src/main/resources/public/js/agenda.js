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
            {data: "room.roomType"},
            {data: "room.roomNumber"},
        ],
        data: result
    });

});


$("#submitagenda").click(function(event){
    $('#availableRooms').show();
});