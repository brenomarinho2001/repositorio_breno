package twutter;

import java.util.Map;
import java.util.TreeMap;

public class User {
	
//ATRIBUTOS 
String username;
Map<String, User> seguidores;
Map<String, User> following;
Map<Integer, Tweet> timeline;
int unreadCount;

//MÉTODOS ESPECIAIS DEFININDO TUDO
public User(String username)
{
    this.following = new TreeMap<>();
    this.timeline = new TreeMap<>();
    this.seguidores = new TreeMap<>();
    this.username = username;
    
}


//SEGUINDO 
public void follow(User u) throws Exception 
{
	
//SE CONTÉM O USUÁRIO
if (following.containsKey(u.getUsername()))
throw new Exception("JÁ SEGUE ESSE USUÁRIO");

//ESSE USUÁRIO SEGUE O USUÁRIO "U"
this.following.put(u.getUsername(), u);

//SEGUIDOR U GANHA UM SEGUIDOR QUE É O "THIS"
u.getseguidores().put(this.username, this);
}




//PARAR DE SEGUIR
void unfollow(String u) throws Exception
{
	
//SE NÃO CONTÉM ESSE USUÁRIO
if (!this.following.containsKey(u))
  throw new Exception("NÃO HÁ COMO PARAR DE SEGUIR SE TU NÃO SEGUE O " + this.username);


//AUXILIAR PARANDO DE SEGUIR
User aux = this.following.remove(u);

//PERDENDO UM SEGUIDOR 
aux.getseguidores().remove(this.username);

}


//MANDAR TWEET METODO 
void sendTweet(Tweet tweet)
{
	
//------------ TIMELINE -------------------------
for(Map.Entry<String, User> seguidoress : this.seguidores.entrySet())
{
seguidoress.getValue().timeline.put(tweet.getIdTw(), tweet);
seguidoress.getValue().unreadCount++;
}

//-------------- COLOCANDO O TWEET NA TIMELINE CERTA -------
   this.timeline.put(tweet.getIdTw(), tweet);
}

 //RETORNA A --------TIMELINE
    public Tweet getTweet(int id) throws Exception 
    {
    	
    	//SE CONTÉR 
 if(!timeline.containsKey(id))
 throw new Exception("ESSE TWEET NÃO EXISTE NA TIME");

 //RETORNANDO A TIMELINE DE TERMINADO ID
    return this.timeline.get(id);
}
    
    
    
    
    
    

    
    
    
// -----------FULL TIMELINE
String getTimelineFull()
{
//CRIANDO O BUILDER PARA ARMAZENAR CARACTERES
StringBuilder time = new StringBuilder();


//PEGANDO OS TWEETS DA TIMELINE E PASSANDO 
for (Tweet KEY : timeline.values())
time.append(KEY).append("\n");

this.unreadCount = 0;
return time.toString();
}



  
    
    
    
    
    
    
    
    
    
    // GETTERS ----------
    
    public Map<String, User> getseguidores() 
    {
        return seguidores;
    }

    public Map<String, User> getFollowing()
    {
        return following;
    }

    public Map<Integer, Tweet> getTimeline()
    {
        return timeline;
    }

    public int getUnreadCount() 
    {
        return unreadCount;
    }

    public String getUsername()
    {
        return username;
    }
    
    
    //TO STRING 
    public String toString() 
    {
        return username;
    }


}
