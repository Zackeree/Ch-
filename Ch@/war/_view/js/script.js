//http://jsfiddle.net/tsLpY/

$(function() {
    $('.removespace').on('keypress', function(e) {
        if (e.which == 32)
            return false;
    });
});

// Height = 480px;

function updateScroll(){
	var scroll = document.getElementById("chatMessages");
	//scrollBottom will equal scrollTop if scrolled to bottom
	var scrollBottom = (scroll.scrollTop + scroll.scrollHeight - 480)/2;
	// If user is close to bottom, automatically update to bottom message
	// This accounts for a new messages not making scrollBottom == scrollTop perfectly
	if (scrollBottom - 30 <= scroll.scrollTop) {
		scroll.scrollTop = scroll.scrollHeight;
	}
}


function auto_load(){
    $("#chatMessages").load(location.href + " #chatMessages");
    updateScroll();
}

setInterval(auto_load, 500);
