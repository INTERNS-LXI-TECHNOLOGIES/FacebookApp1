function displayOptions(){
	var j=0;
	var e=document.getElementById('select-input');
	var j=e.options[e.selectedIndex].text;
	console.log(j);
	var i;
	for (i = 1; i <= j; i++) { 
		var option="option"+i;
    	document.getElementById(option).style.display='block';
    	console.log(document.getElementById(option));
}
}
