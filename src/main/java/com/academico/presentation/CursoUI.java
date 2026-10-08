package com.academico.presentation;

import java.util.Scanner;

import com.academico.application.CursoService;
import com.academico.domain.model.Curso;

public class CursoUI {
    private static final CursoService service = new CursoService();

    public static void mostrarMenu(Scanner sc) {
        int opcion;
        do {
            System.out.println("\n=== GESTION DE CURSOS ===");
            System.out.println("1. Registrar");
            System.out.println("2. Listar");
            System.out.println("0. Regresar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("creditos: ");
                    int creditos = sc.nextInt();
                    boolean registrado = service.registrar(new Curso(id, nombre, creditos));
                    System.out.println(registrado ? "Curso registrado" : "El ID ya existe");
                    break;
                case 2:
                    for (Curso curso : service.listar()) {
                        System.out.println(curso.getId() + " - " + curso.getNombre() + " - " + curso.getCreditos() + " creditos");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}