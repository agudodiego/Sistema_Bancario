
package dao;

import modelo.Cuenta;


public class CuentasDao extends DAO implements ICuentasDao{

    private static CuentasDao instance = new CuentasDao();
    
    private CuentasDao() {
    }
    
    public static CuentasDao getInstance() {
        return instance;
    }

    @Override
    public void guardarCuentaBBDD(Cuenta cuenta) throws Exception {
        
        try {
            if (cuenta == null){
            throw new Exception("Debe abrir una cuenta");
            }

            String sql = "INSERT cuentas VALUES (NULL, '" 
                        + cuenta.getTipo() + "','" 
                        + cuenta.getMoneda() + "'," 
                        + cuenta.getSaldo() + ","
                        + cuenta.getNro_cliente() +");";

            insertarModificarEliminar(sql);
            
        } catch (Exception ex) {
            throw ex;
        }
        
    }

    @Override
    public void actualizarSaldoCuentaBBDD(Cuenta cuenta) throws Exception {
        try {
            String sql = "UPDATE cuentas SET saldo = " 
                    + cuenta.getSaldo() + " WHERE num_cuenta = " 
                    + cuenta.getNum_cuenta() + ";";

            insertarModificarEliminar(sql);
            
        } catch (Exception ex) {
            throw ex;
        }
    }
    
}
