
package servicios;

import java.util.List;
import modelo.Cliente;

/**
 * Interfaz para el SERVICE de Sucursales<br><br>
 * <strong>Metodos:</strong><br>
 * mostrarClientesPorSucursal(Integer nro_suc)<br>
 * mostrarTotalDeClientes()<br>
 * MostrarCuentasCliente(String dni)<br>
 * @author diegoagudo
 */
public interface ISucursalesService {
    
    public List<Cliente> mostrarClientesPorSucursal(Integer nro_suc);
    
    public List<Cliente> mostrarTotalDeClientes();
    
    public Cliente MostrarCuentasCliente(String dni);
    
}
