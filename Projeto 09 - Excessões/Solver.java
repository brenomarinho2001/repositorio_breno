package calculadora;

import java.util.Scanner;

class Calculadora{
int energia = 100;


void recarregar(int e) {
	this.energia = e;
	System.out.println("A energia recarregou " + e + " porcento");
}

void gastarbateria() {
 this.energia -= 20;
}

void calcular(String s, int n1,int n2) {
int resultado = 0;
	
switch(s) {

case("somar"):
resultado = n1 + n2;
System.out.println(resultado);
break;

case("diminuir"):
resultado = n1 - n2;
System.out.println(resultado);
break;

case("multiplicar"):
resultado = n1 * n2;	
System.out.println(resultado);
break;

case("dividir"):
resultado = n1/n2;	
System.out.println(resultado);
break;

}


}
}


public class Solver {
public static void main(String[] args) {
Calculadora c1 = new Calculadora();
Scanner scanner = new Scanner(System.in);

while(true){
    try{
        String line = scanner.nextLine();
        String[] ui = line.split(" ");
        if(ui[0].equals("end")){
            break;
        }else if(ui[0].equals("carregar")){
            c1.recarregar(Integer.parseInt(ui[1]));
        }else if(ui[0].equals("calcular")){    
        c1.calcular(String.valueOf(ui[1]), Integer.parseInt(ui[2]), Integer.parseInt(ui[3]));    
        }else{
            System.out.println("fail: comando invalido");
        }
    }catch(IndexOutOfBoundsException e){
    	//CASO A DIVISÃO SEJA POR 0 ELE EMITE ESSA MENSAGEM 
    	System.out.println("CUIDADO COM OS PARAMETROS!");
        System.out.println("NÃO É POSSÍVEL DIVIDIR POR ZERO!");
    }catch(RuntimeException e){
    	System.out.println("CUIDADO COM OS PARAMETROS!");
        System.out.println("NÃO É POSSÍVEL DIVIDIR POR ZERO!");
    }
}
scanner.close();
}
}

