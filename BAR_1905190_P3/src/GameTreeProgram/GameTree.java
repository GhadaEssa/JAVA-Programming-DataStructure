 
package GameTreeProgram;

import java.io.PrintWriter;
/*
        
       Student name:Ghada Essa Al-sulami
        ID:1905190
        Section:BAR
        Emai:Galsulmi0005@stu.kau.edu.sa
        Assignmet 3:Binary Search Tree Program
        Date: 10/11/2021
         */
        
 

 
public class GameTree {
    private PlayerNode root;

    
    //-----Constructor---------------------------
    public GameTree() {
        this.root = null;
    }
    
    
    //------------------------------------------

    public PlayerNode getRoot() {
        return root;
    }
    
    
    
    
    
    //-----Operations/Methods--------------------
    
    
    
    public void add_player(PlayerNode player) {
		PlayerNode newplayer = player;
		root=add_player(root,newplayer);
	}
    
    
    
      
    
    
    private PlayerNode add_player(PlayerNode p, PlayerNode newPlayer) {

        if (p == null) {
            return newPlayer;
        } else {

            if (newPlayer.getPlayerID() > p.getPlayerID()) {

                PlayerNode temp = add_player(p.getRight(), newPlayer);

                p.setRight(temp);
            } else {

                PlayerNode temp = add_player(p.getLeft(), newPlayer);

                p.setLeft(temp);
            }
        }

        return p;

    }

   //=========================================== 
    public void update_player(PlayerNode player ){
        
        player.setStamina(player.getStamina()-5);
        
        
    }
    //========Delete Methods=================================

    public PlayerNode parent(PlayerNode player) {
        return parent(root, player);
    }

    private PlayerNode parent(PlayerNode root, PlayerNode p) {

        if (root == null || root == p) {
            return null;
        }

        if (root.getLeft() == p || root.getRight() == p) {
            return root;
        }

        if (p.getPlayerID() < root.getPlayerID()) {
            return parent(root.getLeft(), p);
        } else if (p.getPlayerID() > root.getPlayerID()) {
            return parent(root.getRight(), p);
        } else {
            return null;
        }
    }
	

     
    //------------------isLeaf------------------------------
    public boolean isLeaf(PlayerNode player) {
		return (player.getLeft()==null && player.getRight()==null);
	}
	
    //-------------------hasOnlyLeftChildMethod--------------
    public boolean hasOnlyLeftChild(PlayerNode player) {
		return (player.getLeft()!=null && player.getRight()==null);
	}
    //---------------------hasOnlyRightChildMethod------------
    public boolean hasOnlyRightChild(PlayerNode player) {
		return (player.getLeft()==null && player.getRight()!=null);
	}
    //------------------------MinMethod-----------------------
    public PlayerNode minPlayer(PlayerNode player) {
        if (player == null) {
            return null;
        }
        else {
            if (player.getLeft() == null) {
                return player;
            }
            else {
                return minPlayer(player.getLeft());
            }
        }
    }
    
    
  //---------------------------MaxMethod-----------------------  
     public PlayerNode maxPlayer(PlayerNode player) {
        if (player == null) {
            return null;
        }
        else {
            if (player.getRight() == null) {
                return player;
            }
            else {
                return maxPlayer(player.getRight());
            }
        }
    }
    
    
    //---------------------------------------------------------
    
    public void delete_player(int ID) {
		root= delete_player(root, ID);
	}
    
    
    
    
    private PlayerNode delete_player(PlayerNode player, int ID) {

        PlayerNode deletePlayer, newDeletePlayer, playerParent;
        int saveIDValue;

        deletePlayer = display_player_by_ID(player, ID);
        // check if the player  doesn't exist , we clearly cannot delete it

        if (deletePlayer == null) {

            return root;
        }
        //Find the parent of the player node we want to delete   

        playerParent = parent(player, deletePlayer);

        //perform Deletion based on three possibilities
        if (isLeaf(deletePlayer)) {

            if (playerParent == null) {

                return null;

            }
            if (ID < playerParent.getPlayerID()) {
                playerParent.setLeft(null);

            } else {
                playerParent.setRight(null);

            }
            return player;

        }

        if (hasOnlyLeftChild(deletePlayer)) {

            if (playerParent == null) {
                return deletePlayer.getLeft();
            }

            if (ID < playerParent.getPlayerID()) {
                playerParent.setLeft(playerParent.getLeft().getLeft());
            } else {
                playerParent.setRight(playerParent.getRight().getLeft());
            }

            return player;

        }

        if (hasOnlyRightChild(deletePlayer)) {

            // if deletePlayer is the root
            if (playerParent == null) {
                return deletePlayer.getRight();
            }

            // If deletePlayer is not the root,
            // it must the left OR the right child of some node
            // IF it is the left child of some node
            if (ID < playerParent.getPlayerID()) {
                playerParent.setLeft(playerParent.getLeft().getRight());
            } // ELSE it is the right child of some node
            else {
                playerParent.setRight(playerParent.getRight().getRight());
            }

            // Finally, return the root of the tree (in case the root got updated)
            return player;
        }

        newDeletePlayer = maxPlayer(deletePlayer.getLeft());/*Here depend on the output file we will 
        replace with the miximum value of the left subtree*/

        saveIDValue = newDeletePlayer.getPlayerID();

        player = delete_player(player, saveIDValue);
        deletePlayer.setPlayerID(saveIDValue);
        deletePlayer.setStamina(newDeletePlayer.getStamina());
        deletePlayer.setPlayername(newDeletePlayer.getPlayername());

        return player;

    }

    //=========================================
     public void display_all_players_info(PlayerNode root,PrintWriter output){
      
         if (root != null) {
       
      output.printf("\t%-15d %-20s %d\n",root.getPlayerID(),root.getPlayername(),root.getStamina());   
      display_all_players_info(root.getLeft(),output);
      display_all_players_info(root.getRight(),output);
       
    
    }
         
          
    
    }
    //==============Count the number of players===========================
     
    public int num_of_players(PlayerNode p){
    if (p == null) {
            return 0;
        } else {
             
                return 1 + num_of_players(p.getLeft()) + num_of_players(p.getRight());
            
                
            }
        }
    
     
   //=========================================
     
     public PlayerNode display_player_by_ID(PlayerNode p,int ID){
      if (p == null)
			return null;
		else {
			// if  ID is equal to the currenr root return player
			if (ID == p.getPlayerID())
				return p;
                        // if  ID is less than to the currenr root search on left subtree
			else if (ID < p.getPlayerID())
				return display_player_by_ID(p.getLeft(),ID);
			else
				return display_player_by_ID(p.getRight(), ID);
		}
 
     }
    
    
    
    
    
    
    //=============SearchMethod==========================
    
    public boolean recurSearch(PlayerNode playerNode,int ID) { 
   if (playerNode == null) 
      return(false); 
   if (ID == playerNode.getPlayerID()) 
      return(true); 
   else if (ID < playerNode.getPlayerID()) 
            return(recurSearch(playerNode.getLeft(),ID)); 
        else
            return(recurSearch(playerNode.getRight(),ID)); 
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
