$.get("api/bookings", function(result) {
    console.table(result);

    var dataSet = [];

    for (var i = 0; i<result.length; i++) {
    console.log("result: "+  result);
    console.log("result[0]: " + result[0] + " "+ result[0].guest.name);
    dataSet.push([result[i].bookingNumber, result[i].guest.name, result[i].guest.address, result[i].start, result[i].end,  result[i].roomNumber, result[i].room.roomType]);
    }

$("#bookings").DataTable( {
        data: dataSet
    });

});