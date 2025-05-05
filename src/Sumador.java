public class Sumador {
    int pointer=0;
    String carry;
    String entrada;
    private void moverDerecha(){
        pointer++;
    }
    private void moverIzquierda(){
        pointer--;
    }

    public Sumador(String entrada){
        this.entrada=entrada;
    }
    public void q0(){
        while (entrada.charAt(pointer) != '+'){
            pointer++;
        }
        q1();
    }
    public void q1(){


        try {
            do {
                pointer--;
            } while (entrada.charAt(pointer) != '1' && entrada.charAt(pointer) != '0');
        
	        char aux = entrada.charAt(pointer);
	        String temp = "";
	        int count = 0;
	        for (count = 0; count < pointer; count++) {
	            temp = temp + entrada.charAt(count);
	        }
	        temp = temp + "_";
	        for (count = pointer +1; count < entrada.length(); count++) {
	            temp = temp + entrada.charAt(count);
	        }
	        entrada = temp;
	        switch (aux){
	            case '1':
	                q2();
	                break;
	            case '0':
	                q3();
	                break;
	                
	        }
        }catch (Exception e){
            pointer++;
            q11();
        }
    }

    public void q2(){


    	do {
            pointer++;
        }while (entrada.charAt(pointer) != '=');
        q4();
    }

    public void q3(){

        do {
            pointer++;
        }while (entrada.charAt(pointer) != '=');

        q5();
    }

    public void q4(){


        do {
            pointer--;
        }while (entrada.charAt(pointer) != '1' && entrada.charAt(pointer)!='0');
        char aux = entrada.charAt(pointer);
        String temp = "";
        int count = 0;
        for (count = 0; count < pointer; count++) {
            temp = temp + entrada.charAt(count);
        }
        temp = temp + "_";
        for (count = pointer +1; count < entrada.length(); count++) {
            temp = temp + entrada.charAt(count);
        }
        entrada = temp;
        switch (aux) {
        case '1':
            q12();
        	break;
        case '0':
            q6();
        	break;
        }
    }

    public void q5(){

    	do {
            pointer--;
        }while (entrada.charAt(pointer) != '1' && entrada.charAt(pointer)!='0');
        char aux = entrada.charAt(pointer);
        String temp = "";
        int count = 0;
        for (count = 0; count < pointer; count++) {
            temp = temp + entrada.charAt(count);
        }
        temp = temp + "_";
        for (count = pointer +1; count < entrada.length(); count++) {
            temp = temp + entrada.charAt(count);
        }
        entrada = temp;
        switch (aux){
            case '1':
                q6();
                break;
            case '0':
                q7();
                break;
        }
    }

    public void q6(){
        do {
            pointer++;
        }while (pointer != (entrada.length() - 1)&& entrada.charAt(pointer) != 'z');
        
        if (entrada.charAt(pointer) == 'z'){
        	entrada = entrada.replace('z', '0');
        	q8();
        } else {
            entrada += "1";
            q9();
        }
    }
	
    public void q7(){


        String temp = "";
        do {
            pointer++;
        }while (pointer!= entrada.length());
        entrada += "0";
        q9();
    }
    public void q8(){


        entrada+="z";
        q9();

    }
    public void q9(){


        do{
            pointer--;
        } while (pointer>0);
        q0();
    }

    public void q11(){


        do {
            pointer++;
        }while (entrada.charAt(pointer) != 'z' && pointer!= (entrada.length() - 1));
        entrada = entrada.replace('z','1');
        System.out.println(entrada);
    }
    
    public void q12(){
        do {
            pointer++;
        }while (entrada.charAt(pointer) != 'z' && pointer != (entrada.length() - 1));
        if ( entrada.contains("z")){
            entrada = entrada.replace('z','1');
        }else {
            entrada += "0";
        }
        q8();
    }
}
