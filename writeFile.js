function write(string, context, size)
{
	for(let i=0, h=0, w=0;i<string.length;i++,w++)
	{
		if(string[i]=="/")
			h++,w=0;
		if(string[i]=="/")
			i++;
		alphabet(string[i],w*6,h*9, context, size);
	}
}
function alphabet(letter, posX, posY, context, size)
{
	switch(letter)
	{
		case "A":
			for(let i=2;i<7;i++) //The Letter A
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2;i<7;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+4)* size, size, size);
			context.fillRect((posX+2)* size, (posY+2)* size, size, size);
			context.fillRect((posX+4)* size, (posY+2)* size, size, size);	
		break;
  
		case "B":
			for(let i=1;i<7;i++) //The Letter B
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+3)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
			for(let i=4;i<6;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
			context.fillRect((posX+5)* size, (posY+2)* size, size, size);
		break;
	  
		case "C":
			for(let i=2;i<6;i++) //The Letter C
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
			context.fillRect((posX+5)* size, (posY+5)* size, size, size);
			context.fillRect((posX+5)* size, (posY+2)* size, size, size);
		break;
		  
		case "D":
			for(let i=2;i<6;i++) //The Letter D
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=1;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=1;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
			for(let i=2;i<6;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
		break;
		
		case "E":
			for(let i=1;i<7;i++) //The Letter E
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2;i<6;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+3)* size, size, size);
			for(let i=2;i<6;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
		break;
		
		case "F":
			for(let i=1;i<7;i++) //The Letter F
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2;i<6;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
					context.fillRect((posX+i)* size, (posY+3)* size, size, size);
		break;
		
		case "G":
			for(let i=2;i<6;i++)//The Letter G
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
			for(let i=3;i<6;i++)
				context.fillRect((posX+i)* size, (posY+4)* size, size, size);
			context.fillRect((posX+5)* size, (posY+5)* size, size, size);
			context.fillRect((posX+5)* size, (posY+2)* size, size, size);
		break;
		 
		case "H":
			for(let i=2;i<5;i++) //The Letter H
				context.fillRect((posX+i)* size, (posY+3)* size, size, size);
			for(let i=1;i<7;i++)
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=1;i<7;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
		break;
		
		case "I":
			for(let i=1;i<6;i++) //The Letter I
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=1;i<6;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
			for(let i=2;i<7;i++)
				context.fillRect((posX+3)* size, (posY+i)* size, size, size);
		break;
		
		case "J":
			for(let i=1;i<6;i++) //The Letter J
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=1;i<4;i++) 
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
			for(let i=2;i<7;i++)
				context.fillRect((posX+3)* size, (posY+i)* size, size, size);
			for(let i=4;i<6;i++)
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			context.fillRect((posX+2)* size, (posY+6)* size, size, size);
		break;
		 
		case "K":
			for(let i=1;i<7;i++)//The Letter K
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let k=0;k<2;k++)
				for(let j=2+k, i=4;j<5+k;j++,i++)
					context.fillRect((posX+j)* size, (posY+i)* size, size, size);
			for(let k=0;k<2;k++)
				for(let j=3+k, i=2;j<5+k;j++,i--)
					context.fillRect((posX+j)* size, (posY+i)* size, size, size);
			context.fillRect((posX+2)* size, (posY+3)* size, size, size);
		break;
			
		case "L":
			for(let i=1;i<6;i++) //The Letter L
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
			for(let i=1;i<6;i++)
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
		break;
		
		case "M":
			context.fillRect((posX+2)* size, (posY+2)* size, size, size); //The Letter M
			context.fillRect((posX+4)* size, (posY+2)* size, size, size);
			context.fillRect((posX+3)* size, (posY+3)* size, size, size);
			for(let i=1;i<7;i++)
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=1;i<7;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
		break;
		
		case "N":
			for(let i=1;i<7;i++)//The Letter N
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2, j=2;i<5;i++,j++)
				context.fillRect((posX+j)* size, (posY+i)* size, size, size);
			for(let i=1;i<7;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
		break;
		 
		case "O":
			for(let i=2;i<6;i++) //The Letter O
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
			for(let i=2;i<6;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
		break;
		 
		case "P":
			for(let i=1;i<7;i++)//The Letter P
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+4)* size, size, size);
			for(let i=2;i<4;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
		break;
		 
		case "Q":
			for(let i=2;i<6;i++) //The Letter Q
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<4;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
			for(let j=3,i=4;j<6;i++,j++)
				context.fillRect((posX+j)* size, (posY+i)* size, size, size);
		break;
		
		case "R":
			for(let i=1;i<7;i++)//The Letter R
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1 )* size, size, size);
			for(let k=0;k<2;k++)
				for(let j=2+k, i=4;j<5+k;j++,i++)
					context.fillRect((posX+j)* size, (posY+i)* size, size, size);
			context.fillRect((posX+4)* size, (posY+3 )* size, size, size);
			context.fillRect((posX+5)* size, (posY+3 )* size, size, size);
			context.fillRect((posX+5)* size, (posY+2 )* size, size, size);
		break;
		 
		case "S":
			context.fillRect((posX+1)* size, (posY+2 )* size, size, size); //The Letter S
			for(let i=1;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6 )* size, size, size);
			for(let i=2;i<6;i++)
				context.fillRect((posX+i)* size, (posY+1 )* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+3 )* size, size, size);
			for(let i=4;i<6;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
		break;
			
		case "T":
			for(let i=1;i<6;i++) //The Letter T
				context.fillRect((posX+i)* size, (posY+1 )* size, size, size);
			for(let i=2;i<7;i++)
				context.fillRect((posX+3)* size, (posY+i)* size, size, size);
		break;
		 
		case "U":
			for(let i=1;i<6;i++) //The Letter U
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6 )* size, size, size);
			for(let i=1;i<6;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
		break;
		 
		case "V":
			context.fillRect((posX+2)* size, (posY+5 )* size, size, size); //The Letter V
			context.fillRect((posX+4)* size, (posY+5 )* size, size, size);
			context.fillRect((posX+3)* size, (posY+6 )* size, size, size);
			for(let i=1;i<5;i++)
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=1;i<5;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
		break;
		
		case "W":
			for(let i=1;i<6;i++) //The Letter W
				context.fillRect((posX+1)* size, (posY+i)* size, size, size);
			for(let i=1;i<6;i++)
				context.fillRect((posX+5)* size, (posY+i)* size, size, size);
			for(let i=4;i<6;i++)
			context.fillRect((posX+3)* size, (posY+i)* size, size, size);
			context.fillRect((posX+2)* size, (posY+6 )* size, size, size);
			context.fillRect((posX+4)* size, (posY+6 )* size, size, size);
		break;
			
		case "X":
			for(let k=0;k<2;k++) //The Letter X
				for(let j=3+k, i=5;i<7;j++,i++)
					context.fillRect((posX+j)* size, (posY+i)* size, size, size);
			for(let k=0;k<2;k++)
				for(let j=1+k, i=6;j<3+k;j++,i--)
					context.fillRect((posX+j)* size, (posY+i)* size, size, size);
			for(let k=0;k<2;k++)
				for(let j=1+k, i=2;j<3+k;j++,i++)
					context.fillRect((posX+j)* size, (posY+i)* size, size, size);
			for(let k=0;k<2;k++)
				for(let j=3+k, i=3;i>1;j++,i--)
					context.fillRect((posX+j)* size, (posY+i)* size, size, size);
			context.fillRect((posX+1)* size, (posY+1 )* size, size, size);
			context.fillRect((posX+5)* size, (posY+1 )* size, size, size);
			context.fillRect((posX+3)* size, (posY+4 )* size, size, size);
		break;
		  
		case "Y":
			for(let i=1;i<3;i++) //The Letter Y
				context.fillRect((posX+1)* size,  (posY+i)* size, size, size);
			for(let i=1;i<3;i++)
				context.fillRect((posX+5)* size, (posY+ i)* size, size, size);
			context.fillRect((posX+2)* size,  (posY+3)* size, size, size);
			context.fillRect((posX+4)* size, (posY+ 3)* size, size, size);
			for(let i=4;i<7;i++)
				context.fillRect((posX+3)* size,  (posY+i)* size, size, size);
		break;
		
		case "Z":
			for(let i=1;i<6;i++) //The Letter Z
				context.fillRect((posX+i)* size, (posY+1 )* size, size, size);
			for(let i=1;i<6;i++)
				context.fillRect((posX+i)* size, (posY+6 )* size, size, size);
			for(let i=2,j=4;i<6;i++,j--)
				context.fillRect((posX+j)* size, (posY+i)* size, size, size);
		break;
	 
		case "!":
			for(let i=1;i<5;i++)//The Letter !
				context.fillRect((posX+3)* size, (posY+ i)* size, size, size);
			context.fillRect((posX+3)* size,  (posY+6)* size, size, size);
		break;	
	
		case "?":
			for(let i=2;i<5;i++)//The Letter ?
				context.fillRect((posX+i)* size, (posY+ 1)* size, size, size);
			for(let i=5, j=2;j<5;i--,j++)
				context.fillRect((posX+i)* size, (posY+j)* size, size, size);
			context.fillRect((posX+3)* size,  (posY+6)* size, size, size);
			context.fillRect((posX+1)* size,  (posY+2)* size, size, size);
		break;
					
		case "(":			
			for(let i=2;i<6;i++)
				context.fillRect((posX+2)* size, (posY+ i)* size, size, size);
			for(let i=1;i<3;i++)
				context.fillRect((posX+3)* size, (posY+ i)* size, size, size);
			for(let i=5;i<7;i++)
				context.fillRect((posX+3)* size, (posY+ i)* size, size, size);
			context.fillRect((posX+4)* size, (posY+ 1)* size, size, size);
			context.fillRect((posX+4)* size, (posY+ 6)* size, size, size);
		break;
		
		case ")":
			for(let i=2;i<6;i++)
				context.fillRect((posX+4)* size, (posY+ i)* size, size, size);
			for(let i=1;i<3;i++)
				context.fillRect((posX+3)* size, (posY+ i)* size, size, size);
			for(let i=5;i<7;i++)
				context.fillRect((posX+3)* size, (posY+ i)* size, size, size);
			context.fillRect((posX+2)* size, (posY+ 1)* size, size, size);
			context.fillRect((posX+2)* size, (posY+ 6)* size, size, size);
		break;
			
		case "0":
			for(let i=2;i<6;i++) //The Letter O
				context.fillRect((posX+2)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);	
			for(let i=2;i<6;i++)
				context.fillRect((posX+4)* size, (posY+i)* size, size, size);
		break;
		
		case "1":
			for(let i=2;i<5;i++) //The Letter T
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
			for(let i=1;i<7;i++)
				context.fillRect((posX+3)* size, (posY+i)* size, size, size);
			context.fillRect((posX+2)* size, (posY+2)* size, size, size);
			break;
		
		case "2":
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+3)* size, size, size);
			for(let i=4;i<6;i++)
				context.fillRect((posX+2)* size, (posY+i)* size, size, size);
			context.fillRect((posX+4)* size, (posY+2)* size, size, size);
		break;
			
		case "3":
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);	
			for(let i=2;i<6;i++)
				context.fillRect((posX+4)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+3)* size, size, size);	
		break;
		
		case "4":
			for(let i=1;i<4;i++) //The Letter 9
				context.fillRect((posX+2)* size, (posY+i)* size, size, size);	
			for(let i=1;i<7;i++)
				context.fillRect((posX+4)* size, (posY+i)* size, size, size);
			context.fillRect((posX+3)* size, (posY+3)* size, size, size);
			break;
		
		case "5":
			for(let i=2;i<4;i++) //The Letter 6
				context.fillRect((posX+2)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);	
			for(let i=3;i<6;i++)
				context.fillRect((posX+4)* size, (posY+i)* size, size, size);
			context.fillRect((posX+3)* size, (posY+3)* size, size, size);
		break;
		
		case "6":
			for(let i=2;i<6;i++) //The Letter 6
				context.fillRect((posX+2)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);	
			for(let i=3;i<6;i++)
				context.fillRect((posX+4)* size, (posY+i)* size, size, size);
			context.fillRect((posX+3)* size, (posY+3)* size, size, size);
		break;
		
		case "7":
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<7;i++)
				context.fillRect((posX+4)* size, (posY+i)* size, size, size);			
		break;
		
		case "8":	
			for(let i=2;i<6;i++) //The Letter 8
				context.fillRect((posX+2)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);	
			for(let i=2;i<6;i++)
				context.fillRect((posX+4)* size, (posY+i)* size, size, size);
			context.fillRect((posX+3)* size, (posY+3)* size, size, size);
		break;
			case "9":
			for(let i=2;i<4;i++) //The Letter 9
				context.fillRect((posX+2)* size, (posY+i)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+1)* size, size, size);
			for(let i=2;i<5;i++)
				context.fillRect((posX+i)* size, (posY+6)* size, size, size);	
			for(let i=2;i<6;i++)
				context.fillRect((posX+4)* size, (posY+i)* size, size, size);
			context.fillRect((posX+3)* size, (posY+3)* size, size, size);	
		break;
			
			case ":":
			context.fillRect((posX+3)* size, (posY+5)* size, size, size);
			context.fillRect((posX+3)* size, (posY+2)* size, size, size);

		break;
		case "'":break;
		case ",":break;
   }
}