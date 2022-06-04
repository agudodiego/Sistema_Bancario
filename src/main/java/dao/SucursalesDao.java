
package dao;

import java.util.LinkedList;
import java.util.List;
import modelo.Cliente;
import modelo.Sucursal;

public class SucursalesDao extends DAO implements ISucursalesDao{
    
    private static SucursalesDao instance = new SucursalesDao();
    
    private SucursalesDao() {
    }
    
    public static SucursalesDao getInstance() {
        return instance;
    }

    
    @Override
    public void guardarSucursalBBDD(Sucursal sucursal) throws Exception{
        try {
            
            if (sucursal == null){
                throw new Exception("Debe indicar una sucursal");
            }
            
            String sql = "INSERT sucursales VALUES (NULL, '" + sucursal.getDireccion() + "' );";
            
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    @Override
    public void borrarSucursalPorNro(Integer nro_suc) throws Exception{
        
        try {
            
            String sql = "DELETE FROM sucursales WHERE nro_sucursal = " + nro_suc +";";
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public Sucursal buscarSucursalPorNro(Integer nro_suc) throws Exception{
        try {
            
            String sql = "SELECT * FROM sucursales WHERE nro_sucursal = " + nro_suc +";";
            consultarBase(sql);
            
            Sucursal sucursal = null;
            while (resultado.next()){
                sucursal = new Sucursal();
                sucursal.setNumeroSucursal(resultado.getInt("nro_sucursal"));
                sucursal.setDireccion(resultado.getString("direccion"));
            }
            
            desconectarBase();
            return sucursal;
            
        } catch (Exception e) {
            
            desconectarBase();
            throw e;
        }
    }

    @Override
        public List<Sucursal>  buscarSucursales() throws Exception{
        try {
            
            String sql = "SELECT * FROM sucursales";
            consultarBase(sql);
            
            Sucursal sucursal = null;
            List<Sucursal> sucursales = new LinkedList<>();
            
            while (resultado.next()){
                sucursal = new Sucursal();
                sucursal.setNumeroSucursal(resultado.getInt(1));
                sucursal.setDireccion(resultado.getString(2));
                sucursales.add(sucursal);
            }
            
            desconectarBase();
            return sucursales;
            
        } catch (Exception e) {
            
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

    @Override
    public List<Cliente> buscarClientesPorSucursal(Integer nro_suc) throws Exception {
        try {
            String sql = "SELECT * FROM clientes WHERE nro_sucursal = " + nro_suc;
            consultarBase(sql);
            
            Cliente cliente = null;
            List<Cliente> clientes = new LinkedList<>();
            
            while (resultado.next()){
                cliente = new Cliente();
                cliente.setNroCliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setDni(resultado.getString(3));
                cliente.setNroTelefono(resultado.getString(4));
                cliente.setSucursal(resultado.getInt(5));
                clientes.add(cliente);
            }
            
            return clientes;
            
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
   
    
    public List<Cliente> buscarTotalClientes() throws Exception{
        try {
            String sql = "SELECT * FROM `clientes` ORDER BY nro_sucursal ASC;";
            consultarBase(sql);
            
            Cliente cliente = null;
            List<Cliente> clientes = new LinkedList<>();
            
            while (resultado.next()){
                cliente = new Cliente();
                cliente.setNroCliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setDni(resultado.getString(3));
                cliente.setNroTelefono(resultado.getString(4));
                cliente.setSucursal(resultado.getInt(5));
                clientes.add(cliente);
            }
            
            return clientes;
            
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    
    
}
