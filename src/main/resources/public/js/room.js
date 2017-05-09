//$.get("/api/roomList", function(result) {
//    console.table(result);
//    var roomTable = [];
//    for(var i = 0; i < result.length; i++) {
//        roomTable.push([result[i].roomNumber, result[i].roomType]);
//    }
//    $('#tableRooms').DataTable( {
//        data: roomTable
//    });
//});


//$.get("/api/{roomNumber}", function(result) {
//    console.table(result);
//
//
//
//    $('#tableRooms').DataTable( {
//        data: roomTable
//    });
//});



//$.get("/api/{roomNumber}", function(result) {
//
//$("#title").text(result.title);
//$("#content").text(result.content);
//
//});


$("#btn1").click(function(event){
    event.preventDefault();
    var k ={roomNumber: $("#tf1").val()};
    console.log("Kamernummer = "+ $("#tf1").val())

    $.ajax({

            contentType: "application/json",
            type: "POST",
            url:"/api/{roomNumber}",
            data: JSON.stringify(k),
            success: function(result) {
                        console.log(result);
                        var s = ("Kamer " + result.roomNumber + " is een " + result.type + " kamer "   );
                        $("#content").text(s);
                        },
            error: function(e){
                  console.log(e);

                  var e = ("Dit is geen geldig kamernummer!")
                    $("#content").text(e);
            }
          });
});
