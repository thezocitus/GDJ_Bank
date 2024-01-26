let btn = document.getElementById("btn");
let btn2 = document.getElementById("btn2");

btn2.addEventListener("click", function(){

    let t = document.getElementById("title").vaule;
    let c = document.getElementById("contents").vaule;
    
    fetch("/notice/add",{
        method:"POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:"boardName="+t+"&boardContents"+c
    }).then(response => response.text())
    .then()


});



btn.addEventListener("click", function(){
    console.log("Ajax 시작");

    fetch("/notice/list",{
        method:"GET" 
        // headers:{}, body:
    }).then(response=>response.text())
    .then((res)=>{
        document.getElementById("result").innerHTML=res;
    });    
 
    console.log("Ajax 끝");

});


































// //js

// const b1 = document.getElementById("b1");
// const b2 = bocument.quertSelector("#b2");



// b1.addEventListener("click", ()=>{


// })
// let v = b1.innerHTML;
// b1.innerHTML = "test";

// b1.속성명
// b2.getAttrobute("속성명");
// b1.setAttribute("속성명", 값);



// //jQuery
// //$("선택자").action()
// $("#b1").click(function(){

// });

// $("#b2").on("click", ()=>{

// });

// $("#b1").html();//text()
// $("#b1").html("test");

// $("#b1").attr("속성명");
// $("#b1").attr("속성명", 값);



// $("#b1").prop("속성명");
// $("#b1").prop("속성명", 값);


// $("#b1").val();
// $("#b1").val("값");





