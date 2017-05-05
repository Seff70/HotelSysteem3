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

