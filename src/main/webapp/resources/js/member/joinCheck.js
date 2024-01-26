console.log('join check')

const pw = document.getElementById("password");
const pwCheck = document.getElementById("passwordCheck");
const passwordResult = document.getElementById("passwordResult");
const passwordCheckResult = document.getElementById("passwordCheckResult");
const submitBtn = document.getElementById("submitButton");
const idResult = document.getElementById("idResult");

const uName = document.getElementById("name");
const userId = document.getElementById("userName");
const email = document.getElementById("email");
const phone = document.getElementById("phone");
const address = document.getElementById("address");


let p1=false; // password check
let p2=false; // passwordCheck check

userId.addEventListener('blur', function(){
    console.log("blur")
    fetch("./idCheck?userName="+userId.value , {
        method:"GET"})
        
    .then(response=>response.text())
    .then(response=>console.log(response.trim()))
    
    
});


pw.addEventListener('keyup',function(){
    
    tempPw = pw.value;
    if(tempPw.length>7){
        passwordResult.innerHTML="ok"
        p1=true;
    }else{
        passwordResult.innerHTML="8자리 이상 입력하세요";
        p1=false;
    }
    pwCheck.value = "";
    p2=false;
    passwordCheckResult.innerHTML="비밀번호가 일치 하지 않습니다.";
})

pwCheck.addEventListener('blur',function(){
    
    let check = pwCheck.value;
    if(check!=pw.value){
        passwordCheckResult.innerHTML="비밀번호가 일치 하지 않습니다.";
        p2=false;
    }else{
        passwordCheckResult.innerHTML="OK";
        p2=true;
    }
    
});




// submitBtn.addEventListener('click',function(e){
//     e.preventDefault();

//     if(p1&&p2){
//         console.log('OK');
//     }else{
//         console.log('GG');
//         e.preventDefault();
//     }
    
//     if(email.value==null){
//         alert("이메일을 입력하세요")
//     }
//     if(userId.value==null || idResult==0){
//         alert("아이디를 확인하세요")
//     }

// })








// submitBtn.addEventListener('click',function(e){
//     // e.preventDefault();
//     let flag = true;

//     if(pw.value != pwCheck.value || pw.legth < 7){       
//         flag=!flag         
//         return false;
//     }

//     console.log(flag);
//     if(flag){
//         alert('가입 완료');
//         return true;
//     }else{
//         alert('비밀번호를 확인하시오');
//         e.preventDefault();
//     }

// })




// jQurey

// let checks = {p1:false, p2:false}

// $('#submitBtn').click(function(){
//     for(p in checks){
//         console.log(p)
//     }
// })


// $('#userName').blur(function(){
    
    // let userName = document.getElementById("userName");
    // $.get("idCheck?userName"+$("#userName").val(), function(response){
    //     console.log(response);
    // })
    // $.ajax({
    //     url:"./idCheck",
    //     method:"GET",
    //     data:{
    //         userName:userName
    //     },
    //     success:function(r){

    //         console.log(r)
    //     },
    //     error:function(){
    //         console.log("아이디 검증 실패")
    //     }
    // });

// });

// $('#password').keyup(function(){
//     if($('#password').val()>7){
//         $('#passwordResult').html('OK');
//         checks.p1=true;
//     }else{
//         $('#passwordResult').html('8자 이상 입력하세요');
//         checks.p1=false;
//     }

    

// })

// $('#passwordCheck').blur(function(){

//     if($('#password').val() != $('#passwordCheck').val()){
//         $('#passwordCheckResult').html('비밀번호가 일치하지 않습니다.');
//         checks.p2=true;
//     }else{
//         $('#passwordCheckResult').html('OK');
//         checks.p2=false;
//     }

// })

