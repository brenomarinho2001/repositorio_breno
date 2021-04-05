package twutter;

import java.util.Map;
import java.util.TreeMap;

public class Controlador {
//ATRIBUTOS MAPS DE USUÁRIOS E TWEETS NA TIME 
 Map<String, User> users;
 Map<Integer, Tweet> tweets;



//MÉTODOS ESPECIAIS E DEFININDO OS MAPS
public Controlador() 
{
this.tweets = new TreeMap<>();
this.users = new TreeMap<>();
}


//PEGAR O USUÁRIO A PARTIR DO NOME 
User getUser(String username) throws Exception
{
//SE NÃO CONTER NO MAP O USUÁRIO DETERMINADO
if (!this.users.containsKey(username))
	throw new Exception("-ERROR(NÃO FOI ENCONTRADO USUÁRIO)");
//RETORNANDO O USER
return this.users.get(username);
}


//METODOS MANDAR TWEET
void sendTweet(String u, String m) throws Exception 
{
//SE O USUÁRIO U ESTIVER NO MAP DE USUÁRIOS
if (!users.containsKey(u)) //CASO NÃO, "USUÁRIO NÃO ENCONTRADO
throw new Exception("-ERROR(NÃO FOI ENCONTRADO USUÁRIO)");

//CRIANDO UM NOVO TWWET COM A DETERMINADA MENSAGEM
Tweet tweet = new Tweet(u, m);
this.users.get(u).sendTweet(tweet);
this.tweets.put(tweet.getIdTw(), tweet);
}


//ADICIONANDO UM USUÁRIO 
void addUser(String u) throws Exception
{
//SE USUÁRIO CONTÉM NO MAP 
 if (users.containsKey(u)) //CASO NÃO, "USUÁRIO NÃO ENCONTRADO
	 throw new Exception("USUÁRIO NÃO EXISTE");

 //CRIANDO UM NOVO USUÁRIO E COLOCANDO NO MAP
 User user = new User(u);
 this.users.put(u, user);
}
    
    
    

//SEGUINDO PESSOAS --------
void follow(String f, String f2) throws Exception
{
	
// F = USUÁRIO 1 F2 = USUÁRIO 2 SE ELES CONTÉM NOS USUÁRIO (MAP)
 if (!users.containsKey(f) || !users.containsKey(f2))
 throw new Exception("USUÁRIO NÃO ENCONTRADO");

// PEGANDO O USUÁRIO E USUÁRIO 2 
User following = users.get(f);
User followers = users.get(f2);

//FAZENDO USUÁRIO 1 SEGUIR O 2
 following.follow(followers);
 }
    
    
    
    
//PARAR DE SEGUIR 
public void unfollow(String f1, String f2) throws Exception
{
	
//SE CONTÉR NO MAP
if (!users.containsKey(f1) || !users.containsKey(f2))
throw new Exception("NÃO FOI ENCONTRADO USUÁRIO");

//PEGANDO OS USUÁRIO
User seguidor = users.get(f1);
User seguindo = users.get(f2);

//FAZENDO O F1 DAR UNFOLLOW NO F2
seguidor.unfollow(seguindo.getUsername());
}
    
    
    
//MÉTODO DANDO LIKE
void like(String u, int idTw) throws Exception
{ // USERNAME E ID 
	
	//PEGANDO O TWEET APARTIR DO ID
	Tweet tweet = tweets.get(idTw);
	//DANDO LIKE NO TWEET 
	tweet.like(u);
}
    

//USUÁRIO
String timeLine(String u) throws Exception
{
//SE USUÁRIO CONTÉM NO MAP
 if (!users.containsKey(u)){
	 throw new Exception("NÃO FOI ENCONTRADO O DETERMINADO USUÁRIO");
}

 
 //RETORNA A TIMEINE INTEIRA DO DETERMINADO USUÁRIO
 return users.get(u).getTimelineFull();
}
    
    
    



}
