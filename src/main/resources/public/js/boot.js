$.get("/api/boot", function(result) {
       var dataSet = [];
       for (var i = 0 ; i < result.length ; i++) {
        var beschikbaar = result[i].trip == null
        dataSet.push([result[i].nummer, beschikbaar])
       }
        console.log(dataSet);
       $("#botentabel").DataTable({
            data: dataSet
       });


});

$("#startLakeTrip").click(function(event){
    event.preventDefault();
    $.get("/api/newtrip", function(result) {});
    var newtrip ={
                    startTime:$("#InputStart").val(),
                    endTime:$("#InputEnd").val(),
                    type:"Meer"
                    };

console.log(newtrip);

            $.ajax({
            contentType: "application/json",
            type: "POST",
            url:"/api/boot",
            data: JSON.stringify(newtrip),
            success: function(result) {
                        console.log(result);
                        },
            error: function(e){
                  console.log(e);

                  var e = ("Het is niet gelukt om een tocht toe te voegen")
                     }
          });

});