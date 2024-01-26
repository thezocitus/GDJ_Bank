console.log("FileManager");

// <div class="input-group">
// <input class="form-control" type="file" name="attachs"></input>
// <span class="input-group-text text-danger del">X</span>
// </div> 


const filelist = document.getElementById("filelist");
const fileadd = document.getElementById("fileAdd");
const attachs = document.getElementsByName("attachs");
const del = document.getElementsByClassName("del");
let count = 0;
let max = 5;





// filelist.addEventListener("click", (e)=>{
//     console.log(e);
//     console.log(e.target);
//     console.log(e.currentTarget);
//     if(e.target.classList.contains('del')){
//         console.log(e.target.parentNode);
//         // e.target.parentNode.remove();


//     }
//     count--;
// })

// let idx=0;

// fileadd.addEventListener("click", function(){
//     idx++
//     //id추가
//     id="file"+idx


//     if(max<=count){
//         alert("첨부파일을 최대 5개");
//         return;
//     }
//     count++
//     let divfile = document.createElement("div"); 
//         divfile.setAttribute("class", "input-group");
//         divfile.setAttribute("data-file-id", ididx)
//     let inputFile = document.createElement("input");
//         inputFile.setAttribute("class","form-control");
//         inputFile.setAttribute("type","file");
//         inputFile.setAttribute("name","attachs");
//     let spanFile = document.createElement("span");
//         spanFile.setAttribute("class","input-group-text text-danger del");     
//         spanFile.setAttribute("data-file-id", id);   
//     let spanText = document.createTextNode("X");
//         spanFile.appendChild(spanText);

//         divfile.appendChild(inputFile);
//         divfile.appendChild(spanFile);    
//         filelist.appendChild(divfile);

//     // if(count<5){

//     //     divfile.appendChild(inputFile);
//     //     divfile.appendChild(spanFile);    
//     //     filelist.appendChild(divfile);
//     //     count++;
//     // }else{
//     //     alert("첨부파일을 최대 5개")
//     // }

// })

// --------- jQuery




// let delBtn;
// let index = 0;
// $("#fileAdd").click(function() {
//     console.log(this)
    

//     let element = `<div class="input-group ">
//                    <input class="form-control" type="file" name="attachs"></input>
//                    <span class="input-group-text text-danger del" id="${index}" type="button">X</span>
//                    </div>`
    
//     if(count<5){
//         $('#filelist').append(element);    
//         delBtn = $('#filelist').find('.del')
//     count++
//     } else {
//         alert("첨부파일을 최대 5개")
//     } 
//     index++;
//     delBtn.click(function() {
//     console.log(this)
//     console("파일 지우기" + this)
// })   
// })

 count = $("#filelist").attr("data-file-count");
 max = $("#filelist").attr("data-file-max");

 let element = `<div class="input-group">
 <input class="form-control" type="file" name="attachs"></input>
 <span class="input-group-text text-danger del" type="button">X</span>
 </div>`
 

$("#fileAdd").click(function() {
  
    if(count<max){
        count++
        $('#filelist').append(element);            
    } else {
        alert("첨부파일을 최대 5개")
    } 
  
    
    console.log(count)
    
    $("#filelist").on("click",".del", function(){
        $(this).parent().remove();
        count--
    }) 
})
