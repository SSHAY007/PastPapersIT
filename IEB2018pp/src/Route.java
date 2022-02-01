/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class Route {
    private char routeCode;
    private Boolean isCircular;
    private Stop[] stop;

    public Route(char routeCode, Boolean isCircular) {
        this.routeCode = routeCode;
        this.isCircular = isCircular;
    }

    public void setStops(Stop[] s) {
        this.stop = s;
    }

    public char getRouteCode() {
        return routeCode;
    }
    
    public Stop getStopAt(int num){
        if(num >=1  && num < stop.length){
            return stop[num-1];
        }else{
        return null;
        }
        
    }
    @Override
    public String toString(){
        
        String output= routeCode +"-" ;
        if(stop.length==0){
            output+= "invalid";
        }
        if(isCircular == true){
             output+="Circular"+"\n";
        }else{
            output+="Linear"+"\n";
        }
            for (int i = 0; i < stop.length; i++) {
               
                if(isCircular == true){
                    
                    output+= "-> " +this.getStopAt(i)+stop[i].toString()+"\n";
                }else{
                    
                    output+= "-> "+this.getStopAt(i) +stop[i].toString()+"\n";
                }
            
        }
            
            return output;
        
          
}
}//end of class