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


    public String getCodigoOrden() {
        return codigoOrden;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public String getDescripcionPrendas() {
        return descripcionPrendas;
    }

    public void setDescripcionPrendas(String descripcionPrendas) {
        this.descripcionPrendas = descripcionPrendas;
    }
}
