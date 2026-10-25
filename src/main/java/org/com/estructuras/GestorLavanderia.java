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

    public void mostrarEstadoGeneralDelSistema() {
        System.out.println("\n--- REGISTRO GENERAL ---");
        if (listaGeneral.cuentaElementos() == 0) {
            System.out.println("Sistema vacío. No hay órdenes registradas.");
        } else {
            listaGeneral.mostrarAdelante();
        }
        System.out.println("\n--- PENDIENTES ---");
        if (colaPendientes.esVacia()) {
            System.out.println("Sin órdenes en espera.");
        } else {
            colaPendientes.mostrar();
        }
        System.out.println("\n--- HISTORIAL PROCESADOS ---");
        if (historialProcesados.esVacia()) {
            System.out.println("No hay órdenes procesadas en el historial.");
        } else {
            historialProcesados.mostrar();
        }
    }
}
