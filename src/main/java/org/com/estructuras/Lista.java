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
}
