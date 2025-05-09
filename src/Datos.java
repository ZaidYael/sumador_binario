import java.sql.SQLOutput;
import java.util.Scanner;

public class Datos {
    Scanner sc = new Scanner(System.in);
    public String entrada, sumando1, sumando2;

    public Datos(String entrada) {
        this.entrada = entrada;
    }

    public void comprobarCadena() {
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                if (!entrada.contains("+") || !entrada.endsWith("=")) {
                    System.out.println("La cadena debe contener '+' y terminar con '='.");
                } else {
                    String aux = entrada.substring(0, entrada.length() - 1);
                    String[] sumandos = aux.split("\\+");

                    if (sumandos.length != 2) {
                        System.out.println("Formato incorrecto. Debe ser: numero1+numero2=");
                    } else {
                        sumando1 = sumandos[0];
                        sumando2 = sumandos[1];
                        if (sumando1.length() != sumando2.length()) {
                            System.out.println("Los números binarios deben tener la misma longitud.");
                        }
                        else if (!sumando1.matches("[01]+") || !sumando2.matches("[01]+")) {
                            System.out.println("Uno o ambos sumandos NO son números binarios.");
                        } else {
                            System.out.println("La cadena es válida.");
                            entradaValida = true;
                        }
                    }
                }

                if (!entradaValida) {
                    System.out.print("Ingresa de nuevo los números a sumar: ");
                    entrada = sc.nextLine();
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor escribe la cadena correctamente de la forma numero1+numero2=");
                entrada = sc.nextLine();
            }
        }
    }
}

