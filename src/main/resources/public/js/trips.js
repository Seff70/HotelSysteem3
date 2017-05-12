$.get("/api/trips", function (result) {
    var trips = result._embedded.trips;
    console.log(trips);
    $("#TripID").DataTable({
        columns: [
            {data: 'tripID'},
            {data: 'type'},
            {data: 'startTime'},
            {data: 'endTime'}
        ],
        data: trips
    });
});
