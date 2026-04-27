package com.reservas.controlador;

import com.reservas.dao.UsuarioDAO;
import com.reservas.modelo.Usuario;
import com.reservas.vista.Utilidades;
import com.reservas.vista.VistaUsuario;

import java.sql.SQLException;

/**
 * Controlador que coordina {@link VistaUsuario} con {@link UsuarioDAO}.
 *
 * <p><b>Estado:</b> de momento solo está implementada la opción de
 * insertar un usuario base. El resto queda pendiente.</p>
 */
public class ControladorUsuario {

    private final VistaUsuario vista = new VistaUsuario();
    private final UsuarioDAO   dao   = new UsuarioDAO();

    public void ejecutar() {
        int op;
        do {
            op = vista.mostrarMenu();
            try {
                switch (op) {
                    case 1 -> insertarUsuario();
                    case 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 ->
                        System.out.println("  > Funcionalidad en desarrollo. Próximamente disponible.");
                    case 0 -> System.out.println("Volviendo al menú principal...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (SQLException e) {
                System.err.println("[ERROR SQL] " + e.getMessage());
            }
            if (op != 0) Utilidades.pausar();
        } while (op != 0);
    }

    private void insertarUsuario() throws SQLException {
        Usuario u = vista.pedirDatosUsuario();
        int id = dao.insertar(u);
        System.out.println("Usuario creado con ID = " + id);
    }

    // TODO: listar()
    // TODO: buscarPorId()
    // TODO: modificar()
    // TODO: eliminar()
    // TODO: buscarPorNombre()
    // TODO: insertarAdministrador()
    // TODO: insertarUsuarioNormal()
    // TODO: listarAdministradores()
    // TODO: listarUsuariosNormales()
}
