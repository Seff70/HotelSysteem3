$.get("/api/stats", function(result) {
        console.log(result);
      $("#totalNumberTrips").text(result[0]);
      $("#totalLakeTrips").text(result[1]);
      $("#totalRiverTrips").text(result[2]);
      $("#durationAllTrips").text(result[3]);
      $("#durationLakeTrips").text(result[4]);
      $("#durationRiverTrips").text(result[5]);

});
$("#refresh").click(function (event) {
                     location.href= "stats.html"
});