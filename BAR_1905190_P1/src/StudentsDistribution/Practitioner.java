 
package StudentsDistribution;

 /*
        
       Student name:Ghada Essa Al-sulami
        ID:1905190
        Section:BAR
        Emai:Galsulmi0005@stu.kau.edu.sa
        Assignmet 1:KAU Vaccination Centers Management System
        Date: 10/5/2021
         */
 
 
public class Practitioner {
   
    private String parctID;
    private String Fname;
    private String IName;
    private String Status;
    private int center;
    private Practitioner next;

    
    
    
     public Practitioner(String parctID, String Fname, String IName, int center) {
        this(parctID, Fname,   IName, "Exist", center);
        
    }
    
    
    
    public Practitioner(String parctID, String Fname, String IName, String Status, int center) {
        this.parctID = parctID;
        this.Fname = Fname;
        this.IName = IName;
        this.Status = Status;
        this.center = center;
        
    }

    public String getParctID() {
        return parctID;
    }

    public String getFname() {
        return Fname;
    }

    public String getIName() {
        return IName;
    }

    public String getStatus() {
         
        return Status;
        
        
        
    }

    public int getCenter() {
        return center;
    }

    public Practitioner getNext() {
        return next;
    }

    public void setParctID(String parctID) {
        this.parctID = parctID;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setIName(String IName) {
       
        
        this.IName = IName;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setCenter(int center) {
        this.center = center;
    }

    public void setNext(Practitioner next) {
        this.next = next;
    }

    
    
    
    
    @Override
    public String toString() {
        return parctID + " " + Fname + " " + IName + " , " + getStatus()   ;
    }
    
    
    
    
    
    
    
}
