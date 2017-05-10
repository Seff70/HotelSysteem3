$("#btntrip").click(function(event){
    event.preventDefault();
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
