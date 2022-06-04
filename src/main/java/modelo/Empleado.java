
package modelo;

public class Empleado extends Persona{
    
    private Integer legajo;
    private Sucursal sucursal;

    public Empleado(String nombre,
                    String email,
                    String nroTelefono,
                    Integer legajo,
                    Sucursal sucursal)
    {
        super(nombre, email, nroTelefono);
        this.legajo = legajo;
        this.sucursal = sucursal;
    }  

    @Override
    public String mostrarDatosCompletos() {
        return "mostrar datos empleado";
    }
   
}
