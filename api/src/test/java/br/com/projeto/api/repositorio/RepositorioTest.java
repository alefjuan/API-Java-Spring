package br.com.projeto.api.repositorio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.projeto.api.model.Aluno;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

@DataJpaTest
public class RepositorioTest {

    @InjectMocks
    private Repositorio repositorio;

    @Mock
    private Repositorio repositorioMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByNome() {
        Aluno aluno = new Aluno();
        aluno.setMatricula(1);
        aluno.setNome("João Silva");
        aluno.setIdade(25);

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);

        when(repositorioMock.findByNome("João Silva")).thenReturn(alunos);

        List<Aluno> result = repositorio.findByNome("João Silva");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("João Silva", result.get(0).getNome());
    }

    @Test
    void testCountByMatricula() {
        when(repositorioMock.countByMatricula(1)).thenReturn(1);

        int count = repositorio.countByMatricula(1);

        assertEquals(1, count);
    }
}
