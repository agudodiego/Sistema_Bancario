
package modelo;

public abstract class Persona {
    
    protected String nombre;
    protected String dni;
    protected String nroTelefono;

    public Persona() {
    }
    
    public Persona(String nombre,String dni, String nroTelefono) {
        
        this.nombre = nombre;
        this.dni = dni;
        this.nroTelefono = nroTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public abstract String mostrarDatosCompletos();
    
    
}
