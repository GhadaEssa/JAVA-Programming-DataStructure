 
package GameTreeProgram;
 /*
        
       Student name:Ghada Essa Al-sulami
        ID:1905190
        Section:BAR
        Emai:Galsulmi0005@stu.kau.edu.sa
        Assignmet 3:Binary Search Tree Program
        Date: 10/11/2021
         */
        
public class PlayerNode {
  private int playerID; 
  private String Playername; 
  private int stamina; 
  private PlayerNode right; 
  private PlayerNode left; 
  
  //-----Constructor---------------------------

    public PlayerNode(int playerID, String Playername) {
        this.playerID = playerID;
        this.Playername = Playername;
        this.stamina = 15;
        left = right = null;
    }

    public PlayerNode(int playerID, String Playername, int stamina, PlayerNode right, PlayerNode left) {
        this.playerID = playerID;
        this.Playername = Playername;
        this.stamina = stamina;
        this.right = right;
        this.left = left;
    }

    
    
    
    //-----Setters Method---------------------------
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setPlayername(String Playername) {
        this.Playername = Playername;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setRight(PlayerNode right) {
        this.right = right;
    }

     
    public void setLeft(PlayerNode left) {
        this.left = left;
    }

    
    
    
    //-----Getters Method---------------------------
    public int getPlayerID() {
        return playerID;
    }

    public String getPlayername() {
        return Playername;
    }

    public int getStamina() {
        return stamina;
    }

    public PlayerNode getRight() {
        return right;
    }

    public PlayerNode getLeft() {
        return left;
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
