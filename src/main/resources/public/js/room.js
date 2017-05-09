$.get("/api/rooms", function(result) {
    console.table(result);
    var roomTable = [];
    for(var i = 0; i < result.length; i++) {
        roomTable.push([result[i].roomNumber, result[i].roomType]);
    }
    $('#tableRooms').DataTable( {
        data: roomTable
    });
});


$("#btn1").click(function(event){
    event.preventDefault();
    var k ={roomNumber: $("#tf1").val()};
    console.log("Kamernummer = "+ $("#tf1").val())

    $.ajax({

            contentType: "application/json",
            type: "GET",
            url:"/api/rooms/" + k.roomNumber,
            success: function(result) {
                        console.log(result);
                        var s = ("Kamer " + result.roomNumber + " is een " + result.roomType + " kamer "   );
                        $("#content").text(s);
                        },
            error: function(e){
                  console.log(e);

                  var e = ("Dit is geen geldig kamernummer!")
                    $("#content").text(e);
            }
          });
});
