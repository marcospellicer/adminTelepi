/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_telepi;

/**
 *
 * @author alumno
 */
public class Pedido {
    private String fecha;
    private int IdCliente;
    private int Npizzas;
    private double precio;

    public Pedido(String fecha, int IdCliente, int Npizzas, double precio) {
        this.fecha = fecha;
        this.IdCliente = IdCliente;
        this.Npizzas = Npizzas;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  "fecha : "+fecha + " cliente : " + IdCliente + " pizzas : " + Npizzas + " precio : " + precio+"€"+"\n";
    }
    

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the IdCliente
     */
    public int getIdCliente() {
        return IdCliente;
    }

    /**
     * @param IdCliente the IdCliente to set
     */
    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    /**
     * @return the Npizzas
     */
    public int getNpizzas() {
        return Npizzas;
    }

    /**
     * @param Npizzas the Npizzas to set
     */
    public void setNpizzas(int Npizzas) {
        this.Npizzas = Npizzas;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}
