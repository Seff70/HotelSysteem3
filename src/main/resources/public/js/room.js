$.get("/api/rooms", function(result) {
    console.table(result);
    var roomTable = [];
    for(var i = 0; i < result.length; i++) {
        roomTable.push([result[i].roomNumber, result[i].roomType]);
    }
    var table = $('#tableRooms').DataTable( {
        data: roomTable
    });
      $('#tableRooms tbody').on('click', 'tr', function () {
      console.log('API row values : ', table.row(this).data());
      var data = table.row( this ).data();
      $("#newroom").show();
      $("#tableRooms").hide();
      $("#inputaddnumber").hide();
      $("#inputaddtype").val(data[1]);
      $("#btn2").click(function(event){
          event.preventDefault();
          var k ={roomNumber: data[0],
          roomType: $("#inputaddtype").val()}
           $.ajax({

                      contentType: "application/json",
                      type: "POST",
                      url:"/api/rooms",
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
         // console.log("Kamernummer = "+ $("#tf1").val())
      })

        $("#btn3").click(function(event){
          event.preventDefault();
          var k ={roomNumber: data[0],
                  roomType: $("#inputaddtype").val()}  ;
           $.ajax({

                      contentType: "application/json",
                      type: "DELETE",
                      url:"/api/rooms/" + k.roomNumber,
//                      data: JSON.stringify(k),
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
         // console.log("Kamernummer = "+ $("#tf1").val())
      })

      }
      );
});
//nieuwe kamer toevoegen
 $("#btn4").click(function(event){
                     $("#newroom").show();
                     $("#btn3").hide();
                     console.log("teskltj");
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



