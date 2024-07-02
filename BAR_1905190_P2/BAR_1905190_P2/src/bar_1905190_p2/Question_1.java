/*
        
       Student name:Ghada Essa Al-sulami
        ID:1905190
        Section:BAR
        Emai:Galsulmi0005@stu.kau.edu.sa
        Assignmet 2: Question 1
        Date: 1/11/2021
         */
   
package bar_1905190_p2;

import java.util.Scanner;
 
   
public class Question_1 {
public static void  printAllPossibleOutcomes( int nTimes,String updateCard,String card , int numOfLetter)  {
       int i = 0;
       if (nTimes == 0) {
       System.out.println(updateCard);
       return;
       }
       while(i< numOfLetter )  {
       String newOutcome =updateCard + card.charAt(i);
         
        printAllPossibleOutcomes(nTimes-1,newOutcome,  card , numOfLetter);
       i++;
       
       }
    
       }
     
     
     
     
    
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
  
   String card = "JK";
   
   System.out.print("Enter number of times : ");
   int nTimes=input.nextInt();
   System.out.println("The possible ways are\n"+"-------------------------");
  int numOfLetter= card.length();
  printAllPossibleOutcomes(nTimes,"",card, numOfLetter);
    
     
    }
    
    
}
