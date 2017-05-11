$.get("/api/guests",function (result){
    console.table(result);

    $("#newguestform").hide();
    $("#guestlist").show();
    $("#deleteGuest").hide();
    $("#editGuest").hide();

    var table = $('#guestList').DataTable({
        columns: [
            {data: "guestID"},
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

    $('#guestList tbody').on('click','tr', function () {
        var data = table.row(this).data();
        console.log('API row values : ', data);
        $("#newguestform").show();
        $("#guestList").hide();
        $("#deleteGuest").show();
        $("#editGuest").show();

        $("#InputName").val(data.name);
        $("#InputAddress").val(data.address);
        $("#InputZipcode").val(data.zipcode);
        $("#InputCity").val(data.city);
        $("#InputCountry").val(data.country);
        $("#InputTelephone").val(data.phonenumber);
        $("#InputSpecial").val(data.special);

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

function editGuest(data){
    $.ajax({
        contentType:"application/json",
        type: "PUT",
        url: "/api/guests/" + data.guestID,
        data: JSON.stringify({
//           guestID: data.guestID,
           name:$("#InputName").val(),
           address:$("#InputAddress").val(),
           zipcode:$("#InputZipcode").val(),
           city:$("#InputCity").val(),
           country:$("#InputCountry").val(),
           phonenumber:$("#InputTelephone").val(),
           special:$("#InputSpecial").val()
           }),
        success: function (result){
            console.log(result);
            location.href="guest.html"
        },
        error: function(){
            console.log("You're amazing");
        }
    });
};

function deleteGuest(data){
    console.log("data "+data.guestID)
    $.ajax ({
        contentType:'application/json',
        type: "DELETE",
        url:"/api/guests/" + data.guestID,
        success: function() {
            console.log("Guest was deleted");
            location.href="guest.html";
        },
    });
};


$('#btnAddGuest').click(function() {
    $("#newguestform").show();
    $("#guestlist").hide();
})