window.onload=function(){
	var crossButon=document.getElementsByClassName("cross_button");
	var popUpWidow=document.getElementsByClassName("popups")[0];
	var loginPage=document.getElementById("loginpage_content");
	var loginButton=document.getElementById("login_button");
	
	
	
	
	function PopUps(){
		this.claseclosePopups=closePopups;
		this.closeLoginPage=closeLoginPage;
		this.openPopUp=openPopUp;
		this.openLoginPage=openLoginPage;
		
		function closePopups()
		{
			document.getElementById("login_form").reset();
			loginPage.style.display="none";
			popUpWidow.style.display="none";			
			
		}
		
		function openPopUp()
		{
			popUpWidow.style.display="block";
			popUpWidow.addEventListener('click',function(event)
			{
				if(event.target === popUpWidow)
				{
					closePopups();
				}
			})
		}
		
		function openLoginPage()
		{
			
			openPopUp();
			loginPage.style.display="block";
			
			
		}
		function closeLoginPage()
		{
			loginPage.style.display="none";
			closePopups();
			
		}
	}
	

	var popUps=new PopUps();
	loginButton.addEventListener('click', popUps.openLoginPage);
	
	
	for(let button of crossButon)
	{
		button.addEventListener('click',popUps.closeLoginPage)
	}
	
	
}


