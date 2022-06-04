
package dao;

import java.util.LinkedList;
import java.util.List;
import modelo.Cliente;
import modelo.Cuenta;

public class ClientesDao extends DAO implements IClientesDao{
    
    private static ClientesDao instance = new ClientesDao();
    private CuentasDao cuentasDao;
    
    private ClientesDao() {
        this.cuentasDao = CuentasDao.getInstance();
    }
    
    public static ClientesDao getInstance() {
        return instance;
    }


    @Override
    public void guardarClienteBBDD(Cliente cliente, Cuenta cuenta) throws Exception {
        try {
            if (cliente == null){
                throw new Exception("Debe indicar un cliente");
            }
            
            if (cuenta == null){
                throw new Exception("Debe abrir una cuenta");
            }

            String sql = "INSERT clientes VALUES (NULL, '" 
                    + cliente.getNombre() + "','" 
                    + cliente.getDni() + "','" 
                    + cliente.getNroTelefono() + "',"
                    + cliente.getSucursal() +");";
            
            
            insertarModificarEliminar(sql);  

            cuenta.setNro_cliente(buscarClientePorDni(cliente.getDni()).getNroCliente());     
            
            cuentasDao.guardarCuentaBBDD(cuenta);
            
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    @Override
    public Cliente buscarClientePorDni(String dni) throws Exception{
        try {
            
            String sql = "SELECT * FROM clientes WHERE dni = " + dni +";";
            consultarBase(sql);
            
            Cliente cliente = null;
            while (resultado.next()){
                cliente = new Cliente();
                cliente.setNroCliente(resultado.getInt("nro_cliente"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setDni(resultado.getString("dni"));
                cliente.setNroTelefono(resultado.getString("telefono"));
                cliente.setSucursal(resultado.getInt("nro_sucursal"));
            }
            
            desconectarBase();
            return cliente;
            
        } catch (Exception e) {
            
            desconectarBase();
            throw e;
        }
    }

    @Override
    public Cliente ListarCuentasPorDni(String dni) throws Exception {
        
        try {
            
            Cliente cliente = buscarClientePorDni(dni);
            
            String sql = "SELECT * FROM cuentas WHERE nro_cliente = " + cliente.getNroCliente() +";";
            consultarBase(sql);
            
            List<Cuenta> cuentas = new LinkedList<>();
            while (resultado.next()){
                Cuenta cuenta = new Cuenta();
                cuenta.setNum_cuenta(resultado.getInt("num_cuenta"));
                cuenta.setTipo(resultado.getString("tipo"));
                cuenta.setMoneda(resultado.getString("moneda"));
                cuenta.setSaldo(resultado.getDouble("saldo"));
                cuentas.add(cuenta);
            }
            
            cliente.setCuentas(cuentas);
            desconectarBase();
            return cliente;
            
        } catch (Exception e) {
            
            desconectarBase();
            throw e;
        }
    }

    @Override
    public void actualizarSucursalPorTraslado(Integer fromSucursal, Integer toSucursal) throws Exception {
        try {
            String sql = "UPDATE clientes SET nro_sucursal = " 
                    + toSucursal + " WHERE nro_sucursal = " 
                    + fromSucursal + ";";

            insertarModificarEliminar(sql);
            
        } catch (Exception ex) {
            throw ex;
        }
    }
    
}
