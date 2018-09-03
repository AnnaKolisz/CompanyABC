
window.onload = function(){
      searchEmployee();

};

function searchEmployee() {
      let input = document.getElementById("myInput");
      input.addEventListener("keyup", function(event){
        let filter = input.value.toLowerCase();
        let table = document.getElementById("myTable");
        let trs = table.getElementsByTagName("tr");
        let row;
        for(let i = 0; i < trs.length; i++) {
             row = trs[i].getElementsByTagName("td");
           for(let j = 0; j < 4; j++){
                if (row[j].innerHTML.toLowerCase().indexOf(filter) > - 1) {
                    trs[i].style.display = "";
                    break;
                } else {
                    trs[i].style.display = "none";
                }
           }
        }
    });
};



