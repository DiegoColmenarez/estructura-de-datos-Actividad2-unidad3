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
            Object vigente = listaGeneral.buscarDato(listaGeneral.buscarDato(ordenEnTurno));
            if (vigente == ordenEnTurno) {
                break;
            }
            ordenEnTurno = null;
        }
        if (ordenEnTurno != null) {
            historialProcesados.apilar(ordenEnTurno);
        }
        return ordenEnTurno;
    }

    public OrdenLavado revertirUltimaOrdenProcesada() {
        if (historialProcesados.esVacia()) {
            return null;
        }
        OrdenLavado ordenRevertida = (OrdenLavado) historialProcesados.desapilar();
        colaPendientes.encolar(ordenRevertida);
        return ordenRevertida;
    }

    public String estadoDeOrden(String codigo) {
        OrdenLavado clave = new OrdenLavado(codigo, "", null, "");
        if (!listaGeneral.contiene(clave)) return "NO EXISTE";
        if (colaPendientes.contiene(clave)) return "PENDIENTE";
        if (historialProcesados.contiene(clave)) return "PROCESADA";
        return "REGISTRADA";
    }

    public boolean cancelarOrdenPendiente(String codigo) {
        if (!estadoDeOrden(codigo).equals("PENDIENTE")) {
            return false;
        }
        OrdenLavado clave = new OrdenLavado(codigo, "", null, "");
        listaGeneral.eliminarEnPosicion(listaGeneral.buscarDato(clave));
        return true;
    }

    public OrdenLavado buscarOrdenEnRegistroGeneral(String codigo) {
        OrdenLavado clave = new OrdenLavado(codigo, "", null, "");
        int indice = listaGeneral.buscarDato(clave);
        return indice != -1 ? (OrdenLavado) listaGeneral.buscarDato(indice) : null;
    }


}
