package com.academico.application;

import com.academico.domain.model.Curso;
import com.academico.infrastructure.CursoRepository;

import java.util.List;

public class CursoService {

    private final CursoRepository repository;

    public CursoService() {
        repository = new CursoRepository();
    }

    public boolean registrar(Curso curso) {

        List<Curso> cursos = repository.listar();

        for (Curso cursoExistente : cursos) {
            if (cursoExistente.getId() == curso.getId()) {
                return false;
            }
        }

        cursos.add(curso);

        repository.guardar(cursos);
        return true;
    }

    public List<Curso> listar() {
        return repository.listar();
    }

    public boolean actualizar(Curso curso) {

        List<Curso> cursos = repository.listar();

        for (Curso c : cursos) {

            if (c.getId() == curso.getId()) {

                c.setNombre(curso.getNombre());
                c.setCreditos(curso.getCreditos());

                repository.guardar(cursos);

                return true;
            }
        }

        return false;
    }

    public boolean eliminar(int id) {

        List<Curso> cursos = repository.listar();

        boolean eliminado = cursos.removeIf(c -> c.getId() == id);

        if (eliminado) {
            repository.guardar(cursos);
        }

        return eliminado;
    }
}