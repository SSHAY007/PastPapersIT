/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class Flight {
    private String code,origin ,destination ,departureTime ,arrivalTime ;
    private double cost;

    public Flight(String cde, String orig, String dest, String dtime, String atime, double cst) {
        this.code = cde;
        this.origin = orig;
        this.destination = dest;
        this.departureTime = dtime;
        this.arrivalTime = atime;
        this.cost = cst;
    }//end of contuctor 
    
    public String getCode(){
        return code;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public double getCost() {
        return cost;
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
    public int getDurationFlight(){
        int out=0;
        int hoursDp=getDTime(this.departureTime);
        int minDp=getATime(this.departureTime);
        int hoursAp=getDTime(this.arrivalTime);
        int minAp=getDTime(this.arrivalTime);
        
       out= -((hoursDp*60)+minDp)+((hoursAp*60)+minAp);
        return out;
    }

    
    @Override
    public String toString() {
        return code + "\t" + origin + " " + destination + "\t" + arrivalTime;
    }
    
    
    
    
}
