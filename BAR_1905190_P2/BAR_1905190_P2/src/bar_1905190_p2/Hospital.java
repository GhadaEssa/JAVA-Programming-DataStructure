 
package bar_1905190_p2;
 
import java.util.ArrayList;
/*
        
       Student name:Ghada Essa Al-sulami
        ID:1905190
        Section:BAR
        Emai:Galsulmi0005@stu.kau.edu.sa
        Assignmet 2: Question 3
        Date: 1/11/2021
         */
   
public class Hospital {
 private String SiteName="";
 private ArrayList<String>sites=new ArrayList<>();
 private int cost=0;   

 //-------------------------------------------------------------- 

    public Hospital(String SiteName, ArrayList<String> sites, int cost) {
        this.SiteName = SiteName;
        this.sites = sites;
        this.cost = cost;
    }
//--------------------------------------------------------------
    public String getSiteName() {
        return SiteName;
    }

    public ArrayList<String> getSites() {
        return sites;
    }

    public int getCost() {
        return cost;
    }
//--------------------------------------------------------------
    public void setSiteName(String SiteName) {
        this.SiteName = SiteName;
    }

    public void setSites(ArrayList<String> sites) {
        this.sites = sites;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return SiteName ;
    }

   
    
 
    
    
    
}
