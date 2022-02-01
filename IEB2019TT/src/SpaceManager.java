
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
public class SpaceManager {
    private Detail[] details = new Detail[100];
    private DetailMore[] detailsMore = new DetailMore[100];
    private int detailCounter=0;
    private int detailMoreCounter =0;
    
    public SpaceManager(String filename){
        try {
            Scanner scan = new Scanner(new File(filename));
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String line2=scan.nextLine();
                Scanner sc = new Scanner(line).useDelimiter(",");               
                String nameAndSurname= sc.next();
                String inOrOutDoor=sc.next();
                int sizeO =sc.nextInt();
                Scanner sc2 = new Scanner(line2).useDelimiter(",");
                
                String nameAndSurnameO= sc2.next();
                String inOrOutDoorO=sc2.next();
                float size =sc2.nextFloat();
                  Indoor[] Indoors = new Indoor[100];
                  Outdoor[] Outdoors = new Outdoor[100];
                 Indoors[detailMoreCounter]= new Indoor(nameAndSurname,inOrOutDoor,size);
                 Outdoors[detailMoreCounter]= new Outdoor(nameAndSurname,inOrOutDoor,sizeO);
                  
                  String[] nameOrSurname = nameAndSurname.split(" ");
              detailsMore[this.detailMoreCounter++]= new DetailMore(nameOrSurname[0],nameOrSurname[1],Indoors[detailMoreCounter-1],Outdoors[detailMoreCounter-1]);    
                  //minus one because detailsMore increamented up before t coult populate 
                  
                 // System.out.println(size);
                  
                details[detailCounter++]= new Detail(nameAndSurname,inOrOutDoor,size);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SpaceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < detailMoreCounter; i++) {
        System.out.println( detailsMore[i].getOutdoor());
        
        }
    }
    
    public String sort(String inOutDoor){
        String out="";
        for (int i = 0; i < detailCounter; i++) {
            if(details[i].getArea().contains(inOutDoor)){
                //out+=details[i].toString();
            }
            
        }
        return out;
    }
}//end of class
