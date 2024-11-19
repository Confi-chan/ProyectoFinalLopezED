
package Vista;
import java.sql.*;

public class Ventas {
    


    public void Crear_Venta(int producto_Id, int cliente_Id, int cantidad) throws Exception {
        Connection con = DBConexion.getConnection();
        con.setAutoCommit(false);
        
        try {
            PreparedStatement ps = con.prepareStatement("INSERTAR EN ventas (producto_Id, cliente_Id, cantida) VALORES (?, ?, ?)");
            ps.setInt(1, producto_Id);
            ps.setInt(2, cliente_Id);
            ps.setInt(3, cantidad);
            ps.executeUpdate();

            PreparedStatement psUpdate = con.prepareStatement("UPDATE products SET stock = stock - ? WHERE id = ?");
            psUpdate.setInt(1, cantidad);
            psUpdate.setInt(2, producto_Id);
            psUpdate.executeUpdate();

            con.commit();
        } catch (Exception e) {
            con.rollback();
            throw e;
        }
    }

    // Agregar métodos para conseguir ventas, etc.
}


