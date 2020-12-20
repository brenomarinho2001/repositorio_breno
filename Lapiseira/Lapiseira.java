package lapiseira;

//-----------------------------------CLASSE GRAFITE----------------------------------------------------
class Grafite {
	//ATRIBUTOS DO GRAFITE
	public float espessura;
	public int qualidade;
	public int tamanho;
	
	//METODO CONSTRUTOR 
	public Grafite(float espessura,int qualidade,int tamanho) {
		this.espessura = espessura;
		this.tamanho = tamanho;
		this.qualidade = qualidade;
	}
	
	  public String toString() {
	        return " Espessura: " + espessura + "Qualidade: " + qualidade + "Tamanho: " + tamanho + "]";
	    }
	}
	
	
	
	//--------------------------------CLASS LAPISEIRA-------------------------------------------------
//ATRIBUTOS LAPISEIRA
public class Lapiseira {
	float espessura; 
	public String cor;
	Grafite grafite;
	boolean quebrada;
	
	
	//METODO CONSTRUTOR DA LAPISEIRA
	Lapiseira(float espessura,String cor,boolean quebrada) {
		this.espessura = espessura;
        this.cor = cor;
        this.quebrada = quebrada;
        this.grafite = null;
    }
	
	
	 void inserir (Grafite grafite) {
		 if(quebrada == false) {
	        if (this.grafite != null)
	        {
	            System.out.println("Há um grafite");
	        }
	        else if (this.espessura < grafite.espessura) 
	        {
	            System.out.println("grafite não cabe na lapiseira");
	        } else {
	            this.grafite = grafite;
	            System.out.println("o grafite entrou");
	        }
	    }
		 else {
			 System.out.println("Lápiseira está quebrada");
		 }
	 }
	 
	 void remover() {
		 if(this.grafite != null) {
			 this.grafite = null;
			 System.out.println("O GRAFITE FOI RETIRADO!!");
		 }
	 }
	 
	 void desenhar() {
		 if(this.grafite != null)
		 {
		 if(this.grafite.tamanho > 0) {
		 if(this.grafite != null)
		 {
			System.out.println("VOCÊ ESTÁ DESENHANDO :D ");
			this.grafite.tamanho-=1;
			System.out.println("Seu grafite diminuiu de tamanho,seu tamanho agora é : " + this.grafite.tamanho);
		 }
		 }
		 if(this.grafite.tamanho <= 0) {
			 System.out.println("Seu grafite acabou :(");
			 this.grafite = null;
		 }
	 }
		 else {
			 System.out.println("NÃO EXISTE GRAFITE!!");
		 }
	 }
	 
	 
	 
	
	 
	  public String toString() {
		  
	        return " Espessura: " + espessura + "/cor: " + cor + "/Existe grafite: " + grafite;
		  
	    }
	  
	 
	
	
	
	
	
	public static void main(String[] args) {
		Lapiseira bic = new Lapiseira(.7f,"Azul",false);
		
		
		System.out.println(bic);
		bic.inserir(new Grafite(.7f,3,0));
		bic.desenhar();
		bic.desenhar();
		bic.inserir(new Grafite(.7f,3,5));
		bic.desenhar();
		bic.remover();
		bic.desenhar();
		
	
	}
	
	

}
