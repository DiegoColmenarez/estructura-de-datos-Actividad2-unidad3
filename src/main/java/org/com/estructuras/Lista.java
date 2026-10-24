package org.com.estructuras;

public class Lista {
    private NodoEnlazado cabeza;
    private NodoEnlazado cola;
    private int tamanio;

    public Lista() {
        this.cabeza = null;
        this.cola = null;
        this.tamanio = 0;
    }

    public void agregar(Object dato) {
        NodoEnlazado nuevo = new NodoEnlazado(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
        tamanio++;
    }

    public void agregarAlInicio(Object dato) {
        NodoEnlazado nuevo = new NodoEnlazado(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
        tamanio++;
    }

    public void agregarEnPosicion(int indice, Object dato) {
        if (indice < 0 || indice > tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (indice == 0) {
            agregarAlInicio(dato);
            return;
        }
        if (indice == tamanio) {
            agregar(dato);
            return;
        }
        NodoEnlazado nuevo = new NodoEnlazado(dato);
        NodoEnlazado actual = cabeza;
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.getSiguiente();
        }
        NodoEnlazado siguienteNodo = actual.getSiguiente();
        nuevo.setSiguiente(siguienteNodo);
        nuevo.setAnterior(actual);
        actual.setSiguiente(nuevo);
        if (siguienteNodo != null) {
            siguienteNodo.setAnterior(nuevo);
        }
        tamanio++;
    }

    public Object eliminarPrimero() {
        if (cabeza == null) return null;
        Object datoExtraido = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        if (cabeza == null) {
            cola = null;
        } else {
            cabeza.setAnterior(null);
        }
        tamanio--;
        return datoExtraido;
    }
}
