$.get("/api/Tochten", function(result) {


       var eind = [];
       var item = [];
       for (var i = 0 ; i < result.length ; i++) {
        var Trip = result[i];
        var totaal = [Trip.TripID, Trip.startTime, Trip.endTime, Trip.type, Trip.BoatID];

       eind.push(totaal);


       }
        console.log(eind);
       $("#TripID").DataTable({
            data: eind
       });


});
