//http://jsfiddle.net/tsLpY/

$(function() {
    $('.removespace').on('keypress', function(e) {
        if (e.which == 32)
            return false;
    });
});
