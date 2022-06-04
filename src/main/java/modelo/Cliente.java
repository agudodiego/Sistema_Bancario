
package modelo;

import java.util.LinkedList;
import java.util.List;

public class Cliente extends Persona{
    
    private Integer nro_cliente = null;
    private Integer sucursal;
    private List<Cuenta> cuentas;

    public Cliente() {
    }
    
    public Cliente(String nombre, String dni, String nroTelefono, Integer sucursal) {
        super(nombre, dni, nroTelefono);
        this.sucursal = sucursal;        
        this.cuentas = new LinkedList<>();
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }
    
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Integer getNroCliente() {
        return nro_cliente;
    }

    public void setNroCliente(Integer nro_cliente) {
        this.nro_cliente = nro_cliente;
    }

    @Override
    public String mostrarDatosCompletos() {        
        return "Cliente N°: "+ nro_cliente + " | Nombre: "+this.getNombre()+" | DNI: "+this.getDni()+" | Telefono: "+this.getNroTelefono();
    }
    
    
}
