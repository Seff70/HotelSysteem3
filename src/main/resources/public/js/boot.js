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
                        return "Onderweg met tochtnummer " + trip.tripID;
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
                console.log("boot: " + boat ", bootnr " + boat.nummer);
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
                    $("#header").text("Gegevens van boot " + boat[0]);
                    $("#endTripContainer").show();
                    $("#tripID").text("Tochtnummer "+ boat[1]);
                    //$("#startTime").val("")
    //                <div class="row" id="endTripContainer" hidden>
    //                            <div id="tripID"></div><br>
    //                            <div id="startTime"></div><br>
    //                            <div id="tripType"></div><br>
                    endTrip(boat);
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
        });
    };

    function startLakeTrip(dataFromRow) {
        console.log(JSON.stringify({dataFromRow}));
        $.ajax({
            contentType: "application/json",
            type: "POST",
            url: "/api/addlaketrip",
            data: JSON.stringify(dataFromRow),
            success: function(result){
                alert("Tocht " + result.tripID + " is gestart met boot " + dataFromRow.nummer);
                $("#boatTableBig").show();
                $("#header").text("Overzicht Boten");
                $("#oneBoat").hide();
                },
            error: function(e){
                      console.log(e);
            }
        });
    }
});