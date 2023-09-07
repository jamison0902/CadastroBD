/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author jsq
 */
public class PessoaFisica extends Pessoa{

    String cpf;

    public PessoaFisica(int idPessoa, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cpf) {
        super(idPessoa, nome, logradouro, cidade, estado, telefone, email);
        this.cpf = cpf;

    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String newCpf) {
        this.cpf = newCpf;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + this.cpf);
    }
}
