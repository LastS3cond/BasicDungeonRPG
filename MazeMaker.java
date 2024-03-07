import java.util.*;
import java.io.*;
import java.lang.*;
public class MazeMaker
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      char[][] retArr;
      
      Maze m;
      System.out.println();
      
      for (;;)
      {
         boolean inputOne=true;
         do
         {
            System.out.println("\nWhat do you want to do (choose 1, 2, or 3):");
            System.out.println("   1: Generate a maze");
            System.out.println("   2: Load a prewritten maze");
            System.out.println("   3: Exit");
            int codeOne=sc.nextInt();
            if(codeOne==3)
            {
               System.out.println("Goodbye!\n"); 
               System.exit(0);
               m=new Maze(buildCharArr(sc.next()));
               inputOne=false;
            }
            else if(codeOne==2)
            {
               System.out.print("\nEnter the maze's filename (file extension not needed): ");
               m=new Maze(buildCharArr(sc.next()));
               inputOne=false;
            }
            else if(codeOne==1)
            {
               System.out.println("When generating a maze, we create a perfect square, so your row number is also your column number\nEnsure your input is above 2, as a maze of 2 or less rows has no paths :).");
               int temprow;
               int tempcmplx;
               do
               {
                  System.out.println("Please enter number of rows:");
                  temprow=sc.nextInt();
                  if(temprow<3)
                     System.out.println("Input was not valid.");
               }
               while(temprow<3);
               long start=System.currentTimeMillis();
               m = new Maze(temprow);
               System.out.println("Maze generation took "+ ((System.currentTimeMillis()-start)/1E3)+" seconds!");
               inputOne=false;
            }
            else
            {
               System.out.println("Input was not valid.");
               m=new Maze();
            }
         }
         while(inputOne);
         boolean inputTwo=true;
         do
         {
            System.out.println("\nWould you like to solve the maze yourself, or have a program solve the maze?");
            System.out.println("   1: Solve the maze myself.");
            System.out.println("   2: Have a program solve the maze.");
            int codeTwo=sc.nextInt();
            if(codeTwo==1)
            {
               boolean inputThree=true;
               int codeThree;
               do
               {
                  System.out.println("\nWould you like to see the whole maze while solving(Recommended for larger mazes?\nIf no, you will only see areas you have explored.");
                  System.out.println("   1: See the whole maze.");
                  System.out.println("   2: See only what I have explored.");
                  codeThree=sc.nextInt();
                  if(codeThree==1)
                     inputThree=false;
                  else if(codeThree==2)
                     inputThree=false;
                  else
                     System.out.println("Input was not valid.");
               }
               while(inputThree);
               m.interactiveMaze(codeThree);
               inputTwo=false;
            }
            else if(codeTwo==2)
            {
               System.out.println ("Maze: ");
               m.display();
               m.solve();               
               m.display();
               inputTwo=false;
            } 
            else
            {
               System.out.println("Input was not valid.");
            }
         }
         while(inputTwo); // for
      } 
   }// main
   // precondition: The file mentions the length and width of maze first, as integers, and the length and width are correct
   // postcondition: take in a filename (without .txt), and return a char[][]
   public static char[][] buildCharArr(String fileName) throws FileNotFoundException
   {
      try{
         Scanner in=new Scanner(new File(fileName+".txt")); //Scans file specified
      
         int r=in.nextInt(); //Scans amount of rows
         int c=in.nextInt(); //Scans amount of columns
         char[][] maze=new char[r][c]; //Builds a 2D array as specified
         
         String temp=in.nextLine(); 
         for(int i=0;i<maze.length;i++) 
         {
            temp=in.nextLine(); //Scans the next line when one line runs out
            for(int j=0;j<maze[0].length;j++)
            {
               maze[i][j]=temp.charAt(j); //Builds 2D array using the characters in the file
            }
         }
         return maze; //returns the built array
      }  // buildCharArr
   catch(FileNotFoundException e){
      throw new FileNotFoundException("The file specified does not exist, or is in a different location.");
      }
   }
   
   private static void transfer2DGridToFile (char [][] m) throws FileNotFoundException
   {
      System.out.print ("Enter the name of the output file? \nUse 'txt' as the file extension: ");
      Scanner input = new Scanner (System.in);
      String name = input.next();
      File outputFile = new File (name);
      if (outputFile.exists())
      {
         System.out.println (name + "already exists");
         System.exit(1);
      }
      
      PrintWriter pw = new PrintWriter (outputFile);  
      
      System.out.println ("Enter the dimensions (row and column) of the random maze (separated the numbers with a space): ");
      pw.println(input.next() + " " + input.next());
   
      // transfer the 2D grid to the .txt text file
      for (char [] row : m)
      {
         pw.println (row);
      } 
      pw.close();
   
   } // transfer2DGridToFile

}  // MazeDriver


   //Constants
 class Maze
{
   //Constants
   //fields
   private char[][] maze;
   private int[][] mazeInt;
   private char[][] mazeU;
   private int startRow, startCol;  // store where the start location is
   private int endRow, endCol;
   private boolean S_Exists=false, E_Exists=false;
   public Maze()
   {
      maze=null;
   }
   public void mazeShell(int row, int col)
   {
      mazeInt=new int[row][col];
      maze=new char[row][col];
      int r;
      int c;
      for(r=0, c=0;r<mazeInt.length;r++)
      {
         mazeInt[r][c]=-2;
      }
      for(r=0,c=mazeInt[0].length-1;r<mazeInt.length;r++)
      {
         mazeInt[r][c]=-2;
      }
      for(r=0,c=1;c<mazeInt[0].length-1;c++)
      {
         mazeInt[r][c]=-2;
      }
      for(r=mazeInt.length-1,c=1;c<mazeInt[0].length-1;c++)   
      {
         mazeInt[r][c]=-2;
      }
      for(r=1;r<mazeInt.length-1;r++)
      {
         for(c=1;c<mazeInt[0].length-1;c++)
         {
            mazeInt[r][c]=0;
         }
      }
      startRow=(int)(Math.random()*(mazeInt.length-2)+1);
      startCol=0;
      mazeInt[startRow][startCol]=-3;
      S_Exists=true;
      
      endRow=(int)(Math.random()*(mazeInt.length-2)+1);
      endCol=mazeInt[0].length-1;
      mazeInt[endRow][endCol]=-5;
      E_Exists=true;    
   }
   public int spotCheck(int crow, int ccol)
   {
      if(mazeInt[crow][ccol]==-4)
         return 0;
      else if(mazeInt[crow][ccol]!=0&&mazeInt[crow][ccol]!=1)
         return 1;
      else
         return 2;
   }
   public void spotConvert(int crow, int ccol)
   {
      mazeInt[crow][ccol]=-1;
      if(mazeInt[crow+1][ccol]>=0)
         mazeInt[crow+1][ccol]++;
      if(mazeInt[crow][ccol+1]>=0)
         mazeInt[crow][ccol+1]++;
      if(mazeInt[crow-1][ccol]>=0)
         mazeInt[crow-1][ccol]++;
      if(mazeInt[crow][ccol-1]>=0)
         mazeInt[crow][ccol-1]++;
   }

   public Maze(int row)
   {
      mazeShell(row,row);
      boolean endNotFound=true;
      ArrayDeque<Integer> pathRow=new ArrayDeque<>();
      ArrayDeque<Integer> pathCol=new ArrayDeque<>();
      ArrayList<Character> possibleOps=new ArrayList<>();
      spotConvert(startRow, startCol+1);
      pathRow.push(startRow);
      pathCol.push(startCol+1);
      mazeInt[endRow][endCol-1]=-4;
      int south,east,north,west,rndm;
      while(!pathRow.isEmpty())
      {
         south=spotCheck(pathRow.peek()+1,pathCol.peek());
         east=spotCheck(pathRow.peek(),pathCol.peek()+1);
         north=spotCheck(pathRow.peek()-1,pathCol.peek());
         west=spotCheck(pathRow.peek(),pathCol.peek()-1);
         if(south==0||east==0||north==0||west==0)
         {
            endNotFound=false;
            break;
         }
         if(south==2)
            possibleOps.add('s');
         if(east==2)
            possibleOps.add('e');
         if(north==2)
            possibleOps.add('n');
         if(west==2)
            possibleOps.add('w');
         if(possibleOps.size()>0)
         {
            rndm=(int)(Math.random()*possibleOps.size());
            if(possibleOps.get(rndm)=='s')
            {
               pathRow.push(pathRow.peek()+1);
               pathCol.push(pathCol.peek());
            }
            else if(possibleOps.get(rndm)=='e')            
            {
               pathRow.push(pathRow.peek());
               pathCol.push(pathCol.peek()+1);
            }
            else if(possibleOps.get(rndm)=='n')            
            {
               pathRow.push(pathRow.peek()-1);
               pathCol.push(pathCol.peek());
            }
            else            
            {
               pathRow.push(pathRow.peek());
               pathCol.push(pathCol.peek()-1);
            }
            spotConvert(pathRow.peek(),pathCol.peek());
            possibleOps.clear();
         }
         else
         {
            pathRow.pop();
            pathCol.pop();
         }
      }
      spotConvert(endRow, endCol-1);
      int Nrow,Ncol;
      while(!(pathRow.isEmpty()||pathCol.isEmpty()))
      {
         if((int)(Math.random())*2==0)
         {
            Nrow=pathRow.removeLast();
            Ncol=pathCol.removeLast();
            if(spotCheck(Nrow+1,Ncol)==2||spotCheck(Nrow,Ncol+1)==2||spotCheck(Nrow-1,Ncol)==2||spotCheck(Nrow,Ncol-1)==2)
               SidePathGenerator(Nrow, Ncol);
         }
         else
         {
            Nrow=pathRow.removeFirst();
            Ncol=pathCol.removeFirst();
            if(spotCheck(Nrow+1,Ncol)==2||spotCheck(Nrow,Ncol+1)==2||spotCheck(Nrow-1,Ncol)==2||spotCheck(Nrow,Ncol-1)==2)
               SidePathGenerator(Nrow, Ncol);
         }
      }
      mazeConversion();
   }
   public ArrayList<Integer> findOps(ArrayList<Integer> a)
   {
      int size=a.size();
      if(size>=2)
         a.add(a.get(0)+a.get(1));
      if(size>=3)
      {
         a.add(a.get(1)+a.get(2));
         a.add(a.get(0)+a.get(2));
         a.add(a.get(0)+a.get(1)+a.get(2));
      }
      return a;  
   }
   public void SidePathGenerator(int row, int col)
   {
      Stack<Integer> pathRow=new Stack<>();
      Stack<Integer> pathCol=new Stack<>();
      ArrayList<Integer> possibleOps=new ArrayList<>();
      pathRow.push(row);
      pathCol.push(col);
      while(!pathRow.isEmpty())
      {
         row=pathRow.pop();
         col=pathCol.pop();
         possibleOps.clear();
         if(spotCheck(row+1,col)==2)
            possibleOps.add(1);
         if(spotCheck(row,col+1)==2)
            possibleOps.add(2);
         if(spotCheck(row-1,col)==2)
            possibleOps.add(4);
         if(spotCheck(row,col-1)==2)
            possibleOps.add(8);
         if(possibleOps.size()>0)
         {
            possibleOps=findOps(possibleOps);
            int rndm=(int)(Math.random()*possibleOps.size());
            if(possibleOps.get(rndm)==1)
            {
               pathRow.push(row+1);
               pathCol.push(col);
            }
            else if(possibleOps.get(rndm)==3)
            {
               pathRow.push(row+1);
               pathCol.push(col);
               pathRow.push(row);
               pathCol.push(col+1);
            }
            else if(possibleOps.get(rndm)==5)
            {
               pathRow.push(row+1);
               pathCol.push(col);
               pathRow.push(row-1);
               pathCol.push(col);
            }
            else if(possibleOps.get(rndm)==9)
            {
               pathRow.push(row+1);
               pathCol.push(col);
               pathRow.push(row);
               pathCol.push(col-1);
            }
            else if(possibleOps.get(rndm)==7)
            {
               pathRow.push(row+1);
               pathCol.push(col);
               pathRow.push(row);
               pathCol.push(col+1);
               pathRow.push(row-1);
               pathCol.push(col);         
            }
            else if(possibleOps.get(rndm)==11)
            {
               pathRow.push(row+1);
               pathCol.push(col);
               pathRow.push(row);
               pathCol.push(col+1);
               pathRow.push(row);
               pathCol.push(col-1);
            }
            else if(possibleOps.get(rndm)==13)
            {
               pathRow.push(row+1);
               pathCol.push(col);
               pathRow.push(row-1);
               pathCol.push(col);
               pathRow.push(row);
               pathCol.push(col-1);
            }
            else if(possibleOps.get(rndm)==2)            
            {
               pathRow.push(row);
               pathCol.push(col+1);
            }
            else if(possibleOps.get(rndm)==6)
            {  
               pathRow.push(row);
               pathCol.push(col+1);
               pathRow.push(row-1);
               pathCol.push(col);
            }
            else if(possibleOps.get(rndm)==10)
            {
               pathRow.push(row);
               pathCol.push(col+1);
               pathRow.push(row);
               pathCol.push(col-1);
            }
            else if(possibleOps.get(rndm)==14)
            {
               pathRow.push(row);
               pathCol.push(col+1);
               pathRow.push(row-1);
               pathCol.push(col);
               pathRow.push(row);
               pathCol.push(col-1);
            }
            else if(possibleOps.get(rndm)==4)           
            {
               pathRow.push(row-1);
               pathCol.push(col);
            }
            else if(possibleOps.get(rndm)==12)           
            {
               pathRow.push(row-1);
               pathCol.push(col);
               pathRow.push(row);
               pathCol.push(col-1);
            }
            else if(possibleOps.get(rndm)==8)           
            {
               pathRow.push(row);
               pathCol.push(col-1);
            } 
            spotConvert(pathRow.peek(),pathCol.peek());
         }
      }  
   } 
      /** Initializes all the field of a Maze object: maze, startRow, startCol
   */
   public void mazeConversion()
   {
      for(int r=0;r<maze.length;r++)
      {
         for(int c=0;c<maze[0].length;c++)
         {
            if(mazeInt[r][c]==-1)
               maze[r][c]='.';
            else if(mazeInt[r][c]==-3)
               maze[r][c]='S';
            else if(mazeInt[r][c]==-5)
               maze[r][c]='E';
            else
               maze[r][c]='W';
         }
      }
   }
   public void interactiveMaze(int i)
   {
      Scanner in= new Scanner(System.in);
      buildMazeU(i);
      boolean endFlag=false;
      boolean inputflag=false;
      int x=startRow;
      int y=startCol;
      
      System.out.println("Welcome to the maze! You are represented as the O on the map!\nYour goal is to find E(The End)\nIn the maze, W=Wall, .=Path, *=Unknown\nWhen asked where to move, use W,A,S,D keys to move\nW=up,A=left,S=down,D=Right\nMake sure to press enter after movement!");
      
      mazeU[x][y]='O';
      mazeU[x+1][y]=maze[x+1][y];
      mazeU[x-1][y]=maze[x-1][y];
      mazeU[x][y+1]=maze[x][y+1];
      
      int px;
      int py;
      displayMazeU();
      while(!endFlag)
      {
         px=x;
         py=y;
         if(maze[x][y]!='E')
         {
            System.out.println("Where would you like to move?");
            String input=in.next();
            
            if(input.equals("W")||input.equals("w"))
            {
               inputflag=true;
               x--;
            }
            else if(input.equals("A")||input.equals("a"))
            {
               inputflag=true;
               y--;
            }
            else if(input.equals("S")||input.equals("s"))
            {
               inputflag=true;
               x++;
            }
            else if(input.equals("D")||input.equals("d"))
            {
               inputflag=true;
               y++;
            }
            else
            {
               System.out.println("Try pressing an W,A,S,D key next time!");
            }
            if(inputflag)
            {
               if(y<0)
               {
                  System.out.println("You can't move beyond start. /;");
                  x=px;
                  y=py;
               }
               else if(maze[x][y]=='W')
               {
                  System.out.println("You can't move into walls. /;");
                  x=px;
                  y=py;
               }
               else if(maze[x][y]=='E')
               {
                  endFlag=true;
               }
               else
               {
                  mazeU[x][y]='O';
                  mazeU[x+1][y]=maze[x+1][y];
                  mazeU[x-1][y]=maze[x-1][y];
                  mazeU[x][y+1]=maze[x][y+1];
                  mazeU[x][y-1]=maze[x][y-1];
                  displayMazeU();
                  inputflag=false;
               }
            }
         }
      }
      System.out.print("Congrats! You found the end!");
   }
   public void buildMazeU(int k)
   {
      mazeU=new char[maze.length][maze[0].length]; //Builds a 2D array as specified
      for(int i=0;i<maze.length;i++) 
      {
         for(int j=0;j<maze[0].length;j++)
         {
            if(k==2)
               mazeU[i][j]='*'; //Builds 2D array using the characters in the file
            else
               mazeU[i][j]=maze[i][j];
         }
      }
   }
   public void displayMazeU()
   {
      for(int i=0;i<maze.length;i++) 
      {
         System.out.println();
         for(int j=0;j<maze[0].length;j++)
         {
            System.out.print(" "+mazeU[i][j]); //Builds 2D array using the characters in the file
         }
      }
      System.out.println();
   }  
   public Maze(char[][] inCharArr)    
   {
      maze=inCharArr; //initializes the maze as the 2D array
      for(int i=0;i<maze.length;i++)
      {
         for(int j=0;j<maze[0].length;j++)
         {
            if(maze[i][j]=='S') //Scans array for start
            {
               startRow=i; //Sets start position
               startCol=j; //Sets start position
               S_Exists=true; //Start is set to exist
            }
            if(maze[i][j]=='E')
            {
               E_Exists=true; //Exit is set to exist
            }
         }
      }       
               
   }  // Maze
   
   /**
   */
   public void display()
   {
      if(maze==null) 
         return;
      for(int a = 0; a<maze.length; a++)
      {
         for(int b = 0; b<maze[0].length; b++)
         {
            System.out.print(maze[a][b]+" "); //prints out each character in the maze individually
         }
         System.out.println();
      }
      System.out.println();
   }  // display
   
   /**
   */
   public void solve()
   {
      if(!(S_Exists&&E_Exists))
         System.out.println("No Path found!"); 
      double start=System.currentTimeMillis();
      if(!markCorrectPathStack(startRow, startCol, 0)) //Checks if Start and Exit exists, and then checks for the path
         System.out.println ("No Path found!"); 
      System.out.println("The time it took to find the solution was "+(System.currentTimeMillis()-start)/1E3+" seconds");
   }  // solve   
   

//         if(r+1>=maze.length&&r-1<0||c-1<0||c+1>=maze[0].length||maze[r][c]=='W');
  //       if(r>=maze.length||r<0||c<0||c>=maze[0].length||maze[r][c]=='W');
    //     if(maze[r][c]=='E') //returns true if the Exit is found, and prints the amount of steps taken to get there. 
   private boolean markCorrectPathStack(int r, int c, int count) //Uses Stack to satisfy postconditon
   {
      Stack<Integer> row= new Stack<Integer>();
      Stack<Integer> column= new Stack<Integer>();
      maze[r][c]='.';
      for(;;)
      {            
         if(maze[r][c]=='.')
         {
            column.push(c);
            row.push(r);
         }
         if(maze[r][c]=='0'||maze[r][c]=='.')
         {
            maze[r][c]='*';
            if(c+1<maze[0].length&&(maze[r][c+1]=='.'||maze[r][c+1]=='E'))
               c++;
            else if(c-1>=0&&(maze[r][c-1]=='.'||maze[r][c-1]=='E'))
               c--;
            else if(r+1<maze.length&&(maze[r+1][c]=='.'||maze[r+1][c]=='E'))
               r++;
            else if(r-1>=0&&(maze[r-1][c]=='.'||maze[r][c+1]=='E'))
               r--;
         }
         else if(maze[r][c]=='E')
         {              
            count=column.size();
            System.out.println("The number of stars is "+(count-1)+", so the total number of steps taken is "+count);
            for(c=0;c<maze[0].length;c++)
            {
               for(r=0;r<maze.length;r++)
               {
                  if(maze[r][c]=='0')
                     maze[r][c]='.';
               }
            }
            maze[startRow][startCol]='S';
            return true;
         }
         else
         {         
            column.pop();
            row.pop();
            maze[r][c]='0';
            c=column.peek();
            r=row.peek();
            maze[r][c]='0';
         }
      }
   }
}








