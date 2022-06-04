
package modelo;

import java.util.LinkedList;
import java.util.List;

public class Sucursal {
    
    private  Integer numeroSucursal;
    private  String direccion;
    public List<Cliente> clientes;

    public Sucursal() {
    }

    public Sucursal(Integer numeroSucursal, String direccion) {
        this.direccion = direccion;
        this.clientes = new LinkedList<>();
    }

    public void setNumeroSucursal(Integer numeroSucursal) {
        this.numeroSucursal = numeroSucursal;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumeroSucursal() {
        return numeroSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
 
}
