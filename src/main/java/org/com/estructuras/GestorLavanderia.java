package org.com.estructuras;

public class GestorLavanderia {
    private final Lista listaGeneral;
    private final Cola colaPendientes;
    private final Pila historialProcesados;

    public GestorLavanderia() {
        this.listaGeneral = new Lista();
        this.colaPendientes = new Cola();
        this.historialProcesados = new Pila();
    }

    public void registrarNuevaOrdenLavado(String codigo, String cliente, String Tipotela, String prendas) {
        OrdenLavado ordenFicticia = new OrdenLavado(codigo, "", null, "");
        if (listaGeneral.contiene(ordenFicticia)) {
            System.out.println("ERROR DEL SISTEMA: La orden con código '" + codigo + "' ya existe.");
            return;
        }
        OrdenLavado nuevaOrden = new OrdenLavado(codigo, cliente, Tipotela, prendas);
        listaGeneral.agregar(nuevaOrden);
        colaPendientes.encolar(nuevaOrden);
    }
}
