$.get("api/guestlist", function(result) {
    console.table(result);

    var dataSet = [];

    for (var i = 0; i<result.length; i++) {
    console.log(result);
    console.log(result[0].name);
    dataSet.push([result[i].name, result[i].address, result[i].zipcode, result[i].city, result[i].country, result[i].phonenumber, result[i].special]);
    }

$("#guestlist").DataTable( {
        data: dataSet

//        columns: [
//        {title: "Name"},
//        {title: "Address"},
//        {title: "Zipcode"},
//        {title: "City"},
//        {title: "Country"},
//        {title: "Phonenumber"},
//        {title: "Special"}
//        ]
    });

});

