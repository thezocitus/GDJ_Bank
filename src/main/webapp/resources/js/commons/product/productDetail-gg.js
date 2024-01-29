console.log("product Detail")


const addBtn = document.getElementById("wishList");
const productNum = document.getElementById("productNum");
// const replyJumsu = document.getElementById("replyJumsu");
// const replyContents = document.getElementById("replyContents");
// const replyAddBtn = document.getElementById("replyAddBtn");
const replyList = document.getElementById("replyList");


const frm = document.getElementById("frm");
const up = document.getElementById("up");
const dele = document.getElementById("del");
const create = document.getElementById("create");
const more = document.getElementById("more")

// replyList.addEventListener("click", (e)=>{

//     if(e.target.getAttribute("id")=='more'){
        
//         p*1+1;
//     }

// });


// fetch("../reply/list?productNum="+productNum.value,{
//     method:"GET"
// }).then(response=>response.text())
// .then(function(response){
//     console.log(response.trim())
//     $("#replyList").html(response);
// })



addBtn.addEventListener('click', function(){
    console.log("click");
    console.log(productNum.value)
    fetch("/wishlist/add?productNum="+productNum.value,{
        method : "GET"})
        .then(response=>response.text())
        .then(response=>console.log(response.trim()))
    
        confirm("위시리스트로 이동");
});


// replyAddBtn.addEventListener('click', function(){
//     let form = formReply;
//     console.log(productNum.value);
//     form = new FormData(form) 
//     fetch("/reply/add",{
//         method : "POST",       
//         body : form
//     }).then(function(response){
//         return response.text();
//     })
//     .then(function(response){
//         console.log(response.trim())
//         $("#replyList").html(response);
//     })

    
// });


// ---------------------------------sam------------------------


//  replyList.addEventListener("click", (e)=>{
   
// 	if(e.target.getAttribute("id")=='more'){
// 		let p = e.target.getAttribute('data-replyList-page');
// 		fetch("../reply/list?productNum="+up.getAttribute("data-product-num")+"&page="+(p*1+1), {
// 			method:"GET"
// 		}).then(r=> r.text())
// 		  .then(r=>document.getElementById("replyList").innerHTML=r)

// 	}
   
//  })

function getReplyList(page, num){
    console.log(page);
    console.log(num);
	fetch("../reply/list?page="+page+"&productNum="+num, {
		method:"GET"
	})
	.then(r => r.json())
	.then(r => {
		more.setAttribute("data-replyList-page", r.pager.page*1+1);
		more.setAttribute("data-replyList-totalPage", r.pager.totalPage);
		r=r.datas;
		for(let i=0;i<r.length;i++){
			let tr = document.createElement("tr");

			let td = document.createElement("td");
			td.innerHTML=r[i].replyContents;
			tr.append(td);

			td = document.createElement("td");
			td.innerHTML=r[i].userName;
			tr.append(td);

			td = document.createElement("td");
			let d = new Date(r[i].replyDate);
			td.innerHTML=d.getFullYear()+"."+(d.getMonth()+1)+"."+d.getDate();
			tr.append(td);
			replyList.append(tr);
		}


	})
	;

}



more.addEventListener("click", ()=>{
   let p = more.getAttribute("data-replyList-page");//현재 페이지 번호
   let a = more.getAttribute("data-replyList-totalPage");//전체 페이지 번호
   
   p=p*1+1;

   if(p>a){
       alert('마지막 페이지 입니다');
   }
   more.setAttribute("data-replyList-page", p)

   fetch("../reply/list?productNum="+up.getAttribute("data-product-num")+"&page="+p, {
   method:"GET"
   })
   .then(r=> r.text())
     .then(r=>$("#replyList").append(r))
})

//replyAdd (Fetch 사용, JS)
const replyAddBtn = document.getElementById("replyAddBtn");

// fetch("../reply/list?productNum="+up.getAttribute("data-product-num"), {
// 	method:"GET"
// }).then(r=> r.text())
//   .then(r=>document.getElementById("replyList").innerHTML=r)

   
replyAddBtn.addEventListener("click", ()=>{

   const formReply = document.getElementById("formReply");
   let form = new FormData(formReply);

   fetch("/reply/add", {
       method:"POST",
       body:form
   })
   .then(r=>r.text())
   .then(r=>{
       document.getElementById("replyList").innerHTML=r
       formReply.reset();
       more.setAttribute("data-replyList-page", 1);
   })
})



    up.addEventListener("click", function(){
        frm.submit();
    });
    
    create.addEventListener("click", function(){
        frm.setAttribute("action","../account/add");
        frm.setAttribute("method","get");
        frm.submit();
        
    });

    dele.addEventListener("click", function(){
        let result = confirm("정말 삭제하시겠습니까?");
        if(result){
        frm.setAttribute("action","./delete");
        frm.setAttribute("method","post");
        frm.submit(); 		
        }
    });

    $("#wishList").click(function(){
       // fetch("../wishlist/add?productNum="+$("#up").attr("data-product-num"),{
       // 	method:"GET"
       // })
       // .then(response=>response.text())
       // .then(response=>{
       // 	console.log(response);
       // })
       let productNum = $("#up").attr("data-product-num");
       $.ajax({
           url:"../wishlist/add",
           method:"GET",
           data:{
               productNum:productNum
           },
           success:function(result){
               if(result==1){
                   let r=confirm("관심목록으로 이동");
                   if(r){
                       location.href="../wishlist/list"
                   }
               }else {
                   alert('등록 실패');
               }
               
           },
           error:function(){
               alert("관심상품 추가에 실패하였습니다");
           }
       });

   });