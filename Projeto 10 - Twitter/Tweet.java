package twutter;

import java.util.TreeSet;

public class Tweet 
{
	//ATRIBUTOS
int idTw;
String username;
String msg;
TreeSet<String> likes;
    
    
    //MÉTODOS ESPECIAIS
    void like(String username) 
    {
        this.likes.add(username);
    }

  //MÉTODOS ESPECIAIS
    public Tweet(String username, String msg) 
    {
    	//ADICIONANDO UM ID
    	 this.idTw+=1;
    	 //VOLTANDO AO ESTADO INICIAL
    	 if (this.idTw > 0)
             this.idTw = 0;
    	 
    	 //DEFININDO
        this.username = username;
        this.msg = msg;
        this.likes = new TreeSet<>();
        
    }

    
    
    //GETTERS 
    public TreeSet<String> getLikes()
    {
        return likes;
    }
    
    public int getIdTw() 
    {
        return idTw;
    }
    public String getUsername() 
    {
        return username;
    }
    
    public String getMsg() 
    {
        return msg;
    }
    
    
    
    
    
    
    
    
    //TO STRING
    public String toString() {
        String aux = "";
        
        aux = username + ":" + idTw + ":" + "(" + msg + ")" + likes;

        return aux.toString();
    }
}
