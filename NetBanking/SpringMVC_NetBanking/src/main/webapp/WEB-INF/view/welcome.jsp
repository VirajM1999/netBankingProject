

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome Page</title>
<Style>
* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
}

body {
	position: relative;
}

.main_image_div {
	height: 400px;
	width: 99%;
	position: relative;
	margin-top: 10px;
	margin: auto;
	background-image: url(../images/image3.jpg);
	box-shadow: 4px 45px 93px 16px;
	background-size: cover;
	background-repeat: no-repeat;
	padding: 94px 0px 0px 175px;
	border-radius: 50px;
	border-bottom-right-radius: 0px;
}

#welcome_page_content {
	height: 300px;
	width: 450px;
	color: white;
}

#welcome_page_content>h1 {
	font-size: 55px;
	margin-bottom: 30px;
}

#welcome_page_content button {
	font-size: 18px;
	font-weight: bolder;
	margin-bottom: 30px;
	padding: 5px;
	height: 40px;
	width: 120px;
	border-radius: 6px;
	border: none;
	display: inline-block;
	color: white;
}

#register_button {
	background-color: #46a0b3;
	margin-left: 30px;
}

#login_button {
	background-color: #eb4034;
}

#welcome_page_content button:hover {
	heght: 45px;
	width: 125;
	font-size: 19px;
	color: #eb4034;
	background-color: white;
}

.logoImage {
	float: left;
	height: 50px;
	width: 100px;
}

.logText {
	margin-top: 3px;
	float: left;
	font-size: 22px;
	text-align: center;
	color: antiquewhite;
}

.logText>p {
	font-weight: bolder;
}

.mgs {
	font-weight: bolder;
	color: antiquewhite;
	font-size: 35px;
}

.clear_div {
	clear: both;
}

.imagelogo {
	margin-top: 10px;
	margin-bottom: 20px;
}

.popups {
	height: 100%;
	width: 100%;
	background-color: rgba(0, 0, 0, 0.9);
	position: fixed;
	left: 0;
	top: 0;
	display: none;
}

#main_div {
	width: 100vw;
	height: 100vh;	
	position: relative;
}

#loginpage_content {
	height: 400px;
	width: 400px;	
	text-align: center;	
	background: white;
	display: none;	
	position: absolute;
	inset: 0px;
	margin: auto;
	color: #03AED2;
}

#loginpage_content>form>label {
	color: black;
	display: block;
	text-align: left;
	margin-left: 55px;
	margin-bottom: 5px;
	margin-top: 10px;
	font-size: 24px;
	font-weight: bolder;
	/* color:white; */
	color: #0687a1;
}

#loginpage_content>h1 {
	font-size: 55px;
	margin-bottom: 30px;
	color: black
}

.inputFiled {
	display: block;
	height: 30px;
	width: 300px;
	margin: auto;
	border: none;
	border-radius: 5px;
	background-color: #c7babafb;
	text-indent: 5px;
}

.button {
	font-size: 18px;
	font-weight: bolder;
	padding: 5px;
	border-radius: 6px;
	border: none;
	display: block;
	background-color: #eb4034;
	height: 30px;
	width: 300px;
	margin-top: 15px;
	color: white;
}

#loginpage_content>#register {
	background-color: #00e1e7;
}

#reset_button {
	background-color: #0687a1;
}

#registerLink {
	/* color:white; */
	color: #03AED2;
	font-weight: bolder;
}

.logoImage {
	float: left;
	height: 50px;
	width: 100px;
}

.logText {
	margin-top: 3px;
	float: left;
	font-size: 22px;
	text-align: center;
	color: antiquewhite;
}

.logText>p {
	font-weight: bolder;
}

.mgs {
	font-weight: bolder;
	color: antiquewhite;
	font-size: 35px;
}

.clear_div {
	clear: both;
}

.imagelogo {
	padding-top: 10px;
	padding-bottom: 10px;
}

#error_message {
	color: red;
	margin-top: 10px;
}
.cross_button
{
	display:black;
	height:25px;
	width:25px;
	float:right;
	color:black;
/* 	border:none; */
	text-align:center;
	font-size: 18px;
	border:none;
	border-radius: inherit;
	
}
.cross_button:hover
{
	color:white;
	background-color:red;
	
} 

</Style>
<script type="text/javascript" src="script/main.js"></script>
</head>
<body style="background-color: #03AED2">
	<div class="imagelogo">
		<img src="images/banklogo.png" alt="bank logo" class="logoImage">
		<div class="logText">
			<p class="mgs">MGS BANKING</p>

		</div>
		<div class="clear_div"></div>
	</div>
	<div class="main_image_div">
		<div id="welcome_page_content">

			<h1>Welcome To NetBanking</h1>
			<a href="loginpage"><button id="login_button">User Login</button></a>
			<!-- <button id="login_button">User Login</button> -->

			<a href="registerpage"><button id="register_button">Register</button></a>

		</div>

	</div>

	<%-- <div class="popups">
		<div id="loginpage_content">
			<button class="cross_button">&#10006;</button>
			<h1>Login</h1>
			<form action="login" method="post" id="login_form">
				<label for="loginid">Login Id:</label> <input type="text"
					name="loginId" id="loginid" class="inputFiled"
					placeholder="Loginid"> <label for="password">Password:</label>

				<input type="password" name="password" id="password"
					class="inputFiled" placeholder="Password">
				<c:if test="${isfaild}">
					<p id="error_message">${message}</p>

				</c:if>

				<input type="submit" value="Login" class="button inputFiled">
				<input type="reset" value="Reset" id="reset_button"
					class="button inputFiled">
			</form>
			<br>

			<p>
				if not registered Please <a href="registerpage">Register</a>
			</p>



		</div>
	</div>
 --%>
</body>
</html>