/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class InstaPageUI {
    
    public static void main(String[] args) {
        InstaPageManager ipm = new InstaPageManager("2017data.txt");
        
        System.out.print(ipm.postAndResponse());
       
        
    }
}
