package tamagochi;

public class Tamagochi {
	//ATRIBUTOS
	
	//OUTROS
	 int diamantes;
	 int idade;
	
	//ENERGIA
	private int energy;
	private int energyMax;
	
	//SACIEDADE E VIVO
	private int saciedade;
	private boolean vivo;
	
	//FOME
	private int hungry;
    private int hungryMax;
	
    //LIMPEZA
    private int clean;
    private int cleanMax;
    
    
	//METÓDOS ESPECIAIS
    public Tamagochi(int energyMax, int hungryMax,int cleanMax) {
		super();
		this.energy = energyMax;
		this.energyMax = energyMax;
		this.vivo = true;
		this.hungry = hungryMax;
		this.hungryMax = hungryMax;
		this.cleanMax = cleanMax;
		this.clean = cleanMax;
		this.idade = 0;
        this.diamantes = 0;
		
	}


	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getEnergyMax() {
		return energyMax;
	}

	public void setEnergyMax(int energyMax) {
		this.energyMax = energyMax;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public int getHungry() {
		return hungry;
	}

	public void setHungry(int hungry) {
		this.hungry = hungry;
	}

	public int getHungryMax() {
		return hungryMax;
	}

	public void setHungryMax(int hungryMax) {
		this.hungryMax = hungryMax;
	}
	
	
	public int getClean() {
		return clean;
	}

	public void setClean(int clean) {
		this.clean = clean;
	}


	public int getCleanMax() {
		return cleanMax;
	}


	public void setCleanMax(int cleanMax) {
		this.cleanMax = cleanMax;
	}


	public String toString(){
		 	System.out.println("-------MENU----------");
	        return "Sua energia é: " + energy + "/" + energyMax + " Sua fome é: " + hungry + "/" + hungryMax + " Sua limpeza é: "  + this.getClean() + "/" + this.cleanMax + " IDADE: " + this.idade ; 
	    }
	
	
	
	//METODOS 
	// BRINCAR , COMER , DORMIR , BANHO , MORRER
	
	public void brincar() {
	//SE TIVER VIVO E ENERGIA MAIOR QUE 0 PODE BRINCAR 
	if(this.getEnergy() > 0 && this.isVivo() && this.getEnergy() > 0 && this.getEnergy() <= this.getEnergyMax()) {
	this.setEnergy(this.getEnergy()-2);
	System.out.println("---VOCÊ ACABOU DE BRINCAR!---");
	if(this.getClean() > 0) {
	this.setClean(this.getClean() - 2);
	this.idade += 1;
	}
	
	}
	//SE ENERGIA FOR MENOR QUE ZERO 
	if(this.getEnergy() < 0) {
		System.out.println("SUA ENEGIA É MENOR QUE ZERO");
	}
	
	if(this.getClean() <= 0) {
		this.setVivo(false);
		System.out.println("-----/////---------------");
		System.out.println("SEU BIXINHO MORREU :( E MORTOS NÃO BRINCAM");
		System.out.println("-----/////---------------");
		}

	}
	
	public void comer() {
		if(this.isVivo() && this.getHungry() <= this.getHungryMax() && this.getHungry() > 0) {	
		System.out.println("VOCÊ SE ALIMENTOU!! E PERDEU DOIS DE FOME!");
		this.idade += 1;
		this.setHungry(this.getHungry()-2);
		}
		
		if(this.getClean() <= 0) {
			this.setVivo(false);
			System.out.println("-----/////---------------");
			System.out.println("SEU BIXINHO MORREU :( E MORTOS NÃO BRINCAM");
			System.out.println("-----/////---------------");
			}
	}
	
	public void dormir() {
	
	if(this.isVivo()) {
		if(this.getEnergy() < this.getEnergyMax())
		{
			System.out.println("VOCÊ RECUPEROU 2 DE ENERGIA");
			this.idade += 1;
			this.setEnergy(this.getEnergy() + 2);
		}
	}
	if(this.getClean() <= 0) {
		this.setVivo(false);
		System.out.println("-----/////---------------");
		System.out.println("SEU BIXINHO MORREU :( E MORTOS NÃO BRINCAM");
		System.out.println("-----/////---------------");
		}
	}
	
	
	public static void main(String[] args) {
	Tamagochi pow = new Tamagochi(10,10,10);
	
	System.out.println(pow);
	pow.brincar();
	pow.brincar();
	pow.brincar();
	pow.brincar();
	pow.brincar();
	pow.comer();
	
	System.out.println(pow);
	
	}
	
	
}