$.get("api/bookings", function(result) {
    console.table(result);

    var dataSet = [];

    for (var i = 0; i<result.length; i++) {
    console.log("result: "+  result);
    console.log("result[0]: " + result[0] + " "+ result[0].guest.name);
    var start = "" + result[i].start[2]+ "-" + result[i].start[1] + "-" + result[i].start[0]
    var eind = "" + result[i].eind[2]+ "-" + result[i].eind[1] + "-" + result[i].eind[0]

    dataSet.push([result[i].bookingNumber, result[i].guest.name, result[i].guest.address, start, eind, result[i].room.roomNumber, result[i].room.roomType]);
    }

$("#bookings").DataTable( {
        data: dataSet
    });

});