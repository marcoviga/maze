Example input

	OOOOOOOOOO
	O    O   O
	O OO O O O
	O  O O O O
	O OO   O  
	O OOOOOOOO
	O        O
	OOOOOOOOOO
	
Starting point: (x=3, y=1)
 	
 	OOOOOOOOOO
	O    O   O
	O OO O O O
	O• O O O O
	O OO   O  
	O OOOOOOOO
	O        O
	OOOOOOOOOO
	
Desired output:
	
	OOOOOOOOOO
	O••••O•••O
	O•OO•O•O•O
	O• O•O•O•O
	O OO•••O••
	O OOOOOOOO
	O        O
	OOOOOOOOOO
	
Example of post payload:

{ 
"startX": 1,
"startY": 2,
"maze": [["O","O","O","O","O","O","O","O","O","O"],
	     ["O"," "," "," "," ","O"," "," "," ","O"],
	     ["O"," ","O","O"," ","O"," ","O"," ","O"],
	     ["O"," "," ","O"," ","O"," ","O"," ","O"],
	     ["O"," ","O","O"," "," "," ","O"," "," "],
	     ["O"," ","O","O","O","O","O","O","O","O"],
	     ["O"," "," "," "," "," "," ","O","O","O"],
	     ["O","O","O","O","O","O","O","O","O","O"]]
}