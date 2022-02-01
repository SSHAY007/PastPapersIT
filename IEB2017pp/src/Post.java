/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class Post {
    private int id;
    String user, postContent ,postDateTime ;

    public Post(int id, String user, String postContent, String postDateTime) {
        this.id = id;
        this.user = user;
        this.postContent = postContent;
        this.postDateTime = postDateTime;
    }

    public int getPostId() {
        return id;
    }

    @Override
    public String toString() {
        return postDateTime +"\t" +user+"\t"+"posted:" +"\t"+postContent;
    }
    
    
}
