/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class TennisUI {
    public static void main(String[] args) {
        TournamentManager tm = new TournamentManager("players.txt");
        System.out.println(tm.ListAllPlayers());
        System.out.println(tm.populateMatches());
        System.out.println(tm.processResults("results.txt"));
    }
}
