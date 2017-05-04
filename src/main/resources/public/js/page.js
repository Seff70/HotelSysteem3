
$.get("api/pages", function(result) {

$("#title").text(result.title);
$("#content").text(result.content);
});