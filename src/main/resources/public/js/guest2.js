$.get("/api/guests",function (result){
    console.table(result);

    var table = $('#guestList').DataTable({
        columns: [
            {data: "guestid"},
            {data: "name"},
            {data: "address"},
            {data: "zipcode"},
            {data: "city"},
            {data: "country"},
            {data: "phonenumber"},
            {data: "special"}
        ],
           data: result
    });

    $('#guestList tbody').click('tr', function () {
        var data = table.row(this).data();
        console.log('API row values : ', data);
        $("#newguestform").hide();
        $("#guestList").show();
        $("#deleteGuest").hide();
        $("#editGuest").hide();
        $("#addGuest").click(function (event) {
            event.preventDefault();
            addGuest(data);
        });
        $("#editGuest").click(function (event){
            event.preventDefault();
            editGuest(data);
        });
        $("#deleteGuest").click(function (event){
            event.preventDefault();
            deleteGuest(data);
        });
    });
});

function addGuest(data){
    var newGuest = {
            name:$("#InputName").val(),
            address:$("#InputAddress").val(),
            zipcode:$("#InputZipcode").val(),
            city:$("#InputCity").val(),
            country:$("#InputCountry").val(),
            phonenumber:$("#InputTelephone").val(),
            special:$("#InputSpecial").val()
            };
            console.log("test bij new guest");
    $.ajax({
            contentType:"application/json",
            type: "POST",
            url: "/api/guests",
            data: JSON.stringify(newGuest),
            success: function(result){
                        console.log(result);
                        location.href="guest.html"
                        },
            error: function(){
                console.log("Het werkt niet om nieuwe gast aan te maken");
            }
    });
};
