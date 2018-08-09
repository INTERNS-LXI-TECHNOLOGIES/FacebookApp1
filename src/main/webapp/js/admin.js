function displayOptions(){
	var j=0;
	var e=document.getElementById('select-input');
	var j=e.options[e.selectedIndex].text;
	console.log(j);
	var i;
	for (i = 1; i <= j; i++) { 
		var option="option"+i;
    	document.getElementById(option).style.display='block';
    	document.getElementById(option).required=true;
    	//console.log(document.getElementById(option));
    	console.log("i="+i+document.getElementById(option).required);
	}
	for (j=i; j <= 8; j++) { 
		var option="option"+j;
    	document.getElementById(option).style.display='none';
    	document.getElementById(option).required=false;
    	//console.log(document.getElementById(option));
    	console.log("j="+j+document.getElementById(option).required);
	}
}
