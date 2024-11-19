
package Vista;
import java.sql.*;

public class Cliente {
    // Método para crear un cliente
    public void crearCliente(String nombre, String email,String telefono) throws Exception {
        Connection con = DBConexion.getConnection();
        String sql = "INSERT INTO cliente (nombre, email, telefono) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, email);
        ps.setString(3, telefono);
        ps.executeUpdate();
        ps.close();
        con.close();
    }
      // Método para obtener un cliente por ID
    public ResultSet Obtener_cliente(int cliente_Id) throws Exception {
        Connection con = DBConexion.getConnection();
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, cliente_Id);
        return ps.executeQuery();

    }
    // Método para obtener todos los clientes
    public ResultSet obtenerTodosLosClientes() throws Exception {
  Connection con = DBConexion.getConnection();
        String sql = "SELECT * FROM cliente";
        Statement stmt = con.createStatement();
        return stmt.executeQuery(sql);

 }
    //Agregar métodos para actualizar, eliminar, etc.
}


