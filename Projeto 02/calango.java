package projeto_calango;

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
			System.out.println("AINDA N�O � SUFICIENTE AAA mais QI!!");
			qi+=100;
			return;
		}
		
		if(qi > 200) {
			System.out.println("AGORA SIM HAHAHAHA O PODER EST� NAS MINHAS M�OS");
			qi+=100;
			return;
		}

	}
	
	void briga() {
		
		if(qi < 50)
		{
			vida -= 1;
		System.out.println("EU N�O ACREDITO,PERDI POR QUE ESTOU BURRO AINDA! estou morrendo..");
		}
		
		if(qi > 50)
		{
			vida += 1;
		System.out.println("MINHA VIDA EST� SE PROLONGANDO HAHAHAHAH esse � o poder.");
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
			System.out.println("ainda n�o tenho um organismo evoluido,preciso ver para sempre");
		}
	}
	
	
	public String toString() {
        return "calango : energia:" + energia + " vida:" + vida + " qi:" + qi;
    }
	
	
	 public static void main(String[] args) { 
		 calango genio = new calango(3,4,10);
		
		 
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
