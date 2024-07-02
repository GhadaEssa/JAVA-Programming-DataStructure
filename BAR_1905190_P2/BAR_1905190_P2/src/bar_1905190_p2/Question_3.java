 
package bar_1905190_p2;
 
import java.io.File;
import java.util.ArrayList;
 
 
import java.util.Scanner;
 

public class Question_3 {
 
    /*
        
       Student name:Ghada Essa Al-sulami
        ID:1905190
        Section:BAR
        Emai:Galsulmi0005@stu.kau.edu.sa
        Assignmet 2: Question 3
        Date: 1/11/2021
         */
   
   
    public static void printBestCoverage(int i, Hospital[] hospitals, int fund, ArrayList<Hospital> maxSites, int sum, Hospital hospital, int difference) {
       System.out.print("Suppose total available funds (budget) are: SARs 80,000,000.");
       ArrayList<Hospital> storageTemp = bestCoverage(1, hospitals, fund, maxSites, 0, hospitals[0], hospitals[0].getCost() - hospitals[0].getCost());
        System.out.print("The optimal coverage is ");
        System.out.print(storageTemp.toString());
        ArrayList<String> districts = new ArrayList<>();
        ArrayList<String> tempSite;
        for (int j = 0; j < maxSites.size(); j++) {
            tempSite = maxSites.get(j).getSites();

            for (int k = 0; k < tempSite.size(); k++) {

                if (!districts.contains(tempSite.get(k))) {
                     
                    districts.add(tempSite.get(k));

                }

            }

        }

        System.out.println(" covers "+districts.size()+" districts.");

    }


   
   
   
   
   
   
   
   
   
   
   //--------------------------------------------------------------------------------------------------------
   public static  ArrayList<Hospital> bestCoverage(int i,Hospital[] hospitals,int fund,ArrayList<Hospital> maxSites ,int sum,Hospital hospital,int difference){
   
    
       
   
     
      
      if(i<hospitals.length){
       difference=hospitals[i].getCost()-hospital.getCost();
       
         if(difference>=hospital.getCost()){
  
             
        
       int difference2=Math.abs(difference); 
       bestCoverage(i+1,hospitals,fund, maxSites ,sum+hospitals[i].getCost(),hospital,difference2); 
               
         }
        
        
      else  {
        
        
       int difference2=Math.abs(difference); 
       //------------------------------------------------------
        maxSites.add(hospitals[i]);
       
  
       bestCoverage(i+1,hospitals,fund,maxSites,sum+hospitals[i].getCost(),hospital,difference2);
       
      }
       
        
       
      
       }
   
   
       
      
   
    
   return maxSites;  
  
   }
    
   
     
   
   
   
   //--------------------------------------------------------------------------------------------------------
   
   
   
   
   
   
      

      
    
    
    public static void main(String[] args) throws Exception{
        
        
       File inputFile=new File("input.txt") ;
        
        if(!inputFile.exists()){
        
            System.out.println("File doesn't exist");
        
        }
        
       Scanner read=new Scanner(inputFile); 
        
        int constantCost=read.nextInt();
        Hospital[] hospitals=new Hospital[read.nextInt()];
         
        for (int i = 0; i <hospitals.length; i++) {
        ArrayList<String> sites=new ArrayList<>();
            String siteName=read.next();
           
         while(!(read.hasNextInt())){
        String temp=read.next();
             if(!temp.equalsIgnoreCase("cost")){
             sites.add(temp);
             
        }
         }
            
           int cost= read.nextInt();
            hospitals[i] = new Hospital(siteName,sites,cost) ; 
             
        }
        
       
      
      
      
       ArrayList<Hospital> hospitalsCover=new ArrayList<>();
       hospitalsCover.add(hospitals[0]);
      ArrayList<String> sitesCoverUpdate =new ArrayList<>();
      ArrayList<String> sites =hospitals[0].getSites() ;
        for (int i = 0; i < sites.size(); i++) {
          sitesCoverUpdate.add(sites.get(i));
        }
      
     printBestCoverage(1,hospitals,constantCost, hospitalsCover,0,hospitals[0],hospitals[0].getCost()-hospitals[0].getCost()); 
       
       
       
       
       
       
    }
    
}
