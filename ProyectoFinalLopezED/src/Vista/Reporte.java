
package Vista;
import java.sql.*;

public class Reporte {
    


    public ResultSet ObtenerInformeExistenciasBajas() throws Exception {
        Connection con = DBConexion.getConnection();
        Statement stmt = con.createStatement();
        return stmt.executeQuery("SELECCIONAR * DE productos DONDE stock < stock_minimo");
    }

    // Agregue otros métodos de informe según sea necesario
}


