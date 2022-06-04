
package servicios;

import dao.ClientesDao;
import dao.SucursalesDao;
import modelo.Cliente;
import java.util.List;

public class SucursalesService implements ISucursalesService{
    
    private SucursalesDao sucursalesDao;  
    private ClientesDao clientesDao;  
    

    public SucursalesService() {
        sucursalesDao = SucursalesDao.getInstance();
        clientesDao = ClientesDao.getInstance();
    }

    @Override
    public List<Cliente> mostrarClientesPorSucursal(Integer nro_suc) {
        try {
            return sucursalesDao.buscarClientesPorSucursal(nro_suc);
        } catch (Exception e) {
            System.out.println("\nError al recuperar clientes de la Base de Datos");
        }
        return null;
    }
    
    @Override
    public List<Cliente> mostrarTotalDeClientes() {
        try {
            return sucursalesDao.buscarTotalClientes();
        } catch (Exception e) {
            System.out.println("\nError al recuperar clientes de la Base de Datos");
        }
        return null;        
    }
    
    public Cliente MostrarCuentasCliente(String dni) {
        try {
            return clientesDao.ListarCuentasPorDni(dni);
        } catch (Exception e) {
            System.out.println("\nError al recuperar las cuentas del Cliente");
        }
        return null;
    }
    
}
