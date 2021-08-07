
const questions = document.querySelectorAll(".ques");
const resultForm = document.getElementById("result-form");
const result = document.getElementById("result");
const timeDisplay = document.getElementById("time");
const nextBtn = document.getElementById("nextBtn");
var currentIndex = 1;
//set default currentIndex is 1

function startTimer(duration, timeDisplay) {

    var minutes, seconds;
    var radix = 10;
    setInterval(function () {
        //this function will excecute after 1000 millliseconds

        minutes = parseInt(duration / 60, radix);
        //minutes equal timer divide to 60
        seconds = parseInt(duration % 60, radix);
        //seconds equal timer modulo to 60

        minutes = minutes < 10 ? "0" + minutes : minutes;
        //append to 0 before minutes if it less than 10
        seconds = seconds < 10 ? "0" + seconds : seconds;
        //append to 0 before seconds if it less than 10

        timeDisplay.textContent = minutes + ":" + seconds;
        //display time

        if (duration === 0) {
            //duration equal 0 then submit result then return
            submitResult();
            return;
        }

        duration--;
        //duration decrease to 1 second
    }, 1000);
}

window.onload = function () {
    questions[0].className="showquestion";
    // display block the first question when web loaded all the resource  
    var timelabel = timeDisplay.textContent;
    var duration = parseInt(timelabel.substr(0, 2), 10) * 60 + parseInt(timelabel.substr(3, 2), 10);
    startTimer(duration - 1, timeDisplay);
    // duration is decreased to 1 cause the timedisplay has already displayed the first second
};

function getResult() {
    var rs = "";
    var inputAnswers = document.querySelectorAll('.op');
    //get all input checkbox of answers
    for (var i = 0; i < inputAnswers.length; i++) {
        if (inputAnswers[i].checked) {
            //if input checkbox of answers was checked then append id of that answer to result string
            rs += inputAnswers[i].value + " ";
        }
    }
    return rs;
}

function submitResult() {
    //get value of result of all checkbox input to result input
    result.value = getResult();
    //submit form to server
    resultForm.submit();

}

function nextQuestion() {
    if (currentIndex === questions.length) {
        //currentIndex is equal to position of last question then submit the hidden form
        submitResult();
    } else {
        //currentIndex is not equal to position of last question 
        //then set display style of next and previous question div
        if (currentIndex === questions.length - 1) {
            //currentIndex is equal to position of before last question 
            //then change text of nextBtn to finish
            nextBtn.textContent = "Finish";
        }
        questions[currentIndex - 1].className="hidequestion";
        //set style of the previous question div to none
        questions[currentIndex].className="showquestion";
        //set style of the next question div to block
        currentIndex++;
        //currentIndex have to increase to 1 after the nextBtn is clicked        
    }
}


