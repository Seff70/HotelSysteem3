$.get("/api/boats", function(result) {

    var table = $("#botentabel").DataTable({
        columns: [
            {data: 'nummer'},
            {
                data: 'currentTrip',
                render: function(data, type, row) {
                    var trip = row.trip;
                    if (trip == null) {
                        return "Beschikbaar";
                    }
                    else {
                        return "Onderweg met tochtnummer " + trip.tripID + " sinds " + Date.parse(trip.startTime).toString();
                    }
                }
            }
        ],
        data: result
    });



//       var dataSet = [];
//       for (var i = 0 ; i < result.length ; i++) {
//        var beschikbaar;
//         if (result[i].trip == null) {
//            beschikbaar = "Beschikbaar";
//         }
//         else {
//            beschikbaar = "Onderweg met tochtnummer " + result[i].trip.tripID;
//         }
//         var a = {boatID: result[i].boatID, nummer: result[i].nummer, beschikbaar: beschikbaar};
//         dataSet.push(a);
//       }
//        console.log(dataSet);
//       $("#botentabel").DataTable({
//            columns: [
//            {data: "nummer"},
//            {data: "beschikbaar"}
//            ],
//            data: dataSet
//       });

//       var table = $('#botentabel').DataTable();

     $('#botentabel tbody').on('click', 'tr', function () {
                event.preventDefault();
                var boat = table.row( this ).data();
                console.log("boot: " + boat + ", bootnr " + boat.nummer);
                //start een nieuwe tocht
                if (boat.trip==null) {
                    $("#boatTableBig").hide();
                    $("#header").text("Gegevens van boot " + boat.nummer);
                    $("#oneBoat").show();
                    startTrip(boat);
                }
                // beeindig de aangeklikte tocht
                else {
                    $("#boatTableBig").hide();
                    $("#header").text("Gegevens van boot " + boat.nummer);
                    $("#endTripContainer").show();
                    $("#tripID").text("Tochtnummer "+ boat.trip.tripID);
                    //$("#startTime").val("")
    //                <div class="row" id="endTripContainer" hidden>
    //                            <div id="tripID"></div><br>
    //                            <div id="startTime"></div><br>
    //                            <div id="tripType"></div><br>
                    endMenu(boat);
                }
    });

    function startTrip(dataFromRow){
        $('#startLakeTrip').on('click', function(){
            event.preventDefault();
            startLakeTrip(dataFromRow);
        });
        $("#startRiverTrip").on('click', function(){
            event.preventDefault();
            startRiverTrip(dataFromRow);
        });
        $("#cancelStartTrip").on('click', function(){
            event.preventDefault();
            $("#boatTableBig").show();
            $("#header").text("Overzicht Boten");
            $("#oneBoat").hide();
            location.href = "Bootpage.html"
        });
    };

    function startLakeTrip(boat) {
        console.log(JSON.stringify(boat));
        $.ajax({
            contentType: "application/json",
            type: "POST",
            url: "/api/boats/"+ boat.boatID + "/addlaketrip",
            data: JSON.stringify(boat),
            success: function(result){
                alert("Tocht " + result.tripID + " is gestart met boot " + boat.nummer);
                location.href="Bootpage.html";
                $("#boatTableBig").show();
                $("#header").text("Overzicht Boten");
                $("#oneBoat").hide();
                },
            error: function(e){
                      console.log(e);
            }
        });
    }
    function startRiverTrip(boat) {
            console.log(JSON.stringify(boat));
            $.ajax({
                contentType: "application/json",
                type: "POST",
                url: "/api/boats/"+ boat.boatID + "/addrivertrip",
                data: JSON.stringify(boat),
                success: function(result){
                    alert("Tocht " + result.tripID + " is gestart met boot " + boat.nummer);
                    location.href="Bootpage.html";
                    $("#boatTableBig").show();
                    $("#header").text("Overzicht Boten");
                    $("#oneBoat").hide();
                    },
                error: function(e){
                          console.log(e);
                }
            });
        }

    function endMenu(boat) {
        $("#endTrip").on('click', function(){
            event.preventDefault();
            endTrip(boat);
        });
        $("#cancelEndTrip").on('click', function(){
            event.preventDefault();
            $("#boatTableBig").show();
            $("#header").text("Overzicht Boten");
            $("#oneBoat").hide();
            $("#endTripContainer").show();
            location.href = "Bootpage.html"
        });
    }

   function endTrip(boat) {
       $.ajax({
           contentType: "application/json",
           type: "POST",
           url: "/api/boats/"+ boat.boatID + "/endtrip",
           data: JSON.stringify(boat),
           success: function(trip){
                var start = "";
                if (trip.startTime != null) {
                    start = "" + trip.startTime[2] + "-" + trip.startTime[1] + "-" + trip.startTime[0] + " " + pad(trip.startTime[3], 2) + ":" + pad(trip.startTime[4], 2)
                }
                var end = "";
                if (trip.endTime != null) {
                    end = trip.endTime[2] + "-" + trip.endTime[1] + "-" + trip.endTime[0] + " " + pad(trip.endTime[3], 2) + ":" + pad(trip.endTime[4], 2)
                }
                var duration = "";
                duration = Math.floor(trip.duur/3600) + "uur en " + Math.floor((trip.duur%3600)/60) + " minuten.";
//               duration = Math.floor(trip.duur/3600) + " uur en " + Math.floor(trip.duur/60) + " minuten.";
               alert("Tocht " + trip.tripID + " met boot " + boat.nummer + " over " +
               trip.type + " is geëindidgd.\n De tocht is gestart om: " +
               start + ". \n De tocht is geëindigd om: " +
               end + ". \n De tocht duurde: " +
               duration + "."
               );
               var tripStats = [trip.tripID, trip.type, trip.duur];
               location.href="Bootpage.html";
               $("#boatTableBig").show();
               $("#header").text("Overzicht Boten");
               $("#oneBoat").hide();
               $("#endTripContainer").hide();
               },
           error: function(e){
                     console.log(e);
           }
       });
   }

   function pad(num, size) {
       var s = num + "";
       while (s.length < size) s = "0" + s;
       return s;
   }

});