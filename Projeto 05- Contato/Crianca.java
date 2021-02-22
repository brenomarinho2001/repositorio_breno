package pulapulaa;

import java.util.ArrayList;

class PulaPula{
//ATRIBUTOS
ArrayList<Crianca> pulapulas;
ArrayList<Crianca> fila;
int espaco;


public PulaPula(int espaco) {
	this.pulapulas = new ArrayList<Crianca>();
	this.fila = new ArrayList<Crianca>();
	this.espaco = espaco;
	limitepulapula(this.espaco);
}



//Limite DE CRIANÇAS NO PULA PULA

void limitepulapula(int espaco){
	for (int i = 0; i < espaco; i++){
        this.pulapulas.add(null);
    }
}


void entrarfila(Crianca crianca) {
    fila.add(crianca);
}


// sai do vetor esperando pro brincando
void entrar() {
	if(fila.size() > 0) {
    pulapulas.add(fila.get(0));
    System.out.println(fila.get(0).nome + " Entrou no pula pula");
    fila.remove(fila.get(0));
    
	}
	else {
		System.out.println("----NÃO TEM NINGUÉM NA FILA------");
	}
}

// sai do vetor brincando pro esperando (final a fila) 
void sair() {
    fila.add(pulapulas.get(0));
    System.out.println(fila.get(0).nome + " Saiu no pula pula");
    pulapulas.remove(pulapulas.get(0));
}



public String toString(){
    return "pula-pula" + this.pulapulas + "\n Fila" + this.fila;
}
	


}
	


public class Crianca {
	//ATRIBUTOS
	String nome;
	int idade;
	float altura;
	//METÓDO ESPECIAIS
	public Crianca(String nome, int idade, float altura) {

		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
	}
		

	public String toString(){
	    return "Nome: " + nome + "|" + " idade: " + idade + "|" + " altura: " + altura;
	}
	

	
	public static void main(String[] args) {
	
	Crianca c1 = new Crianca("Breno",11,1.5f);
	Crianca c2 = new Crianca("Mariana",20,1.1f);
	PulaPula p1 = new PulaPula(0);
	
	p1.entrarfila(c1);
	p1.entrarfila(c2);
	
	p1.entrar();
	p1.entrar();
	
	p1.sair();

	
	System.out.println(p1);
	
	
	}
}
	




