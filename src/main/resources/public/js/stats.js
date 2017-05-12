$.get("api/stats", function(result) {
      $("#numberOfTrips").text(result[0]);
      $("#numberOfLakeTrips").text(result[1]);
      $("#numberOfRiverTrips").text(result[2]);
      $("#averageDurationOfTrip").text(result[3]);
      $("#averageDurationOfLakeTrip").text(result[4]);
      $("#averageDurationOfRiverTrip").text(result[5]);

});