"use strict";

console.log('---------------------Lab5------------------------');

// question 1> Define a function max() that takes two numbers as arguments and returns the largest of them.
//  Use the if-then-else construct available in Javascript.

function max(num1, num2) {
    if (num1 > num2) {
        return num1;
    } else {
        return num2;
    }
}

console.log('1> Maximum between (5, 8) => ' + max(5, 8));

//2> Define a function maxOfThree() that takes three numbers as arguments and returns the largest of them.

function maxOfThree() {
    let i = 0;
    let max = -Infinity;
    for (i = 0; i < arguments.length; i++) {
        if (arguments[i] > max) {
            max = arguments[i];
        }
    }
    return max;
}

console.log('2> Maximum between 5,56 and 8 => ' + max(5, 56, 8));

//3> Write a function isVowel() that takes a character (i.e. a string of length 1) and 
// returns true if it is a vowel, false otherwise.
function isVowel(char) {
    if (char == 'a' | char == 'e' | char == 'i' | char == 'o' | char == 'u') {
        return true;
    } else
        return false;
}
console.log('3> z isVowel -> ' + isVowel('z'));
console.log('\t a isVowel -> ' + isVowel('a'));

// 4) Define a function sum() and a function multiply() that sums and multiplies (respectively) all 
// the numbers in an array of numbers. 
// For example, sum([1,2,3,4]) should return 10, and multiply([1,2,3,4]) should return 24.
function sum(x, y, ...more) {
    let total = x + y;
    if(more.length > 0){
    for (let i=0; i<more.length; i++) 
        total += more[i];
    }
    return total;
}

function multiply(x, y, ...more) {
    let total = x * y;
    if(more.length > 0){
    for (let i=0; i<more.length; i++) 
    total *= more[i];
    }
    return total;
}

console.log('4> The total of 1,2,3,4 => '+sum(1,2,3,4));
console.log('\t The product of 1,2,3,4 => '+multiply(1,2,3,4));


// 5>Define a function reverse() that computes the reversal of a string.
//  For example, reverse("jag testar") should return the string "ratset gaj".
function reverse(str){
    let reverseString = "";
    for (let i = str.length - 1; i >= 0; i--) {
        reverseString += str[i];
    }
    return reverseString;
}
console.log('5> The reverse of "jag testar" --> '+reverse("jag testar"));

// 6> Write a function findLongestWord()
//  that takes an array of words and returns the length of the longest one.
function findLongestWord(...args){
    let maxLength = 0;
    args.forEach(function(arg) {
        if(arg.length > maxLength){
            maxLength = arg.length;
        }
    }, this);
    return maxLength;
}
var words = ['dog','aeroplane','management','dancingOnTheRoad','partyAllNight','human'];
console.log('6> Length of longest words [] => '+ findLongestWord(...words));

console.log('Words in the array are: -> '+words);
// 7> Write a function filterLongWords()
//  that takes an array of words and an integer i and returns the array of words that are longer than i.
function filterLongWords(i , ...args){
    var retArray = new Array();
    args.forEach(function(arg){
        if(arg.length > i)
            retArray.push(arg);
    },this);
    return retArray;
}
console.log('7> The returned words greater than size 5 are -> ['+ filterLongWords(5, ...words)+ ']');