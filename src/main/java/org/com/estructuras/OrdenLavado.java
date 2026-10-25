package org.com.estructuras;

public class OrdenLavado {
    private final String codigoOrden;
    private String nombreCliente;
    private String tipoTela;
    private String descripcionPrendas;

    public OrdenLavado(String codigoOrden, String nombreCliente, String tipoTela, String descripcionPrendas) {
        this.codigoOrden = codigoOrden;
        this.nombreCliente = nombreCliente;
        this.tipoTela = tipoTela;
        this.descripcionPrendas = descripcionPrendas;
    }


}
