package org.com.estructuras;

public class NodoEnlazado {
    private Object dato;
    private NodoEnlazado siguiente;
    private NodoEnlazado anterior;

    public NodoEnlazado(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
