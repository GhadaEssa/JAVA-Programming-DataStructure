 
package GameTreeProgram;
 
import java.io.*;
import java.util.Scanner;

public class MainProgram {
 
    public static void main(String[] args)throws Exception {
         
        
 /*
        
       Student name:Ghada Essa Al-sulami
        ID:1905190
        Section:BAR
        Emai:Galsulmi0005@stu.kau.edu.sa
        Assignmet 3:Binary Search Tree Program
        Date: 10/11/2021
         */
        
        
     
        
        
       File intialInfoFile=new File("IntialInformationProgram.txt");
       File commandsFile=new File("CommandsProgram.txt"); 
        
        if (!(intialInfoFile.exists())||!(commandsFile.exists())) {
         throw new FileNotFoundException("file doesn't exist ");   
        }
       //----------Scanner------------------------ 
       Scanner readInfo=new Scanner(intialInfoFile); 
       Scanner readCommand=new Scanner(commandsFile);  
       //--------output--------------------------- 
       PrintWriter output=new  PrintWriter("output.txt");
       output.println("	Welcome to Game Tree Program\n" +
"       ---------------------------------------------------------");
       //------Create tree---------------------------------
       GameTree playerNodes=new GameTree();
        String command;
        
       while(readCommand.hasNext()){
       
       command=readCommand.next();
       
        if (command.equalsIgnoreCase("STARTUP")) {
               STARTUP(readInfo,playerNodes);  
            } else if (command.equalsIgnoreCase("DISPLAY_ALL_PLAYERS")) {
                output.println("The players existed in the game are:\n\n");
                output.println("       PlayerID         Player Name      Stamina level");
                output.println("---------------------------------------------------");
                DISPLAY_ALL_PLAYERS(output,playerNodes);
                output.println("\n===================================================================================================\n");
            } else if (command.equalsIgnoreCase("NUM_OF_PLAYERS")) {
                int numOfPlayers=NUM_OF_PLAYERS(playerNodes);
                output.println("Number of players : "+numOfPlayers);
                 output.println("===================================================================================================\n");
            } else if (command.equalsIgnoreCase("DISPLAY_PLAYER_INFO")) {
                DISPLAY_PLAYER_INFO(readCommand, playerNodes,output);
                output.println("===================================================================================================\n");
            } else if (command.equalsIgnoreCase("ADD_PLAYER")) {
               ADD_PLAYER(readCommand,playerNodes);
            } else if (command.equalsIgnoreCase("DELETE_PLAYER")) {
               DELETE_PLAYER( readCommand,playerNodes,output);
               output.println("===================================================================================================\n");
            } else if (command.equalsIgnoreCase("UPDATE_PLAYER_INFO")) {
               UPDATE_PLAYER_INFO(readCommand,playerNodes,output);       
                output.println("===================================================================================================\n");     
            } else if (command.equalsIgnoreCase("QUIT")) {
            output.print("\n			-------------------------------------\n"
                    + "	   	       |	     Good Bye                 |\n"
                    + "                        -------------------------------------");

        }
       
    
       
       
       }
        
       readInfo.close();
       readCommand.close();
       output.flush();
       output.close();
        
        
        
        
    }//main class
    
 //-----------------------STARTUP------------------------------------ 
    /*This command will create tne nodes of BST*/
    
    public static void STARTUP(Scanner input,  GameTree playerNodes){
  
        int numberOfPlayers=input.nextInt();
        for (int i = 0; i < numberOfPlayers; i++) {
         int playerID=input.nextInt();
         String Playername=input.next();
        playerNodes.add_player(new PlayerNode(playerID,Playername));
         
        
        }
        
          
      }
      
  //-------------------DISPLAY_ALL_PLAYERS----------------------------
     /*This command will display all players information */
    public static void  DISPLAY_ALL_PLAYERS(PrintWriter output, GameTree playerNodes){
         PlayerNode root=playerNodes.getRoot();
         playerNodes.display_all_players_info(root,output);
        
        }
        
  //--------------------NUM_OF_PLAYERS---------------------------------
    /*The command will counts the number of player in BST and return it */
     public static int  NUM_OF_PLAYERS(GameTree playerNodes){
         PlayerNode root=playerNodes.getRoot();
         int numberOfPlayers=playerNodes.num_of_players(root);
         return numberOfPlayers;
        }
      
//----------------------DISPLAY_PLAYER_INFO----------------------------
/*The command will display player information based on his ID*/
 public static void  DISPLAY_PLAYER_INFO(Scanner input,GameTree playerNodes,PrintWriter output){
         PlayerNode root=playerNodes.getRoot();
         int ID=input.nextInt();
         boolean isFound=playerNodes.recurSearch(root,ID);
          
         if(isFound){
         PlayerNode playerTemp=playerNodes.display_player_by_ID(root, ID);
         output.println("Player with ID <"+ID+"> is <"+playerTemp.getPlayername()+"> and the stamina level is <"+playerTemp.getStamina()+">");
         }else{
         
         output.println("Not found any player with ID number <"+ID+">");
         
         }
        
 }
 //------------------------ADD_PLAYER------------------------------------
 /*The command will add player node into BST*/
   public static void  ADD_PLAYER(Scanner input,GameTree playerNodes){
       int playerID = input.nextInt();
       String Playername = input.next();
       playerNodes.add_player(new PlayerNode(playerID,Playername));
  
   
   }
//-------------------------------DELETE_PLAYER------------------------------------
 /*The command will checks if the player exists then return the deleted player 
   and send this player to the delete_player method to remove it from BST*/
    public static void  DELETE_PLAYER(Scanner input,GameTree playerNodes,PrintWriter output){
        PlayerNode root=playerNodes.getRoot();
        int playerID = input.nextInt();
        
        boolean isFound=playerNodes.recurSearch(root,playerID);
        
         if(isFound){
          PlayerNode deletedPlayer=playerNodes.display_player_by_ID(root,playerID);
          playerNodes.delete_player(playerID); 
          output.println("The player <"+deletedPlayer.getPlayername()+"> left the game ");
          
         }else{
           
           output.println("Not found any player with ID number <"+playerID+">");
         
         }
          
   
   }
   //------------------------------- UPDATE_PLAYER_INFO-------------------------
    /*The command will reduce the level by 5 when the player take a hit
    ,and once the level come up to zero, have to delete  it from BST  */
    
    public static void  UPDATE_PLAYER_INFO(Scanner input,GameTree playerNodes,PrintWriter output){
       
        
        PlayerNode root=playerNodes.getRoot();
        int playerID = input.nextInt();
        PlayerNode findPlayer=playerNodes.display_player_by_ID(root,playerID);
        boolean isFound=playerNodes.recurSearch(root,playerID);
          
         if(isFound){
               
               playerNodes.update_player(findPlayer);
             if (findPlayer.getStamina()==0 ) {
                 output.println("The stamina level for the player <"+findPlayer.getPlayername()+"> reaches zero and <"+findPlayer.getPlayername()+"> left the game!â€");
                 playerNodes.delete_player(playerID); 
                    
             }
             else
                  output.println("The player <"+findPlayer.getPlayername()+"> received a hit and the stamina level reduced by 5");
          
         }else{
           
           output.println("Not found any player with ID number <"+playerID+">");
         
         }
        
      
         
   
   }
  
   
   
}
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
