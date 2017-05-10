$("#btn2").click(function(event){
    event.preventDefault();
    var k ={
            roomNumber: $("#inputaddnumber").val(),
            roomType: $("#inputaddtype").val()
            };
    console.log("Kamernummer = "+ $("#inputaddnumber").val() + "; kamertype = " + $("#inputaddtype").val());

    $.ajax({

            contentType: "application/json",
            type: "POST",
            url:"/api/rooms/addroom",
            data: JSON.stringify(k),
            success: function(result) {
                        console.log(result);
                        location.href="room.html"
                        },
            error: function(e){
                  console.log(e);

                  var e = ("Uw invoer is niet correct.")
                    $("#confirmaddroom").text(e);
            }
          });
});