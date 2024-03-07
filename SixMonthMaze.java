import java.util.*;
import java.io.*;
public class SixMonthMaze
{
   public static void main(String[]args) throws FileNotFoundException
   {
      Scanner in= new Scanner(System.in);
      System.out.println("A warrior on a perilious journey, you've finally found the maze of love.\nWill you escape with it's treasure, or fall victim?");
      char[][] mazeR=buildmazeR();
      char[][] mazeU=buildmazeU();
      boolean endFlag=false;
      boolean inputflag=false;
      int x=1;
      int y=5;
      
      System.out.println("Welcome to the maze! You are represented as the A on the map!\nYour goal is to find E(Treasure) or T(Secret)\nIn the maze, W=Wall, .=Path, *=Unknown\nWhen asked where to move, use W,A,S,D keys to move\nW=up,A=left,S=down,D=Right\nMake sure to press enter after movement!");
      
      mazeU[x][y]='Y';
      mazeU[x+1][y]=mazeR[x+1][y];
      mazeU[x-1][y]=mazeR[x-1][y];
      mazeU[x][y+1]=mazeR[x][y+1];
      mazeU[x][y-1]=mazeR[x][y-1];
      int px;
      int py;
      display(mazeU);
      while(!endFlag)
      {
         px=x;
         py=y;
         if(mazeR[x][y]!='E')
         {
            System.out.println("Where would you like to move?");
            String input=in.next();
            
            if(input.equals("W"))
            {
               inputflag=true;
               x--;
            }
            else if(input.equals("A"))
            {
               inputflag=true;
               y--;
            }
            else if(input.equals("S"))
            {
               inputflag=true;
               x++;
            }
            else if(input.equals("D"))
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
               if(mazeR[x][y]=='W')
               {
                  System.out.println("You can't move into walls. /;");
                  x=px;
                  y=py;
               }
               else if(mazeR[x][y]=='E')
               {
                  endFlag=true;
               }
               else
               {
                  mazeU[x][y]='Y';
                  mazeU[x+1][y]=mazeR[x+1][y];
                  mazeU[x-1][y]=mazeR[x-1][y];
                  mazeU[x][y+1]=mazeR[x][y+1];
                  mazeU[x][y-1]=mazeR[x][y-1];
                  display(mazeU);
                  inputflag=false;
               }
            }
         }
      }
      System.out.print("Congrats! You found the end!");
   }
   public static char[][] buildmazeR() throws FileNotFoundException
   {
      Scanner in=new Scanner(new File("mazeSixMonth.txt")); //Scans file specified
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
   }
   public static char[][] buildmazeU()
   {
      char[][] maze=new char[12][12]; //Builds a 2D array as specified
      for(int i=0;i<maze.length;i++) 
      {
         for(int j=0;j<maze[0].length;j++)
         {
            maze[i][j]='*'; //Builds 2D array using the characters in the file
         }
      }
      return maze; //returns the built array
   }
   public static void display(char[][] maze)
   {
      for(int i=1;i<maze.length;i++) 
      {
         System.out.println();
         for(int j=0;j<maze[0].length-1;j++)
         {
            System.out.print(" "+maze[i][j]); //Builds 2D array using the characters in the file
         }
      }
      System.out.println();
   }  
}
