package org.com;

import org.com.estructuras.GestorLavanderia;
public class Main {

    private static void cargarDatosDePrueba(GestorLavanderia gestor) {
        String[] telas = {"Algodon", "Seda", "Sintetico", "Lana", "Mezclilla"};
        for (int i = 1; i <= 15; i++) {
            String codigo = "ORD-" + String.format("%03d", i);
            String cliente = "Cliente Prueba " + i;
            String tela = telas[i % telas.length];
            String prendas = (i + 2) + " prendas variadas";
            gestor.registrarNuevaOrdenLavado(codigo, cliente, tela, prendas);
        }
    }

    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println(String.format("Hello and welcome!"));

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            IO.println("i = " + i);
        }
    }
}
