/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_telepi;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author alumno
 */
public class Bd {
    private Connection con;
    private String url;
    private String usu;

    public Bd() {
     this.url = "jdbc:mysql://192.168.4.187:3310/telepizza";
        this.usu = "marcos";   
    }

    public Bd(String url, String usu) {
        this.url = url;
        this.usu = usu;
    }
    
    private void conectar(){
        try {
            con = (Connection) DriverManager.getConnection(url,usu,usu);
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public ArrayList<Pedido> verPedidios(){
        conectar();
        ArrayList<Pedido> a = new ArrayList<>();
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select * from pedido");
            
            while(rs.next()){
              Pedido p = new Pedido(rs.getString("fecha"), rs.getInt("c_cliente"), rs.getInt("n_pizzas"), rs.getInt("precio"));
              a.add(p);
            }
         desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
     }
      public ArrayList<String> verPizzas(){
        conectar();
        ArrayList<String> a = new ArrayList<>();
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select nombre from pizzas;");
            
            while(rs.next()){
              a.add(rs.getString("nombre"));
            }
         desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
     }
      public void borrarPizza(String p){
        conectar();
        try {
            Statement s = (Statement) con.createStatement();
            s.executeUpdate("delete from pizzas where nombre='"+p+"';");
         desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }

     }
     public int contarPedidos(){
        conectar();
      int aux = 0;
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select count(id) from pedido");
            
            if(rs.first()){
                aux=rs.getInt(1);
            }
         desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
     }
     public int contarPedidosDia(){
        conectar();
      int aux = 0;
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select count(id) from pedido where fecha=curdate()");
            
            if(rs.first()){
                aux=rs.getInt(1);
            }
         desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
     }
     public int contarPrecioDia(){
        conectar();
      int aux = 0;
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select sum(precio) from pedido where fecha=curdate()");
            
            if(rs.first()){
                aux=rs.getInt(1);
            }
         desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
     }
     public int contarPrecio(){
        conectar();
      int aux = 0;
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select sum(precio) from pedido");
            
            if(rs.first()){
                aux=rs.getInt(1);
            }
         desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
     }
      public void insertarPizza(String pizza){
        conectar();

        try {
            Statement s = (Statement) con.createStatement();
            s.executeUpdate("insert into pizzas values(0,'"+pizza+"',10)");
         desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      public void insertarCliente(String nombre ,String telefono ,String direccion ){
        conectar();
 
        try {
            Statement s = (Statement) con.createStatement();
            s.executeUpdate("insert into clientes values(0,'"+nombre+"','"+telefono+"','"+direccion+"');");
         desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    void insertarCliente(String text, JTextField jTextFieldTelefono, JTextField jTextFieldDireccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

