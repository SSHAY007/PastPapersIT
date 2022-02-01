/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class Stop {
    private String stopName,routCodes;
    private int stopType;
    
    public static final int STOPTYP_CAFE =1;
    public static final int STOPTYP_SHELTER =2;
    public static final int STOPTYP_EXPRESS =3;
    public static final int STOPTYP_OTHER =4;
    
    public Stop(String inStopName, String inRouteCodes, int inStopType ){
        this.routCodes = inRouteCodes;
        this.stopName = inStopName;
        this.stopType =this.check(inStopType);
    }
    
    
    private int check(int stopt){
            if(stopt >4){
            return 4;
            }
            return stopt;
    }
    public String getStopTypeName(){
        switch (stopType) {
            case 1:
                return "cafe";
            case 2:
                return "shelter";
            case 3:
                return "express";
            default:
                return "other";
        }
       
    }
    public Boolean isPartOfRout(char routChar){
        
        
       return (routCodes.contains(""+routChar));
    }
    
    @Override
    public String toString(){
        return this.getStopTypeName() +"\t"+ stopName;
    }
    
}//end of class
 
