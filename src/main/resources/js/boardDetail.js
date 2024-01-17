const update = document.getElementById("update");
const del = document.getElementById("del");
const frm = document.querySelector("#frm");
console.log(update)

update.addEventListener("click", (e)=>{
    console.log("update")
    e.preventDefault();
    frm.submit();
})


del.addEventListener("click",(e)=>{
    console.log("delete")
    e.preventDefault();
    frm.setAttribute("action", "./delete");
    frm.setAttribute("method","POST");
    frm.submit();
})

