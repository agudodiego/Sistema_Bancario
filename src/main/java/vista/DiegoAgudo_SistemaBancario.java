
package vista;


import modelo.Cliente;
import modelo.Cuenta;
import modelo.Sucursal;
import java.util.InputMismatchException;
import java.util.Scanner;
import servicios.BancoService;
import servicios.ClientesService;
import servicios.SucursalesService;
import servicios.CuentasService;

public class DiegoAgudo_SistemaBancario {

    public static void main(String[] args) {
        
        BancoService bancoService = new BancoService();
        SucursalesService sucursalesService = new SucursalesService();
        ClientesService clientesService = new ClientesService();
        CuentasService cuentasService = new CuentasService();

        imprimirMenu();
 
        boolean sigueMenu = true;
        do{
            Scanner sc = new Scanner(System.in);
            boolean error = false;
            Integer input = null;
            do{
                try{  
                    System.out.println("");
                    System.out.print("su opcion: ");
                    input = sc.nextInt();
                    if (input > 0 && input < 14){
                        error = false;

                    }else{
                        System.out.println("Debe ingresar una opción válida");
                        error = true;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Debe ingresar una opción válida");
                    error = true;
                    sc.nextLine();
                }    
            }while(error);

        
        //inicio opciones        
        switch (input) {
            
            case 1://Agregar Cliente
                sc.nextLine(); //limpia el scanner
                System.out.println("");
                System.out.print("Ingrese el nombre del nuevo Cliente: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese el DNI del nuevo Cliente: ");
                String dni = sc.nextLine();
                System.out.print("Ingrese el telefono del nuevo Cliente: ");
                String telefono = sc.nextLine();
                System.out.print("Ingrese el numero de sucursal donde agregara al Cliente " + nombre.toUpperCase() +": ");
                Integer sucursal = sc.nextInt();
                System.out.println("Defina el Tipo de Cuenta que quiere abrir:");
                System.out.println("1) Caja de Ahorro en $");
                System.out.println("2) Caja de Ahorro en U$S");
                System.out.println("3) Cuenta Corriente en $");
                System.out.println("4) Cuenta Corriente en U$S");
                Integer tipoCuenta = sc.nextInt();
                Cliente cl = new Cliente(nombre, dni, telefono, sucursal);
                clientesService.agregarCliente(cl, tipoCuenta);
                
                break;
                
            case 2://Agregar cuenta a Cliente
                sc.nextLine(); //limpia el scanner
                System.out.println("");
                System.out.print("Ingrese el DNI del Cliente: ");
                dni = sc.nextLine();
                System.out.println("Defina el Tipo de Cuenta que quiere abrir:");
                System.out.println("1) Caja de Ahorro en $");
                System.out.println("2) Caja de Ahorro en U$S");
                System.out.println("3) Cuenta Corriente en $");
                System.out.println("4) Cuenta Corriente en U$S");
                tipoCuenta = sc.nextInt();

                clientesService.agregarCuentaACliente(dni, tipoCuenta);
               
                break;
            
            case 3: //Mostrar Cliente
                sc.nextLine(); //limpia el scanner
                System.out.println("");
                System.out.print("Ingrese el DNI del Cliente: ");
                dni = sc.nextLine();
                System.out.println("");
                try{
                    Cliente cliente = sucursalesService.MostrarCuentasCliente(dni);
                    System.out.println(cliente.mostrarDatosCompletos());
                    for (Cuenta c: cliente.getCuentas()){
                        System.out.printf(">>>  Cuenta N°: %d | Tipo: %S - %s | Saldo: %.2f %n", c.getNum_cuenta(), c.getTipo(), c.getMoneda(), c.getSaldo());
                    }
                }catch (Exception e){
                    System.out.println("DNI erroneo");
                }
                
                break;
                
            case 4://Listar Total de Clientes por sucursal
                sc.nextLine(); //limpia el scanner
                System.out.println("");
                for (Cliente c: sucursalesService.mostrarTotalDeClientes()){
                        System.out.println("Sucursal N°: "+ c.getSucursal() + " | " + c.mostrarDatosCompletos());               
                }
                break;
                
            case 5://Listar Clientes de una sucursal
                sc.nextLine(); //limpia el scanner
                System.out.println("");
                System.out.print("Ingrese el numero de Sucursal a consultar: ");
                sucursal = sc.nextInt();
                System.out.println("");
                System.out.println("Clientes de la Sucursal N°: "+ sucursal);
                System.out.println("***********************************");
                for (Cliente c: sucursalesService.mostrarClientesPorSucursal(sucursal)){
                    System.out.println(">>> " + c.mostrarDatosCompletos());
                }
                
                break;
                
            case 6://extraccion
                sc.nextLine(); //limpia el scanner
                System.out.println("");
                System.out.print("Ingrese el DNI del Cliente: ");
                dni = sc.nextLine();
                System.out.print("Ingrese el numero de cuenta donde hacer la Extraccion: ");
                Integer nroCuenta = sc.nextInt();
                System.out.print("Ingrese el monto a extraer: ");
                Double monto = sc.nextDouble(); 
                cuentasService.extraer(dni, nroCuenta, monto);  
            break;
                
            case 7://consultar saldo
                sc.nextLine(); //limpia el scanner
                System.out.println("");
                System.out.print("Ingrese el DNI del Cliente: ");
                dni = sc.nextLine();
                System.out.print("Ingrese el numero de cuenta a consultar: ");
                nroCuenta = sc.nextInt();
                System.out.println("");

                try{
                    Cliente cliente = sucursalesService.MostrarCuentasCliente(dni);
                    boolean existeCuenta = false;
                    for (Cuenta c: cliente.getCuentas()){
                        if (c.getNum_cuenta().equals(nroCuenta)){
                            existeCuenta = true;
                            System.out.printf(">>>  Cliente: %S | Cuenta N°: %d | Saldo: %.2f %s%n", cliente.getNombre(), c.getNum_cuenta(), c.getSaldo(), c.getMoneda());
                        }                   
                    } 
                    if (!existeCuenta){
                        System.out.println("La cuenta no existe");
                    }
                }catch (Exception e){
                    System.out.println("Revise los datos ingresados");
                }    
                break;
            
            case 8://deposito
                sc.nextLine(); //limpia el scanner
                System.out.println("");
                System.out.print("Ingrese el DNI del Cliente: ");
                dni = sc.nextLine();
                System.out.print("Ingrese el numero de cuenta donde hacer el Deposito: ");
                nroCuenta = sc.nextInt();
                System.out.print("Ingrese el monto a depositar: ");
                monto = sc.nextDouble();
                
                cuentasService.depositar(dni, nroCuenta, monto);              
                break;
                
            case 9: //Transferencia
                sc.nextLine(); //limpia el scanner
                System.out.println("");
                System.out.print("Ingrese el DNI del Cliente de la cuenta ORIGEN: ");
                String dniOrigen = sc.nextLine();
                System.out.print("Ingrese el numero de cuenta ORIGEN: ");
                Integer cuentaOrigen = sc.nextInt();                
                System.out.print("Ingrese el monto a transferir: ");
                monto = sc.nextDouble();
                System.out.println("");
                System.out.print("Ingrese el DNI del Cliente de la cuenta DESTINO: ");
                sc.nextLine(); //limpia el scanner
                String dniDestino = sc.nextLine();
                System.out.print("Ingrese el numero de cuenta DESTINO: ");
                Integer cuentaDestino = sc.nextInt();                
                
                cuentasService.transferir(dniOrigen, cuentaOrigen, dniDestino, cuentaDestino, monto);
                break;
                
            case 10://agregar sucursal
                sc.nextLine(); //limpia el scanner
                System.out.println("");
                System.out.print("Direccion de la nueva Sucursal: ");
                String dire = sc.nextLine();
                Sucursal nuevaSuc = new Sucursal(null, dire);
                
                bancoService.agregarSucursal(nuevaSuc);
                break;     
                
            case 11://Eliminar una sucursal
                sc.nextLine(); //limpia el scanner
                System.out.println("");
                System.out.print("Numero de Sucursal a eliminar: ");
                Integer fromSucursal = sc.nextInt();
                System.out.print("Numero de Sucursal a donde TRASLADAR los Clientes: ");
                Integer toSucursal = sc.nextInt();
                bancoService.eliminarSucursal(fromSucursal, toSucursal);
                break;   
                
            case 12://Listar Sucursales del Banco
                System.out.println("");
                System.out.println("Sucursales Activas: ");
                for (Sucursal s: bancoService.getSucursales()){
                    System.out.printf("Sucursal N°: %d - Dirección: %s%n", s.getNumeroSucursal(), s.getDireccion());
                }
                break;
            
            case 13://exit
                sigueMenu = false;
                break;
                
            default:
                throw new AssertionError();
        }
            
        }while(sigueMenu);
        
    }
    
    
    public static void imprimirMenu(){
        System.out.println("*********************************");
        System.out.println("****** Bienvenido al Banco ******");
        System.out.println("*********************************");
        System.out.println("Elija una opcion:");
        System.out.println("1) Agregar Cliente");
        System.out.println("2) Agregar cuenta a Cliente");
        System.out.println("3) Mostrar Cliente");
        System.out.println("4) Listar Clientes por sucursal");
        System.out.println("5) Listar Clientes de una sucursal");
        System.out.println("6) Extraer dinero");
        System.out.println("7) Consultar Saldo");
        System.out.println("8) Realizar Deposito");
        System.out.println("9) Realizar transferencias");
        System.out.println("10) Agregar Sucursal");
        System.out.println("11) Eliminar una sucursal");
        System.out.println("12) Listar Sucursales del Banco");
        System.out.println("13) Exit");
        System.out.println("*********************************");
    }
    
}
