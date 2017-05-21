$.get("/api/guests",function (result){
    console.table(result);

    $("#guestlist").removeClass('hidden');
    $("#btnAddGuest").removeClass('hidden');
    $("#newguestform").addClass('hidden');
    $("#addGuest").addClass('hidden');
    $("#deleteGuest").addClass('hidden');
    $("#editGuest").addClass('hidden');
    $("#backToPrevious").addClass('hidden');

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
        $("#guestlist").addClass('hidden');
        $("#btnAddGuest").addClass('hidden');
        $("#newguestform").removeClass('hidden');
        $("#addGuest").addClass('hidden');
        $("#deleteGuest").removeClass('hidden');
        $("#editGuest").removeClass('hidden');
        $("#backToPrevious").removeClass('hidden');

        $("#InputName").val(data.name);
        $("#InputAddress").val(data.address);
        $("#InputZipcode").val(data.zipcode);
        $("#InputCity").val(data.city);
        $("#InputCountry").val(data.country);
        $("#InputTelephone").val(data.phonenumber);
        $("#InputSpecial").val(data.special);

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



$('#btnAddGuest').click(function() {
    $("#guestlist").addClass('hidden');
    $("#btnAddGuest").addClass('hidden');
    $("#newguestform").removeClass('hidden');
    $("#addGuest").removeClass('hidden');
    $("#deleteGuest").addClass('hidden');
    $("#editGuest").addClass('hidden');
    $("#backToPrevious").addClass('hidden');

    $("#headerForm").text("Nieuwe gast");
});

$("#addGuest").click(function (event) {
    event.preventDefault();
    addGuest();
});

function addGuest(){
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
//                console.log("Het werkt niet om nieuwe gast aan te maken");

                alert("Deze gast bestaat al.");
            }
    });
};

function editGuest(data){
    $.ajax({
        contentType:"application/json",
        type: "PUT",
        url: "/api/guests/" + data.guestID,
        data: JSON.stringify({
           guestID: data.guestID,
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


