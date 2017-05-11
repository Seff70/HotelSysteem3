$.get("api/guests", function(result) {
    var dataSet = [];

    for (var i = 0; i<result.length; i++) {
        $("#newguestform").hide();
        $("#guestlist").show();
        $("#btn3").hide();

        dataSet.push([
            result[i].guestID,
            result[i].name,
            result[i].address,
            result[i].zipcode,
            result[i].city,
            result[i].country,
            result[i].phonenumber,
            result[i].special
        ]);
    };

    $("#guestlist").DataTable({
        data: dataSet
    });

    $(document).ready(function() {
        console.log("komt hier");

        var table = $('#guestlist').DataTable();

        $('#guestlist tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();

            console.log(data);
            console.log("appel");
            $("#newguestform").show();
            $("#guestlist").hide();
            $("#btn3").show();

            $("#InputName").val(data[1]);
            $("#InputAddress").val(data[2]);
            $("#InputZipcode").val(data[3]);
            $("#InputCity").val(data[4]);
            $("#InputCountry").val(data[5]);
            $("#InputTelephone").val(data[6]);
            $("#InputSpecial").val(data[7]);

            $("#btn3").click(function() {
                $.ajax ({
                    contentType:'application/json',
                    type: "DELETE",
                    url:"/api/guests/" + data[0],
                    success: function() {
                        console.log("Guest was deleted");
                    },
                });
            });


        });
    });
});

$('#btnAddGuest').click(function() {
    $("#newguestform").show();
    $("#guestlist").hide();
})


