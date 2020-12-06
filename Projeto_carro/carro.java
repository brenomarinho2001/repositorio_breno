package carro;

public class carro {
//Definindo as Atributos
int pessoas_no_carro;
int gas;
int km;
int q_gas;
int q_km;

//Definindo 
carro(int pessoas_no_carro,int gas,int km,int q_gas,int q_km){
	this.pessoas_no_carro = pessoas_no_carro;
	this.gas = gas;
	this.km = km;
	this.q_gas = q_gas;
	this.q_km = q_km;
}
	

void embarcar() {
	pessoas_no_carro += 1;
	if(pessoas_no_carro == 3){
		pessoas_no_carro = 2;
		System.out.println("limite de pessoas atingido,só podem 2 pessoas no carro");
	}
	
}

void desembarcar() {
	pessoas_no_carro -= 1;
	if(pessoas_no_carro < 0)
	{
		pessoas_no_carro = 0;
		System.out.println("não tem ninguém no carro");
	}
}

void abastecer(int n_gas) {
	//SOMA O GAS
	gas += n_gas;
	
	//CASO PASSE O LIMITE ELE FICA 100
	if(gas > 100) {
		gas = 100;
	}
}


//DIRIGINDO O CARRO
void dirigir(int q_km){
	if(pessoas_no_carro > 0 && gas > 0 && pessoas_no_carro < 2)
{
		//SE CASO O KM FOR MAIS QUE O GAS
		if(q_km > gas || q_km == gas && gas > 0)
		{
		//SE O QUE A GENTE ANDAR FOR MAIOR DO QUE O GÁS
			System.out.println("tanque vazio apos andar " + gas + "km");
			km += gas;
			gas = 0;
			
			return;
		}
		
		//SE CASO O KM FOR MENOR QUE O GAS
		if(q_km < gas && gas > 0 )
		{
			gas -= q_km;
			km += q_km;
		}
		
} 
	
	if(gas == 0)
	{
		System.out.println("tanque vazio");	
	}
		
		
		
	
	
	
	
	if(pessoas_no_carro == 0) 
	{
		System.out.println("Não tem ninguém no carro,carro está parado");
		return;
	}

	
}

public String toString() {
    return "carro : pessoas:" + pessoas_no_carro + " gas:" + gas + " km:" + km;
}

public static void main(String[] args) {
	carro gol = new carro(0,0,0,0,0); // int pessoas_no_carro,int gas,int km,int q_gas,int q_km
	
	
	gol.abastecer(400);
	gol.embarcar();
	gol.dirigir(100);
	System.out.println(gol);
	gol.desembarcar();
	System.out.println(gol);
	gol.dirigir(10);

	
}
	
	
	
	
	
	
	

	
	
	
	
	
	
}
