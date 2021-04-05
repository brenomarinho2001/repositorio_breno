package twutter;



import java.util.Scanner;




public class Main 
{
public static void main(String[] args) throws Exception {
Controlador c1 = new Controlador();
Scanner aux = new Scanner(System.in);
while (true) {
String is = aux.nextLine();
String[] up = is.split(" ");

try {
if (up[0].equalsIgnoreCase("FIM"))
break;

else if (up[0].equalsIgnoreCase("SENDTWEET")) {
StringBuilder solver = new StringBuilder();
for (int i = 2; i < up.length; i++)
solver.append(up[i]).append(" ");
c1.sendTweet(up[1], solver.toString());
}

else if (up[0].equalsIgnoreCase("FOLLOW"))
    c1.follow(up[1], up[2]);

else if (up[0].equalsIgnoreCase("UNFOLLOW"))
    c1.unfollow(up[1], up[2]);

else if (up[0].equalsIgnoreCase("GETUSER"))
                    c1.getUser(up[1]);

else if (up[0].equalsIgnoreCase("LIKE"))
c1.like(up[1], Integer.parseInt(up[2]));

else if (up[0].equalsIgnoreCase("ADDUSER"))
c1.addUser(up[1]);

else if (up[0].equalsIgnoreCase("TIMELINE"))
System.out.println(c1.timeLine(up[1]));

else
System.out.println("OPERAÇÃO INVALIDA");

} catch (IndexOutOfBoundsException g) {
                System.out.println("ERROR");
} catch (Exception g) {
                System.out.println(g.toString());
}
}
 aux.close();
    }
}