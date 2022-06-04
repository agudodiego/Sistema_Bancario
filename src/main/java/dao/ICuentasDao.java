
package dao;

import modelo.Cuenta;

/**
 * Interfaz para el DAO de Cuentas<br><br>
 * <strong>Metodos:</strong><br>
 * guardarCuentaBBDD(Cuenta cuenta)<br>
 * actualizarSaldoCuentaBBDD(Cuenta cuenta)<br>
 * @author diegoagudo
 */
public interface ICuentasDao {
    
    public void guardarCuentaBBDD(Cuenta cuenta) throws Exception;
    
    public void actualizarSaldoCuentaBBDD(Cuenta cuenta) throws Exception;
    
}
