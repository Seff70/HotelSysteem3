//$.get("api/guests", function(result) {
//    console.table(result);
//    var dataSet = [];
//
//    for (var i = 0; i<result.length; i++) {
//        $("#newguestform").hide();
//        $("#guestlist").show();
//        $("#deleteGuest").hide();
//        $("#editGuest").hide();
//
//        dataSet.push([
//            result[i].guestID,
//            result[i].name,
//            result[i].address,
//            result[i].zipcode,
//            result[i].city,
//            result[i].country,
//            result[i].phonenumber,
//            result[i].special
//        ]);
//    };
//
//    var table = $("#guestlist").DataTable({
//        data: dataSet
//    });
//
//    $('#guestlist tbody').on('click', 'tr', function () {
//        var data = table.row( this ).data();
//
//        console.log(data);
//        console.log("appel");
//        $("#newguestform").show();
//        $("#guestlist").hide();
//        $("#deleteGuest").show();
//        $("#editGuest").show();
//
//        $("#InputName").val(data[1]);
//        $("#InputAddress").val(data[2]);
//        $("#InputZipcode").val(data[3]);
//        $("#InputCity").val(data[4]);
//        $("#InputCountry").val(data[5]);
//        $("#InputTelephone").val(data[6]);
//        $("#InputSpecial").val(data[7]);
//    });
//});
//
//$("#addGuest").click(function(event){
//    event.preventDefault();
//    var newguest= { name:$("#InputName").val(),
//                    address:$("#InputAddress").val(),
//                    zipcode:$("#InputZipcode").val(),
//                    city:$("#InputCity").val(),
//                    country:$("#InputCountry").val(),
//                    phonenumber:$("#InputTelephone").val(),
//                    special:$("#InputSpecial").val()};
//
//    console.log(newguest);
//
//    $.ajax({
//
//            contentType: "application/json",
//            type: "POST",
//            url:"/api/guests",
//            data: JSON.stringify(newguest),
//            success: function(result) {
//                        console.log(result);
//                        location.href ="guest.html"
//                        },
//            error: function(e){
//                  console.log(e);
//
//                  var e = ("Het is niet gelukt om een gast toe te voegen")
//                     }
//          });
//
//});
//
// $("#deleteGuest").click(function() {
//
//    $.ajax ({
//        contentType:'application/json',
//        type: "DELETE",
//        url:"/api/guests/" + data[0],
//        success: function() {
//            console.log("Guest was deleted");
//        },
//    });
//});
//
// $("#editGuest").click(function() {
// console.log("je hebt op editguest geklikt")
//    var newguest= { GuestID:data[0],
//                    name:$("#InputName").val(),
//                    address:$("#InputAddress").val(),
//                    zipcode:$("#InputZipcode").val(),
//                    city:$("#InputCity").val(),
//                    country:$("#InputCountry").val(),
//                    phonenumber:$("#InputTelephone").val(),
//                    special:$("#InputSpecial").val()};
//    $.ajax ({
//        contentType:'application/json',
//        type: "PUT",
//        data: JSON.stringify(newguest),
//        url:"/api/guests/" + data[0],
//        success: function() {
//            console.log("Guest was edited");
//        },
//    });
//});
//
//$('#btnAddGuest').click(function() {
//    $("#newguestform").show();
//    $("#guestlist").hide();
//})
//
//
