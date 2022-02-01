/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class BookingDay {
    private String bookingDay;
    private Wedding garden,lake;

    public BookingDay(String inBookingDay, Wedding inGarden, Wedding inLake) {
        this.bookingDay = inBookingDay;
        this.garden = inGarden;
        this.lake = inLake;
    }
    
    public String getOverbooked(){
        String outGarden="";
        String outLake="";
        
        if(garden.getGuests() >=103){
             outGarden+= "Garden venue is overbooked by "+Integer.toString(garden.getGuests()-103)+ " guests";
        }
           
        
        if(lake.getGuests() >=160){
            outLake+= "Lake venue is overbooked by "+Integer.toString(lake.getGuests()-160)+ " guests";
        }
        return outGarden+"\n"+outLake;
    }

    @Override
    public String toString() {
        
        String out="";
        
        if(garden ==null||lake==null){
            out+=bookingDay+" No Weddings booked"+"\n";
        }else{
            out+=garden.getWeddingDate()+ " Garden: "+garden.toString()+"\n"+"Lake: "+lake.toString()+"\n"+this.getOverbooked()+"\n";
        }
              
        return out;
    }
    
    public static void getSome(){
        System.out.print("Hello Static");
    }
    
}
