console.log("ready to load wishlist")


const addBtn = document.getElementById("add")
const productNum = document.getElementById("productNum")



addBtn.addEventListener('click', function(){
    console.log("click");
    console.log(productNum.value)
    fetch("/wishlist/add?productNum="+productNum.value,{
        method : "GET"})
        .then(response=>response.text())
        .then(response=>console.log(response.trim()))
    
        confirm("위시리스트로 이동");
});


// 전체선택 버튼 구현

//id = checkall
//class = checks

//JQuery
// id = #
// class = .




$('#checkAll').click(()=>{

    let chk = $('#checkAll').prop("checked");

    $('.checks').prop("checked", chk);

});

$('.checks').click(function(){
    let flag = true;

    $('.checks').each(function(idx, chk){

        if(!$('.checks').prop("checked")){
            flag =! flag;
            return false
        }
    });

    $('.checks').prop("checked", flag);

});

//삭제


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

    // deletewithJquery();
    eletwithFetch(nums);
    console.log(nums.length);
    
});

function deletwithFetch(nums){
    
    let param = "";
    nums.forEach(element => {
        param=param+"productNum"+element+"&";
    });

    fetch("./delete",{
        method:"POST",
        body:"productNum="+nums
    })
    .then(response => response.text())
    .then(response=>{
        console.log(response);
        $('#ajaxList').html(response.trim());
    })
}


function deletewithJquery(){

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
 
             $('ajaxList').html(result)
        },
        error:function(){
             alert('알수없는 에러 발생');
        }
     });

}

