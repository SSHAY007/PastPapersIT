/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class Player {
    private int seed;
    private String fullname,country;

    public Player(int inSeed, String inFullname, String inCountry) {
        this.seed = inSeed;
        this.fullname = inFullname;
        this.country = inCountry;
    }
    
    public String getCountyCode(){
        String out="";
        
        String[] countryC;
        if(country.contains(" ")){//two words
            countryC = country.split("\\s");
            out+=countryC[0].substring(0, 1).toUpperCase()+countryC[1].substring(0, 2).toUpperCase();
        }else{//ome words
            out+=country.substring(0, 3).toUpperCase();
        }
        
        return "("+out+")";
    }
//         \<-- initiates REGEX   \s<-- white space    therefore \\s REGEX whitrspace
    @Override
    public String toString() {
        return fullname+" "+ this.getCountyCode();
    }
    
    
}
