console.log("agreement");

//js
// const checkAll = document.getElementById("checkAll");
// const checks = document.getElementsByClassName("checks");
// const btn = document.getElementById("btn");
// const req = document.getElementsByClassName("req");

// checkAll.addEventListener("click", ()=>{
//     let v = checkAll.getAttribute("checked");
//     console.log("CHECK : ", v);
//     v = checkAll.checked;
    
//     for(let check of checks){
//         check.checked=v;
//     }

// })

// for(let c of checks){
//     c.addEventListener("click", function(){
//         let flag=true;
//        for(let ch of checks){
//             if(!ch.checked){
//                 flag=!flag;
//                 break;
//             }
//        }

//        checkAll.checked=flag;

//     })
// }

// //----------------------------
// btn.addEventListener("click", function(e){
//     e.preventDefault();
    
//     let flag=true;

//     for(let r of req){
//         if(!r.checked){
//             flag=!flag;
//             break;
//         }
//     }

//     if(flag){
//         location.href="./join";
//     }else {
//         alert('필수 약관은 동의 해야 함');
//     }

// })



//jquery
$('#checkAll').click(()=>{
    let v = $("#checkAll").prop("checked");
    
    $('.checks').prop("checked", v);
});

$('.checks').click(function(){
    let flag=true;
    
    $('.checks').each(function(idx, c){
        
        if(!$(c).prop('checked')){
            flag=!flag;
            return false;
        }
    });

    $("#checkAll").prop("checked", flag);
})

$('#btn').click(function(e){
    e.preventDefault();
    
    let flag=true;

    $('.req').each(function(idx, r){
        if(!$(r).prop('checked')){
            flag=!flag;
            return false;
        }
    });

    if(flag){
        location.href="join";
    }else {
        alert('필수 약관 동의 필요');
    }


});

//삭제
$('#del').click(function(e){
    e.preventDefault();
    let nums =new Array;
    let checkElement = [];    
    $('.checks').each(function(idx, c){
        
        if($(c).prop('checked')){
            let result = $(c).val();
            console.log(result);
            nums.push(result);
            checkElement.push(c);
        }

    });

    console.log(nums.length);
   
   
    $.ajax({
       method:"post",
       url:"./delete",
       traditional:true, //배열을 전송할때 사용
       data:{
            productNum:nums
       },
       success:function(result){

            if(result.trim()>0){
              //1.  location.reload();
              //2.  
              checkElement.forEach((element)=>{
                $(element).parent().parent().remove();
                console.log(element)

              })            
            //   $('.checks').each(function(idx, c){
        
            //     if($(c).prop('checked')){       
                                       
            //     }
            // });      
        
            }
       },
       error:function(){
            alert('알수없는 에러 발생');
       }
    });
});





// let checkAll = document.getElementById("checkAll");
// let button = document.getElementsByClassName("checks");
// let join = document.getElementById("join")
// const req = document.getElementsByClassName("req")

// checkAll.addEventListener("click", ()=>{

//     let v = checkAll.checked;    
//     console.log("if밖", v);

//         for(let i = 0 ; i < button.length ; i++){
           
//             button[i].checked = v;
//         }
        
// });


// for(let c of button){
//     c.addEventListener("click", function(){
//         console.log(c)
//         if(this.checked != true ){
//             checkAll.checked = false;                    
//         } 
//         checkAll.checked = true; 
//     });
// };

// button.addEventListener("click",function(){
    
//     for(let c of button){
        
//         if(this.checked == false){
//             checkAll==false;
//             return;
//         }
//     }
//     checkAll.checked==true;
    
// });


// join.onclick = function(){
//     console.log("회원가입")

//     for(let i = 0; i< 3; i++){
//         console.log(button[i])
//         if(button[i].checked == false){            
//             alert("약관에 동의 하시오")
//             beack;
//         }
//     }    
//     location.href = "./join";
// };


// join.addEventListener("click", function(e){
//     e.preventDefault();
//     let flag = true;
//     for(let r of req){

//         if(!r.checked){
//             flag=!flag;
//             break;
//         }
//     }
//     if(flag){
//         location.href = "./join";
//     }else{
//         alert("필수약관동의");
//     }
// })


// for(let )


// jqurey

// $("#checkAll").click(()=>{
//     let v = $("checkAll").prop("checked");

//     $('.checks').prop("checked", v);
// });

// $('.checks').click(function(){
//     console.log($(this).prop('checked'))
// });


// $('.checks').click(function(){

//     let flag = true;

//     $('.checks').each(function(idx, c){
//         console.log(idx);
//         console.log($(c).prop('checked'));
//        if(idx==2){
//             console.log('continue')
//             return true;
//        }
//        console.log('hello')
//     });

// })

// $('.checks').click(function(){

//     let flag = true;

//     $('.checks').each(function(idx, c){
       
//         if(!$(c).prop('checked')){

//             flag=!flag;
//             return false;
//         }
       
//     });

//     $("#checkAll").prop("checked", flag);

// })

$('#join').click(function(e){
    e.preventDefault();
  
    let flag = true;

    $('.req').each(function(idx, r){
        if(!$(r).prop('checked')){
            flag=!flag;
            return false;
        }
    })

    if(flag){
        location.href = "./join";
    }else{
        alert("필수약관동의");
    }

})

