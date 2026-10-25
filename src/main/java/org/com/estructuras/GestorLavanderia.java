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

    public OrdenLavado procesarSiguienteOrdenPendiente() {
        OrdenLavado ordenEnTurno = null;
        while (!colaPendientes.esVacia()) {
            ordenEnTurno = (OrdenLavado) colaPendientes.desencolar();
            if (listaGeneral.contiene(ordenEnTurno)) {
                break;
            }
            ordenEnTurno = null;
        }
        if (ordenEnTurno != null) {
            historialProcesados.apilar(ordenEnTurno);
            return ordenEnTurno;
        }
        return null;
    }

    public OrdenLavado revertirUltimaOrdenProcesada() {
        if (historialProcesados.esVacia()) {
            return null;
        }
        OrdenLavado ordenRevertida = (OrdenLavado) historialProcesados.desapilar();
        colaPendientes.encolar(ordenRevertida);
        return ordenRevertida;
    }

    public boolean cancelarOrdenPendiente(String codigo) {
        OrdenLavado ordenObjetivo = new OrdenLavado(codigo, "", null, "");
        int indice = listaGeneral.buscarDato(ordenObjetivo);
        if (indice != -1) {
            listaGeneral.eliminarEnPosicion(indice);
            return true;
        }
        return false;
    }

    public OrdenLavado buscarOrdenEnRegistroGeneral(String codigo) {
        OrdenLavado ordenFicticia = new OrdenLavado(codigo, "", null, "");
        int indice = listaGeneral.buscarDato(ordenFicticia);
        if (indice != -1) {
            return (OrdenLavado) listaGeneral.buscarDato(indice);
        }
        return null;
    }
}
