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

    public boolean esVacia() {
        return cima == null;
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
}
