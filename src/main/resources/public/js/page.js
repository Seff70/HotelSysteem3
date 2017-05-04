//$.get("api/pages", function(result) {
//
//$("#title").text(result.title);
//$("#content").text(result.content);
//});

$("#btn1").click(function(){
    console.log("waarde = "+ $("#tf1").val())
    $.ajax({
    type: "POST",
    url:"/api/kamernummer",
    data: $("#tf1").val(),
    contentType: "application/json",
    success: console.log("success!1"),

      });
});

