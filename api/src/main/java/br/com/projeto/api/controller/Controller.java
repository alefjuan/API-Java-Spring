package br.com.projeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.projeto.api.model.Aluno;
import br.com.projeto.api.services.Servico;
//import java.util.List;
//import org.springframework.http.HttpStatus;
//import br.com.projeto.api.repositorio.Repositorio;

@RestController
public class Controller {

    /*
    @Autowired
    private Repositorio repositorio;*/


    @Autowired
    private Servico servico;

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Aluno obj){
        return servico.cadastrar(obj);
    }

    @GetMapping("/api")
    public ResponseEntity<?> listarTodosAlunos(){
        return servico.selecionar();
    }
    
    @GetMapping("/api/{matricula}")
    public ResponseEntity<?> listarPorMatricula(@PathVariable int matricula){
        return servico.selecionarPorMatricula(matricula);
    }

    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Aluno obj){
        return servico.editar(obj);
    }

    @DeleteMapping("/api/{matricula}")
    public ResponseEntity<?> remover(@PathVariable int matricula){
        return servico.remover(matricula);
    }

    /*Métodos extras mas sem implementação no momento
    @GetMapping("/api/quantidadeDeAlunos")
    public long quantidadeDeAlunos(){
        return repositorio.count();
    }
    @GetMapping("api/idade/{idade}")
    public List<Aluno> listarPorIdade(@PathVariable int idade){
        return repositorio.findByIdade(idade);
    }
    @GetMapping("/api/somarIdades")
    public int somaIdades(){
        return repositorio.somaIdades();
    }

    @GetMapping("/api/idadeMaiorIgual/{idade}")
    public List<Aluno> idadeMaiorIgual(@PathVariable int idade){
        return repositorio.idadeMaiorIgual(idade);
    }
    
    @GetMapping("api/aluno/{nome}")
    public List<Aluno> listarPorNome(@PathVariable String nome){
        return repositorio.findByNome(nome);
    }
        */
}
