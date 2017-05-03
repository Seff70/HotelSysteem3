
$.get("api/page", function(result) {

$("#title").text(result.title);
$("#content").text(result.content);


});