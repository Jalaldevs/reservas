package com.reservas.vista;

import com.reservas.modelo.Administrador;
import com.reservas.modelo.Usuario;
import com.reservas.modelo.UsuarioNormal;

import java.util.List;

/**
 * Vista para los menús e impresión de datos relativos a Usuarios.
 */
public class VistaUsuario {

    public int mostrarMenu() {
        Utilidades.cabecera("GESTIÓN DE USUARIOS");
        System.out.println("  1. Insertar usuario base");
        System.out.println("  2. Insertar administrador             [PENDIENTE]");
        System.out.println("  3. Insertar usuario normal            [PENDIENTE]");
        System.out.println("  4. Modificar usuario                  [PENDIENTE]");
        System.out.println("  5. Eliminar usuario                   [PENDIENTE]");
        System.out.println("  6. Listar todos los usuarios          [PENDIENTE]");
        System.out.println("  7. Buscar usuario por ID              [PENDIENTE]");
        System.out.println("  8. Buscar usuarios por nombre         [PENDIENTE]");
        System.out.println("  9. Listar administradores             [PENDIENTE]");
        System.out.println(" 10. Listar usuarios normales           [PENDIENTE]");
        System.out.println(" 11. Contar usuarios                    [PENDIENTE]");
        System.out.println("  0. Volver");
        return Utilidades.leerInt("\nElige una opción: ");
    }

    public Usuario pedirDatosUsuario() {
        String nombre   = Utilidades.leerString("Nombre: ");
        String email    = Utilidades.leerString("Email: ");
        String pass     = Utilidades.leerString("Contraseña: ");
        String telefono = Utilidades.leerString("Teléfono: ");
        return new Usuario(nombre, email, pass, telefono);
    }

    public Administrador pedirDatosAdministrador() {
        Usuario u = pedirDatosUsuario();
        int nivel = Utilidades.leerInt("Nivel de acceso (entero): ");
        return new Administrador(0, u.getNombre(), u.getEmail(),
                u.getPassword(), u.getTelefono(), nivel);
    }

    public UsuarioNormal pedirDatosUsuarioNormal() {
        Usuario u = pedirDatosUsuario();
        String depto = Utilidades.leerString("Departamento: ");
        return new UsuarioNormal(0, u.getNombre(), u.getEmail(),
                u.getPassword(), u.getTelefono(), depto);
    }

    public void mostrar(Usuario u) {
        System.out.println(u);
    }

    public void mostrarLista(List<? extends Usuario> lista) {
        if (lista.isEmpty()) {
            System.out.println("  (sin resultados)");
            return;
        }
        lista.forEach(System.out::println);
    }
}
