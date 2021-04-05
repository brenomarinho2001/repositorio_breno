package maquina;

import java.util.ArrayList;

class Objetos{
String nome;
int quantidade;
float valor;


public Objetos(String nome, float valor,int quantidade) {

	this.nome = nome;
	this.valor = valor;
	this.quantidade = quantidade;
}



	
	
	
public String toString(){
	return "[" + nome + " | Quantidade: " + quantidade +" | Valor: " + valor + " reais ] "; //[empty : 0 U : 0.00 RS ]\n
}
}


public class Maquina {
int numeroespirais;
int produtos_max_por_espiral;
ArrayList<Objetos> espirais;
int saldo;

public Maquina(int numeroespirais, int produtos_max_por_espiral,int saldo) {
	this.numeroespirais = numeroespirais;
	this.produtos_max_por_espiral = produtos_max_por_espiral;
	this.saldo = saldo;
	this.espirais = new ArrayList<>();
	for(int i = 0; i < numeroespirais;i++) {
		this.espirais.add(null);
	}
}


void adicionarobjeto(String n,float v,int q) {
	Objetos o = new Objetos(n,v,q);
	for(int i = 0; i < numeroespirais;i++) {
		if(this.espirais.get(i) == null) {
			this.espirais.set(i, o);
			break;
		}
	}
	
}

void resetarespiral() {
	for(int i = 0; i < numeroespirais;i++) {
	this.espirais.set(i, null);
	}
}

void limparespiral(int i) {
	if(this.produtos_max_por_espiral >= i) {
		this.espirais.set(i, null);
	}
}


void alterarespiral(int i,String n,int q,float f) {
	//maquina.alterarEspiral(2, "todinho", 3, 2.50f);
	if(i < numeroespirais) {
	Objetos o = new Objetos(n,f,q);
	this.espirais.set(i, o);
	}
	else {
		System.out.println("INDICE INVALIDO");
	}
	
	
}

void adicionarsaldo(float f) {
	this.saldo += f;
	System.out.println("SEU SALDO AGORA É " + saldo + " REAIS");
}

void mostrarsaldo() {
	System.out.println("SEU SALDO É " + saldo + " REAIS");
}


void vender(int i) {
	if(this.espirais.get(i) != null) {
	if(this.saldo <= this.espirais.get(i).valor) {
		System.out.println("NÃO TEM DINHEIRO SUFICIENTE");
		}
	if(this.saldo >= this.espirais.get(i).valor) {
		this.saldo -= this.espirais.get(i).valor;
		this.espirais.get(i).quantidade -= 1;
	}
	}
	else {
		System.out.println("NÃO HÁ NADA NESSA SESSÃO");
	}
	
}



public String toString(){
    String saida = "";
    for(Objetos pessoa : espirais){
        if(pessoa == null)
            saida += "[empty : 0 U : 0.00 RS]";
        else
            saida += pessoa + " ";
    }
    return saida + "";
}


public static void main(String[] args) {
	Maquina m1 = new Maquina(3,5,0);


	m1.adicionarobjeto("Chocolate", 2.5f,8);
	System.out.println(m1);
	m1.adicionarsaldo(3f);
	
	m1.vender(1);
	System.out.println(m1);
	m1.mostrarsaldo();

	m1.adicionarsaldo(5f);

	System.out.println(m1);

	
}

}
