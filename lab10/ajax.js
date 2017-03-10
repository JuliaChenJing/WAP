'use strict';
$(function () {
    $("#loader").hide();//隐藏loading图标
    $(document).ajaxStart(function () { $("#loader").show(); })//控制loading图标的显示与否，一旦ajax起作用就开始显示图标
        .ajaxStop(function () { $("#loader").hide(); });

    //ajax for first go button click
    $("#go").click(function () {//一旦第一个go被点击
        console.log('button clicked');//随时输出一些log用来帮助编程
        let userId = $('#inputValue').val();//val() 方法返回或设置被选元素的值
        console.log('UserId--> ' + userId);
        $.get("http://jsonplaceholder.typicode.com/users/" + userId)
            .done(ajaxSuccess)
            .fail(ajaxFailure);

    });

    // ajax for second go button click
    // Display all posts from selected user /posts?userId=1
    $("#go2").click(function () {//一旦第一个go被点击
        console.log(' button 2 clicked');
        let userId = $('#inputValue2').val();
        console.log('UserId--> ' + userId);
        $.ajax({
            "url": "http://jsonplaceholder.typicode.com/posts?userId=" + userId,
            "type": "GET",
            "dataType": 'json',
            "success": ajaxSuccess2,
            "error": ajaxFailure
        });
    });


});
// document ready closed------

// comment ajax request
$(document).on("click", ".showComment", function () {
    console.log(' comment button clicked');
    var postId = $(this).data('value');

    $.ajax({
        "url": "http://jsonplaceholder.typicode.com/comments?postId=" + postId,
        "type": "GET",
        "dataType": 'json',
        "success": ajaxSuccess3,
        "error": ajaxFailure
    });
});

//the first button
function ajaxSuccess(data) {
    $('p#output').empty();//先清空旧内容
    console.log('Responded data--->' + (data = JSON.stringify(data)));
    $('p#output').html(data);
}
//the second button
function ajaxSuccess2(data) {
    $('p#output').empty();//先清空旧内容
    $('<h3>').text('All-posts').appendTo('#output');
    for (var i = 0; i < data.length; i++) {
        $('<li>')
            .text('userId-> ' + data[i].userId + '  id-> ' + data[i].id + '  title-> ' + data[i].title)
            .appendTo('#output');

        //   add button and paragraph
        $('<button class="showComment" data-value="' + data[i].id + '" style= "Position:Absolute; right:50px; ">showComment</button><br />' +
            '<p id="outputComment' + data[i].id + '" data-value="' + data[i].id + '"></p><br />')
            .appendTo('#output');
    }
}
//comment button 
function ajaxSuccess3(data) {
    for (var i = 0; i < data.length; i++) {
        $('p#outputComment' + data[i].postId).html(data[i].body);
    }
}

function ajaxFailure(xhr, status, exception) {
    console.log(xhr, status, exception);
}