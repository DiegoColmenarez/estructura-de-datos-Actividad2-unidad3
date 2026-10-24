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

    public NodoEnlazado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEnlazado siguiente) {
        this.siguiente = siguiente;
    }

    public NodoEnlazado getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoEnlazado anterior) {
        this.anterior = anterior;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }
}
