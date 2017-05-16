$('#datepicker').datepicker({
    todayBtn: true,
    todayHighlight: true,
    language: 'nl',
    format: 'dd-mm-yyyy'
});
$('#start').datepicker('update', new Date());

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


$("#submitagenda").click(function(event){
    $('#availableRooms').show();
});