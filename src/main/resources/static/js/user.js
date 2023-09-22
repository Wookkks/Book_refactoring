let index = {

    init: function () {
        $("#btn-save").on("click", ()=>{
            this.save();
        });

    },

    save: function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            name: $("#name").val(),
            phoneNumber: $("#phoneNumber").val(),
            birth: $("#birth").val(),

        };

        $.ajax({
            // 회원가입 수행 요청
            type: "POST",
            url: "/user/join",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp){
            if(resp.status === 500) {
                alert("회원가입에 실패하였습니다. 중복된 아이디 입니다.")
            } else {
                alert("회원가입이 완료되었습니다.")
            }
            location.href = "/user/main";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
}

index.init();