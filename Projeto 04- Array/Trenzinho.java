package trenzinho;

import java.util.ArrayList;

import java.util.Scanner;

class Crianca {
private String nome;
private int altura;


Crianca(String nome,int altura){
	this.nome = nome;
	this.altura = altura;
}

public String toString() {
    return nome + " : " + altura;
}

//RETORNANDO O NOME DA CRIANCA
String getNome() {
	return nome;
}

//RETORNANDO A ALTURA
float getaltura() {
	return altura;
}

}


public class Trenzinho {

	ArrayList<Crianca> fila = new ArrayList<>();
	ArrayList<Crianca> no_trem = new ArrayList<>();
	
	
	//Avistou o pula pula para entrar na fila
	void avistar(Crianca crianca) {
		fila.add(crianca); //Entrou na fila
	}
	
	void status() {
		System.out.println("Na fila: " + fila);
        System.out.println("No Trem: " + no_trem);
	}
	
	//Sair do vetor esperar pra entrar
	void entrar() {
		no_trem.add(fila.get(0));
        fila.remove(no_trem.get(0));
	}
	
	void saindo() {
		fila.add(no_trem.get(0));
        no_trem.remove(no_trem.get(0));
	}
	
	
	
	public static void main(String[] args) {
        Trenzinho trem_1 = new Trenzinho();
        Scanner leitor = new Scanner (System.in);

        while (true) {
            String line = leitor.nextLine();
            String [] ui = line.split(" ");
            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("chegar")) {
                trem_1.avistar(new Crianca(ui[1], Integer.parseInt(ui[2])));
                trem_1.status();
            } else if (ui[0].equals("entrar")) {
                trem_1.entrar();
                trem_1.status();
            } else if (ui[0].equals("sair")) {
                trem_1.saindo();
                trem_1.status();
            }
        }
        leitor.close();
    }
	
	
	
	
	
	
	
}
