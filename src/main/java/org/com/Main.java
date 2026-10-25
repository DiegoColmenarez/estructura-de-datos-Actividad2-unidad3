package org.com;

import org.com.estructuras.GestorLavanderia;
import org.com.ui.MenuLavanderia;

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
        GestorLavanderia gestor = new GestorLavanderia();
        cargarDatosDePrueba(gestor);
        MenuLavanderia menu = new MenuLavanderia(gestor);
        menu.iniciar();
    }
}
