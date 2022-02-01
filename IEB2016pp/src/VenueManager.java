
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
public class VenueManager {
    private Wedding[] wedding = new Wedding[50];
    private BookingDay[] bookingDay = new BookingDay[30];
    private int counter=0;
    public VenueManager(String filename) {
        
        try {
            Scanner scan = new Scanner(new File(filename));
            
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                
                Scanner sc = new Scanner(line).useDelimiter("#");
                
                String bride = sc.next();
                String groom = sc.next();
                String wd = sc.next();
                String venue = sc.next();
                int guests = sc.nextInt();
                
                wedding[counter]= new Wedding(bride,groom,wd,venue,guests);
                counter++;
                
            }
//            for (int i = 0; i < wedding.length; i++) {
//                System.out.println(wedding[i].toString());
//                
//            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VenueManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Wedding getWeddingOnDay(String date,String venue){
        Wedding tempWedding =null;
        
        int count=0;
        for (int i = 0; i < wedding.length; i++) {
            
            if(wedding[i].equals(date, venue)){
                tempWedding = wedding[i];        
            }        
            
        }
        
        return tempWedding;
    }//end of get wedding
    
    public String processBooking(){
        String out="";
        int countersG=0;
        int countersL=0;
        
        Wedding garden[]=new Wedding[50];
        Wedding lake[]=new Wedding[50];
        for (int i = 0; i < wedding.length; i++) {
            
            if(wedding[i].getVenue().contains("Garden")){           
                garden[countersG++]=wedding[i];             
            }else{
                lake[countersL++]= wedding[i];
            }
     
        } 
        for (int j = 0; j < bookingDay.length; j++) {
                
                bookingDay[j]= new BookingDay(Integer.toString(j),garden[j],lake[j]);
                out+= bookingDay[j].toString();
                
               // System.out.println(lake[j].toString());
            }
        return out;
    }
    
    public String bookingProcessing2(){
        String out="";
        for (int i = 0; i < bookingDay.length; i++) {
           int day = i+1;
           
           String date="";
           
           if(day<10){
               date+="2016-11-0"+day;
           }else{
               date+="2016-11-"+day;
           }
           
           Wedding garden = this.getWeddingOnDay(date, "Garden");
           Wedding lake = this.getWeddingOnDay(date, "Lake");
            
           bookingDay[day-1]= new BookingDay(Integer.toString(day),garden,lake);
           out+=bookingDay[i].toString();
          //System.out.println(garden.toString());
        }
        return out;
        
    }
    public void displayCaldender(){
        
    }
}//end of class
