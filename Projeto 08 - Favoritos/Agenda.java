package favortios;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

class Fone{
	String desc; // A ETIQUETA 
    String numero_tel;  // Vetor que guarda telefones
    
    //Métodos especiais
    Fone(String numero_tel, String desc) {
        this.numero_tel = numero_tel; 
        this.desc = desc; 
    }
    
    
    //MOSTRANDO A DESCRIÇÃO E O numero_tel
    public String toString() {
        return this.desc + ":" + this.numero_tel;
    }
    
}

class Contato{

	Boolean favorito;// FAVORITO OU NÃO?  
    ArrayList<Fone> lista; // array que guarda fones

    Contato() {
        this.favorito = false; // se é ou não um contato favorito
        this.lista = new ArrayList<Fone>(); // define a lista de numero_tels
    }

    
    //RETORNAR O CONTATO
    public String toString() {
        String listaconsole = "";
        for (int i = 0; i < lista.size(); i++) {
            Fone telefone = lista.get(i);
            listaconsole += " [" + i + ":" + telefone + "]";
        }
        return listaconsole;
    }
}


public class Agenda {
	Map<String, Contato> listaDeContatos;

		
	//CRIANDO UMA NOVA LISTA DE CONTATOS ASSIM QUE A ag1 FOR CRIADA
    Agenda() {
        this.listaDeContatos = new TreeMap<>();
    }
	
    boolean verificarnumero_tel(String number) {// VERIFICAR SE O numero_tel É VALIDO
    	
    	 String numero_tel_escolhidos = "1234567890().";
        boolean resutado_r = true;
        for (int i = 0; i < number.length(); i++) {//ANDANDO PELO NUMBER
            if (resutado_r == false) { //SE FOR FALSE ELE SAI
                break;
            }
            int contagem = 0;
            for (int j = 0; j < numero_tel_escolhidos.length(); j++) {
                if (number.charAt(i) != numero_tel_escolhidos.charAt(j)) {
                    contagem += 1;
                }
                if (contagem == numero_tel_escolhidos.length()) {
                	
                    resutado_r = false;//SE ELE CHEGAR A SER IGUA QUER DIZENDO QUE ELE NÃO É IGUAL A NENHUM DA LISTA
                }
            }
        }
        
        return resutado_r;
    }
    
    
    //VERIFICA SE O CONTATO ESTÁ NA LISTA
	 boolean Verificacao_De_Contato(String n) {
         if (listaDeContatos.containsKey(n)) {
        	 
             return true;
         }
         
     return false;
	 }
	

	 //PEGAR O CONTATO DETERMINADO SE NÃO ACHAR RETORNA NULL
	 Contato getContato(String n) {
		 
	    if (listaDeContatos.containsKey(n)) {
	    	
	     return listaDeContatos.get(n);
	    }   
	    
	        return null;
	    }
	 
	 
	 //ADICIONAR FAVORITOS 
	 void adicionarFavorito(String n) {
	        if (Verificacao_De_Contato(n) == true) {
	        	
	            if (getContato(n).favorito == true){ //VERIFICA SE O CONTATO ESTÁ NA LISTA
	                System.out.println("ESSE CONTATO JÁ ESTÁ NA LISTA DE FAVORITOS!! :)");
	                return;
	            }
	            
	            getContato(n).favorito = true; //SE NÃO TIVER COLOCA ELE NA LISTA
	            return;
	        }
	        
	        System.out.println("CONTATO NÃO EXISTE");
	    }
	 
	 
	 
	 //REMOVER DOS FAVORITOS PELO n
	    void removerFavorito(String n) {
	        if (Verificacao_De_Contato(n) == true) {
	        if (getContato(n).favorito == false){
	        	
	         System.out.println("ESSE CONTATO NÃO É DA LISTA DE FAVORITOS");
	         return;
	         }
	        
	        getContato(n).favorito = false;
	        return;
	        }
	        System.out.println("CONTATO NÃO EXISTE");
	    }
	    
	    
	    
    //ADICIONAR CONTATO NO MAP
	void adicionarContato(String n) {
        if (Verificacao_De_Contato(n) == true) { //SE CONTATO TIVER O MESMO n
            System.out.println("CONTATO JÁ EXISTE");
            return;
        }
        listaDeContatos.put(n, new Contato()); //ADICIONANDO CONTATO
    }
	
	//REMOVER CONTATO
    void removerContato(String contatin) {
        listaDeContatos.remove(contatin); //APENAS TIRA DIRETO O CONTATO 
    }
    
    void AdicionarNumero_Tel(String n, String desc, String numero_tel) {
        if (Verificacao_De_Contato(n) == true && verificarnumero_tel(numero_tel) == true) {
            getContato(n).lista.add(new Fone(numero_tel, desc));
            return;
        }
        if (verificarnumero_tel(numero_tel) == false){
            System.out.println("CONTATO INVALIDO");
            return;
        }
        System.out.println("CONTATO NÃO EXISTE");
    }
    
    void removerNumero(String nome, String index) {
        if (Verificacao_De_Contato(nome) == true) {
            if (Integer.parseInt(index) > getContato(nome).lista.size() || Integer.parseInt(index) < 0){
            	
                System.out.println("LOCAL DO INDICE INVALIDO");
                return;
            }
            getContato(nome).lista.remove(Integer.parseInt(index));
            return;
        }
        System.out.println("CONTATO NÃO FOI ENCONTRADO");
    }
    
    
    
    //MOSTRAR QUAIS CONTATOS SÃO FAVORITOS
    void favoritos (){
    	//Cria novo MAP AUXILIZAR PARA FAVORITOS
        Map<String, Contato> a_x = new TreeMap<>();
        for (Map.Entry<String, Contato> entry : listaDeContatos.entrySet()){//rodar a procura de favs
            if (entry.getValue().favorito == true){
                a_x.put(entry.getKey(), entry.getValue());//COLOCA OS FAVORITOS EM OUTRO MAP
            }
        }
        for (Map.Entry<String, Contato> entry : a_x.entrySet()) {
            System.out.println("<3" + entry.getKey() + " " + entry.getValue());//mostrar os favs
        }
    }
    
    

    //SE FOR FAVORITO ELE MOSTRA O < senão ele mostra o -
    String dar_favorito (Boolean bool){
    	
    	//BOOL SE ELE FOR FAVORITO = TRUE
        if (bool == true){
            return "<3 ";
        }
        return "- ";
    }
    
    //MÉTODO TO STRING
    public String toString(){
        String a_x = "";
        for (Map.Entry<String, Contato> entry : listaDeContatos.entrySet()){
            a_x +=(dar_favorito(entry.getValue().favorito) + entry.getKey() + " " + entry.getValue()) + "\n";
        }
        return a_x;
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Agenda ag1 = new Agenda();
		 System.out.println(ag1);
		
		 System.out.println("---------INICIANDO AGENDA --------");
		 System.out.println(" COMANDOS 1 ADD_C (STRING) " + "\n COMANDOS 2 STOP (DAR UM BREAK NO WHILE)" + "\n COMANDOS 3 REMOVE_C (STRING) " + "\n ADD_NUM (STRING) " + "\n AGENDA (MOSTRA QUEM ESTÁ NA AGENDA) " + "\n ADD_FAV (STRING) " + "\n REMOVE_FAV (STRING) ");
		while(true){
	        String line = scanner.nextLine();
	        String ui[] = line.split(" ");
	        if (ui[0].equals("ADD_C")){
	            ag1.adicionarContato(ui[1]);
	        } else if(ui[0].equals("STOP")){
	            break;
	        } else if(ui[0].equals("REMOVE_C")){
	            ag1.removerContato(ui[1]);
	        }else if(ui[0].equals("ADD_NUM")){
	            ag1.AdicionarNumero_Tel(ui[1], ui[2], ui[3]);;
	        } else if (ui[0].equals("REMOVE_NUM")){
	            ag1.removerNumero(ui[1], ui[2]);
	        } else if (ui[0].equals("AGENDA")){
	            System.out.println(ag1);
	        } else if (ui[0].equals("ADD_FAV")){
	            ag1.adicionarFavorito(ui[1]);
	        } else if (ui[0].equals("REMOVE_FAV")){
	            ag1.removerFavorito(ui[1]);
	            } else {
	            System.out.println("COMANDO INVALIDO");
	        }
	    }
	    scanner.close();
	    
	    }
	    
}
