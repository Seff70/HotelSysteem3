$.get("api/pages", function(result) {

$("#title").text(result.title);
$("#content").text(result.content);

});

$("#btn1").click(function(event){
    event.preventDefault();
    var k ={kamernummer: $("#tf1").val()};
    console.log("waarde = "+ $("#tf1").val())

    $.ajax({

            contentType: "application/json",
            type: "POST",
            url:"/api/kamernummer",
            data: JSON.stringify(k),
            success: function(result) {
                        console.log(result);
                        var s = ("Kamer " + result.kamernummer + " is een " + result.type + " kamer "   );
                        $("#content").text(s);
                        },
            error: function(e){
                  console.log(e);

                  var e = ("Dit is geen geldig kamernummer!")
                    $("#content").text(e);
            }
          });
});

