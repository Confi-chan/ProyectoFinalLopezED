
package Vista;
import java.sql.*;

public class ProductoControl {
    

    public void crearProducto(String nombre, double precio, String licencia) throws Exception {
        Connection con = DBConexion.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO products (name, price, licenseType) VALUES (?, ?, ?)");
        ps.setString(1, nombre);
        ps.setDouble(2, precio);
        ps.setString(3, licencia);
        ps.executeUpdate();
    }

    public ResultSet ObtenerProductos() throws Exception {
        Connection con = DBConexion.getConnection();
        Statement stmt = con.createStatement();
        return stmt.executeQuery("seleccionar * el producto");
    }

    // Agregar métodos para actualizar, eliminar, etc.
}

