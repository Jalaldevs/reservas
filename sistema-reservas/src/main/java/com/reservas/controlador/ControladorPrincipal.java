package com.reservas.controlador;

import com.reservas.util.ConexionBD;
import com.reservas.vista.Utilidades;
import com.reservas.vista.VistaPrincipal;

import java.sql.SQLException;

/**
 * Controlador principal que coordina los submenús y gestiona el ciclo
 * de vida de la conexión con la base de datos.
 *
 * <p><b>Estado:</b> de momento solo está implementado el módulo de
 * Usuarios (parcialmente). Los módulos de Recursos, Horarios,
 * Disponibilidades y Reservas se irán añadiendo más adelante.</p>
 */
public class ControladorPrincipal {

    private final VistaPrincipal vista = new VistaPrincipal();

    public void iniciar() {
        try {
            ConexionBD.getConexion();
            vista.mostrarMensaje("Conexión con la base de datos establecida correctamente.");
        } catch (SQLException e) {
            vista.mostrarError("No se pudo conectar a la base de datos: " + e.getMessage());
            vista.mostrarError("Revisa las variables DB_URL, DB_USER y DB_PASSWORD.");
            return;
        }

        int op;
        do {
            op = vista.mostrarMenuPrincipal();
            switch (op) {
                case 1 -> new ControladorUsuario().ejecutar();
                case 2, 3, 4, 5 -> {
                    vista.mostrarMensaje("Módulo en desarrollo. Próximamente disponible.");
                    Utilidades.pausar();
                }
                case 0 -> vista.mostrarMensaje("Saliendo de la aplicación. ¡Hasta pronto!");
                default -> {
                    vista.mostrarError("Opción no válida.");
                    Utilidades.pausar();
                }
            }
        } while (op != 0);

        ConexionBD.cerrarConexion();
    }
}
