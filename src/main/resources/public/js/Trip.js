$.get("/api/Tochten", function(result) {


       var eind = [];
       var item = [];
       for (var i = 0 ; i < result.length ; i++) {
        var Trip = result[i];
        var totaal = [Trip.tripnummer, Trip.starttime, Trip.endtime, Trip.type, Trip.BoatID];

       eind.push(totaal);


       }
        console.log(eind);
       $("#TripID").DataTable({
            data: eind
       });


});
