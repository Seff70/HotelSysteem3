$.get("api/pages", function(result) {

$("#title").text(result.title);
$("#content").text(result.content);
});

$("#btn1").click(function(event){
    event.preventDefault();
    var k ={kamernummer: $("#tf1").val()};
    //k.kamernummer = $("#tf1").val();
    console.log("waarde = "+ $("#tf1").val())
    $.ajax({
        contentType: "application/json",
        type: "POST",
        url:"/api/kamernummer",
        data: JSON.stringify(k),
        success: function(kamer) {
            console.log(kamer);
            var s = ("Kamer " + kamer.kamernummer);
            $("#content").text(s);

    }
          });
});

