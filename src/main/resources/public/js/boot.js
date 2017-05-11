$.get("/api/boot", function(result) {
       var dataSet = [];
       for (var i = 0 ; i < result.length ; i++) {
        var beschikbaar;
         if (result[i].trip == null) {
            beschikbaar = "Beschikbaar";
         }
         else {
            beschikbaar = "Onderweg met tochtnummer " + result[i].trip.tripID;
         }
        dataSet.push([result[i].nummer, beschikbaar])
       }
        console.log(dataSet);
       $("#botentabel").DataTable({
            data: dataSet
       });

       var table = $('#botentabel').DataTable();

     $('#botentabel tbody').on('click', 'tr', function () {
                var dataFromRow = table.row( this ).data();
                console.log(dataFromRow);
                //start een nieuwe tocht
                if (dataFromRow[1]=="Beschikbaar") {
                    $("#boatTableBig").hide();
                    $("#header").text("Gegevens van boot " + dataFromRow[0]);
                    $("#oneBoat").show();
                    startTrip(dataFromRow);
                }
                // beeindig de aangeklikte tocht
                else {
                    $("#boatTableBig").hide();
                    $("#header").text("Gegevens van boot " + dataFromRow[0]);
                    $("#endTripContainer").show();
                    $("#tripID").text("Tochtnummer "+ dataFromRow[1]);
                    //$("#startTime").val("")
    //                <div class="row" id="endTripContainer" hidden>
    //                            <div id="tripID"></div><br>
    //                            <div id="startTime"></div><br>
    //                            <div id="tripType"></div><br>
                    endTrip(dataFromRow)
                }
    });

    function startTrip(dataFromRow){
        event.preventDefault();
        $('#startLakeTrip').on('click', function(){
            startLakeTrip(dataFromRow);
        });
        $("#startRiverTrip").on('click', function(){
            startRiverTrip(dataFromRow);
        });
        $("#cancelStartTrip").on('click', function(){
            $("#boatTableBig").show();
            $("#header").text("Overzicht Boten");
            $("#oneBoat").hide();
        });
    };

    function startLakeTrip(dataFromRow) {
        console.log(JSON.stringify({nummer: dataFromRow[0]}));
        $.ajax({
            contentType: "application/json",
            type: "POST",
            url: "/api/addlaketrip/",
            data: JSON.stringify({
                nummer: dataFromRow[0]
                //currentTrip: null
                }),
            success: function(result){
                alert("Tocht " + result.tripID + " is gestart met boot " + dataFromRow[0]);
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