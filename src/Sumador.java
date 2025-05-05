public class Sumador {
    int pointer = 0;
    String entrada;

    public Sumador(String entrada) {
        this.entrada = entrada;
    }

    private void moverDerecha() {
        pointer++;
    }

    private void moverIzquierda() {
        pointer--;
    }

    public void q0() {
        while (entrada.charAt(pointer) != '+') {
            moverDerecha();
        }
        q1();
    }

    public void q1() {
        try {
            do {
                moverIzquierda();
            } while (entrada.charAt(pointer) != '1' && entrada.charAt(pointer) != '0');

            char aux = entrada.charAt(pointer);
            entrada = reemplazar(pointer, '_');

            if (aux == '1') {
                q2(); // bit izquierdo 1
            } else {
                q3(); // bit izquierdo 0
            }
        } catch (Exception e) {
            pointer++;
            q11();
        }
    }

    public void q2() {
        while (entrada.charAt(pointer) != '=') {
            moverDerecha();
        }
        q4(); // 1 + ?
    }

    public void q3() {
        while (entrada.charAt(pointer) != '=') {
            moverDerecha();
        }
        q5(); // 0 + ?
    }

    public void q4() {
        do {
            moverIzquierda();
        } while (entrada.charAt(pointer) != '1' && entrada.charAt(pointer) != '0');
        char aux = entrada.charAt(pointer);
        entrada = reemplazar(pointer, '_');

        if (aux == '1') {
            q12(); // 1 + 1
        } else {
            q6(); // 1 + 0
        }
    }

    public void q5() {
        do {
            moverIzquierda();
        } while (entrada.charAt(pointer) != '1' && entrada.charAt(pointer) != '0');
        char aux = entrada.charAt(pointer);
        entrada = reemplazar(pointer, '_');

        if (aux == '1') {
            q6(); // 0 + 1
        } else {
            q7(); // 0 + 0
        }
    }

    public void q6() {
        while (pointer < entrada.length() && entrada.charAt(pointer) != 'z') {
            moverDerecha();
        }

        if (pointer == entrada.length()) {
            entrada += "1";
        } else {
            entrada = reemplazar(pointer, 'z'); // acarreo
        }

        q9(); // volver al inicio
    }

    public void q7() {
        while (pointer < entrada.length()) {
            moverDerecha();
        }
        entrada += "0"; // suma sin acarreo
        q9();
    }

    public void q8() {
        entrada += "z"; // continuar acarreo
        q9();
    }

    public void q9() {
        pointer = 0;
        q0();
    }

    public void q11() {
        while (pointer < entrada.length() && entrada.charAt(pointer) != 'z') {
            moverDerecha();
        }

        entrada = entrada.replace("z", "1");
        System.out.println(entrada);
    }

    public void q12() {
        while (pointer < entrada.length() && entrada.charAt(pointer) != 'z') {
            moverDerecha();
        }

        if (entrada.contains("z")) {
            entrada = entrada.replaceFirst("z", "1");
        } else {
            entrada += "0"; // hay acarreo
        }

        q8();
    }

    private String reemplazar(int pos, char nuevo) {
        return entrada.substring(0, pos) + nuevo + entrada.substring(pos + 1);
    }
}
