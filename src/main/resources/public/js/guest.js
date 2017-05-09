$.get("api/guests", function(result) {
    //console.table(result);

    var dataSet = [];

    for (var i = 0; i<result.length; i++) {
    //console.log(result);
    //console.log(result[0].name);
    dataSet.push([result[i].name, result[i].address, result[i].zipcode, result[i].city, result[i].country, result[i].phonenumber, result[i].special]);
    }

$("#guestlist").DataTable( {
        data: dataSet
    });

$(document).ready(function() {
    console.log("komt hier")
    var table = $('#example').DataTable();

    $('#example tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        alert( 'You clicked on '+data[0]+'\'s row' );
    } );
} );
});

