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

    public boolean contiene(Object dato) {
        Nodo actual = frente;
        while (actual != null) {
            if (actual.getDato().equals(dato)) return true;
            actual = actual.getSiguiente();
        }
        return false;
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

    public Object peek() {
        return esVacia() ? null : frente.getDato();
    }

    public int tamanio() {
        return tamanio;
    }

    public void mostrar() {
        System.out.println("FRENTE");
        Nodo actual = frente;
        int turno = 1;
        while (actual != null) {
            System.out.println("  " + turno + ". " + actual.getDato());
            actual = actual.getSiguiente();
            turno++;
        }
        System.out.println("FIN");
    }
}
