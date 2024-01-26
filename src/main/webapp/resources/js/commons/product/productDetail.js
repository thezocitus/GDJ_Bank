console.log("product Detail")


const addBtn = document.getElementById("add");
const productNum = document.getElementById("productNum");
const replyJumsu = document.getElementById("replyJumsu");
const replyContents = document.getElementById("replyContents");
const replyAddBtn = document.getElementById("replyAddBtn");
const replyList = document.getElementById("replyList");


replyList.addEventListener("click", (e)=>{

    if(e.target.getAttribute("id")=='more'){
        
        alert(p*1+1)
    }

});


fetch("../reply/list?productNum="+productNum.value,{
    method:"GET"
}).then(response=>response.text())
.then(function(response){
    console.log(response.trim())
    $("#replyList").html(response);
})



addBtn.addEventListener('click', function(){
    console.log("click");
    console.log(productNum.value)
    fetch("/wishlist/add?productNum="+productNum.value,{
        method : "GET"})
        .then(response=>response.text())
        .then(response=>console.log(response.trim()))
    
        confirm("위시리스트로 이동");
});


replyAddBtn.addEventListener('click', function(){
    let form = formReply;
    console.log(productNum.value);
    form = new FormData(form) 
    fetch("/reply/add",{
        method : "POST",       
        body : form
    }).then(function(response){
        return response.text();
    })
    .then(function(response){
        console.log(response.trim())
        $("#replyList").html(response);
    })

    
});




