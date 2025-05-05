import java.util.Scanner;
public class Datos {
    public String entrada, sumando1, sumando2;
    private boolean comprobacion;

    public Datos(String entrada) {
        this.entrada = entrada;
    }
    //comprueba si ambos sumandos son de la misma longitud
    public void comprobarCadena(){
        String aux =entrada;
        if (aux.endsWith("=")) {
            aux = aux.substring(0, aux.length() - 1);
        }
        String [] sumandos = aux.split("\\+");
        sumando1=sumandos[0];
        sumando2=sumandos[1];
         if(comprobacion=sumando1.length()!=sumando2.length()){
             System.out.println("Los numeros binarios son de distinta longitud");
             System.exit(0);
         }
        System.out.println("Se ha comprobado que los numeros son de la misma longitud");
         sonBinarios(sumando1,sumando2);
    }
    //comprueba si ambos sumandos son numeros binarios
        public void sonBinarios(String sumando1, String sumando2){
            if(!sumando1.matches("[0-1]*")||!sumando2.matches("[0-1]*")){
                System.out.println("Uno o ambos sumandos NO son numeros binarios");
                System.exit(0);
            }
            System.out.println("Se ha comprobado que los numeros son binarios");
        }
}
