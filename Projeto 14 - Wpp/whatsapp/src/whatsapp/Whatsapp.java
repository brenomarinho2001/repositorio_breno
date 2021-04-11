package whatsapp;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


//CLASSE MSG ----------------------------------------------

class Mensagem{
//Atributos 
 String nome;
 String msg;

 
//Métodos Especiais:
Mensagem(String n, String msg){
this.msg = msg;
 this.nome = n;

 }

//to String:
public String toString()
{
String aux = "[" + this.nome + ": " + this.msg + "]";
return aux;
}
}








//CLASS NOTIFICAÇÃO --------------------
class Notificação{

//ATRIBUTOS
String n_Grupo;
int notice;
	
//MÉTODOS ESPECIAIS
Notificação(String n_g)
{
	this.n_Grupo = n_g;
	this.notice = 0; //GRUPO INICIA COM 0 NOTIFICAÇÕES
}

//ADICIONAR NOTIFICÃO
void addNotice() 
{
	this.notice += 1;
}

//ESVAZIAR NOTIFICAÇÃO
void EsvaziarNot() 
{
	this.notice = 0;
}

//to String
public String toString()
{
String aux = n_Grupo + "";
aux += " [" + this.notice + "] ";
return aux;
}

}







//---------- CLASS CONTATO -----------------

class Contato{
String nome;
Map<String, Grupo> grupos;
Map<String, Notificação> notices;	
}






//CLASS GRUPO -----------------------
class Grupo{
	
}





//CLASS WHATSAPP -------------------------------
public class Whatsapp{
Map<String,Contato> usuarios;
Map<String, Grupo> grupos;

Whatsapp(){
    this.usuarios = new TreeMap<>();
    this.grupos = new TreeMap<>();
}

public static void main(String[] args) {
	
}
}