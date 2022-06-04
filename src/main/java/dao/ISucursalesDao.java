
package dao;

import modelo.Sucursal;
import java.util.List;
import modelo.Cliente;

/**
 * Interfaz para el DAO de Sucursales<br><br>
 * <strong>Metodos:</strong><br>
 * guardarSucursalBBDD(Sucursal sucursal)<br>
 * borrarSucursalPorNro(Integer nro_suc)<br>
 * buscarSucursalPorNro(Integer nro_suc)<br>
 * buscarClientesPorSucursal(Integer nro_suc)<br>
 * buscarTotalClientes()<br>
 * buscarSucursales()<br>
 * @author diegoagudo
 */

public interface ISucursalesDao {
    
    public void guardarSucursalBBDD(Sucursal sucursal) throws Exception;
    
    public void borrarSucursalPorNro(Integer nro_suc) throws Exception;
    
    public Sucursal buscarSucursalPorNro(Integer nro_suc) throws Exception;
    
    public List<Cliente> buscarClientesPorSucursal(Integer nro_suc) throws Exception;
    
    public List<Cliente> buscarTotalClientes() throws Exception;
    
    public List<Sucursal>  buscarSucursales() throws Exception;
    
}
