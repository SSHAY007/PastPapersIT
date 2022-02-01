/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class PostWithResponses {
    
    private Post post;
    private Response[] responses;

    public PostWithResponses(Post post, Response[] responses) {
        this.post = post;
        this.responses = responses;
    }

    @Override
    public String toString() {
        
        String out =post.toString()+"\n"+"\t"+"Responses";
        
        for (int i = 0; i < responses.length; i++) {
            
            out+= "\n"+"\t"+ responses[i].toString();
        }
        
        
        return out;
    }
    
    
    
}

