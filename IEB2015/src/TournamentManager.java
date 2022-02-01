
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
public class TournamentManager {
    private Player[] players= new Player[32];
    private Match[] matches = new Match[16];
    private int playerCounter;
    public TournamentManager(String filename){
        
        try {
            
            this.playerCounter=0;
            Scanner sc = new Scanner(new File(filename));
            while(sc.hasNextLine()){
                String line= sc.nextLine();
                Scanner scan = new Scanner(line).useDelimiter(",");
                int seedD= scan.nextInt();
                String nameD= scan.next();
                String CountryD = scan.next();
                
                players[this.playerCounter++]= new Player(seedD,nameD,CountryD);
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TournamentManager.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//constructor
    
    
    public String ListAllPlayers(){
            String out="";
            for (int i = 0; i < this.playerCounter; i++) {
              out+=players[i].toString()+"\n";
            
        }
            return out;
            
        }//end of list all players 
    
    public String populateMatches(){
        int k=players.length-1;
        int j = 0;
       
        int f=1;
        int l=players.length;
        String out="";
        String sead;
        for (int i = 0; i < matches.length; i++) {
            sead="M"+String.valueOf(f)+String.valueOf(l);
            f++;
            l--;
               matches[i]= new Match(sead,players[j++],players[k--]);
               System.out.println(sead);
                out+=matches[i].toString()+"\n";
            }   
        return out;
    }//end of popluate macthes
    
    public Match findMatch(String matchCode){
        Match tempMatch=null;
        
        for (int i = 0; i < matches.length; i++) {
            if(matchCode.contains(matches[i].getMatchCode())){
                tempMatch=matches[i];
            }
            
        }
        
        return tempMatch;
    }
    
    
    public String processResults(String filename){
        int counter =0;
        String[] matchesP= new String[50];
        String out="Match Results: ";
        try {
            Scanner sc = new Scanner(new File(filename));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                Scanner scan= new Scanner(line).useDelimiter("\n");
                String som = scan.next();
               matchesP[counter++]= new String(som);
             
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TournamentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        String add=matchesP[0];
         out+=matchesP[0]+" "+ this.findMatch(add);
         int countP1=0;
         int countP2=0;
         int sumPlayer1=0,sumPlayer2=0;
         
         String set1="";
         String set2="";
         String set3="";
         String set4="";
//         <------------------- 1st set-------------------->    
        for (int i = 1; i < 7; i++) {
            if(matchesP[i].contains("1")){
                countP1++;
                sumPlayer1++;
            }else{
                countP2++;
                sumPlayer2++;
            }
            
            set1=countP1+"-"+countP2;
        }//end of first set
//         <------------------- 2nd set-------------------->           
        countP1=0;
        countP2=0;
        for (int i = 7; i < 21; i++) {
            if(matchesP[i].contains("1")){
                countP1++;
                sumPlayer1++;
            }else{
                countP2++;
                sumPlayer2++;
            }
            
            set2=countP1+"-"+countP2;
        }//end of second set
//         <------------------- 3rd set-------------------->            
        countP1=0;//<---------------- reset counter outher wise the score will overlap to next set
        countP2=0;
        for (int i = 21; i < 31; i++) {
            if(matchesP[i].contains("1")){
                countP1++;
                sumPlayer1++;
            }else{
                countP2++;
                sumPlayer2++;
            }
            
           
            set3=countP1+"-"+countP2;
        }//end of Third set
//        <------------------- 4th set-------------------->        
        countP1=0;
        countP2=0;
        for (int i = 31; i < 40; i++) {
            if(matchesP[i].contains("1")){
                countP1++;
                sumPlayer1++;
            }else{
                countP2++;
                sumPlayer2++;
            }
            
            
            set4=countP1+"-"+countP2;
        }//end of frouth set
        
      // System.out.print(sumPlayer1+"\t"+sumPlayer2);
        
       // int player1 = winner[0]
        out+=set1+" "+set2+" "+set3+" "+set4;
        if(sumPlayer1>sumPlayer2){
            out+=" Player 1 wins";
        }else{
             out+=" Player 2 wins";
        }
        
        return out;
    }
}// end of class
