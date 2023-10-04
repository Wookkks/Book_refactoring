function handleSubmit() {
    const userResponse = confirm("삭제 하시겠습니까?");
    return userResponse;
}

var currentDate = new Date();
var year = currentDate.getFullYear(); // 연도 가져오기
var month = currentDate.getMonth() + 1; // 월(0부터 시작하므로 1을 더함)
var day = currentDate.getDate(); // 일 가져오기
if (month < 10) {
    month = '0' + month;
}
if (day < 10) {
    day = '0' + day;
}
var formattedDate = year + '-' + month + '-' + day;
document.getElementById("date").value = formattedDate;