/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class TourUI {

    public TourUI() {
        TourManager tourmanager = new TourManager("data.txt");
        
        
        System.out.println(tourmanager.getRouteWithcode('R', true).toString());
        System.out.println(tourmanager.getRouteWithcode('Y', false).toString());
    }
    
    public static void main(String[] args) {
        new TourUI();
    }
}
