// http://stackoverflow.com/questions/2998784/how-to-output-integers-with-leading-zeros-in-javascript
function pad(num, size) {
    var s = num + "";
    while (s.length < size) s = "0" + s;
    return s;
}

$.get("/api/Tochten", function (result) {
    var dataSet = [];
    var item = [];
    for (var i = 0; i < result.length; i++) {
        var trip = result[i];
        var start = "";
        if (trip.startTime != null) {
            start = "" + trip.startTime[2] + "-" + trip.startTime[1] + "-" + trip.startTime[0] + " " + pad(trip.startTime[3], 2) + ":" + pad(trip.startTime[4], 2)
        }
        var eind = "";
        if (trip.endTime != null) {
            eind = trip.endTime[2] + "-" + trip.endTime[1] + "-" + trip.endTime[0] + " " + pad(trip.endTime[3], 2) + ":" + pad(trip.endTime[4], 2)
        }
        dataSet.push([trip.tripID, start, eind, trip.type]);
    }
    $("#TripID").DataTable({
        data: dataSet
    });
});
