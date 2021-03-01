package topic;

import java.util.ArrayList;
import java.util.Scanner;


class Pessoa{
 String nome;
 int idade;
 
public Pessoa(String nome, int idade) {
	this.nome = nome;
	this.idade = idade;
}

public String toString(){
    return nome + ": " + idade + " ";
}
}


public class Topic {
 int maxdepessoas;
 int maiordesesenta;
 ArrayList<Pessoa> assento_n;
 ArrayList<Pessoa> assento_p;
 
 
 //METÓDOS ESPECIAIS
 Topic (int lotacaoMax, int prioridade){
     this.maxdepessoas = lotacaoMax;
     this.maiordesesenta = prioridade;
     
     
     //Array de Assentos normais
     assento_n = new ArrayList<>();
     //
     for (int i = 0; i < (this.maxdepessoas - this.maiordesesenta); i++){
         assento_n.add(null);
     }
     
     assento_p = new ArrayList<>();
     //Array de Assentos prioridade
     for (int i = 0; i < this.maiordesesenta; i++){
         assento_p.add(null);
     }
 }
 
 
 //METÓDOS SE ELE ENCONTRAR, RETORNA O ASSENTO EXATO QUE TÁ LIVRE
 int procurarVagas(ArrayList<Pessoa> a){
     for(int i = 0; i < a.size(); i++){
         if(a.get(i) == null){
             return i;
         }
     }
     return -1;
 }
 
 
 //PROCURA A PESSOA PELO NOME E RETORNA A VAGA EXATA
 int procurarPessoa(ArrayList<Pessoa> array, String p) {
     for(int i = 0; i < array.size(); i++){
         Pessoa comparar = array.get(i);
         if(comparar != null && p.equals(comparar.nome)){
             return i;
         }
     }
     return -1;
 }
 
 
 //Adicionar Pessoa 
 void AdicionarPessoa(String n,int idade) {
Pessoa p1 = new Pessoa(n,idade);

int repitido = procurarPessoa(assento_n,p1.nome);

if(repitido != -1){
    System.out.println("O " + p1.nome + " JÁ COMPROU A PASSAGEM");
    return;
}

repitido = procurarPessoa(assento_p, p1.nome);

if(repitido != -1){
    System.out.println("O " + p1.nome + " JÁ COMPROU A PASSAGEM");
    return;
}

if (procurarVagas(assento_p) == -1 && procurarVagas(assento_n) == -1){
    System.out.println("NÃO TEM VAGA"); 
    return;
}

//SE A PESSOA TEM MENOS DE 60 ANOS PROCURA SE TEM NO NORMAL
if (p1.idade < 60){
	//PROCURANDO SE TEM VAGA
    int vaga = procurarVagas(assento_n);
    
    //RETORNOU QUE NÃO ENCONTRADO "-1"
    if(vaga != -1){
  
        assento_n.set(vaga, p1);
        return;
    }
    vaga = procurarVagas(assento_p);
    assento_p.set(vaga, p1);
    return;
}

//SE A PESSOA TEM MAIS DE 60 ANOS

if (p1.idade >= 60){
    int vaga = procurarVagas(assento_p);
    if (vaga != -1){
        assento_p.set(vaga, p1);
        return;
    }
    vaga = procurarVagas(assento_n);
    assento_n.set(vaga, p1);
    return;
}
System.out.println("PARABÉNS VOCÊ ACHOU A CADEIRA!");
}

 
 
 //REMOVER PESSOA PEGANDO A STRING "P"
 void remover(String p){
	 //PROCURA PELO P NO ARRAY ASSENTO_N 
     int ps = procurarPessoa(assento_n, p);
     if (ps != -1){
    	 System.out.println(p + " FOI REMOVIDO");
         assento_n.set(ps, null);
         return;
     }
     ps = procurarPessoa(assento_p, p);
     if (ps != -1){
    	 System.out.println(p + " FOI REMOVIDO");
         assento_p.set(ps, null);
         return;
     }
     System.out.println("ESSA PESSOA NÃO EXISTE AQUI");
 }

 
 
 
 
 public String toString(){
 return assento_n + ":" + assento_p;
 }
 
 
 public static void main(String[] args) {
     System.out.println("--------VOCÊ ESTÁ EM UMA TOPICA----------");
     System.out.println("VOCÊ PODERÁ INTERAGIR COM A TOPIC");
     Scanner scanner = new Scanner(System.in);
     Topic topic = new Topic(2, 1);
     while (true){
     String line = scanner.nextLine();
     String ui[] = line.split(" ");
     if (ui[0].equals("START")){
         topic = new Topic(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
         System.out.println(topic);
     } else if (ui[0].equals("STOP")){
         break;
     } else if (ui[0].equals("ADD")){
         topic.AdicionarPessoa(ui[1], Integer.parseInt(ui[2]));
         System.out.println(topic);
     } else if (ui[0].equals("REMOVE")){
         topic.remover(ui[1]);
         System.out.println(topic);
     } else {
         System.out.println("Erro: comando invalido");
     }
     }
     scanner.close();
 }
}