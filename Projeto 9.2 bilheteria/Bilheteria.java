package bilheteria;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Venda{
Pessoa cliente;
Evento evento;
Setor setor;
Double valor;


public Venda(Pessoa cliente, Evento evento, Setor setor) {
	this.cliente = cliente;
	this.evento = evento;
	this.setor = setor;
}


	
}

class Pessoa{
String nome;
boolean meia;


public Pessoa(String nome, boolean meia) {
	this.nome = nome;
	this.meia = meia;
}


public String toString() {
	if(this.meia == true) {
		return  "Meia";	
	}
	else {
		return "Inteira";  
	}

}





void getMeia() {
	if(this.meia) {
		System.out.println("Meia");
	}
	if(!this.meia) {
		System.out.println("Inteira");
	}
	
}
}









class Evento{
String nome;
Map<String, Setor> repSetores;




public Evento(String nome) {
	this.nome = nome;
	this.repSetores = new TreeMap<>();
}

void addSetor(String n,Setor s) {
this.repSetores.put(n, s);
}










public String toString() {
	
	//MOSTRAR EVENTOS
	System.out.println("-------- SETORES DO EVENTO " + this.nome + " ----------");
	for(Setor key : repSetores.values()) {
		
		System.out.println(key.nome + " " + key.preco + " " + key.capacidade);
	}
	
	
	
	return "";



}	

}




class Setor{
String nome;
double preco;
int qtd;
int capacidade;

public Setor(String nome, double preco, int capacidade) {
	this.nome = nome;
	this.preco = preco;
	this.capacidade = capacidade;
}

void vender() {
	this.qtd += 1;
}





public String toString() {
	
	//MOSTRAR EVENTOS
	

	
	return  "";
	



}	
}








public class Bilheteria {
	ArrayList<Venda> repVendas;
	Map<String, Pessoa> repPessoas;
	Map<String,Evento> repEvento;
	double caixa;
	
	
	
	
	public Bilheteria() {
		super();
		this.repPessoas = new TreeMap<>();
		this.repEvento = new TreeMap<>();
		this.repVendas = new ArrayList<>();
	}



	void addPessoa(Pessoa p) {
		if(repPessoas.containsKey(p.nome)) {
			System.out.println("O " + p.nome + " JÁ COMPROU!");
		}
		else {
		repPessoas.put(p.nome,p);
		}
	  }
	
	
	void addEvento(String s) {
		Evento evento = new Evento(s);
		repEvento.put(s,evento);
	}
	
	
	void addSetor(String id,String n, double p, int c) {
		
		var idevento = repEvento.containsKey(id);

		
		if(idevento) {
			
			Setor s = new Setor(n,p,c);
			var a = repEvento.get(id);
			a.addSetor(n, s);
			System.out.println(a);
			
			
			
		}
		else {
			System.out.println("ESSE EVENTO NÃO EXISTE!");
		}
		
		
		
	}
	
	
	void Vender(String p,String e,String s) {
		
		var pes = repPessoas.get(p);
		var even = repEvento.get(e);
		var i = even.repSetores.get(s);
		
		
		if(repPessoas.containsKey(p) && repEvento.containsKey(e) && even.repSetores.containsKey(s)) {
			
		
		
		Venda vend = new Venda(pes,even,i);
		repVendas.add(vend);
		
		for(Venda key : repVendas) {
			System.out.println(key.valor);
		}
		}
		
	}
	
	
	
	
	
	
	
	public String toString() {
			
		var valor = 0;
		System.out.println("-------VENDA TOTAL------");
		for(var i = 0;i < repVendas.size();i++) {
			valor+= 5;
		}
		System.out.println("R$ " + valor);
		
		
		
		
		
			//MOSTRAR EVENTOS
		System.out.println("-----EVENTOS-------");
		for(Evento key : repEvento.values()) {
			System.out.println(key.nome);	
		}
		
		
		
		
			
			System.out.println("-----PESSOAS QUE COMPRARAM INGRESSO-------");
		
			for(Pessoa key : repPessoas.values()) {
				System.out.println(key.nome);	
			}
			return "" ;

}	
	
	
	
	

	public static void main(String[] args) {
		Bilheteria b = new Bilheteria();
		Scanner scanner = new Scanner(System.in);
		/*
		b.addPessoa(new Pessoa("Steve",false));
		b.addPessoa(new Pessoa("Mario",true));
		
		b.addEvento("Lolapo");
		b.addEvento("Festinhamassa");
		
		b.addSetor("Lolapo", "palco", 3.0f, 5);
		b.addSetor("Lolapo", "andar", 3.0f, 5);
		
		b.Vender("Steve", "Lolapo", "palco");
		*/

		 while (true) {
		 
		 String line = scanner.nextLine();
		 String ui[] = line.split(" ");
		                     
		  if (ui[0].equals("stop")) {
		  break;
		  }else if(ui[0].equals("AddPessoa")) {
		  b.addPessoa(new Pessoa(ui[1],Boolean.parseBoolean(ui[2])));
		  System.out.println(b);
		  } else if(ui[0].equals("AddEvento")) {
		  b.addEvento(ui[1]);
		  System.out.println(b);
		  }
		  else if(ui[0].equals("AddSetor")) {
		  b.addSetor(ui[1], ui[2], Double.parseDouble(ui[3]), Integer.parseInt(ui[4]));
		  System.out.println(b);
		  }
		  else if(ui[0].equals("Vender")) {
		  b.Vender(ui[1], ui[2], ui[3]);
		  System.out.println(b);
		  }
		  
		  
		  
		  else {
              throw new RuntimeException("\"ERROR: COMANDO INVÁLIDO!\"");
          }
		  
       
		 }
		 
}
	}
