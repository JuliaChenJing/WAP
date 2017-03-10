"use strict";
console.log('Maze game starts');

var maze = (function () {              // maze is the function constructor
    var started = false;
    var outside = 0;
    return {
        start: function () {
            started = true;
            outside = 0;
        },
        hasStarted: function () {
            return started;
        },
        incrementOutside: function () {
            console.log('incrementOutside  with -->' + outside);
            return outside++;
        },
        reset: function () {
            console.log('maze reset called');
            started = false;
            outside = 0;
            setTimeout(function () {
                $('h2#status').html('Click "S" to continue!!!');
            }, 2000);
        },
        getOutSide: function () {
            return outside;
        }

    };
})();

$(document).ready(function () {    // load the DOM
    console.log('JQuery starts');
    $("#start").click(function () {
        maze.start();
        $("h2#status").html("Game Started");
        if ($(".boundary").hasClass("youlose")) {
            $(".boundary").removeClass("youlose");
        }
    });
    $("#maze").on('mouseover', function (evt) {
        if (maze.hasStarted()) {
            var target = evt.target;

            if ($(target).hasClass("boundary")) {
                maze.incrementOutside();
                $(".boundary").addClass("youlose");
                $("h2#status").html("Sorry , You Lose !!!");
                maze.reset();
            }
            if ($(target).attr("id") === 'end') {
                if (maze.getOutSide() === 0) {        // also check if cheated going for outside
                    $("h2#status").html("You Win !!!");
                } else {
                    $("h2#status").html("Sorry , You Lose !!!");
                }
                maze.reset();
            } 
        }
        });
    $("#maze").on('mouseleave', function (evt) {
        if (maze.hasStarted()) {
            console.log('you leaved the boundary');
            $("h2#status").html("Sorry , You Lose !!! ,\n You went out of Maze (Cheater !!!)");
            //and make the maze color red
            $(".boundary").addClass("youlose");
            maze.reset();
        }
    });
});