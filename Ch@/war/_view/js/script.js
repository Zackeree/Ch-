//http://jsfiddle.net/tsLpY/

$(function() {
    $('.removespace').on('keypress', function(e) {
        if (e.which == 32)
            return false;
    });
});


function auto_load(){
    $("#chatMessages").load(location.href + " #chatMessages");
};

setInterval(auto_load, 1000);
