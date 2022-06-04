
package servicios;

import java.util.List;
import modelo.Sucursal;

/**
 * Interfaz para el SERVICE de Banco<br><br>
 * <strong>Metodos:</strong><br>
 * agregarSucursal(Sucursal sucursal)<br>
 * getSucursales()<br>
 * eliminarSucursal(Integer fromSucursal, Integer toSucursal)<br>
 * @author diegoagudo
 */
public interface IBancoService {
    
    public void agregarSucursal(Sucursal sucursal);
    
    public List<Sucursal> getSucursales();
    
    public void eliminarSucursal(Integer fromSucursal, Integer toSucursal);
}
