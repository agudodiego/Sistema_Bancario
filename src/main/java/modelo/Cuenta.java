
package modelo;

public class Cuenta {
    
    private String casaCentral;
    private Integer num_cuenta = null;
    private String tipo = null;
    private String moneda = null;    
    private Double saldo = null;
    private Integer nro_cliente = null;

    public Cuenta() {
        casaCentral = "Banco Softtek";
        saldo = 0.0;
    }


    public String getCasaCentral() {
        return casaCentral;
    }

    public Integer getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(Integer num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getNro_cliente() {
        return nro_cliente;
    }

    public void setNro_cliente(Integer nro_cliente) {
        this.nro_cliente = nro_cliente;
    }    

    public void depositar(Double saldo) {
        this.saldo += saldo;
    }
    
    public void extraer(Double saldo) {
        this.saldo -= saldo;
    } 
    
  
}
