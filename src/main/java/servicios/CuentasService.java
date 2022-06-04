
package servicios;

import dao.CuentasDao;
import java.awt.datatransfer.FlavorListener;
import modelo.Cliente;
import modelo.Cuenta;


public class CuentasService implements ICuentasService{
    
    private CuentasDao cuentasDao;
    private SucursalesService sucursalesService;
    
    public CuentasService() {
        cuentasDao = CuentasDao.getInstance();
        sucursalesService = new SucursalesService();
    }

    @Override
    public void depositar(String dni, Integer nroCuenta, Double monto) {
        try {
            Cliente cliente = sucursalesService.MostrarCuentasCliente(dni);
            boolean existeCuenta = false;
            for (Cuenta c: cliente.getCuentas()){
                if ( c.getNum_cuenta().equals(nroCuenta)){
                    existeCuenta = true;
                    c.setSaldo(c.getSaldo() + monto);
                    cuentasDao.actualizarSaldoCuentaBBDD(c);
                }
            }
            if (!existeCuenta){
                System.out.println("No se encontró la cuenta");
            }else{
                System.out.println("Transacción realizada con éxito");
            }
            
        } catch (Exception e) {
            System.out.println("Error al hacer Deposito");
        }
    }

    @Override
    public void extraer(String dni, Integer nroCuenta, Double monto) {
        try {
            Cliente cliente = sucursalesService.MostrarCuentasCliente(dni);
            boolean existeCuenta = false;
            for (Cuenta c: cliente.getCuentas()){
                if (c.getNum_cuenta().equals(nroCuenta)){
                    existeCuenta = true;
                    if ( c.getSaldo() > monto ){
                        c.setSaldo(c.getSaldo() - monto);
                        cuentasDao.actualizarSaldoCuentaBBDD(c);
                    }else{
                        System.out.println("No tiene suficiente dinero en la cuenta");
                    }
                }
            }
            if(!existeCuenta){
               System.out.println("No se encontró la cuenta"); 
            }else{
                System.out.println("Transacción realizada con éxito");
            }            
            
        } catch (Exception e) {
            System.out.println("Error al hacer la Extracción");
        }
    }

    @Override
    public void transferir(String dniOrigen, Integer cuentaOrigen, String dniDestino, Integer cuentaDestino, Double monto) {
        try { 
            
            Cuenta cuentaOr = traerCuenta(dniOrigen, cuentaOrigen);
            Cuenta cuentaDest = traerCuenta(dniDestino, cuentaDestino);
            
            if (cuentaOr == null || cuentaDest == null || cuentaOr.getSaldo()<monto){
                throw new Exception();
            }else{
                cuentaOr.setSaldo(cuentaOr.getSaldo() - monto);
                cuentaDest.depositar(monto);
                cuentasDao.actualizarSaldoCuentaBBDD(cuentaOr);
                cuentasDao.actualizarSaldoCuentaBBDD(cuentaDest);
                System.out.println("Transacción realizada con éxito");
            }
            
        } catch (Exception e) {            
            System.out.println("No se pudo realizar la transferencia");
        }
        
    }
    
    private Cuenta traerCuenta(String dni, Integer cuenta){
        
        try {
            Cliente cliente = sucursalesService.MostrarCuentasCliente(dni);
            for (Cuenta c: cliente.getCuentas()){
                if (c.getNum_cuenta().equals(cuenta)){
                    return c;
                }
            }
        } catch (Exception e) {
            System.out.println("Operación cancelada para DNI: "+dni);
        }
        return null;
    }
    
}
