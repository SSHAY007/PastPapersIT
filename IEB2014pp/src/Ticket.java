/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class Ticket {
    private String ticketID,name;
    private Flight departingFlight,returningFlight;

    public Ticket(String tID, String nme, Flight dflight, Flight rflight) {
        this.ticketID = tID;
        this.name = nme;
        this.departingFlight = dflight;
        this.returningFlight = rflight;
    }
      private int getHour(String time){
        String tyd = time.substring(11, 13);
        int timeI = Integer.parseInt(tyd);
        return timeI;
    }
       private int getMin(String time){
        String tyd = time.substring(14);
        int timeI = Integer.parseInt(tyd);
        return timeI;
    }
    public String getName() {
        return name;
    }

    public Flight getDepartingFlight() {
        return departingFlight;
    }

    public Flight getReturningFlight() {
        return returningFlight;
    }

    public int getTotalFlightDuration(){
        return this.departingFlight.getDurationFlight()+this.returningFlight.getDurationFlight();
    }
    
    
    public double getTotalCost(){
        double out=90.00;
       
           out= this.departingFlight.getCost()+this.returningFlight.getCost();
       
        return out;
    }
    
    
    
    
    //read all the difficult questions first to know what this small methods
    //will do which will give you better understanding

    @Override
    public String toString() {
        
        String out="";
        if(this.getDepartingFlight()!=null||this.getReturningFlight()!=null){
        out+=ticketID+"\t"+name+"\t"+this.getTotalCost()+"\n" ;
        out+=out+this.getDepartingFlight().toString()+"\n"+this.getReturningFlight().toString()+"\n";
        }
        return out ;
    }
}
