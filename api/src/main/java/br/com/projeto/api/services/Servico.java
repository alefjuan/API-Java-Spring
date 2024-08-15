package br.com.projeto.api.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.model.Aluno;
import br.com.projeto.api.model.Mensagem;
import br.com.projeto.api.repositorio.Repositorio;

@Service
public class Servico {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio repositorio;

    //método de cadastro
    public ResponseEntity<?> cadastrar(Aluno obj) {
        // Verificar se o campo nome está preenchido e tem mais de 3 caracteres
        if (obj.getNome() == null || obj.getNome().isEmpty() || obj.getNome().length() <= 3) {
            mensagem.setMensagem("Nome necessita preenchimento e deve conter mais de 3 caracteres.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        
        // Verificar se o campo idade é maior que zero
        if (obj.getIdade() <= 0) {
            mensagem.setMensagem("Idade inválida! Deve ser maior que zero.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        
        // Verificar se a matrícula é um número positivo
        if (obj.getMatricula() <= 0) {
            mensagem.setMensagem("Matrícula inválida! Deve ser um número positivo.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
    
        // Verificar se a matrícula não se repete na base manualmente, já que o método existsByMatricula(int) não está definido
        if (repositorio.findById(obj.getMatricula()).isPresent()) {
            mensagem.setMensagem("A matrícula já existe!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
    
        // Se todas as verificações passarem, salvar o aluno
        return new ResponseEntity<>(repositorio.save(obj), HttpStatus.CREATED);
    }
    
    

    //método de seleção
    public ResponseEntity<?> selecionar()
    {
        return new ResponseEntity<>(repositorio.findAll(), HttpStatus.OK);
    }
    
    //método de seleção por matricula
    public ResponseEntity<?> selecionarPorMatricula(int matricula){
        if(repositorio.countByMatricula(matricula)==0){
            mensagem.setMensagem("Aluno não encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(repositorio.findByMatricula(matricula), HttpStatus.OK);
        }
    }

    //metodo para edição
    public ResponseEntity<?> editar(Aluno obj){
        if(repositorio.countByMatricula(obj.getMatricula())==0)
        {
            mensagem.setMensagem("Matricula não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(obj.getNome().equals(""))
            {
                mensagem.setMensagem("Necessário informar nome");
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            }else if(obj.getIdade()<=0)
            {
                mensagem.setMensagem("Informe uma idade Válida");
                return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
            }else{
                return new ResponseEntity<>(repositorio.save(obj), HttpStatus.OK);
            }
    }
    //metodo de remoção
    public ResponseEntity<?> remover(int matricula)
    {
        if(repositorio.countByMatricula(matricula)==0){
            mensagem.setMensagem("Matricula não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            Aluno obj =repositorio.findByMatricula(matricula);
            repositorio.delete(obj);

            mensagem.setMensagem("Aluno excluído com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
    }
