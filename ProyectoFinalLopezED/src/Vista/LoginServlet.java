
package Vista;
import java.sql.*;

public class LoginServlet {
      // Método para manejar el inicio de sesión
    public void login(String usuario, String contraseña, String role) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Obtener conexión
            con = DBConexion.getConnection();

            // Consulta SQL
            String sql = "SELECT * FROM users WHERE username=? AND role=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, role);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Verificar contraseña (asumiendo que está hasheada)
                String storedPassword = rs.getString("contraseña");

                if (storedPassword.equals(contraseña)) { // Cambiar por comparación segura si usas hashing
                    System.out.println("Inicio de sesión exitoso para el usuario: " + usuario + " con rol: " + role);

                    // Redirigir según el rol
                    if ("admin".equalsIgnoreCase(role)) {
                        System.out.println("Redirigir a la página de administración");
                    } else if ("seller".equalsIgnoreCase(role)) {
                        System.out.println("Redirigir a la página del vendedor");
                    } else {
                        System.out.println("Redirigir a la página de usuario estándar");
                    }
                } else {
                    System.out.println("Contraseña incorrecta para el usuario: " + usuario);
                }
            } else {
                System.out.println("Usuario o rol no encontrado: " + usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        LoginServlet loginServlet = new LoginServlet();
        loginServlet.login("testUsuario", "testContraseña", "admin");
    }
}

