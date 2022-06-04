
package servicios;

/**
 * Interfaz para el SERVICE de Cuentas<br><br>
 * <strong>Metodos:</strong><br>
 * depositar(String dni, Integer nroCuenta, Double monto)<br>
 * extraer(String dni, Integer nroCuenta, Double monto)<br>
 * transferir(String dniOrigen, Integer cuentaOrigen, String dniDestino, Integer cuentaDestino, Double monto)<br>
 * @author diegoagudo
 */
public interface ICuentasService {
    
    public void depositar(String dni, Integer nroCuenta, Double monto);
    
    public void extraer(String dni, Integer nroCuenta, Double monto);
    
    public void transferir(String dniOrigen, Integer cuentaOrigen, String dniDestino, Integer cuentaDestino, Double monto);
    
}
