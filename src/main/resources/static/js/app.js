
window.onload = function(){
    if(document.getElementById("myInput") != null){
      searchEmployee();
      }
    if(document.getElementById("send") !=null){
      addEmployeeSucces();
      }

    if(document.getElementById("cointeinerImage") !=null){
          loginPhoto();
          }
      if(document.getElementById("officeImage") !=null){
            startPhoto();
            }
      menuChooseButton();

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

function addEmployeeSucces() {
    let submit = document.getElementById("send");
    submit.addEventListener("submit", function(event){

       alert("Pracownik został dodany");
    })
}

function loginPhoto(){
    document.getElementById('cointeinerImage').style.backgroundImage = "url('../images/officeLogin.jpg')";
}

function startPhoto(){
    document.getElementById('officeImage').style.backgroundImage = "url('../images/office.jpg')";
}

function menuChooseButton(){
     let menuButtons = document.querySelectorAll(".leftmenu a");
     for(var	i	=	0;	i	<	menuButtons.length;	i++)	{
        menuButtons[i].addEventListener("mouseover",	function(event)	{
     					this.style.backgroundColor	=	"#ffb366";
     				});
     	menuButtons[i].addEventListener("mouseout",	function(event)	{
             			this.style.backgroundColor	=	"white";
             		});
     	}
}

