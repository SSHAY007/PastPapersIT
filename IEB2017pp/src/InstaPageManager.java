
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class InstaPageManager {
    private PostWithResponses[] prArray;
    private Post[] post= new Post[100];
    private Response[] response= new Response[500];
    
 
    private int postCounter,responseCounter;

    public InstaPageManager(String filename) {
        
        try {
            Scanner scan = new Scanner(new File(filename));
            
           
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                Scanner sc = new Scanner(line).useDelimiter("#");
                
                int id = sc.nextInt();
                String user= sc.next();
                String postContent=sc.next();
                String postDateTime=sc.next();
                
               
             
                
                if(sc.hasNextInt()){
                    int responseType =sc.nextInt();
//                    int postId = sc.nextInt();
//                    String userP = sc.next();
//                    String comment=sc.next();
//                    String respondDateTime = sc.next();
                    
                    
                    response[responseCounter]= new Response(id,responseType,user,postContent,postDateTime);
                    responseCounter++;
                   //  System.out.print(responseCounter);
                }else{
                     post[postCounter]= new Post(id,user,postContent,postDateTime);
                     
                     postCounter++;
                }
                     
                
                
              
                  
                
                
                
             
                
                
            }
            
           // System.out.print(postCounter);
//              for (int i = 0; i < response.length; i++) {
//                    
//                    System.out.print(response[i].toString(false));
//                }
//          
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InstaPageManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File not found");
        }
            
        
        
    }
    
  
    public String getAllPosts(){
     
      String posts="";
        for (int j = 0; j < post.length; j++) {
            
            if(post[j]!= null){
                 posts+= post[j].toString()+"\n";
            }
           
            
        }
        
        
        
        return posts ;
    }
    
    public String postAndResponse(){
        String out ="";
        prArray = new PostWithResponses[postCounter];
        
        for (int i = 0; i < postCounter; i++) {
            Response res[] = new Response[100];
          int counter=0;
            for (int j = 0; j < res.length; j++) {
                
                if(post[i].getPostId()==response[j].getPostID()){
                    
                    res[counter++]=response[j];
                    
                }
                }
              
             Response postResponses[] = new Response[counter]; 
             
             System.arraycopy(res, 0, postResponses, 0, counter);
            prArray[i]=new PostWithResponses(post[i],postResponses);
            out+= prArray[i].toString();
            }
        
        
        
        return out;
          
            
            
        
        
    }
    
    
}//end of class
//   Post[] pp = new Post[post.length];
//        
//        for ( i = 0; i < post.length; i++) {
//          
//            
//        }
//       if(post[i].toString() == null){
//           
//       }else{
//           return post[i].toString();
//       }
        