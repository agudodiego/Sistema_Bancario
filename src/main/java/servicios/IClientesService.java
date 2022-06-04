
package servicios;

import modelo.Cliente;


/**
 * Interfaz para el SERVICE de Clientes<br><br>
 * <strong>Metodos:</strong><br>
 * agregarCliente(Cliente cliente, Integer tipoCuenta)<br>
 * agregarCuentaACliente(String dni, Integer tipoCuenta)<br>
 * @author diegoagudo
 */
public interface IClientesService {
    
    public void agregarCliente(Cliente cliente, Integer tipoCuenta);
    
    public void agregarCuentaACliente(String dni, Integer tipoCuenta);
    
}
