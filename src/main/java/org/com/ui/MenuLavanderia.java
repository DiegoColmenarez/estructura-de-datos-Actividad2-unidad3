package org.com.ui;

import org.com.estructuras.*;

import java.util.Scanner;

public class MenuLavanderia {
    private final GestorLavanderia gestor;
    private final Scanner scanner;

    public MenuLavanderia(GestorLavanderia gestor) {
        this.gestor = gestor;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            mostrarOpciones();
            int opcion = leerEntero("Seleccione una opción: ");

            try {
                switch (opcion) {
                    case 1 -> registrarOrden();
                    case 2 -> procesarOrden();
                    case 3 -> revertirProceso();
                    case 4 -> cancelarOrden();
                    case 5 -> buscarOrden();
                    case 6 -> mostrarEstado();
                    case 7 -> salir = true;
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error inesperado en el sistema: " + e.getMessage());
            }
            System.out.println();
        }
        System.out.println("¡Sistema de lavandería apagado. Hasta luego!");
    }

    private void mostrarOpciones() {
        System.out.println("=== GESTIÓN DE LAVANDERÍA ===");
        System.out.println("1. Registrar nueva orden de lavado");
        System.out.println("2. Procesar siguiente orden pendiente");
        System.out.println("3. Revertir último procesamiento");
        System.out.println("4. Cancelar orden pendiente");
        System.out.println("5. Buscar orden en registro general");
        System.out.println("6. Mostrar estado del sistema (Listas, Colas, Pilas)");
        System.out.println("7. Salir");
    }

    private void registrarOrden() {
        System.out.println("--- REGISTRAR ORDEN ---");
        String codigo = leerTexto("Código único de la orden: ");
        String cliente = leerTexto("Nombre del cliente: ");
        String tipoTela = leerTexto("Tipo de tela (Ej. Algodon, Seda): ").toUpperCase();
        String prendas = leerTexto("Descripción de prendas: ");
        if (gestor.registrarNuevaOrdenLavado(codigo, cliente, tipoTela, prendas)) {
            System.out.println("ÉXITO: Orden registrada y en espera.");
        } else {
            System.out.println("ERROR: La orden con código '" + codigo + "' ya existe.");
        }
    }

    private void procesarOrden() {
        System.out.println("--- PROCESAR ORDEN PENDIENTE ---");
        OrdenLavado procesada = gestor.procesarSiguienteOrdenPendiente();
        if (procesada != null) {
            System.out.println("ÉXITO: Orden procesada -> " + procesada.toString());
        } else {
            System.out.println("AVISO: No hay órdenes pendientes en la cola.");
        }
    }

    private void revertirProceso() {
        System.out.println("--- REVERTIR ÚLTIMO PROCESAMIENTO ---");
        OrdenLavado revertida = gestor.revertirUltimaOrdenProcesada();
        if (revertida != null) {
            System.out.println("ÉXITO: Orden revertida a pendientes -> " + revertida.toString());
        } else {
            System.out.println("AVISO: El historial de procesados está vacío.");
        }
    }

    private void cancelarOrden() {
        System.out.println("--- CANCELAR ORDEN ---");
        String codigo = leerTexto("Ingrese el código de la orden a cancelar: ");
        if (gestor.cancelarOrdenPendiente(codigo)) {
            System.out.println("ÉXITO: Orden cancelada y eliminada del sistema.");
        } else {
            String estado = gestor.estadoDeOrden(codigo);
            System.out.println(estado.equals("NO EXISTE")
                    ? "ERROR: No se encontró la orden en el sistema."
                    : "ERROR: La orden está " + estado + " y ya no puede cancelarse.");
        }
    }

    private void buscarOrden() {
        System.out.println("--- BUSCAR ORDEN ---");
        String codigo = leerTexto("Ingrese código a buscar: ");
        OrdenLavado encontrada = gestor.buscarOrdenEnRegistroGeneral(codigo);
        if (encontrada != null) {
            System.out.println("Orden encontrada [" + gestor.estadoDeOrden(codigo) + "]: " + encontrada);
        } else {
            System.out.println("No se encontró ninguna orden con el código: " + codigo);
        }
    }

    private void mostrarEstado() {
        Lista lista = gestor.getListaGeneral();
        Cola cola = gestor.getColaPendientes();
        Pila pila = gestor.getHistorialProcesados();
        System.out.println("\n--- REGISTRO GENERAL (" + lista.cuentaElementos() + ") ---");
        if (lista.cuentaElementos() == 0) {
            System.out.println("Sistema vacío. No hay órdenes registradas.");
        } else {
            lista.mostrarAdelante();
        }
        System.out.println("\n--- PENDIENTES (" + cola.tamanio() + ") ---");
        if (cola.esVacia()) {
            System.out.println("Sin órdenes en espera.");
        } else {
            cola.mostrar();
            System.out.println("Siguiente en turno: " + cola.peek());
        }
        System.out.println("\n--- HISTORIAL PROCESADOS (" + pila.tamanio() + ") ---");
        if (pila.esVacia()) {
            System.out.println("No hay órdenes procesadas en el historial.");
        } else {
            pila.mostrar();
            System.out.println("Última procesada (se revertiría): " + pila.peek());
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
}