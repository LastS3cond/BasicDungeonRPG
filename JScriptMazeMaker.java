import java.util.*;
import java.io.*;
import java.lang.*;
public class JScriptMazeMaker
{
   public static void main(String[] args)
   {
      Maze m= new Maze(15);
      m.display();
   }
}  
 // MazeDriver


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
      for(;;)
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
      while(!(pathRow.isEmpty()||pathCol.isEmpty()))
      {
         if((int)(Math.random())*2==0)
            SidePathGenerator(pathRow.removeLast(), pathCol.removeLast(),0);
         else
            SidePathGenerator(pathRow.removeFirst(), pathCol.removeFirst(),0);
      }
      mazeConversion();
   }
   public void SidePathGenerator(int row, int col, int prevOp)
   {
         ArrayList<Integer> possibleOps=new ArrayList<>();
         if(prevOp!=4&&spotCheck(row+1,col)==2)
            possibleOps.add(1);
         if(prevOp!=8&&spotCheck(row,col+1)==2)
            possibleOps.add(2);
         if(prevOp!=1&&spotCheck(row-1,col)==2)
            possibleOps.add(4);
         if(prevOp!=2&&spotCheck(row,col-1)==2)
            possibleOps.add(8);
         if(possibleOps.size()>0&&((int)(Math.random()*maze.length))!=0)
         {
            int size=possibleOps.size();
            for(int i=1;i<size;i++)
            {
               possibleOps.add(possibleOps.get(i-1)+possibleOps.get(i));
            }
            int rndm=(int)(Math.random()*possibleOps.size());
            if(possibleOps.get(rndm)==1)
            {
               spotConvert(row+1, col);
               SidePathGenerator(row+1,col,1);
            }
            else if(possibleOps.get(rndm)==3)
            {
               spotConvert(row+1, col);
               spotConvert(row, col+1);
               SidePathGenerator(row+1,col,1);
               SidePathGenerator(row,col+1,2);
            }
            else if(possibleOps.get(rndm)==5)
            {
               spotConvert(row+1, col);
               spotConvert(row-1, col);
               SidePathGenerator(row+1,col,1);
               SidePathGenerator(row-1,col,4);
            }
            else if(possibleOps.get(rndm)==9)
            {
               spotConvert(row+1, col);
               spotConvert(row, col-1);
               SidePathGenerator(row+1,col,1);
               SidePathGenerator(row,col-1,8);
            }
            else if(possibleOps.get(rndm)==2)            
            {
               spotConvert(row, col+1);
               SidePathGenerator(row,col+1,2);
            }
            else if(possibleOps.get(rndm)==6)
            {  
               spotConvert(row, col+1);
               spotConvert(row-1, col);
               SidePathGenerator(row,col+1,2);
               SidePathGenerator(row-1,col,4);
            }
            else if(possibleOps.get(rndm)==10)
            {
               spotConvert(row, col+1);
               spotConvert(row, col-1);
               SidePathGenerator(row,col+1,2);
               SidePathGenerator(row,col-1,8);
            }
            else if(possibleOps.get(rndm)==4)           
            {
               spotConvert(row-1, col);
               SidePathGenerator(row-1,col,4);
            }
            else if(possibleOps.get(rndm)==12)           
            {
               spotConvert(row-1, col);
               spotConvert(row, col-1);
               SidePathGenerator(row-1,col,4);
               SidePathGenerator(row,col-1,8);
            }
            else if(possibleOps.get(rndm)==8)           
            {
               spotConvert(row, col-1);
               SidePathGenerator(row,col-1,8);
            } 
         }  
         else
         {
           return;
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
 
   /**
   */ // display
   
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










