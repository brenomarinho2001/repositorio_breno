package busca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//--------CLASS FONE
class Fone {
String numero;
String desc;
public Fone(String numero, String desc) {
	this.numero = numero;
	this.desc = desc;
}
public String toString (){
    return this.numero + ":" + this.desc;
}
}

//--------CLASSE CONTATO
class Contato{
String nome; // nome da pessoa do contato
ArrayList<Fone> lista = new ArrayList<Fone>(); //guardar os numeros na lista


public Contato(String nome) {
	this.nome = nome;
	this.lista = lista;
}

boolean VerificadorDeNumeros (String n){
boolean r = true; // Resultado
int contador = 0;

String numeros_c = "123456789().";

for(int i = 0; i < n.length(); i++){
    if(r == false){
        break;
    }
    
//SE ELE ENCONTRAR UM CARACTERE DIFERENTE DOS CORRETOS ELE ADICIONA UM NO CONTADOR
for(int j = 0; j < n.length(); j++){
     if(n.charAt(i) != n.charAt(j)){
     contador = contador + 1;
}  
    
     if(contador == numeros_c.length()){
    	 r = false;
      }
}

}

return r;

}

//MOSTRANDO O NOME MAIS O NUMERO DA PESSOA 
public String toString (){
    String espelhodalista = "";
    for(int i = 0; i < lista.size(); i++){
        Fone telefone = lista.get(i);
        espelhodalista += "["+ i+telefone + "]";
    }
    return this.nome + espelhodalista;
}

}



//-----------------CLASSE ORGANIZAR EM ORDEM ALFABETICA 
class OrganizarEmOrdemAlfabetica implements Comparator<Contato>{
    public int compare(Contato one, Contato two){
        return one.nome.compareTo(two.nome);
    }
}

//-----------------CLASSE AGENDA
public class Agenda {
	
ArrayList<Contato> listaDeContatos;

public Agenda() {
	this.listaDeContatos = new ArrayList<Contato>();
}

boolean verificarNumero (String n){
    boolean r = true;
    String numeros_c = "1234567890().";
    for(int i = 0; i < n.length(); i++){
        if(r == false){
            break;
        }
        int contador = 0;
        for(int y = 0;y < numeros_c.length(); y++){
            if(n.charAt(i)!= numeros_c.charAt(y)){
                contador = contador + 1;
            }
            if(contador == numeros_c.length()){
                r = false;
            }
        }
    }
    return r;
}




void agenda(){
    Collections.sort(listaDeContatos, new OrganizarEmOrdemAlfabetica());
    for (Contato contato : listaDeContatos){
        System.out.println("- " + contato);
    }
}


//ADICIONAR NUMERO
void adicionarNumero(String n, String desc, String num){
    if (verificarContato(n) == true){
        getContato(n).lista.add(new Fone(num, desc));
        return;
    }
}

//REMOVER NUMERO
void removerNumero(String nome, String index){
        if (verificarContato(nome) == true){
            getContato(nome).lista.remove(Integer.parseInt(index));
            return;
        }
        System.out.println("fail: contato não encontrado");
    }


//ADICIONAR CONTATO 
void adicionarContato(String n){
    if(verificarContato(n) == true){
        System.out.println("----- ESTE CONTATO JÁ EXISTE ------");
        return;
    }
    listaDeContatos.add(new Contato(n));
}


//REMOVER DETERMINDO CONTATO PELO NOME 
void removerContato(String e){
    listaDeContatos.remove(getContatoPosition(e));
}



//PEGAR CONTATO POR STRING
Contato getContato(String n){
    for(int i = 0; i < listaDeContatos.size(); i++){
        String comparar = listaDeContatos.get(i).nome;
        if(n.equals(comparar)){
            return listaDeContatos.get(i);
        }
    }
    return null;   
}


//PEGAR POSIÇÃO PELO NOME 
int getContatoPosition(String n){
    for(int i = 0; i < listaDeContatos.size(); i++){
        String comparar = listaDeContatos.get(i).nome;
        if(n.equals(comparar)){
            return i;
        }
    }
    return -1;   
}

//VERIFICA CONTATO POR STRING NOME
boolean verificarContato(String n){
    for(int i = 0; i < listaDeContatos.size(); i++){
        String comparar = listaDeContatos.get(i).nome;
        if(n.equals(comparar)){
            return true;
        }
    }
    return false;
}


public void buscar (String entrada){
    ArrayList<Contato> aux = new ArrayList<Contato>();
    for (Contato contato : listaDeContatos){
        if (contato.nome.contains(entrada)){
            aux.add(contato);
        }
        ArrayList<Fone> listaFones = contato.lista;
        for(Fone fone : listaFones){
            if (fone.desc.contains(entrada)){
                aux.add(contato);
            }
            if (fone.numero.contains(entrada)){
                aux.add(contato);
            }
        }
    }
    for (Contato contato : aux){
        System.out.println("- " + contato);
    }
}
public static void main(String[] args) {
Agenda agenda = new Agenda();
Contato c1 = new Contato("Eduardo");

agenda.adicionarContato(c1.nome);
agenda.adicionarNumero("Breno", "contato do meu amigo","99557097");
agenda.adicionarContato("Breno");
agenda.adicionarContato("Mariana");
agenda.adicionarContato("Eudes");
System.out.println(agenda.listaDeContatos);
}
}
