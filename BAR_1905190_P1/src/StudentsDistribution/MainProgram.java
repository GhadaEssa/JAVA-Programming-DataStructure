 
package StudentsDistribution;
 
import java.io.*;
import java.util.*;

 /*
        
       Student name:Ghada Essa Al-sulami
        ID:1905190
        Section:BAR
        Emai:Galsulmi0005@stu.kau.edu.sa
        Assignmet 1:KAU Vaccination Centers Management System
        Date: 10/5/2021
         */



public class MainProgram {
    
    //I declared these here to be sharing by all methods at the same block
    protected static ArrayList<Center> centers=new ArrayList<>();
    protected static int maxCapacity;
    
    
    
    public static void main(String[] args) throws Exception {
      
        
        
     // I created two input files  to read from files.   
     File  file1=new File("initialinformation.txt ");  
     File  file2=new File("commands.txt ");   
      
     /*The condition checks either file1 or file2  then throws an exception 
     */
     
     if(!(file1.exists()||file2.exists())){
          
      throw new FileNotFoundException("file doesn't exist ");
          
      }  
        
      // now, we sure that file is existing, and we can created two scanner to read from these file
     Scanner input1= new Scanner(file1);
     Scanner input2= new Scanner(file2);
     
     //this is a third file to print on it.
     PrintWriter output=new PrintWriter("output.txt");  
        
     output.println("	Welcome to the KAU Vaccination Centers Management System\n" +
"       ---------------------------------------------------------");
        
        
      
     /* a string variable reads a command from the commands.txt file
     to enter inside a pecific condition
     */
     String command;
     
        while (input2.hasNext()) {// while the pointer has next string statement please continous loop

            command = input2.next();

           
            
            
            if (command.equalsIgnoreCase("STARTUP")) {
                 STARTUP(input1,output);
            } else if (command.equalsIgnoreCase("DISPLAY_ALL_CENTERS")) {
                  output.println(" \nThe first distribution for health practitioners among the vaccination centers \n" +
"===================================================================================================\n");
        
                DISPLAY_ALL_CENTERS(output);
            } else if (command.equalsIgnoreCase("NUM_PRACTIONERS")) {
                  NUM_PRACTIONERS(input2, output);
            } else if (command.equalsIgnoreCase("DISPLAY_ALL_BASED_ON_STATUS")) {
               DISPLAY_ALL_BASED_ON_STATUS(input2, output);
            } else if (command.equalsIgnoreCase("DISPLAY_BASED_ON_STATUS")) {
               DISPLAY_BASED_ON_STATUS(input2, output);
            } else if (command.equalsIgnoreCase("LEAVE_THE_JOB")) {
                LEAVE_THE_JOB(input2, output);
            } else if (command.equalsIgnoreCase("MOVE")) {
                      MOVE(input2, output);
            } else if (command.equalsIgnoreCase("DISPLAY")) {
                       DISPLAY(  input2,output);
            } else if (command.equalsIgnoreCase("REMOVE_ALL_LEFT_PRACTITIONERS")) {
                      REMOVE_ALL_LEFT_PRACTITIONERS(output);
                     output.println("\n        The remaining practitioners After remove the practitioners of status left\n"
                        + "	------------------------------------------------------------------------");
                     DISPLAY_ALL_CENTERS(output);
                     
            } else if (command.equalsIgnoreCase("DELETE_CENTER")) {
                 DELETE_CENTER(input2,output);
                  
            } else if (command.equalsIgnoreCase("MERGE")) {
                       MERGE(output);
            } else if (command.equalsIgnoreCase("QUIT")) {
                output.println("\n			-------------------------------------\n"
                        + "	   	       |	     Good Bye                 |\n"
                        + "                        -------------------------------------                         \n"
                        + "\n");
                
            }

        }

     //close input file
    input1.close();
    input2.close();
    //close output files
     output.flush();
     output.close();
    }//main method

 
    
    /*
    The method compares between the capacity of all centers 
    ,and stores the largesr one.*/
    public static void MaxCapacity(){
      
     int centerCapacity;
     maxCapacity= centers.get(0).getCapacity();//This is an innitial value to be compare
    for (int i = 0; i < centers.size(); i++) {
          centerCapacity=centers.get(i).getCapacity(); 
          if(centerCapacity>=maxCapacity ){
               
           maxCapacity=centerCapacity; 
           
          }
          
   
   }   
  
 }

    
    
    public static void STARTUP(Scanner input,PrintWriter output){
  
      int NumOfcenter=input.nextInt();//ArrayListSize 3 centers
      int centerCapacity;
      
      for (int i = 0; i < NumOfcenter ; i++) {
          centerCapacity=input.nextInt();// center1--> 10, center2--> 6,center3-->4
          centers.add(new Center((i+1),centerCapacity));//create a new object of center in each iteration
          
      }
  
       
      String centerName;
      output.println("The vaccination centers are:");
      for (int i = 0; i < centers.size(); i++) {
        centerName=input.next();// read a center's name 
        output.println("   "+centerName.replaceAll("_"," "));
        centers.get(i).setCenterName(centerName);//sets a name in center obj
      
      }
  
    for (int i = 0; i < centers.size(); i++) {
        
          for (int j = 0; j < centers.get(i).getCapacity(); j++) {
              String parctID=input.next();
              String Fname=input.next();
              String IName=input.next();
              // create an object of type practitioner and add it in a linked list of specific center
              Practitioner practitioner=new Practitioner( parctID,  Fname, IName, (i+1));
              centers.get(i).addPractitioner(practitioner);
          
          }
      
      
      
      }
  
  
  
  }  
    
    
    public static void DISPLAY_ALL_CENTERS(PrintWriter output) {

        int counter;
       
        for (int i = 0; i < centers.size(); i++) { 
            
       String name=centers.get(i).getCenterName().replaceAll("_", " ");
       output.printf("       %-19s ",name);
        
        
        }
        output.println("\n\n--------------------------------------------------------------------------------------------------");
        
         
        MaxCapacity();
        for (int i = 0; i < maxCapacity; i++) {// outer loop keeps a number of iteration to print all nodes
            
             
         /*this loop prints a practitioner of each center and then back to the outer loop */ 
            for (int j = 0; j < centers.size(); j++) {
               
                Practitioner hlpPrt = centers.get(j).getHead();

                counter = 0;
                while (counter != i) {// to tranvers on all nodes 

                    if (hlpPrt != null) {
                        hlpPrt = hlpPrt.getNext();

                    }

                    counter++;
                }

                if (hlpPrt != null) {
                    output.printf("%-30s",hlpPrt.toString());

                }

            }output.println();

        }output.println("===================================================================================================");

    }

    
   //--------------------------------------------------------------------------------------------------------- 
    
  
    
    public static void NUM_PRACTIONERS(Scanner input,PrintWriter output){
  
      int centerID=input.nextInt();//it determines the center
       
      for (int i = 0; i < centers.size(); i++) {
            
      if(centerID==centers.get(i).getCenterID()){
           
      output.println("\nNumber of practitioners in center "+ centerID+": "+centers.get(i).getCapacity());
      }
 
  
      }
  
  output.println("===================================================================================================");
  }     
    
    
   //------------------------------------------------------------------------------------------ 
    
    public static void DISPLAY_ALL_BASED_ON_STATUS(Scanner input, PrintWriter output) {

        String status = input.next();//reed a status
         

        int counter;
        boolean check = false ;
          
        for (int i = 0; i < maxCapacity; i++) {

            for (int j = 0; j < centers.size(); j++) {

                Practitioner hlpPrt = centers.get(j).getHead();

                counter = 0;
                while (counter != i) {

                    if (hlpPrt != null) {
                        hlpPrt = hlpPrt.getNext();

                    }

                    counter++;
                }

                if (hlpPrt != null) {
                   if (hlpPrt.getStatus().equalsIgnoreCase(status)) {
                        
                        check = true;break; //if there is at least one status (true)
                       
                         
                    }
                 
                }

            }

        }    
          

        if (check) {//true

            output.println("\n	The practitioners of status " + status + " are ");
            output.println("	------------------------------------- \n");
            DISPLAY_ALL_CENTERS( output);/* I don't need to write a lot of 
            statments to print , so I have called a build method*/
 

        } else {

            output.println("\nNot found any practitioners of the status " + status);
            output.println("===================================================================================================");
        }

         
    }

    
    
   //==================================================================================================== 
    
    public static void DISPLAY_BASED_ON_STATUS(Scanner input, PrintWriter output){
    
    
    String status=input.next();
    int centerNum=input.nextInt();
    int counter=0,indexOfCenter=0; boolean check=false;
       
    for (int i = 0; i < centers.size(); i++) {

            if (centers.get(i).getCenterID() == centerNum) {
                 
                indexOfCenter=i;// I want to save the center indexs for printing later
                
                for (int j = 0; j < centers.get(i).getCapacity(); j++) {

                    Practitioner hlpPrt = centers.get(i).getHead();// create a help pointer to traverse
                    
                    counter = 0;
                    while (counter != j) {

                        if (hlpPrt != null) {
                            hlpPrt = hlpPrt.getNext();

                        }

                        counter++;
                    }

                    if (hlpPrt != null) {

                        if (hlpPrt.getStatus().equalsIgnoreCase(status)) {
                        check=true;
                        }

                    }

                }

            } 
        
        }
    
   
    if(check){
     output.println("\n	The practitioners of status Exist in center"+ centerNum+" are");
     output.println("        ------------------------------------------------- \n");
     output.println("      			 "+centers.get(indexOfCenter).getCenterName().replaceAll("_", " "));
     output.println("\n-----------------------------------------------------");
     
     for (int j = 0; j < centers.get(indexOfCenter).getCapacity(); j++) { 
         /*I wrote only one loop because I have been 
         stored the number of center above in an indexOfCenter*/
                    Practitioner hlpPrt = centers.get(indexOfCenter).getHead();
                    
                    counter = 0;
                    while (counter != j) {

                        if (hlpPrt != null) {
                            hlpPrt = hlpPrt.getNext();

                        }

                        counter++;
                    }

                    if (hlpPrt != null) {

                        output.println("		"+hlpPrt.toString());

                    }

                }

    
    
    output.println("=======================================================");
    
    }
    
    
    else{ 
   
    output.println("\nNot found any practitioners of the status "+ status +" in center "+centerNum);
    output.println("===================================================================================================");
    
    }
    
    
    
    
    }
    
   //--------------------------------------------------------------------------------------------------------------------- 
    
    
    public static void LEAVE_THE_JOB(Scanner input, PrintWriter output) {
        int counter;
        String PractitionerID = input.next();
        Practitioner practitioner = null;
        for (int i = 0; i < centers.size(); i++) {

            // The method searchByID returns an object after it checked an id.
            practitioner = centers.get(i).searchByID(PractitionerID);
           
            if (practitioner != null) {
                practitioner.setStatus("Left");// change the set to left the job
                output.println("\nThe practitioner of id " + PractitionerID + " is left");
                output.println("\n\tThe practitioners of center " + centers.get(i).getCenterID() + " are ");
                output.println("\t-------------------------------------------------");
                output.println("\n      			 "+centers.get(i).getCenterName().replaceAll("_", " "));
                output.println("\n -----------------------------------------------------");
                
                for (int j = 0; j < centers.get(i).getCapacity(); j++) {

                    counter = 0;
                    Practitioner hlpPrt = centers.get(i).getHead();
                    while (counter != j) {// to move the help pointer 
                        if (hlpPrt != null) {
                            hlpPrt = hlpPrt.getNext();
                        }
                        counter++;
                    }

                    output.println("		"+hlpPrt.toString());
                }

            }

        }

    output.println("=======================================================");
    
    }

//-----------------------------------------------------------------------------------------------
    public static void MOVE( Scanner input, PrintWriter output){
    
    String pracID=input.next();
    int centerNum=input.nextInt();    
    Practitioner pract=null, newPract=null;    
        for (int i = 0; i < centers.size(); i++) {

            pract = centers.get(i).searchByID(pracID);
            if (pract != null) {

                newPract = new Practitioner(pract.getParctID(), pract.getFname(), pract.getIName(), "Moved", centerNum);
                centers.get(i).deletePractitionerById(pracID);
                /* decrement the capacity because when print all center 
                I don't want print the space of moved practitioner */
                centers.get(i).setCapacity(centers.get(i).getCapacity()-1); 
                 
               
            } 
          
              
              }
                
        for (int j = 0; j < centers.size(); j++) {

           
            if (centers.get(j).getCenterID() == centerNum) {
                  
                if (newPract != null) {
                    centers.get(j).addPractitioner(newPract);
                     centers.get(j).setCapacity( centers.get(j).getCapacity()+1);
                }
                  
                output.println("\n	The Practitioner of id " + pracID + " is moved to center " + centers.get(j).getCenterID());
                output.println("	------------------------------------------------");
                
                DISPLAY_ALL_CENTERS(output);
 
            } 
            

        }
        
          
         
    }

    
   //------------------------------------------------------------------------ 
    
    
    public static void DISPLAY( Scanner input, PrintWriter output){
    
    
    int centerNum=input.nextInt();    
     
    
    
     for (int i = 0; i < centers.size(); i++) {
         
             
         
                    if (centers.get(i).getCenterID() == centerNum) {
               
              output.println("\n        The practitioners of center "+centerNum+" are");
              output.println("        -------------------------------------------------\n");
              output.println("     			 "+centers.get(i).getCenterName().replaceAll("_", " ") );
              output.println("\n-----------------------------------------------------");
             for (int j = 0; j < centers.get(i).getCapacity(); j++) {

                 Practitioner hlpPrt = centers.get(i).getHead();

                 int counter = 0;
                 while (counter != j) {

                     if (hlpPrt != null) {
                         hlpPrt = hlpPrt.getNext();

                     }

                     counter++;
                 }

                 if (hlpPrt != null) {

                     output.println("		" + hlpPrt.toString());

                 }

             }
         }
    
     }
     
    output.println("=======================================================\n");
    

     }

    //------------------------------------------------------------------------------------
    
    public static void REMOVE_ALL_LEFT_PRACTITIONERS(PrintWriter output){
    
       output.println(" 	All left Practitioners are moved to new linked list\n" +
"	---------------------------------------------------");
    Center newCenter= new Center(0);   
    
        for (int i = 0; i < centers.size(); i++) {

            Practitioner hlpPrt = centers.get(i).getHead();
 
            while (hlpPrt != null) {

                if (hlpPrt.getStatus().equalsIgnoreCase("Left")) {
 
                    Practitioner leftPractitioner = new Practitioner(hlpPrt.getParctID(), hlpPrt.getFname(), hlpPrt.getIName(), hlpPrt.getStatus(), hlpPrt.getCenter());
                     newCenter.addPractitioner(leftPractitioner);
                       output.println(hlpPrt.toString());
                         /* decrement the capacity because when print all center 
                           I don't want print the space of 'lefted practitioner '*/
                       
                       centers.get(i).setCapacity(centers.get(i).getCapacity()-1);
                }

                hlpPrt = hlpPrt.getNext();

            }
                
            
    centers.get(i).deletePractitionersBasedOnStatus("Left");
        
    }
     
     

    }

    
    
    //----------------------------------------------------------------------------------------
    
    public static void DELETE_CENTER(Scanner input,PrintWriter output){
    
       int centerNum=input.nextInt();
       Center tempCenter=null;
       /*I declared a temporary center 
       to store the required one and remove it from  array list after clears the linked list*/  
        for (int i = 0; i < centers.size(); i++) {

            if (centers.get(i).getCenterID() == centerNum) {
                tempCenter = centers.get(i);
                tempCenter.clearCenter();
                break;
            }

        }
 
    centers.remove(tempCenter);
    output.println("\n  			Center "+centerNum+" is Closed\n" +
"===================================================================================================");
    }
     
     
    public static void MERGE(PrintWriter output){
    /*In this method, I created a new Center to collect all remaining 
        practitioner into it by copying a practitioner from each center , and also printin a new center*/
        
        
        
    output.println("\n			The remaining centers are merged");
    output.println("\n--------------------------------------------------------------------------------------------------");
      Center newCenter=new Center();  //a new center
      // copying The practitioner information  and add it to new one 
     for (int i = 0; i < centers.size(); i++) {
          
          
     Practitioner hlpPtr=centers.get(i).getHead() ;
     
         while (hlpPtr != null) {

             String parctID = hlpPtr.getParctID();
             String Fname = hlpPtr.getFname();
             String IName = hlpPtr.getIName();
             String Status = hlpPtr.getStatus();
             int center = hlpPtr.getCenter();

             newCenter.addPractitioner(new Practitioner(parctID, Fname, IName, Status, center));
             hlpPtr = hlpPtr.getNext();
         }
     
     }
        
      // ptint a new merged center
    Practitioner newPointer=newCenter.getHead();
     
     
        while (newPointer != null) {
            output.println(newPointer.toString());
            newPointer = newPointer.getNext();
        }
     
      output.println("===================================================================================================");
        
        
    }
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
   
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    


