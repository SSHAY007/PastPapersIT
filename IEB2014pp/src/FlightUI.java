/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class FlightUI {
    public static void main(String[] args) {
        
        FlightManager fm = new FlightManager("data2014.txt");
        fm.sort();
        fm.frequentFlyer();
        System.out.println(fm.frequentFlyer());
        System.out.println(fm.allTickets());
       String[]names=new String[5];
       names[0]="John";
       names[1]="Annie";
       names[2]="Ben";
       names[3]="Zander";
       names[4]="Ina";
       
       
       
        for (int i = 0; i < names.length; i++) {
            
            for(int j=i+1;j<names.length-1;j++){
                if(names[i].compareTo(names[j])>0){
                    String temp=names[j];
                    names[j]=names[i];
                    names[i]=temp;
                   
                }
            }
            
        }//for
       
    }
}
