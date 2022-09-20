(function() {

    let myArray = ['foo', 'bar']
    console.log(myArray.join())

    function Student(name) {
        this.name = name;
        this.introduce = () => {
            console.log(`이름은 : ${this.name}`);
        }
    }

    let userId = document.getElementById("userId");
    let userPw = document.getElementById("userPw");
    let userPwCk = document.getElementById("userPwCk");
    let userNm = document.getElementById("userNm");

    let invalidId = document.getElementById("invalid-userId");
    let invalidPw = document.getElementById("invalid-userPw");
    let invalidPwCk = document.getElementById("invalid-userPwCk");
    let invalidNm = document.getElementById("invalid-userNm");

    const pwCheck = /^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[$@$!%*#?&]).{8,60}$/;
    const idCheck = /^[a-z0-9]{5,20}$/;
    const spaceCheck = /\s/g;
    const specialCheck = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;

    userId.addEventListener("change", () => {
        if(userId.value.match(spaceCheck)) {
            invalidId.classList.remove('valid');
            invalidId.innerHTML = "아이디에 공백을 제거하세요.";
        } else if(!userId.value.match(idCheck) || userId.value === ""){
            invalidId.classList.remove('valid');
            invalidId.innerHTML = "아이디는 영문소문자, 숫자로 입력하세요.(5~20자리)";
        } else {
            invalidId.classList.add('valid');
            invalidId.innerHTML = "사용가능한 아이디입니다.";
        }
    });

    userPw.addEventListener("change", () => {
        if(userPw.value.match(spaceCheck)) {
            invalidPw.classList.remove('valid');
            invalidPw.innerHTML = "비밀번호에 공백을 제거하세요.";
        } else if(!userPw.value.match(pwCheck) || userPw.value === "") {
            invalidPw.classList.remove('valid');
            invalidPw.innerHTML = "비밀번호는 영문, 숫자, 특수문자로 입력하세요.(8~60자리)";
        } else {
            invalidPw.classList.add('valid');
            invalidPw.innerHTML = "사용가능한 비밀번호입니다";
        }
    });

    userPwCk.addEventListener("change", () => {
        if(userPwCk.value.match(spaceCheck)) {
            invalidPwCk.classList.remove('valid');
            invalidPwCk.innerHTML = "비밀번호에 공백을 제거하세요.";
        } else if(userPw.value !== userPwCk.value) {
            invalidPwCk.classList.remove('valid');
            invalidPwCk.innerHTML = "비밀번호가 일치하지않습니다.";
        } else {
            invalidPwCk.classList.add('valid');
            invalidPwCk.innerHTML = "비밀번호가 일치합니다.";
        }
    });

    userNm.addEventListener("change", () => {
        if(userNm.value.match(spaceCheck)) {
            invalidNm.classList.remove('valid');
            invalidNm.innerHTML = "이름에 공백을 제거하세요.";
        } else if(userNm.value.length <= 1 || userNm.value.length >= 21) {
            invalidNm.classList.remove('valid');
            invalidNm.innerHTML = "이름은 2~20자리로 입력하세요.";
        } else if(userNm.value.match(specialCheck)) {
            invalidNm.classList.remove('valid');
            invalidNm.innerHTML = "이름에 특수문자를 제거하세요.";
        } else {
            invalidNm.classList.add('valid');
            invalidNm.innerHTML = "사용가능한 이름입니다.";
        }
    });

    document.getElementById("insertUser").addEventListener("click", () => {
        if(invalidId.classList.contains('valid') && invalidPw.classList.contains('valid') && invalidNm.classList.contains('valid')) {
            insertUser();
        }
    });

}());

function insertUser() {
    let userInfo = {
        userId : document.getElementById("userId").value,
        userPw : document.getElementById("userPw").value,
        userNm : document.getElementById("userNm").value,
    }
    fetch("user/insertUser", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body: JSON.stringify(userInfo),
    }).then(res => console.log(res));
}
