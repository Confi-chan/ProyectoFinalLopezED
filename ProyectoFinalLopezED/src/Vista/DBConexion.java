
package Vista;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBConexion {
       private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Cambia según tu configuración
    private static final String USER = "StudioGamer"; // Cambia al usuario de tu base de datos
    private static final String PASSWORD = "psp2024"; // Cambia al password de tu base de datos

    public static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
