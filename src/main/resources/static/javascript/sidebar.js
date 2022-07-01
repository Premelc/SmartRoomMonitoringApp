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
    closeNav();
    closeRoomArchiveStatusForm();
    closeRoomOnDayForm();
    closeChartPopup()
    closeRoomStatusForm();
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

function showSpinner(){
    document.getElementById("spinner").style.display = "block";
    fadeOut( document.getElementById("right") , document.getElementById("middle"));
}
function hideSpinner(){
    document.getElementById("spinner").style.display = "none";
    fadeIn( document.getElementById("right"), document.getElementById("middle"));
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
    closeChartPopup()
    document.getElementById("roomStatusForm").style.display = "block";
}
function openRoomArchiveStatusForm(){
    closeNav();
    closeRoomStatusForm();
    closeRoomOnDayForm();
    closeChartPopup()
    document.getElementById("roomArchiveStatusForm").style.display = "block";
}
function openRoomOnDayForm(){
    closeNav();
    closeRoomStatusForm();
    closeRoomArchiveStatusForm();
    closeChartPopup()
    document.getElementById("roomStatusOnDay").style.display = "block";
}
function openChartPopup(){
    closeNav();
    closeRoomStatusForm();
    closeRoomArchiveStatusForm();
    closeRoomOnDayForm();
    document.getElementById("chartPopup").style.display = "block";
}
function openPopupRoomState(){
    closeNav();
    document.getElementById("popupRoomStateContainer").style.display = "block";
}
function closeRoomOnDayForm(){
    document.getElementById("roomStatusOnDay").style.display = "none";
}
function closePopupRoomState(){
    document.getElementById("popupRoomStateContainer").style.display = "none";
}
function closeChartPopup(){
    document.getElementById("container").innerHTML = "";
    document.getElementById("chartPopup").style.display = "none";
}
function closeRoomArchiveStatusForm(){
    document.getElementById("roomArchiveStatusForm").style.display = "none";
}
function closeRoomStatusForm(){
    document.getElementById("roomStatusForm").style.display = "none";
}




