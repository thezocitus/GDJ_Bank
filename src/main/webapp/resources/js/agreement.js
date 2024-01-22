let checkAll = document.getElementById("checkAll");
let button = document.getElementsByClassName("checks");

checkAll.addEventListener("click", ()=>{

    let v = checkAll.checked;    
    console.log("if밖", v);

        for(let i = 0 ; i < button.length ; i++){
            console.log("for안 "+ i);
            button[i].checked = v;
        }
        
    });
    
    for(let c of button){
        c.addEventListener("click", function(){
            console.log(c)
            if(this.checked != true ){
                checkAll.checked = false;
                
            } 

        })
    };




// for(let )


// jqurey

// $("#checkAll").click(()=>{
//     let v = $("checkAll").prop("checked");

//     $('.checks').prop("checked", v);
// });

// $('.checks').click(function(){
//     console.log($(this).prop('checked'))
// });
