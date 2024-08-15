package br.com.projeto.api.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.com.projeto.api.model.Aluno;
import java.util.List;

@org.springframework.stereotype.Repository
public interface Repositorio extends CrudRepository<Aluno, Integer>{
    List<Aluno> findAll();
    Aluno findByMatricula(int matricula);
    List<Aluno> findByIdade(int idade);
    List<Aluno> findByNome(String nome);

    @Query(value = "SELECT SUM(idade) FROM alunos", nativeQuery = true)
    int somaIdades();

    @Query(value = "SELECT * FROM alunos WHERE idade >= :idade", nativeQuery = true)
    List<Aluno> idadeMaiorIgual(int idade);
    int countByMatricula(int matricula);
}
