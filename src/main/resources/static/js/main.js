function handleSubmit() {
    const userResponse = confirm("작성 하시겠습니까?");
    return userResponse;
}

 var input = document.getElementById("month");
     var currentDate = new Date();
     var currentYear = currentDate.getFullYear();
     var currentMonth = currentDate.getMonth() + 1;
     input.value = currentYear + '-' + (currentMonth < 10 ? '0' : '') + currentMonth;
   
     var queryString = window.location.search;
     var urlParams = new URLSearchParams(queryString);
     var selectedMonth = urlParams.get("month");
     
     console.log(selectedMonth);
    
     if(selectedMonth){
        input.value = selectedMonth;
     }