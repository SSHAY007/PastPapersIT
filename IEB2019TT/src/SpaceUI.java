/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class SpaceUI {
    public static void main(String[] args) {
        SpaceManager sm = new SpaceManager("2019TestData.txt");
        System.out.println(sm.sort("indoor"));
    }
}
//sort from high to low then pick the first item in the array and you will be GOOD