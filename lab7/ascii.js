"use strict";
//  the JavaScript code for your web page 
console.log('game starts');

window.onload = pageload;
function pageload() {
    var animationTextArea = document.getElementById('text-area'),
        startBtn = document.getElementById('start'),
        stopBtn = document.getElementById('stop'),
        animationSelect = document.getElementById('animation'),
        sizeSelect = document.getElementById('fontsize'),
        turbo = document.getElementById('turbo'),
       
        iteration = 0,
        intervalId = null,
        animationData = null;
        
    startBtn.addEventListener("click", startFunction);
    stopBtn.addEventListener("click", stopFuntion);

    animationSelect.addEventListener("click", displayAnimationText);
    turbo.addEventListener("change", function () {
        console.log('checked turbo');
        if (clearTheInterval()) {
            intervalId = setInterval(animate, this.checked ? 50 : 250);
            console.log('-----------<>'+intervalId);
        }
    });

    sizeSelect.addEventListener("click", function () {
        animationTextArea.style.fontSize = sizeSelect.value;
    });

    function startFunction() {
        if (animationTextArea.value != " ") {
            console.log('Text-Area content --> ' + animationTextArea.value);
            stopBtn.disabled = false;
            disableUIControls();
            animationData = animationTextArea.value.split("=====\n");
            iteration = 0;
            intervalId = setInterval(animate, turbo.checked ? 50 : 250);
            console.log('interval of -> ' + intervalId);
        }
    }
    function animate() {
        if (iteration == animationData.length) {
            iteration = 0;
        }
        animationTextArea.value = animationData[iteration];
        console.log('===>'+animationData[iteration]);
        iteration++;
    }
    function disableUIControls() {
        startBtn.disabled = true;
        animationSelect.disabled = true;
    }
    function enableUIControls() {
        startBtn.disabled = false;
        animationSelect.disabled = false;
    }

    function displayAnimationText() {
        animationTextArea.value = ANIMATIONS[animationSelect.value];
    }

    function stopFuntion() {
        stopBtn.disabled = true;
        enableUIControls();
        displayAnimationText();
        clearTheInterval();
    }
    function clearTheInterval() {
        console.log('The interval id is --> ' + intervalId);
        if (intervalId !== null) {
            clearInterval(intervalId);
            intervalId = null;
            return true;
        }
        return false;
    }

}