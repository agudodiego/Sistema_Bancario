
package servicios;

import dao.ClientesDao;
import dao.SucursalesDao;
import modelo.Sucursal;
import java.util.List;

public class BancoService implements IBancoService{
    
    
    
    private SucursalesDao sucursalesDao;
    private ClientesDao clientesDao;
    
    
    public BancoService() {
        sucursalesDao = SucursalesDao.getInstance(); 
        clientesDao = ClientesDao.getInstance();
    }

    @Override
    public void agregarSucursal(Sucursal sucursal) {
 
        try {
            sucursalesDao.guardarSucursalBBDD(sucursal);            
        } catch (Exception ex) {            
            System.out.println("error al agregar sucursal"+ex);
        }
    }
    
    @Override
    public void eliminarSucursal(Integer fromSucursal, Integer toSucursal){
        try {
            if (sucursalesDao.buscarSucursales().size() > 2){
                
                clientesDao.actualizarSucursalPorTraslado(fromSucursal, toSucursal);
                
                sucursalesDao.borrarSucursalPorNro(fromSucursal);
            }else{
                System.out.println("El Banco debe tener como minimo 2 Sucursales para Funcionar");
            }
            
        } catch (Exception ex) {
            System.out.println("error al borrar sucursal"+ex);
        }
    }
        
    @Override
    public List<Sucursal> getSucursales() {
        try {
            return sucursalesDao.buscarSucursales();
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        return null;
    }  

    
}
