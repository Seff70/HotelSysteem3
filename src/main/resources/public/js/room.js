$.get("/api/kamergegevens", function(result) {
    console.table(result);
    var roomTable = [];
    for(var i = 0; i < result.length; i++) {
        roomTable.push([result[i].roomNumber, result[i].roomType]);
    }
    $('#tableRooms').DataTable( {
        data: roomTable
    });
});
