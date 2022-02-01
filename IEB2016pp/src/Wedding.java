/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class Wedding {
    private String bride,groom,weddingDate,venue;
    private int guests;

    public Wedding(String inBride, String inGroom, String inWeddingDate, String inVenue, int inGuests) {
        this.bride = inBride;
        this.groom = inGroom;
        this.weddingDate = inWeddingDate;
        this.venue = inVenue;
        this.guests = inGuests;
    }

    public String getWeddingDate() {
        return weddingDate;
    }

    public String getVenue() {
        return venue;
    }

    public int getGuests() {
        return guests;
    }
    
    public Boolean equals(String inDay, String inVenue){   
        String[] date=weddingDate.split("-");
        String day =date[2];
        
        
        
        if(this.getWeddingDate().contains(inDay) && this.getVenue().contains(inVenue)){
            return true;
        }else{
            return false;
        }
        
    }//end of equals

    @Override
    public String toString() {
        String out="";
        if(bride!= null){
            out+=bride+" & "+groom+"\t\t"+guests+" guests";
        }else{
            out+="";
        }
        return out;
    }
    
    
    
}//end of calss
