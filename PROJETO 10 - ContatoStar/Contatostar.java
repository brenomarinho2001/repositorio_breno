package contatostar;

import java.util.*;



class Fone {
	//ATRIBUTOS
	String numero;
    String rotulo;
 
//M�TODOS ESPECIAIS
Fone(String rotulo, String numero) 
{
        this.rotulo = rotulo;
        this.numero = numero;
}

//GETTERS 
	public String getrotulo()
	{
    return this.rotulo;
	}

	public String getNumero()
	{
    return this.numero;
	}
	
//---------------------------------
	
    Fone(String serial) 
    {
        String array[] = serial.split("///");
        rotulo = array[0];
        numero = array[1];
    }

    
    public String toString() 
    {
        return rotulo + ":" + numero;
    }
}






//--------------- CONTATO -------------------







class Contato {
//ATRIBUTOS
String nome;
ArrayList<Fone> telefones;


//M�TODOS ESPECIAIS 
public Contato(String nome, List <Fone> telefones) 
{
this.nome = nome; 
this.telefones = new ArrayList<>(); //PARA O ARRAY N�O FICAR NULL
}
	

	//--------M�TODOS 
							//rotulo e numero ADICIONANDO NO ARRAY! 
void addFone(String r, String n) 
{
telefones.add(new Fone(r, n));
}

//TIRANDO O FONE DO SISTEMA PELO INDEX 
void rmFone(int i)
{
telefones.remove(telefones.get(i));
}
    
//----------------------------------------------    

	//GETTERS (PEGANDO NOME DO CONTATO)
    String getNome() 
    {
    return nome;
    }

    
    //TO STRING
    public String toString()
    {
    String aux = "";
    aux += "" + nome + " : " + telefones; //MOSTRANDO O NOME DO CONTATO E OS TELEFONES
    return aux;
    }
}












//-------------- AGENDA -----------------










class Agenda {
//ATRIBUTOS 
  Map <String, Contato> contatos;

  
  //M�TODOS ESPECIAIS 
  public Agenda() {//DEFININDO O MAP CONTATOS
      contatos = new TreeMap<>();
  }

  
  
  //---------- M�TODOS ----------------

  //TIRANDO CONTTO DOS SISTEMA
  public boolean RMC(String n)
  {
	  //REMOVENDO DO MAP
      Contato contato = getContato(n);
      contatos.remove(n);
      return true;
  }
  
  
  
  //ADICIONAR CONTATO NA AGENDA 
void addContato (Contato c, List<Fone> t) 
{
//SE N�O CONTER O NOME NOS CONTATOS 
if (!contatos.containsKey(c.nome)) 
{
//COLOCAR O NOME E O CONTATO 
contatos.put(c.nome, c);
}
}
  


//PEGAR OS CONTATOS
 ArrayList<Contato> getContatos() 
 {
 return new ArrayList<Contato>(contatos.values());
 }
 
 
 
 
 
 
 
 

Contato getContato(String n)
{
Contato c = contatos.get(n);
if (c == null) 
{

	
//SE CONTATO N�O FOR ENCONTRADO 
throw new RuntimeException("CONTATO N�O EXISTE");

} 
//SE FOR PEGAR O CONTATO
return c;
}




public String toString() 
{
String aux = "";
for (Contato contato : contatos.values()) {
 aux += contato + "\n";
      } return aux;
  }
}












//---------------- CONTATOPLUS -------------------

//HERAN�A DO CONTATO PARA CONTATO PLUS! 
class ContatoPlus extends Contato {
//ATRIBUTOS
boolean favorito; // SABER SE CONTATO � FAVORITO! FALSE OU TRUE


//-----M�TODOS ESPECIAIS-----------------

public ContatoPlus(String nome, List<Fone> telefones) 
{
super(nome, telefones);
}

    
    
    //GETTERS E SETTERS---------
      
String getNome()
{
return nome;
}

void setFavorito(boolean v) 
{
this.favorito = v;
}
    
boolean getFavorito () 
{
return favorito; //RETORNA SE � FAVORITO OU N�O
}

    
    //-----------------------------

//TO STRING 

public String toString() 
{
	
String aux = "";
    
//SE FOR FAVORITO ELE GANHA UM <3 CORA��O
if(this.favorito) {
aux += "<3" + " " + nome + ":" + telefones; //
}
else { //CASO N�O SEJA APENAS UM TRA�O 
aux += "-" + " " + nome + ":" + telefones; // 	
}
   
return aux;
 }
}













//------------ CLASS AGENDAPLUYS ----------------






//HERAN�A AGENDA PARA AGENDAPLUS
class AgendaPlus extends Agenda {
//ATRIBUTOS: 	
TreeMap<String, Contato> favoritos; //MAP DOS FAVORITOS


//M�TODOS ESPECIAIS
public AgendaPlus() 
{
favoritos = new TreeMap<>(); //DEFININDO O MAP 
}



public TreeMap<String, Contato> getFavoritos() 
{
return favoritos; //RETORNA SE � FAVORITO OU N�O
}

//M�TODOS 


//FAVORITAR PELO NOME 
void favoritar(String n) 
{
	
//PEGANDO O CONTATO PELO NOME E GUARDANDO NA VAR�AVEL "c" 
Contato c = this.getContato(n);


//SE c FRO UM CONTATO PLUS 
if (c instanceof ContatoPlus) 
{
	
ContatoPlus cplus = (ContatoPlus) c;

//SE J� FOR FAVORITO ADICIONAR NO MAP 

if(cplus.getFavorito())
{
	
favoritos.put(n, c);
	
}

//SE N�O FOR SETAR COMO CONTATO PLUS FAVORITO
if(!cplus.getFavorito())
{
	
favoritos.put(n, c);

//SETANDO COMO FAVORITO
cplus.setFavorito(true);
}
	}
}


//UNFAV UM CONTATO PELO NOME
void UNFAV (String n) 
{

//PEGANDO CONTATO ESPECIFICO PELO n 
Contato c = this.getContato(n);



ContatoPlus cp = (ContatoPlus) c;


//SE O CONTATO PLUS FOR FAVORITO AI VOC� REMOVE DOS FAVORITOS E COLOCA COMO FALSE! 
if (cp.getFavorito()) 
{
//PELO NOME E CONTATO
favoritos.remove(n, c);

cp.setFavorito(false);
}
}

}



































//------------------------ MAIN ---------------------------






public class Contatostar {
public static void main(String[] args) {
	
//CRIANDO A AGENDA 
AgendaPlus agenda = new AgendaPlus();

//SCANNER
try (Scanner l = new Scanner(System.in)){
 while(true){
try{
String line = l.nextLine();
String [] ui = line.split(" ");
if (ui[0].equals("end")){
break;
} else if (ui[0].equals("ADICIONAR")){
List<Fone> telefones = new ArrayList<>() ;
for (int i = 2; i < ui.length-1; i++) {
telefones.add(new Fone(ui[i]));
}
ContatoPlus contato = new ContatoPlus(ui[1], telefones);
 agenda.addContato(contato, telefones);
System.out.println("-------------- AGENDA ------------------");
System.out.println(agenda);
} else if(ui[0].equals("GETCONTATOS")) {
 System.out.println(agenda);
System.out.println(agenda);
} else if(ui[0].equals("FAV")) {
 agenda.favoritar(ui[1]);
 System.out.println(agenda);
} else if(ui[0].equals("UNFAV")) {
agenda.UNFAV(ui[1]);
System.out.println(agenda);
 } else if(ui[0].equals("GETFAVORITOS")) {
System.out.print(agenda.getFavoritos());
} else if(ui[0].equals("RETIRAR")) {
	agenda.RMC(ui[1]);
}
} catch (ArrayIndexOutOfBoundsException e) {
 throw e;
} catch (RuntimeException e) {
System.out.println(e.getMessage());
}
            }
        }
    }
}