
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class FlightManager {
    private Ticket[] tickets= new Ticket[500];
    private int ticketCounter=0;
    private int flightCounter=0;
   
    public FlightManager(String filename){
        
        try {
            Scanner scan = new Scanner(new File(filename));
            
            while(scan.hasNextLine()){
                String line= scan.nextLine();
                String line2= scan.nextLine();
                String line3 =scan.nextLine();
                //reads threee lines at a time because said scan.next line
                Scanner scLine1 = new Scanner(line).useDelimiter("#");
                Scanner scLine2 = new Scanner(line2).useDelimiter("#");
                Scanner scLine3 = new Scanner(line3).useDelimiter("#");
                
                String tID= scLine1.next();
                String pName= scLine1.next();
               
               String code= scLine2.next();
               String origin= scLine2.next();
               String dest= scLine2.next();
               String dpTime= scLine2.next();
               String arTime=scLine2.next();
               String cst= scLine2.next();
               double cost = Double.parseDouble(cst);
               
            Flight departingF = new Flight(code,origin,dest,dpTime,arTime,cost);   
               String codeA= scLine3.next();
               String originA= scLine3.next();
               String destA= scLine3.next();
               String dpTimeA= scLine3.next();
               String arTimeA=scLine3.next();
               String cstA= scLine3.next();
               double cost2 = Double.parseDouble(cstA);
            Flight arraivingF = new Flight(codeA,originA,destA,dpTimeA,arTimeA,cost2);     
               //System.out.println(cst);
               
               tickets[this.ticketCounter++]= new Ticket(tID,pName,departingF,arraivingF);
              
            }//end of while
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlightManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }//end of constructor 
    public String allTickets(){
        String out="";
        for (int i = 0; i < this.ticketCounter; i++) {
            out+=tickets[i].toString()+"\n";
            
        }
        
        
        return out;
    }
      private int getDTime(String time){
        String tyd = time.substring(11, 13);
        int timeI = Integer.parseInt(tyd);
        return timeI;
    }
       private int getATime(String time){
        String tyd = time.substring(14);
        int timeI = Integer.parseInt(tyd);
        return timeI;
    }
    public void sort(){
            
         
        for (int i = 0; i < this.ticketCounter; i++) {
           
            
            for (int j = i+1; j < ticketCounter; j++) {
                
                //sorting the minutes
                 if(this.getATime(tickets[i].getDepartingFlight().getDepartureTime())>this.getATime(tickets[j].getDepartingFlight().getDepartureTime())){
                         Ticket tempt = tickets[j];
                         tickets[j]=tickets[i];
                         tickets[i]=tempt;
                }
                 //sorting the hours
                if(this.getDTime(tickets[i].getDepartingFlight().getDepartureTime())>this.getDTime(tickets[j].getDepartingFlight().getDepartureTime())){
                         Ticket tempt = tickets[j];
                         tickets[j]=tickets[i];
                         tickets[i]=tempt;
                }
                
                 
            }
             int time = this.getDTime(tickets[i].getDepartingFlight().getDepartureTime()); 
           // System.out.println(time);
            System.out.println(tickets[i].getDepartingFlight().getDepartureTime());
            
            String fullTime = tickets[i].getDepartingFlight().getDepartureTime().substring(13);
            
                String[] plitTwo=fullTime.split(i+"");
               // System.out.println(plitTwo[0]);
            
            
       
        }//end of first for
                  
        }//end of sort
  
        public String frequentFlyer(){
            String out="";
            String one="";
            String regex="";
            Ticket[] tempTickets= new Ticket[this.ticketCounter]; 
         System.arraycopy(tickets, 0, tempTickets, 0, ticketCounter);
            int[] allDurations=new int[ticketCounter];
            for (int i = 0; i < this.ticketCounter; i++) {
                 out+=tickets[i].getName()+" ";
           
                 out+=String.valueOf(tickets[i].getTotalFlightDuration())+"\n";
            
                 one=String.valueOf(tickets[i].getTotalFlightDuration());
                 
                 allDurations[i]= Integer.valueOf(one);
            }//regex=one.substring(tickets[0].getName().length());
            //sort from lowest to highest value of miniutes then choose the last item in the array for most
            for (int i = 0; i < ticketCounter; i++) {
                for (int j = i+1; j < ticketCounter; j++) {
                   if(tempTickets[i].getTotalFlightDuration()<tempTickets[j].getTotalFlightDuration()){
                       Ticket ticketT = tempTickets[j];
                       tempTickets[i]=tempTickets[j];
                       tempTickets[j]=ticketT;
                   }
                    
                   
                    
                }
            }
            /*  for (int i = 0; i < allDurations.length; i++) {
            System.out.println(tickets[i].getTotalFlightDuration()+"\t\t"+tempTickets[i].getTotalFlightDuration());
            
            }*/
            String out2= "";
            out2+=tempTickets[0].getName()+tempTickets[0].getTotalFlightDuration();
        return out2;
        }
}//end of classs






    /*for (int i = 0; i < ticketCounter; i++) {
        Ticket[] ticketsTemp = new Ticket[ticketCounter];
        int odd = 2*i;
        if(odd<0){
        odd=1;
        }
        ticketsTemp[i]=new Ticket(tickets[i].getTicketID(),tickets[i].getName(),departOrArraive[i],departOrArraive[odd]);
        System.out.println( ticketsTemp[i].toString());
        
        }*/

 /*  if(sc.hasNext()){
               
               String dest= sc.next();
               String dpTime= sc.next();
               String arTime=sc.next();
               String cst= sc.next();
               //  departFlight= new Flight(tID_OR_code,pName_OR_origin,dest,dpTime,arTime,cst);
               departOrArraive[flightCounter++]= new Flight(tID_OR_code,pName_OR_origin,dest,dpTime,arTime,cst);
               
               }*/
                //System.out.println(departOrArraive[]);
               
               // tickets[ticketCounter++]= new Ticket(tID_OR_code,pName_OR_origin,departOrArraive[one++],departOrArraive[2*one-1]);
                //two=2*one-1;
               // 