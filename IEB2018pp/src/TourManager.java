
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
public class TourManager {
    private Stop[] stopArr = new Stop[100];
    private int stopCounter=0;

    public TourManager(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename ));
            while(scan.hasNext()){
                String line = scan.nextLine();
                
                Scanner scline = new Scanner(line).useDelimiter(",");
                String rname = scline.next();
                int stoptype = scline.nextInt();
                String routecode = scline.next();
                stopArr[stopCounter]= new Stop(rname,routecode,stoptype);
                stopCounter++;
                
               
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TourManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end of contructor 
    
    /**
     *
     * @param routecode
     * @param iscircular
     * @return 
     */
    public Route getRouteWithcode(char routecode,Boolean iscircular){
        
        Route r = new Route(routecode,iscircular);
        int count =0;
        for (int i = 0; i < stopCounter; i++) {
            if(stopArr[i].isPartOfRout(routecode)){
              count++;
            }
         
        } 
        Stop[] arr = new Stop[count];
            
            count =0;
     
        for (int i = 0; i < stopCounter; i++) {
             if (stopArr[i].isPartOfRout(routecode)) {
               arr[count]= stopArr[i];
                count++;
             }
            }
        r.setStops(arr);
        return r;
    }
    
    public String checkRoute(Route rt1, Route rt2){
        String out= "";
        for (int i = 0; i < stopArr.length; i++) {
            if(stopArr[i].isPartOfRout(rt1.getRouteCode())&& stopArr[i].isPartOfRout(rt2.getRouteCode())){
               out+= stopArr[i]+"\n ";
            }
            
        }
        return out;
    }
}//end of class
// ask sir SQL APPEND and also when the item in the array will be null such that if there is somtihng missing in the text file or if its not standerd like more delimieters to use nextInt and stuff