$("#btn1").click(function(event){
    event.preventDefault();
    var newguest= { name:$("#InputName").val(),
                    address:$("#InputAddress").val(),
                    zipcode:$("#InputZipcode").val(),
                    city:$("#InputCity").val(),
                    country:$("#InputCountry").val(),
                    phonenumber:$("#InputTelephone").val(),
                    special:$("#InputSpecial").val()};
//    var k ={kamernummer: $("#tf1").val()};
//    console.log("waarde = "+ $("#tf1").val())
console.log(newguest);

    $.ajax({

            contentType: "application/json",
            type: "POST",
            url:"/api/guests",
            data: JSON.stringify(newguest),
            success: function(result) {
                        console.log(result);
                        location.href ="guest.html"
                        },
            error: function(e){
                  console.log(e);

                  var e = ("Het is niet gelukt om een gast toe te voegen")
                     }
          });

});
