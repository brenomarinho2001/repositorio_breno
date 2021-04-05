package twutter;

import java.util.Map;
import java.util.TreeMap;

public class Controlador {
//ATRIBUTOS MAPS DE USU�RIOS E TWEETS NA TIME 
 Map<String, User> users;
 Map<Integer, Tweet> tweets;



//M�TODOS ESPECIAIS E DEFININDO OS MAPS
public Controlador() 
{
this.tweets = new TreeMap<>();
this.users = new TreeMap<>();
}


//PEGAR O USU�RIO A PARTIR DO NOME 
User getUser(String username) throws Exception
{
//SE N�O CONTER NO MAP O USU�RIO DETERMINADO
if (!this.users.containsKey(username))
	throw new Exception("-ERROR(N�O FOI ENCONTRADO USU�RIO)");
//RETORNANDO O USER
return this.users.get(username);
}


//METODOS MANDAR TWEET
void sendTweet(String u, String m) throws Exception 
{
//SE O USU�RIO U ESTIVER NO MAP DE USU�RIOS
if (!users.containsKey(u)) //CASO N�O, "USU�RIO N�O ENCONTRADO
throw new Exception("-ERROR(N�O FOI ENCONTRADO USU�RIO)");

//CRIANDO UM NOVO TWWET COM A DETERMINADA MENSAGEM
Tweet tweet = new Tweet(u, m);
this.users.get(u).sendTweet(tweet);
this.tweets.put(tweet.getIdTw(), tweet);
}


//ADICIONANDO UM USU�RIO 
void addUser(String u) throws Exception
{
//SE USU�RIO CONT�M NO MAP 
 if (users.containsKey(u)) //CASO N�O, "USU�RIO N�O ENCONTRADO
	 throw new Exception("USU�RIO N�O EXISTE");

 //CRIANDO UM NOVO USU�RIO E COLOCANDO NO MAP
 User user = new User(u);
 this.users.put(u, user);
}
    
    
    

//SEGUINDO PESSOAS --------
void follow(String f, String f2) throws Exception
{
	
// F = USU�RIO 1 F2 = USU�RIO 2 SE ELES CONT�M NOS USU�RIO (MAP)
 if (!users.containsKey(f) || !users.containsKey(f2))
 throw new Exception("USU�RIO N�O ENCONTRADO");

// PEGANDO O USU�RIO E USU�RIO 2 
User following = users.get(f);
User followers = users.get(f2);

//FAZENDO USU�RIO 1 SEGUIR O 2
 following.follow(followers);
 }
    
    
    
    
//PARAR DE SEGUIR 
public void unfollow(String f1, String f2) throws Exception
{
	
//SE CONT�R NO MAP
if (!users.containsKey(f1) || !users.containsKey(f2))
throw new Exception("N�O FOI ENCONTRADO USU�RIO");

//PEGANDO OS USU�RIO
User seguidor = users.get(f1);
User seguindo = users.get(f2);

//FAZENDO O F1 DAR UNFOLLOW NO F2
seguidor.unfollow(seguindo.getUsername());
}
    
    
    
//M�TODO DANDO LIKE
void like(String u, int idTw) throws Exception
{ // USERNAME E ID 
	
	//PEGANDO O TWEET APARTIR DO ID
	Tweet tweet = tweets.get(idTw);
	//DANDO LIKE NO TWEET 
	tweet.like(u);
}
    

//USU�RIO
String timeLine(String u) throws Exception
{
//SE USU�RIO CONT�M NO MAP
 if (!users.containsKey(u)){
	 throw new Exception("N�O FOI ENCONTRADO O DETERMINADO USU�RIO");
}

 
 //RETORNA A TIMEINE INTEIRA DO DETERMINADO USU�RIO
 return users.get(u).getTimelineFull();
}
    
    
    



}
