function handleSubmit() {
    const userResponse = confirm("삭제 하시겠습니까?");
    return userResponse;
}

function addForm() {
    const userResponse = confirm("등록 하시겠습니까?");
    return userResponse;
}

var currentDate = new Date();
var year = currentDate.getFullYear(); 
var month = currentDate.getMonth() + 1;

if (month < 10) {
    month = '0' + month;
}

var formattedDate = year + '-' + month;
document.getElementById("month").value = formattedDate;