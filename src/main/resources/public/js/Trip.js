// http://stackoverflow.com/questions/2998784/how-to-output-integers-with-leading-zeros-in-javascript
function pad(num, size) {
    var s = num+"";
    while (s.length < size) s = "0" + s;
    return s;
}

$.get("/api/Tochten", function(result) {


       var dataSet = [];
       var item = [];
       for (var i = 0 ; i < result.length ; i++) {
        var Trip = result[i];
        var start = "" + Trip.startTime[2]+ "-" + Trip.startTime[1] + "-" + Trip.startTime[0] + " " + pad(Trip.startTime[3], 2) + ":" + pad(Trip.startTime[4], 2)
        var eind = ""
         if(Trip.endTime != null) {
             eind = Trip.endTime[2]+ "-" + Trip.endTime[1] + "-" + Trip.endTime[0] + " " + pad(Trip.endTime[3], 2) + ":" + pad(Trip.endTime[4], 2)
         }
        var totaal = [Trip.tripID, start, eind, Trip.type, Trip.bootnummer];

       dataSet.push(totaal);


       }
//        console.log(eind);
       $("#TripID").DataTable({
            data: dataSet
       });


});
