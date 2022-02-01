/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class Outdoor {
    private String nameAndsurname,name,surname,area;
    private int size;
    //area might be boolean

    public Outdoor(String nameAndsurname, String area, int size) {
        this.nameAndsurname = nameAndsurname;
        this.area = area;
        this.size = size;
    }

    public String getName() {
        
       
        
        String[] nameSplit = nameAndsurname.split(" ");
        
        
        return nameSplit[0];
    }

    public String getSurname() {
        String[] nameSplit = nameAndsurname.split(" ");
        return nameSplit[1];
    }

    public float getSize() {
        return size;
    }

    public String getArea() {
        return area;
    }

    @Override
    public String toString() {
        return  this.getName() + " " + this.getSurname()+ "\t" + area + "\t" + size + 'm' +"\n";
    }
}
