package com.reservas.dao;

import com.reservas.modelo.Usuario;
import com.reservas.util.ConexionBD;

import java.sql.*;

/**
 * DAO (Data Access Object) para la tabla <code>USUARIO</code>.
 *
 * <p><b>Estado:</b> primeras pruebas con JDBC. De momento solo se ha
 * implementado el INSERT básico para comprobar que la conexión y los
 * PreparedStatement funcionan.</p>
 */
public class UsuarioDAO {

    /**
     * Inserta un nuevo usuario base en la tabla <code>USUARIO</code>.
     */
    public int insertar(Usuario u) throws SQLException {
        String sql = "INSERT INTO USUARIO (nombre, email, password, telefono) VALUES (?, ?, ?, ?)";
        Connection con = ConexionBD.getConexion();
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getTelefono());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    u.setId(rs.getInt(1));
                }
            }
        }
        return u.getId();
    }

    // TODO: listarTodos()
    // TODO: buscarPorId(int id)
    // TODO: modificar(Usuario u)
    // TODO: eliminar(int id)
    // TODO: buscarPorNombre(String texto)  -- usar LIKE
    // TODO: insertarAdministrador(Administrador a)  -- con transacción
    // TODO: insertarUsuarioNormal(UsuarioNormal un) -- con transacción
    // TODO: listarAdministradores()  -- INNER JOIN con ADMINISTRADOR
    // TODO: listarUsuariosNormales() -- INNER JOIN con USUARIONORMAL
    // TODO: contar()  -- SELECT COUNT(*)
}
