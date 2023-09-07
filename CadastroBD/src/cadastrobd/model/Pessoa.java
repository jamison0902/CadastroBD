/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author jsq
 */
public class Pessoa {

    int idPessoa;
    String nome;
    String logradouro;
    String cidade;
    String estado;
    String telefone;
    String email;

    public Pessoa(int idPessoa, String nome, String logradouro, String cidade, String estado, String telefone, String email) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdPessoa() {
        return this.idPessoa;
    }

    public void setIdPessoa(int newIdPessoa) {
        this.idPessoa = newIdPessoa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String newLogradouro) {
        this.logradouro = newLogradouro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String newCidade) {
        this.cidade = newCidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String newEstado) {
        this.estado = newEstado;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String newTelefone) {
        this.telefone = newTelefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void exibir() {
        System.out.println("ID: " + this.idPessoa);
        System.out.println("Nome: " + this.nome);
        System.out.println("Logradouro: " + this.logradouro);
        System.out.println("Cidade: " + this.cidade);
        System.out.println("Estado: " + this.estado);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("E-mail: " + this.email);
    }

}
