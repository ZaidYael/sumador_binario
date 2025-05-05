import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada=sc.nextLine();
        Datos datos= new Datos(entrada);
        datos.comprobarCadena();
        Sumador sum = new Sumador(entrada);
        sum.q0();

    }
}
