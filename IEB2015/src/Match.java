/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class Match {
    private String matchCode;
    private Player player1,player2;
    private String score;

    public Match(String inMatchCode, Player inPlayer1, Player inPlayer2) {
        this.matchCode = inMatchCode;
        this.player1 = inPlayer1;
        this.player2 = inPlayer2;
    }
    
    public String getMatchCode(){
        return matchCode;
    }

    public void setScore(String inScore){
        score=inScore;
    }

    @Override
    public String toString() {
        String out =player1.toString()+" Vs. "+player2.toString()+" ";
            if(score!=null) {   
                if(score.contains("X")){
                    out+="Not Yet Played";
                    
                }else{
                    out+=score;
                }
        
            }
        return out;
    }
    
    
    
}
