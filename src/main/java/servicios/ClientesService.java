
package servicios;

import dao.ClientesDao;
import dao.CuentasDao;
import java.io.IOException;
import modelo.Cliente;
import modelo.Cuenta;

public class ClientesService implements IClientesService{
    
    private ClientesDao clienteDao;
    private CuentasDao cuentasDao;
    
    public ClientesService() {
        this.clienteDao = ClientesDao.getInstance();
        this.cuentasDao = CuentasDao.getInstance();
    }    
    
    @Override
    public void agregarCliente(Cliente cliente, Integer tipoCuenta){

        try {
            
            Cuenta cuenta = definirCuenta(tipoCuenta, cliente.getNroCliente());
            
            clienteDao.guardarClienteBBDD(cliente, cuenta);            
            
        } catch (Exception ex) {
             System.out.println("Error al ingresar Cliente\n" + ex);
        }
    
    }
    
    @Override
    public void agregarCuentaACliente(String dni, Integer tipoCuenta) {
        
        try {
           
            Cliente cliente = clienteDao.buscarClientePorDni(dni);
            if (cliente == null){
                System.out.println("El DNI no se encuentra en la Base de Datos");
            }
            
            Cuenta cuenta = definirCuenta(tipoCuenta, cliente.getNroCliente());
            
            cuentasDao.guardarCuentaBBDD(cuenta);          
            
            
        } catch (Exception e) {
        }
        
    }

    public Cuenta definirCuenta(Integer tipoCuenta, Integer nro_cliente) throws IOException{
        Cuenta cuenta = null;
        switch (tipoCuenta) {                    
            case 1:
                cuenta = new Cuenta();
                cuenta.setTipo("CA");
                cuenta.setMoneda("Pesos");
                cuenta.depositar(0.0);
                cuenta.setNro_cliente(nro_cliente);
                break;
            case 2:
                cuenta = new Cuenta();
                cuenta.setTipo("CA");
                cuenta.setMoneda("Dolares");
                cuenta.depositar(0.0);
                cuenta.setNro_cliente(nro_cliente);
                break;
            case 3:
                cuenta = new Cuenta();
                cuenta.setTipo("CC");
                cuenta.setMoneda("Pesos");
                cuenta.depositar(0.0);
                cuenta.setNro_cliente(nro_cliente);
                break;
            case 4:
                cuenta = new Cuenta();
                cuenta.setTipo("CC");
                cuenta.setMoneda("Dolares");
                cuenta.depositar(0.0);
                cuenta.setNro_cliente(nro_cliente);
                break;
            default:
                System.out.println("Debe ingresar una opción de CUENTA válida");
                throw new IOException();
        }
        return cuenta;
    }
   
}
