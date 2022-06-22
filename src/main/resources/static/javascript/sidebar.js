let flag = false;

function toggleNav(){
    if(flag === true){
        console.log(flag)
        closeNav();
    }else if(flag === false){
        console.log(flag);
        openNav();
    }
};

function openNav() {
    document.getElementById("mySidebar").style.width = "250px";
    fadeOut( document.getElementById("right") , document.getElementById("middle"));
    flag = true;

}

function closeNav() {
    document.getElementById("mySidebar").style.width = "0";
    fadeIn( document.getElementById("right"), document.getElementById("middle"));
    flag = false;

}

function fadeOut(element1, element2) {
    var op = 1;  // initial opacity
    var timer = setInterval(function () {
        if (op <= 0.3){
            clearInterval(timer);
        }
        element1.style.opacity = op;
        element1.style.filter = 'alpha(opacity=' + op * 100 + ")";
        element2.style.opacity = op;
        element2.style.filter = 'alpha(opacity=' + op * 100 + ")";
        op -= op * 0.1;
    }, 15);
}

function fadeIn(element1, element2) {
    var op = 0.1;  // initial opacity
    var timer = setInterval(function () {
        if (op >= 1){
            clearInterval(timer);
        }
        element1.style.opacity = op;
        element1.style.filter = 'alpha(opacity=' + op * 100 + ")";
        element2.style.opacity = op;
        element2.style.filter = 'alpha(opacity=' + op * 100 + ")";
        op += op * 0.1;
    }, 15);
}

function openRoomStatusForm(){
    closeNav();
    closeRoomArchiveStatusForm();
    closeRoomOnDayForm();
    document.getElementById("roomStatusForm").style.display = "block";

}

function closeRoomStatusForm(){
    document.getElementById("roomStatusForm").style.display = "none";
}

function openRoomArchiveStatusForm(){
    closeNav();
    closeRoomStatusForm();
    closeRoomOnDayForm();
    document.getElementById("roomArchiveStatusForm").style.display = "block";
}
function closeRoomArchiveStatusForm(){
    document.getElementById("roomArchiveStatusForm").style.display = "none";
}

function openRoomOnDayForm(){
    closeNav();
    closeRoomStatusForm();
    closeRoomArchiveStatusForm();
    document.getElementById("roomStatusOnDay").style.display = "block";
}

function closeRoomOnDayForm(){
    document.getElementById("roomStatusOnDay").style.display = "none";
}
function openPopupRoomState(){
    closeNav();
    document.getElementById("popupRoomState").style.display = "block";
}

function closePopupRoomState(){
    document.getElementById("popupRoomState").style.display = "none";
}