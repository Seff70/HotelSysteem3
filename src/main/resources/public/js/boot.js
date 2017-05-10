$.get("/api/boot", function(result) {


       var eind = [];
       var item = [];
       for (var i = 0 ; i < result.length ; i++) {
        var boot = result[i];
        var totaal = [boot.nummer, boot.bootnaam];

       eind.push(totaal);


       }
        console.log(eind);
       $("#botentabel").DataTable({
            data: eind
       });


});

$("#startLakeTrip").click(function(event){
    event.preventDefault();
    $.get("/api/newtrip", function(result) {});
    var newtrip ={ bootnummer:$("#InputBoat").val(),
                    startTime:$("#InputStart").val(),
                    endTime:$("#InputEnd").val(),
                    type:"." + $("#InputType").val()
                    };

console.log(newtrip);

            $.ajax({
            contentType: "application/json",
            type: "POST",
            url:"/api/Tochten",
            data: JSON.stringify(newtrip),
            success: function(result) {
                        console.log(result);
                        location.href ="Tochten.html"
                        },
            error: function(e){
                  console.log(e);

                  var e = ("Het is niet gelukt om een tocht toe te voegen")
                     }
          });

});