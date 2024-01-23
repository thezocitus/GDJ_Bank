let checkAll = document.getElementById("checkAll");
let button = document.getElementsByClassName("checks");
let join = document.getElementById("join")
const req = document.getElementsByClassName("req")

checkAll.addEventListener("click", ()=>{

    let v = checkAll.checked;    
    console.log("if밖", v);

        for(let i = 0 ; i < button.length ; i++){
           
            button[i].checked = v;
        }
        
    });


for(let c of button){
    c.addEventListener("click", function(){
        console.log(c)
        if(this.checked != true ){
            checkAll.checked = false;                    
        } 
        checkAll.checked = true; 
    })
};

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