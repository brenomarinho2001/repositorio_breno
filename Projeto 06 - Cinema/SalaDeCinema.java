package sala_cinema;

import java.util.ArrayList;

class Pessoa{
// NOME 
String nome;
int tel;

public Pessoa(String nome, int tel) {
	this.nome = nome;
	this.tel = tel;
}
	
public String toString(){
    return nome ;
}
}


public class SalaDeCinema {
int numerocadeiras;
ArrayList<Pessoa> clientes;

public SalaDeCinema(int numerocadeiras) {
	this.numerocadeiras = numerocadeiras;
	this.clientes = new ArrayList<>();
	criandosala(this.numerocadeiras);
	System.out.println("--------SALA DE CINEMA ABERTA------");
}

void criandosala(int numero) {
	 for (int i = 0; i < numerocadeiras; i++){
         this.clientes.add(null);
         
     }
}


void reservar(String nome,int tel,int i) {
	var p = new Pessoa(nome,tel);
	if(i < clientes.size()) {
	if(clientes.get(i) != null) {
		System.out.println("JÁ TEM ALGUÉM NESSA CADEIRA " + nome);
	}
	if(i < numerocadeiras && clientes.get(i) == null){
	clientes.set(i, p);
	System.out.println(clientes.get(i).nome + " RESERVOU A CADEIRA " + i);
	}
	}
	else {
		System.out.println("!!!!!!!!! " + nome + " TENTOU ENTRAR MAS NÃO TEM ESPAÇO" + " !!!!!");
	}
}

void cancelar(String n) {
for(var j = 0;j < this.clientes.size();j++) {
	if(this.clientes.get(j) == null) {
	j = j + 1;
	}
	if(n.equals(this.clientes.get(j).nome) && this.clientes.get(j) != null){
	System.out.println(this.clientes.get(j).nome + " (CANCELOU SUA CADEIRA)");
	System.out.println("CADEIRA " + j + " ESTÁ LIVRE!");
	this.clientes.remove(j);
	this.clientes.add(j, null);;
	
	}
}
}

public String toString(){
    String saida = "[ ";
    for(Pessoa pessoa : clientes){
        if(pessoa == null)
            saida += "- ";
        else
            saida += pessoa + " ";
    }
    return saida + "]";
}
	
public static void main(String[] args) {
	SalaDeCinema s1 = new SalaDeCinema(6);
	
	s1.reservar("Breno", 320, 0);
	
	s1.reservar("Alexandre", 32, 2);
	s1.reservar("Mariana", 440, 3);
	s1.reservar("Alex", 4320, 4);
	s1.reservar("barte", 450, 5);
	s1.reservar("KILL", 450, 4);
	
	s1.cancelar("Alex");
	s1.reservar("KILL", 450, 4);
	s1.cancelar("Breno");

	
	System.out.println(s1);
}
	
	
}
