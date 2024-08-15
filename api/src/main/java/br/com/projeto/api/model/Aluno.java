package br.com.projeto.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricula; 
    private String nome;
    private int idade;
    
    @Column(columnDefinition = "TEXT") // Usar TEXT para MySQL
    private String telefones; // Armazena os telefones como um texto JSON ou delimitado

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String getTelefones() {
        return telefones;
    }
    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }
}
