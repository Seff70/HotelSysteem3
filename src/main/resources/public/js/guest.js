$.get("api/guests", function(result) {
    //console.table(result);

    var dataSet = [];

    for (var i = 0; i<result.length; i++) {
    //console.log(result);
    //console.log(result[0].name);
    $("#newguestform").hide();
    $("#guestlist").show();
    dataSet.push([result[i].name, result[i].address, result[i].zipcode, result[i].city, result[i].country, result[i].phonenumber, result[i].special]);
    }

$("#guestlist").DataTable( {
        data: dataSet
    });

$(document).ready(function() {
    console.log("komt hier")
    var table = $('#guestlist').DataTable();

    $('#guestlist tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        console.log(data);
        $("#newguestform").show();
        $("#guestlist").hide();

        $("#InputName").val(data[0]);
        $("#InputAddress").value(data[1]);
        $("#InputZipcode").val(data[2]);
        $("#InputCity").val(data[3]);
        $("#InputCountry").val(data[4]);
        $("#InputTelephone").val(data[5]);
        $("#InputSpecial").val(data[6]);
//        alert( 'You clicked on '+data[0]+'\'s row' );
    } );
} );
});

