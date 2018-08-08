<html>
<head>
<title>Configure Name</title>
	<link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<div id="add">

<p align="left">
<a href="AdminOptions.jsp"><img src="images/icons/home.jpg" width="50" height="50"></a></br></br>

<style>
.button{
	background-color:cornflowerblue;
	color:white;
}
.button:hover{
	background-color:green;
}

input[type=text] {
    width: 80%;
    padding: 12px 20px;
    margin: 10px 0;
    border: 1px solid #ccc;
    background-color: #FFFFFF;
    border-radius: 3px;
    font-size: 15px;
    color:black;
    
}

</style>
</p>
</div>
<body>



<form action="configureGame" method="post">
	<center>
<div>
    <label for="game mode"><b>Game Mode</b></label>
    <select name="gameMode" selected>
		  <option value="easy">easy</option>
		  <option value="medium">medium</option>
		  <option value="hard">hard</option>
	</select></br></br>

	<label for="key count"><b>Keys Count</b></label>
    <select name="keysCount" selected>
		  <option value="1">1</option>
		  <option value="2">2</option>
		  <option value="3">3</option>
		  <option value="4">4</option>
		  <option value="5">5</option>
		  <option value="6">6</option>
	</select></br></br>
	
	<label for="hall count"><b>Halls Count</b></label>
    <select name="hallsCount" selected>
		  <option value="4">4</option>
		  <option value="13">13</option>
		  <option value="40">40</option>
		  <option value="121">121</option>
	</select></br></br>
	
	<label for="question time"><b>Question Time</b></label>
    <select name="questionTime" selected>
		  <option value="30">30</option>
		  <option value="60">60</option>
		  <option value="90">90</option>
		  <option value="120">120</option>
	</select></br></br>
	
	<label for="game mode"><b>Game Time</b></label>
    <select name="gameTime" selected>
		  <option value="60">60</option>
		  <option value="120">120</option>
		  <option value="180">180</option>
		  <option value="240">240</option>
		  <option value="300">300</option>
	</select></br></br>

            <input type="submit" value="Submit" class="button"  >
            <input type="reset" value="Reset" class="button">

     
   
    
  

</div></center>
</form>

</body>

</html>