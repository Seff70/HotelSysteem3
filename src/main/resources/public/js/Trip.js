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
        var start = "" + Trip.starttime[2]+ "-" + Trip.starttime[1] + "-" + Trip.starttime[0] + " " + pad(Trip.starttime[3], 2) + ":" + pad(Trip.starttime[4], 2)
        var eind = ""
         if(Trip.endtime != null) {
             eind = Trip.endtime[2]+ "-" + Trip.endtime[1] + "-" + Trip.endtime[0] + " " + pad(Trip.endtime[3], 2) + ":" + pad(Trip.endtime[4], 2)
         }
        var totaal = [Trip.tripID, start, eind, Trip.type, Trip.bootnummer];

       dataSet.push(totaal);


       }
//        console.log(eind);
       $("#TripID").DataTable({
            data: dataSet
       });


});
