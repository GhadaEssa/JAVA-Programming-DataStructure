package StudentsDistribution;
 /*
        
       Student name:Ghada Essa Al-sulami
        ID:1905190
        Section:BAR
        Emai:Galsulmi0005@stu.kau.edu.sa
        Assignmet 1:KAU Vaccination Centers Management System
        Date: 10/5/2021
         */

public class Center {
  private int centerID;
  private String centerName;
  private int capacity;
  private Practitioner head; 

    public Center(int centerID,int capacity) {
        this.centerID = centerID;
        this.capacity = capacity;
        centerName=null;
        
    }
    public Center(int centerID) {
        this.centerID = centerID;
         
    }
    public Center() {
         
         
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterName() {
        return centerName;
    }
    
    
    public int getCenterID() {
        return centerID;
    }

    public void setCenterID(int centerID) {
        this.centerID = centerID;
    }

    public Practitioner getHead() {
        return head;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
  
   public boolean isEmpty() {
         
    return head==null;   
   
   }
  
   public void clearCenter() {
         
    this.head=null;   
   
   }
  
  
  // --------------------add Mthod-------------------------
    
    public void addPractitioner(Practitioner practitioner) {

        
        if (isEmpty()) {
             
            this.head = practitioner;   
             
        } else {
            
            Practitioner hlpPtr = head; 
            while (hlpPtr.getNext() != null) {
                hlpPtr = hlpPtr.getNext(); 
           
            } 

             hlpPtr.setNext(practitioner);  
        }

    }
   //----------------------Search Method----------------------------
   public Practitioner searchByID(String id) {
		return searchByID(head, id);
	}
	 
	private Practitioner searchByID(Practitioner practitioner, String id) {
		Practitioner helpPtr = practitioner;
		while (helpPtr != null) {
			if (helpPtr.getParctID().equalsIgnoreCase(id))
				return helpPtr;
			helpPtr = helpPtr.getNext();			
		}
		return null;
	}
        
        
        
   //------------------------delete Practitioners Based On Status--------------------------------
       
 public void deletePractitionersBasedOnStatus(String status) {

        if (head.getStatus().equalsIgnoreCase(status)) {
            head = head.getNext();
        } else {

            Practitioner helpPtr = head;
            while (helpPtr.getNext() != null) {
                if (helpPtr.getNext().getStatus().equalsIgnoreCase(status)) {
                     helpPtr.setNext(helpPtr.getNext().getNext()); 
                    
                }

                helpPtr = helpPtr.getNext();

            }

        }

    }
         
  //--------------------delete Practitioner By Id-----------------------------------------------      
        
public void deletePractitionerById(String id) {

        if (head.getParctID().equalsIgnoreCase(id)) {
            head = head.getNext(); 
        } else {

            Practitioner helpPtr = head;
            while (helpPtr.getNext() != null) {
                if (helpPtr.getNext().getParctID().equalsIgnoreCase(id)) {
                    
                    helpPtr.setNext(helpPtr.getNext().getNext()); 
                   break;
                 
                }

                helpPtr = helpPtr.getNext();

            }

        }

    }
         
        
    
     
         
        
  














        
        
        }   
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   
 
  
  
  
  
  
  
  
  
  
  
  
  