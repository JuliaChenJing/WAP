$(function() {
    $("#send").click(updateGuesses);
});

function updateGuesses() {
    var first = $("#first").val();
    var last = $("#last").val();
    
    $.ajax("guest.ajax", {
		"type": "post",
		"data": {
        	"first": first,
                "last": last
		}
    }).done(displayGuests);
}

function displayGuests(data) {
    var list = $("<ul>");
    for (var i = 0; i < data.length; i++) {
        list.append($('<li>', {'html': data[i].first + " " + data[i].last}));
    }
    $("#guestList").html(list);
    
}