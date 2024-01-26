console.log("ready to load wishlist")



$("#add").click(function(){
    $("#deleteForm").attr("action", "../account/add")
    $("#deleteForm").submit();
});

$("#del").click(function(){

    let nums = [];
    let checkElement=[];
    $(".checks").each(function(idx, item){
        if($(item).prop("checked")){
           nums.push($(item).val());
           checkElement.push(item);
        }
    });

    // deleteWithJquery(nums);
    deleteWithFetch(nums);
    console.log(nums);

});
function deleteWithFetch(nums){
    // let param ="";
    // nums.forEach(element => {
    //     param=param+"productNum="+element+"&";
    // });

    let deleteForm = document.getElementById("deleteForm");

    let form = new FormData(deleteForm);

    fetch("./delete",{
        method:"POST",
        // headers:{
        //     "Content-type":"application/x-www-form-urlencoded"
        // },
        //body:"productNum="+nums
        body:form
    } )
    .then(response=> response.text())
    .then(response=>{
        console.log(response);
        $("#ajaxList").html(response);
    })
}

function deleteWithJquery(nums){

    let form = new FormData($("#deleteForm")[0]);

    $.ajax({
        method:"post",
        url:"./delete",

        cache:false,
        contentType:false,
        processData:false,
        data:form,
        success:function(result){
            //if(result.trim()>0){
                //1. location.reload();
                
                //2. Element들 삭제
                //    checkElement.forEach((element)=>{
                    //         $(element).parent().parent().parent().remove();
                    //    })
                    
                    
                    //}
            //3. DB에서 조회를 다시 해서 html()
            $("#ajaxList").html(result.trim());
        },
        error:function(){
            alert('알수없는 에러 발생 관리자에 문의');
        }
    })

}

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


// const addBtn = document.getElementById("add")
// const productNum = document.getElementById("productNum")




// // addBtn.addEventListener('click', function(){
// //     console.log("click");
// //     console.log(productNum.value)
// //     fetch("/wishlist/add?productNum="+productNum.value,{
// //         method : "GET"})
// //         .then(response=>response.text())
// //         .then(response=>console.log(response.trim()))
    
// //         confirm("위시리스트로 이동");
// // });

// // 전체선택 버튼 구현

// //id = checkall
// //class = checks

// //JQuery
// // id = #
// // class = .



// $('#checkAll').click(()=>{
//     let v = $("#checkAll").prop("checked");
    
//     $('.checks').prop("checked", v);
// });

// $('.checks').click(function(){
//     let flag=true;
    
//     $('.checks').each(function(idx, c){
        
//         if(!$(c).prop('checked')){
//             flag=!flag;
//             return false;
//         }
//     });

//     $("#checkAll").prop("checked", flag);
// })

// //삭제


// //삭제
// $('#del').click(function(e){
//     e.preventDefault();
//     let nums =new Array;
//     let checkElement = [];    
//     $('.checks').each(function(idx, c){
        
//         if($(c).prop('checked')){
//             let result = $(c).val();
//             console.log(result);
//             nums.push(result);
//             checkElement.push(c);
//         }

//     });

//     // deletewithJquery();
//     deletwithFetch(nums);
//     console.log(nums.length);
    
// });

// function deletwithFetch(nums){
    
//     // let param = "";
//     // nums.forEach(element => {
//     //     param=param+"productNum"+element+"&";
//     // });

//     // let deleteForm = document.getElementById("deleteForm");
    
//     // let form = new FormData(deleteForm);//java script 

//     fetch("./delete",{
//         method:"POST",
//         body:form
//     })
//     .then(response => response.text())
//     .then(response=>{
//         console.log(response);
//         $('#ajaxList').html(response.trim());
//     })
// }


// function deletewithJquery(){

//     $.ajax({
//         method:"post",
//         url:"./delete",
//         traditional:true, //배열을 전송할때 사용
//         data:{
//              productNum:nums
//         },
//         success:function(result){
 
//              if(result.trim()>0){
//                //1.  location.reload();
//                //2.  
//                checkElement.forEach((element)=>{
//                  $(element).parent().parent().remove();
//                  console.log(element)
 
//                })            
//              //   $('.checks').each(function(idx, c){
         
//              //     if($(c).prop('checked')){       
                                        
//              //     }
//              // });              
//              }
 
//              $('ajaxList').html(result)
//         },
//         error:function(){
//              alert('알수없는 에러 발생');
//         }
//      });

// }

