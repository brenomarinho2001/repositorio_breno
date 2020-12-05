package projeto_calango;

import java.util.Scanner;

public class calango {
	int vida;
	int energia;
	int qi;
	
	
    calango(int vida,int energia,int qi){
        this.energia = energia;
        this.vida = vida;
        this.qi = qi;
    }
	
	
	void sabedoria(){
		if(qi > 5 && qi < 15) {
			System.out.println("Estou burro,preciso de mais poder");
			qi+=50;
			return;
		}
		
		if(qi > 50 && qi < 200) {
			System.out.println("AINDA NÃO É SUFICIENTE AAA mais QI!!");
			qi+=100;
			return;
		}
		
		if(qi > 200) {
			System.out.println("AGORA SIM HAHAHAHA O PODER ESTÁ NAS MINHAS MÃOS");
			qi+=100;
			return;
		}

	}
	
	void briga() {
		
		if(qi < 50)
		{
			vida -= 1;
		System.out.println("EU NÃO ACREDITO,PERDI POR QUE ESTOU BURRO AINDA! estou morrendo..");
		}
		
		if(qi > 50)
		{
			vida += 1;
		System.out.println("MINHA VIDA ESTÁ SE PROLONGANDO HAHAHAHAH esse é o poder.");
		}
		
		
	}
	
	void energia_fluida()
	{
		if(energia > 10) {
			System.out.println("meu neuronios borbulham por causa da minha energia");
		}
		else
		{
			System.out.println(" estou um pouco cansado..");
		}
	}
	
	void eternidade()
	{
		if(vida > 5) {
			System.out.println("VIVEREI PARA SEMPRE HAHAHA...");
		}
		else {
			System.out.println("ainda não tenho um organismo evoluido,preciso ver para sempre");
		}
	}
	
	
	public String toString() {
        return "calango : energia:" + energia + " vida:" + vida + " qi:" + qi;
    }
	
	
	 public static void main(String[] args) { 
		 calango genio = new calango(3,4,10);
		
		 Scanner leitor = new Scanner(System.in);
		
		 genio.vida = leitor.nextInt();
		 
		 genio.energia = leitor.nextInt();
		 
		 genio.qi = leitor.nextInt();
		 
		 
		 
		 
		 
		 leitor.close();
		 
		 genio.briga();
		 genio.sabedoria();
		 genio.energia_fluida();
		 System.out.println(genio);
		 genio.sabedoria();
		 genio.briga();
		 genio.briga();
		 genio.briga();
		 genio.briga();
		 System.out.println(genio);
		 genio.eternidade();
		 System.out.println(genio);
	 }
	
	
	
	
	

}
