package org.com.estructuras;

public class Pila {
    private Nodo cima;
    private int tamanio;

    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    public void apilar(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
        tamanio++;
    }

    public Object desapilar() {
        if (esVacia()) {
            return null;
        }
        Object datoExtraido = cima.getDato();
        cima = cima.getSiguiente();
        tamanio--;
        return datoExtraido;
    }

    public Object peek() {
        return esVacia() ? null : cima.getDato();
    }

    public void limpiar() {
        cima = null;
        tamanio = 0;
    }

    public Nodo buscar(Object dato) {
        Nodo actual = cima;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean contiene(Object dato) {
        return buscar(dato) != null;
    }

    public boolean esVacia() {
        return cima == null;
    }

    public int getTamanio() {
        return tamanio;
    }
}
