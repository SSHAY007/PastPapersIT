/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class DetailMore {
    private String name,surname;
    private Indoor indoor;
    private Outdoor outdoor;

    public DetailMore(String name, String surname, Indoor indoor, Outdoor outdoor) {
        this.name = name;
        this.surname = surname;
        this.indoor = indoor;
        this.outdoor = outdoor;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Indoor getIndoor() {
        return indoor;
    }

    public Outdoor getOutdoor() {
        return outdoor;
    }
    
    
}
