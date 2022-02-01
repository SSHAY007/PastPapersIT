/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class Response {
    private int postID,response;
    private String user,comment, responseDateTime,responseType;
    
    public static final int RESPONSE_LIKE = 1;
    public static final int RESPONSE_COMMENT = 2;
    public static final int RESPONSE_DISLIKE=3;
    public static final int RESPONSE_LOVE = 4;

    public Response(int inpostID, int inResponse, String inUser, String inComment, String inResponseDateTime) {
        this.postID = inpostID;
        this.response = inResponse;
        this.user = inUser;
        this.comment = inComment;
        this.responseDateTime = inResponseDateTime;
        
    }
    
    
    public String  getResponseType (){
       String responseS="";
        switch (response) {
            case RESPONSE_LIKE:              
                responseS = "liked";
                break;
                
            case RESPONSE_DISLIKE:
                responseS = "diliked";
                
                break;
            case RESPONSE_COMMENT:
                responseS = "commented";
                
                break;
                
            default:
                responseS = "loved";
              
        }//end of sw
        return responseS;
    }//end of method

    public int getPostID() {
        return postID;
    }

    @Override
    public String toString() {
        
     if(response == RESPONSE_COMMENT){
         return responseDateTime+"\t"+user+"\t"+this.getResponseType()+"\t"+"this post";
     }else{
         return responseDateTime+"\t"+user+"\t"+this.getResponseType()+"\t"+"on this post: " +comment+"\n";
     }//end of to 
        
        
    }
    
    
}
//int stend array you going to have the subjects