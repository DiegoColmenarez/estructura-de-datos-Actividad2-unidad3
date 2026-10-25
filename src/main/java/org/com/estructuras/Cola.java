package org.com.estructuras;

public class Cola {
    private Nodo frente;
    private Nodo fin;
    private int tamanio;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamanio = 0;
    }

    public void encolar(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (esVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
        tamanio++;
    }

    public Object desencolar() {
        if (esVacia()) {
            return null;
        }
        Object datoExtraido = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        tamanio--;
        return datoExtraido;
    }

    public boolean esVacia() {
        return frente == null;
    }

    public void limpiar() {
        frente = null;
        fin = null;
        tamanio = 0;
    }

    public Nodo getFrente() {
        return frente;
    }

    public Object peek() {
        return esVacia() ? null : frente.getDato();
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}
