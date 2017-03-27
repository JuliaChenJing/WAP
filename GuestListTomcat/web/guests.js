$(function() {
    $("#send").click(updateGuestList);
});

function updateGuestList() {
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

function displayGuests(guests) {
    var list = $("<ul>");
    for (var i = 0; i < guests.length; i++) {
        list.append($('<li>', {'html': guests[i].first + " " + guests[i].last}));
    }
    $("#guestList").html(list);
    
}