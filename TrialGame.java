import java.util.*;
import java.lang.*;
import java.io.*;
public class TrialGame
{
   public static void main(String[]args) throws FileNotFoundException
   {
      Scanner in=new Scanner(System.in);
      Warrior player=new Warrior();
      System.out.println(player);
      System.out.println("\nNow that character create is finished, what quest would you like to begin?\nQuest 1: A Christmas Challenge\nQuest 2: The Lost Ring\nQuest 3: Generic Playthrough\nPlease enter the number you would like to attempt!");
      int qc;
      do
      {
        qc=in.nextInt();
        if(qc==1)
            new QuestOne(player);
         else if(qc==2||qc==3)
            System.out.println("These quests aren't finished yet, please choose another:");
         else
            System.out.println("Not a valid quest number, please try again:");
      }
      while(qc!=1); 
      System.out.println("I hope you enjoyed your playthrough, goodbye!");
   }
}
class QuestOne
{
   private Warrior mc;
   public QuestOne(Warrior w) throws FileNotFoundException
   {
      Scanner in=new Scanner(System.in);
      mc=w;
      System.out.println("After a long and weary journey, you return to your hometown to spend Christmas with your family.\nHowever, everyone is looking gloom and sad for the holidays, and you are curious why.\nWhat would you like to do?\n1. Go home \n2. Visit the Tavern\n3. Consult the Governer \n4. Talk with a Local\nPlease enter your choice below.");
      int ch1=in.nextInt();
      while(!(ch1>0&&ch1<5))
      {
         System.out.println("Not a valid choice, please try again");
         ch1=in.nextInt();
      }
      Choice1(ch1);
      System.out.println("\n\nYou make it the caves, after days on horseback, and as soon as you enter, something is off.\nYou can't leave, and you feel oddly connected to something outside your realm.\nA gorgeous girl with dark hair, beautiful blue-green eyes, and a perfect nose appears in your mind.\nYou shake your head and wipe the image, and begin exploring the caves.\n");
      Dungeon();
   }
   private void Dungeon() throws FileNotFoundException
   {
      Scanner in= new Scanner(System.in);
      char[][] mazeR=buildmazeR();
      char[][] mazeU=buildmazeU();
      boolean AFlag=false;
      boolean BFlag=false;
      boolean CFlag=false;
      boolean DFlag=false;
      boolean EFlag=false;
      boolean FFlag=false;
      boolean ZFlag=false;
      boolean inputflag=false;
      int x=1;
      int y=5;
      System.out.println("Welcome to the cave, you are represented as the Y on the map!\nYour goal is to find the presents, and leave the maze.\nW=Wall, .=Path, *=Unknown, Letters=Gifts, Numbers=Locks\nWhen asked where to move, use W,A,S,D keys to move\nMake sure to press enter after movement!");
      
      mazeU[x][y]='Y';
      mazeU[x+1][y]=mazeR[x+1][y];
      mazeU[x-1][y]=mazeR[x-1][y];
      mazeU[x][y+1]=mazeR[x][y+1];
      mazeU[x][y-1]=mazeR[x][y-1];
      
      display(mazeU);
      while(!ZFlag)
      {
         if((int)(Math.random()*1)==0)
         {
            System.out.println("The ground falls beneath you\n\nYou encounter something dark, something ancient in the caverns. \nThere are not gifts, there is no holiday, there is no home\nYour soul has forsaken you, your health has left you\nLiquid fear replaces your blood, your mind is consumed\nYour eyes cannot see, your ears cannot hear, you cannot feel\nYou are void, you have always been void\n");
            if(combat(monster(9999,null,null,null,999999,999999,999999,999999,999999,999999,999999,999999)))
            {
               throw new IllegalStateException("something is wrong");
            }
         }
         if(mazeR[x][y]!='A'&&mazeR[x][y]!='B'&&mazeR[x][y]!='C'&&mazeR[x][y]!='D'&&mazeR[x][y]!='E'&&mazeR[x][y]!='F'&&mazeR[x][y]!='Z'&&mazeR[x][y]!='1'&&mazeR[x][y]!='2'&&mazeR[x][y]!='3')
         {
            System.out.println("Where would you like to move?");
            String input=in.next();
            
            if(input.equals("W"))
            {
               if(mazeU[x-1][y]=='W')
                  System.out.println("You can't move into walls /:");
               else if((mazeU[x-1][y]=='1'&&!(AFlag&&BFlag&&CFlag))||(mazeU[x-1][y]=='2'&&!(DFlag&&EFlag))||(mazeU[x-1][y]=='3'&&!(FFlag)))
                  System.out.println("The door is locked, continue exploring");
               else
               {
                  x--;
                  inputflag=true;
               }
            }
            else if(input.equals("A"))
            {
               if(mazeU[x][y-1]=='W')
                  System.out.println("You can't move into walls /:");
               else if((mazeU[x][y-1]=='1'&&!(AFlag&&BFlag&&CFlag))||(mazeU[x][y-1]=='2'&&!(DFlag&&EFlag))||(mazeU[x][y-1]=='3'&&!(FFlag)))
                  System.out.println("The door is locked, continue exploring");
               else
               {
                  y--;
                  inputflag=true;
               }
            }
            else if(input.equals("S"))
            {
               if(mazeU[x+1][y]=='W')
                  System.out.println("You can't move into walls /:");
               else if((mazeU[x+1][y]=='1'&&!(AFlag&&BFlag&&CFlag))||(mazeU[x+1][y]=='2'&&!(DFlag&&EFlag))||(mazeU[x+1][y]=='3'&&!(FFlag)))
                  System.out.println("The door is locked, continue exploring");
               else
               {
                  x++;
                  inputflag=true;
               }
            }
            else if(input.equals("D"))
            {
               if(mazeU[x][y+1]=='W')
                  System.out.println("You can't move into walls /:");
               else if((mazeU[x][y+1]=='1'&&!(AFlag&&BFlag&&CFlag))||(mazeU[x][y+1]=='2'&&!(DFlag&&EFlag))||(mazeU[x][y+1]=='3'&&!(FFlag)))
                  System.out.println("The door is locked, continue exploring");
               else
               {
                  y++;
                  inputflag=true;
               }
            }
            else
            {
               System.out.println("Try pressing an W,A,S,D key next time!");
            }
            if(inputflag&&mazeR[x][y]!='A'&&mazeR[x][y]!='B'&&mazeR[x][y]!='C'&&mazeR[x][y]!='D'&&mazeR[x][y]!='E'&&mazeR[x][y]!='F'&&mazeR[x][y]!='Z'&&mazeR[x][y]!='1'&&mazeR[x][y]!='2'&&mazeR[x][y]!='3')
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
         else if(mazeR[x][y]=='A')
         {
            AFlag=true;
            System.out.println("You've encountered a pair of goblins carrying the presents in.\nClearly the runts of the pack, you get ready to take your revenge");
            if(combat(monster(2,"Goblin","Warrior","Male", 20,20,50,50,30,30,20,20)))
            {
               System.out.println("You have died, quest failed");
               return;
            }
            else
            {
               System.out.println("You have defeated the goblin runts, and got a better look at what they were carrying.\nIt looks like a stocking, with a ferret in winter as it's design.\nYou hold the stocking, and it disappears, an image floating in your head.\nYou see the gorgeous girl joyous as she picks it up and explores what's inside.\nFeeling her joy, you continue through the dungeon");
            }
            mazeR[x][y]='.';
            mazeU[x][y]='Y';
            mazeU[x+1][y]=mazeR[x+1][y];
            mazeU[x-1][y]=mazeR[x-1][y];
            mazeU[x][y+1]=mazeR[x][y+1];
            mazeU[x][y-1]=mazeR[x][y-1];
            display(mazeU);
            inputflag=false;
         }
         else if(mazeR[x][y]=='B')
         {
            BFlag=true;
            System.out.println("You've encountered a Cave Ogre, with a present behind it's legs\nA brute, it charges at you, you get ready to fight");
            if(combat(monster(1,"Ogre","Brute","Male", 75,75,25,30,25,30,50,100)))
            {
               System.out.println("You have died, quest failed");
               return;
            }
            else
            {
               System.out.println("You have defeated the Cave Ogre, and retrieved the gift.\nJust like before, it disappears, another vision coming on.\nThe present finds its way to the girl's feet, and she smiles.\nFeeling her joy, you continue through the dungeon");
            }
            mazeR[x][y]='.';
            mazeU[x][y]='Y';
            mazeU[x+1][y]=mazeR[x+1][y];
            mazeU[x-1][y]=mazeR[x-1][y];
            mazeU[x][y+1]=mazeR[x][y+1];
            mazeU[x][y-1]=mazeR[x][y-1];
            display(mazeU);
            inputflag=false;
         }
         else if(mazeR[x][y]=='C')
         {
            CFlag=true;
            System.out.println("You've encountered an Druid, with a present in it's roots\nUnmoving, spells are cast against you");
            if(combat(monster(1,"Druid","Mage","Female", 45,45,30,30,70,70,50,75)))
            {
               System.out.println("You have died, quest failed");
               return;
            }
            else
            {
               System.out.println("Running circles around the Druid, you cut off it's branches and retrieved the gift.\nIt disappears, a vision coming on.\nThe present finds its way under her tree, and the girl with beautiful eyes smiles.\nFeeling her joy, you continue through the dungeon");
            }
            mazeR[x][y]='.';
            mazeU[x][y]='Y';
            mazeU[x+1][y]=mazeR[x+1][y];
            mazeU[x-1][y]=mazeR[x-1][y];
            mazeU[x][y+1]=mazeR[x][y+1];
            mazeU[x][y-1]=mazeR[x][y-1];
            display(mazeU);
            inputflag=false;
         }
         else if(mazeR[x][y]=='D')
         {
            DFlag=true;
            System.out.println("You've encountered 3 goblin assassins, guarding a gift in a chest behind them\nMoving so fast they disappears from sight, you ready yourself");
            if(combat(monster(3,"Goblin","Assassin","Male", 35,35,70,70,45,45,35,35)))
            {
               System.out.println("You have died, quest failed");
               return;
            }
            else
            {
               System.out.println("Cutting the legs of the last assassin, you reach the chest where the gift resides.\nIt disappears, a vision coming on.\nThe present finds its way under her tree, and the girl with beautiful eyes smiles.\nFeeling her joy, you continue through the dungeon");
            }
            mazeR[x][y]='.';
            mazeU[x][y]='Y';
            mazeU[x+1][y]=mazeR[x+1][y];
            mazeU[x-1][y]=mazeR[x-1][y];
            mazeU[x][y+1]=mazeR[x][y+1];
            mazeU[x][y-1]=mazeR[x][y-1];
            display(mazeU);
            inputflag=false;
         }
         else if(mazeR[x][y]=='E')
         {
            EFlag=true;
            System.out.println("You've encountered a heavily armored dwarf, surrounded by goblin bodies, and the gift they held\nArmor so thick it makes him seem bigger, you move in for the first strike");
            if(combat(monster(1,"Dwarf","Paladin","Male", 40,70,40,30,60,30,40,50)))
            {
               System.out.println("You have died, quest failed");
               return;
            }
            else
            {
               System.out.println("Breaking through the thick helmet, you grab the gift at their feet.\nA vision comes on, as the gift melts away from reality.\nThe present finds its way in her hands, and you once again see her smile.\nFeeling her joy, you continue through the dungeon");
            }
            mazeR[x][y]='.';
            mazeU[x][y]='Y';
            mazeU[x+1][y]=mazeR[x+1][y];
            mazeU[x-1][y]=mazeR[x-1][y];
            mazeU[x][y+1]=mazeR[x][y+1];
            mazeU[x][y-1]=mazeR[x][y-1];
            display(mazeU);
            inputflag=false;
         }
         else if(mazeR[x][y]=='F')
         {
            FFlag=true;
            System.out.println("You've encountered an vicious Orc Envoy, preparing to depart with the gift inbetween\nHeavy swords aimed at you, you read your own in fear");
            if(combat(monster(5,"Orc","Brute","Male", 80,60,80,60,35,35,50,75)))
            {
               System.out.println("You have died, quest failed");
               return;
            }
            else
            {
               System.out.println("The last Orc on the ground, you grab the gift\nAn illusion finds it way within your mind, as the gift disappears.\nYou watch her unwrap the last present, as the smile appears on her face\nFeeling her joy, you continue through the dungeon");
            }
            mazeR[x][y]='.';
            mazeU[x][y]='Y';
            mazeU[x+1][y]=mazeR[x+1][y];
            mazeU[x-1][y]=mazeR[x-1][y];
            mazeU[x][y+1]=mazeR[x][y+1];
            mazeU[x][y-1]=mazeR[x][y-1];
            display(mazeU);
            inputflag=false;    
         }
         else if(mazeR[x][y]=='Z')
         {
            ZFlag=true;
            System.out.println("You've encountered a Grinch, preparing to depart with all of the other gifts\nHe looks at you with his nasty smile, and you feel his power");
            if(combat(monster(1,"Human","Warrior","Male", 60,60,60,60,60,60,100,100)))
            {
               System.out.println("You have died, quest failed");
               return;
            }
            else
            {
               System.out.println("Your vision blurry, you have won\nYou black out\n\n\n");
            }
            System.out.println("You wake up, outside of the cave, the entrance collapsed\nYou return home, and it's clear that all gifts have been given back.\nJoy has returned to your town, and you enjoy the holidays with your family.\nNot only this, you know you have saved the girl's christmas as well\nUntil next time.");
         }
         else if(mazeR[x][y]=='1')
         {
            System.out.println("Unlocked");
            if(mc.getHP()<30)
            {
               System.out.print("You find a half-eaten meal on the ground\nStarved, you eat it and replenish your strength\n[Your health is brought up to 50!]");
               mc.setHP(50);
            }
            mazeR[x][y]='.';
            mazeU[x][y]='Y';
            mazeU[x+1][y]=mazeR[x+1][y];
            mazeU[x-1][y]=mazeR[x-1][y];
            mazeU[x][y+1]=mazeR[x][y+1];
            mazeU[x][y-1]=mazeR[x][y-1];
            display(mazeU);
            inputflag=false;  
         }
         else if(mazeR[x][y]=='2')
         {
            System.out.println("Unlocked");
            System.out.println("You find a potion on the ground next to the door, and drink it\nYour vitality grows, and you feel weirdly refreshed\n[Your health is full!]");  
            mc.setHP(100);
            mazeR[x][y]='.';
            mazeU[x][y]='Y';
            mazeU[x+1][y]=mazeR[x+1][y];
            mazeU[x-1][y]=mazeR[x-1][y];
            mazeU[x][y+1]=mazeR[x][y+1];
            mazeU[x][y-1]=mazeR[x][y-1];
            display(mazeU);
            inputflag=false;  
         }
         else if(mazeR[x][y]=='3')
         {
            System.out.println("Unlocked"); 
            mazeR[x][y]='.'; 
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
   private Warrior[] monster(int amt, String race, String clique, String sex, int str, int def, int spd, int agl, int iq, int mag, int luck, int hp)
   {
      Warrior[] monsters=new Warrior[amt];
      for(int i=amt-1;i>=0;i--)
      {
         monsters[i]=new Warrior("Monster",clique,race,sex,str,def,spd,agl,iq,mag,luck,hp);
      }
      return monsters;      
   }
   private boolean combat(Warrior[] w)
   {
      System.out.println(mc+"\n");
      Scanner sc=new Scanner(System.in);
      for(int i=w.length-1;i>=0;i--)
      {
         System.out.println("There are "+(i+1)+" monsters left to kill");
         System.out.print(w[i]);
         boolean cmbtFlag=true;
         while(cmbtFlag)
         {
            System.out.println("\nYour current Health is "+mc.getHP());
            System.out.println("\nHow would you like to attack?\n1.By Physicality(Strength and Speed)\n2.By Intelligence\n3.By Magic");
            int ch=sc.nextInt();
            if(ch==2)
            {
               if(mc.getIQ()-w[i].getIQ()>=5)
               {
                  int dam=(int)(Math.random()*mc.getLck());
                  System.out.println("Through outsmarting an enemy, you have damaged them by "+dam);
                  w[i].setHP(w[i].getHP()-dam);
                  if(w[i].getHP()<1)
                  {
                     System.out.println("You have killed the monster!");
                     cmbtFlag=false;
                  }
               }
               else
               {
                  System.out.println("No damage was done to the enemy");
               }
            }
            else if(ch==3)
            {
               if(mc.getMag()-w[i].getMag()>=5)
               {
                  int dam=(int)(Math.random()*mc.getLck());
                  System.out.println("Through magic, you have damaged the enemy by "+dam);
                  w[i].setHP(w[i].getHP()-dam);
                  if(w[i].getHP()<1)
                  {
                     System.out.println("You have killed the monster!");
                     cmbtFlag=false;
                  }
               }
               else
               {
                  System.out.println("No damage was done to the enemy");
               }
            }
            else
            {
               if((mc.getStr()+mc.getSpd())-(w[i].getDef()+w[i].getAgl())>=10)
               {
                  int dam=(int)(Math.random()*mc.getLck());
                  System.out.println("Through physicality, you have damaged the enemy by "+dam);
                  w[i].setHP(w[i].getHP()-dam);
                  if(w[i].getHP()<1)
                  {
                     System.out.println("You have killed the monster!");
                     cmbtFlag=false;
                  }
               }
               else
               {
                  System.out.println("No damage was done to the enemy");
               }
            }
            if(cmbtFlag)
            {
               System.out.println("\nHow would you like to defend(Cannot be the same as how you attacked)?\n1.By Physicality(Defense and Agility)\n2.By Intelligence\n3.By Magic");
               int choice=sc.nextInt();
               while(choice==ch)
               {
                  System.out.println("It cannot be the same as how you attacked, pick a new number");
                  choice=sc.nextInt();
               }                  
               if(choice==2)
               {
                  if(w[i].getIQ()-mc.getIQ()>=1)
                  {
                     int dam=(int)(Math.random()*w[i].getLck());
                     System.out.println("Through outsmarting you, they have damaged you by "+dam);
                     mc.setHP(mc.getHP()-dam);
                    if(mc.getHP()<1)
                    {
                       System.out.println("The monster has killed you!");
                       cmbtFlag=false;
                    }
                  }
                  else
                  {
                     System.out.println("No damage was done to the you");
                  }
               }
               else if(choice==3)
               {
                  if(w[i].getMag()-mc.getMag()>=1)
                  {
                     int dam=(int)(Math.random()*w[i].getLck());
                     System.out.println("Through magic, they have damaged you by "+dam);
                     mc.setHP(mc.getHP()-dam);
                     if(mc.getHP()<1)
                    {
                       System.out.println("The monster has killed you!");
                       cmbtFlag=false;
                    }
                  }
                  else
                  {
                     System.out.println("No damage was done to the you");
                  }
               }
               else
               {
                  if((w[i].getStr()+w[i].getSpd())-(mc.getDef()+mc.getAgl())>=1)
                  {
                     int dam=(int)(Math.random()*w[i].getLck());
                     System.out.println("Through physicality, the enemy has damaged you by "+dam);
                     mc.setHP(mc.getHP()-dam);
                     if(mc.getHP()<1)
                    {
                       System.out.println("The monster has killed you!");
                       cmbtFlag=false;
                    }
                  }
                  else
                  {
                     System.out.println("No damage was done to the you");
                  }
               }
            }
         }
      if(mc.getHP()<0)
         return true;
      return false;  
      }   
            if(mc.getHP()<0)
         return true;
      return false;  
   }
   private char[][] buildmazeR() throws FileNotFoundException
   {
      Scanner in=new Scanner(new File("ChristmasDungeon.txt")); //Scans file specified
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
   private char[][] buildmazeU()
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
   private void display(char[][] maze)
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
   private void Choice1(int i)
   {
      if(i==1)
         System.out.println("Desiring to stop being the hero, you return home to your family to enjoy your christmas.\nHowever, all of your presents have disappeared, and your family is as glum as the next.\nPrying on for information, you hear that goblins had raced through town, stealing presents.\nLast anyone saw, they retreated to their treasure cave in the North.\nFurious, you head to Northern Caves to retrieve the presents.");
      if(i==2)
         System.out.println("Desiring to get a quick drink before dealing with family, you hit up a local tavern.\nHowever, everyone within seems just as glum as those outside, and you ask the barkeep why\nSupposedly many presents under christmas trees have disappeared, and many are despairing about what has been lost.\nPrying on for information, you hear that goblins are the culprit, stealing presents house to house.\nLast anyone saw, they retreated to their treasure cave in the North.\nSome patrons overhear, and beg you to fix their christmas.\nYou begin your journey to the Northern Caves.");
      if(i==3)
         System.out.println("Desiring to pick up one last quest before the holidays, you pay a visit to the Governor\nLooking as glum as all else, he briefs you on the situation\nSupposedly many presents under christmas trees have disappeared, and many are despairing about what has been lost.\nPrying on for information, you hear that goblins are the culprit, stealing presents house to house.\nLast anyone saw, they retreated to their treasure cave in the North.\nHe offers you wealth in return, and you head to the Northern Caves.");
      if(i==4)
         System.out.println("Desiring to understand why everyone is so glum, you strike up conversation with a local\nA wealthy man, he tells of goblins who raided the town of their gifts\nRetreating to caves in the North, it is as if christmas is ruined\nWanting to bring back christmas for his family, the gentleman offers you 20 coins to fix the problem\nYou begin your journey to the Northern Caves");
   } 
}
class Warrior
{
   private String name;
   private String clique;
   private String race;
   private String sex;
   private int str; //strength
   private int def; //defense
   private int spd; //speed
   private int agl; //agility
   private int iq; //intelligence
   private int mag; //magic
   private int lck; //luck
   private int hp;
   public Warrior(String n, String c, String r, String s, int strength, int defense, int speed, int agility, int intelligence, int magic, int luck, int hp)
   {
      name=n;
      clique=c;
      race=r;
      sex=s;
      str=strength;
      def=defense;
      spd=speed;
      agl=agility;
      iq=intelligence;
      mag=magic;
      lck=luck;
      this.hp=hp;
   }
   public Warrior()
   {
      Scanner in=new Scanner(System.in);
      System.out.println("Welcome to character creation!\nWhat would you like your character name to be?");
      name=in.next();
      
      System.out.println("What would you like your character gender to be?\n1. Male(High Str, High Def, High Spd)\n2. Female(High Agl, High IQ, High Mag)");
      int gender=in.nextInt();
      while(!(gender==1||gender==2))
      {
         System.out.println("You failed to enter a valid number /:, please try again.");
         gender=in.nextInt();
      }
      generateGender(gender);
      
      System.out.println("What would you like your character race to be?\n1. Human(Middle)\n2. Elf(High Agl, High Mag, Low Str, Low Def)\n3. Dwarf(High Def, High IQ, Low Agl, Low Mag)\n4. Orc(High Str, High Spd, Low IQ, Low Mag)\n5. Goblin(High Spd, High Agl, Low Str, Low Def)\n6. Druid(High IQ, High Mag, Low Spd, Low Agl)\n7. Ogre(High Str, High Def, Low Spd, Low IQ)");
      int r=in.nextInt();
      while(!(r>0&&r<8))
      {
         System.out.println("You failed to enter a valid number /:, please try again.");
         r=in.nextInt();
      }
      generateRace(r);
      
      System.out.println("What would you like your character class to be?\n1. Mage(High Mag, Low Agl)\n2. Warrior(Middle)\n3. Paladin(High Def, Low Spd)\n4. Brute(High Str, Low IQ)\n5. Mad Scientist(High IQ, Low Mag)\n6. Ranger(High Agl, Low Def)\n7. Assassin(High Spd, Low Str)");
      int c=in.nextInt();
      while(!(c>0&&c<8))
      {
         System.out.println("You failed to enter a valid number /:, please try again.");
         c=in.nextInt();
      }
      generateClass(c);
      
      str=1;
      def=1;
      spd=1;
      agl=1;
      iq=1;
      mag=1;
      lck=(int)(Math.random()*50)+50;
      hp=100;
      generateStats();
   }
   private void generateClass(int i)
   {
      if(i==1)
         clique="Mage";
      if(i==2)
         clique="Warrior";
      if(i==3)
         clique="Paladin";
      if(i==4)
         clique="Brute";
      if(i==5)
         clique="Mad Scientist";
      if(i==6)
         clique="Ranger";
      if(i==7)
         clique="Assassin";
   }   
   private void generateGender(int i)
   {
      if(i==1)
         sex="Male";
      if(i==2)
         sex="Female";
   }
   private void generateRace(int i)
   {
      if(i==1)
         race="Human";
      if(i==2)
         race="Elf";
      if(i==3)
         race="Dwarf";
      if(i==4)
         race="Orc";
      if(i==5)
         race="Goblin";
      if(i==6)
         race="Druid";
      if(i==7)
         race="Ogre";
   }
   private void generateStats() //Generates random stats based on the clique chosen
   {
      if(clique.equals("Warrior"))
      {
         str+=statGen(2);
         def+=statGen(2);
         spd+=statGen(2);
         agl+=statGen(2);
         iq+=statGen(2);
         mag+=statGen(2);
         
      }
      if(clique.equals("Mage"))
      {
         str+=statGen(2);
         def+=statGen(2);
         spd+=statGen(2);
         agl+=statGen(1);
         iq+=statGen(2);
         mag+=statGen(3);
         
      }
      if(clique.equals("Paladin"))
      {
         str+=statGen(2);
         def+=statGen(3);
         spd+=statGen(1);
         agl+=statGen(2);
         iq+=statGen(2);
         mag+=statGen(2);
         
      }
      if(clique.equals("Brute"))
      {
         str+=statGen(3);
         def+=statGen(2);
         spd+=statGen(2);
         agl+=statGen(2);
         iq+=statGen(1);
         mag+=statGen(2);
         
      }
      if(clique.equals("Mad Scientist"))
      {
         str+=statGen(2);
         def+=statGen(2);
         spd+=statGen(2);
         agl+=statGen(2);
         iq+=statGen(3);
         mag+=statGen(1);
         
      }
      if(clique.equals("Ranger"))
      {
         str+=statGen(2);
         def+=statGen(1);
         spd+=statGen(2);
         agl+=statGen(3);
         iq+=statGen(2);
         mag+=statGen(2);
         
      }
      if(clique.equals("Assassin"))
      {
         str+=statGen(1);
         def+=statGen(2);
         spd+=statGen(3);
         agl+=statGen(2);
         iq+=statGen(2);
         mag+=statGen(2);
         
      }
      
      if(race.equals("Human"))
      {
         str+=statGen(2);
         def+=statGen(2);
         spd+=statGen(2);
         agl+=statGen(2);
         iq+=statGen(2);
         mag+=statGen(2);
         
      }
      if(race.equals("Elf"))
      {
         str+=statGen(1);
         def+=statGen(1);
         spd+=statGen(2);
         agl+=statGen(3);
         iq+=statGen(2);
         mag+=statGen(3);
         
      }
      if(race.equals("Dwarf"))
      {
         str+=statGen(2);
         def+=statGen(3);
         spd+=statGen(2);
         agl+=statGen(1);
         iq+=statGen(3);
         mag+=statGen(1);
         
      }
      if(race.equals("Goblin"))
      {
         str+=statGen(1);
         def+=statGen(1);
         spd+=statGen(3);
         agl+=statGen(3);
         iq+=statGen(2);
         mag+=statGen(2);
         
      }
      if(race.equals("Ogre"))
      {
         str+=statGen(3);
         def+=statGen(3);
         spd+=statGen(1);
         agl+=statGen(2);
         iq+=statGen(1);
         mag+=statGen(2);
         
      }
      if(race.equals("Druid"))
      {
         str+=statGen(2);
         def+=statGen(2);
         spd+=statGen(1);
         agl+=statGen(1);
         iq+=statGen(3);
         mag+=statGen(3);
         
      }
      if(race.equals("Orc"))
      {
         str+=statGen(3);
         def+=statGen(2);
         spd+=statGen(3);
         agl+=statGen(2);
         iq+=statGen(1);
         mag+=statGen(1);
         
      }
      
      if(sex.equals("Male"))
      {
         str+=statGen(3);
         def+=statGen(3);
         spd+=statGen(3);
         agl+=statGen(1);
         iq+=statGen(1);
         mag+=statGen(1);
         
      }
      if(sex.equals("Female"))
      {
         str+=statGen(1);
         def+=statGen(1);
         spd+=statGen(1);
         agl+=statGen(3);
         iq+=statGen(3);
         mag+=statGen(3);
         
      }
         
   }
   public int statGen(int c)
   {
      if(c==1)
         return (int)(Math.random()*12);
      else if(c==3)
         return (int)(Math.random()*11+23);
      else
         return (int)(Math.random()*11+12);
   }
   
   public int getStr()
   {
      return str;
   }
   public void setStr(int str)
   {
      this.str=str;
   }
   
   public int getDef()
   {
      return def;
   }
   public void setDef(int def)
   {
      this.def=def;
   }
   
   public int getSpd()
   {
      return spd;
   }
   public void setSpd(int spd)
   {
      this.spd=spd;
   }
   
   public int getAgl()
   {
      return agl;
   }
   public void setAgl(int agl)
   {
      this.agl=agl;
   }
   
   public int getIQ()
   {
      return iq;
   }
   public void setIQ(int iq)
   {
      this.iq=iq;
   }
   
   public int getMag()
   {
      return mag;
   }
   public void setMag(int mag)
   {
      this.mag=mag;
   }
   
   public int getLck()
   {
      return lck;
   }
   public void setLck(int lck)
   {
      this.lck=lck;
   }
   
   
   public int getHP()
   {
      return hp;
   }
   public void setHP(int hp)
   {
      this.hp=hp;
   }
   
   public void setStats(String name, String sex, String race, String clique) //returns name
   {
      this.name=name;
      this.sex=sex;
      this.race=race;
      this.clique=clique;
      generateStats();
   }
   public String getName() //returns name
   {
      return name;
   }
   public String getSex() //returns clique
   {
      return sex;
   }   
   public String getRace() //returns clique
   {
      return race;
   }
   public String getClique() //returns clique
   {
      return clique;
   }
   public String toString() //Allows for easy printing of Object Variables
   {
      return "Name: "+name+"\tClique: "+clique+"\tRace: "+race+"   Gender: "+sex+"\nStats:\nStrength: "+str+"\nDefense: "+def+"\nSpeed: "+spd+"\nAgility: "+agl+"\nIntelligence: "+iq+"\nMagic: "+mag+"\nLuck: "+lck+"\nHealth: "+hp;
   }
  // public void fight(Warrior other) //Allowes Warriors to fight eachother, winnner is based off their stats
//   {
  //    if(this.iq-20>other.iq)
    //  {
      //   System.out.println(this.name+" wins by IQ");
//      }
  //    else if(other.iq-20>this.iq)
    //  {
      //   System.out.println(other.name+" wins by IQ");
      //}
   //   else if(this.strength>other.strength)
    //  {
      //   System.out.println(this.name+" wins by Strength");
     // }
      //else if(this.strength<other.strength)
    //  {
        // System.out.println(other.name+" wins by Strength");
      //}
     // else
      //{
      //System.out.println("No winner");
   //   }
  // }
}
