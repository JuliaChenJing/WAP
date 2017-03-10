"use strict";
console.log('Maze game starts');

var maze = (function () {              // maze is the function constructor 好比建立一个class
    var started = false;
    var outside = 0;
    return {
        start: function () {//开始游戏
            started = true;
            outside = 0;
        },
        hasStarted: function () {//是否开始？
            return started;
        },
        incrementOutside: function () {//是否越界
            console.log('incrementOutside  with -->' + outside);
            return outside++;
        },
        reset: function () {//游戏重新开始
            console.log('maze reset called');
            started = false;
            outside = 0;
             setTimeout(function () {
                 $('h2#status').html('Click "S" to continue!!!');
             }, 2000);
        },
        getOutSide: function () {//是否外越界
            return outside;
        }

    };
})();


//处理鼠标的行动
$(document).ready(function () {    // load the DOM 文件是否正确加载
    console.log('JQuery starts');
    $("#start").click(function () {//唯一好用的是start的这个区域
        maze.start();//游戏开始
        $("h2#status").html("Game Started");//标题显示游戏开始
        if ($(".boundary").hasClass("youlose")) {
            $(".boundary").removeClass("youlose");
        }
    });
    $("#maze").on('mouseover', function (evt) {
        if (maze.hasStarted()) {
            var target = evt.target;
            console.log('------------->'+target);
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