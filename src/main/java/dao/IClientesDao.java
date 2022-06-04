
package dao;

import java.util.List;
import modelo.Cliente;
import modelo.Cuenta;

/**
 * Interfaz para el DAO de Clientes<br><br>
 * <strong>Metodos:</strong><br>
 * guardarClienteBBDD(Cliente cliente, Cuenta cuenta)<br>
 * buscarClientePorDni(String dni)<br>
 * ListarCuentasPorDni(String dni)<br>
 * actualizarSucursalPorTraslado(Integer fromSucursal, Integer toSucursal)<br>
 * @author diegoagudo
 */
public interface IClientesDao {
    
    public void guardarClienteBBDD(Cliente cliente, Cuenta cuenta) throws Exception;
    
    public Cliente buscarClientePorDni(String dni) throws Exception;
    
    public Cliente ListarCuentasPorDni(String dni) throws Exception;
    
    public void actualizarSucursalPorTraslado(Integer fromSucursal, Integer toSucursal) throws Exception;
        
}
