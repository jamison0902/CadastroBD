/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package cadastrobd;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaJuridicaDAO;

import java.util.List;

public class CadastroBDTeste {

    public static void main(String[] args) throws Exception {

        // Instanciar e persistir uma pessoa física no banco
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica pessoaFisica = new PessoaFisica(0, "João da Silva", "Rua ABC, 123", "São Paulo", "SP", "111-222-3333", "joao@gmail.com", "123.456.789-00");
        pessoaFisicaDAO.incluir(pessoaFisica);

        // Alterar os dados da pessoa física no banco
        pessoaFisica.setTelefone("999-888-7777");
        pessoaFisicaDAO.alterar(pessoaFisica);

        // Consultar todas as pessoas físicas e listar no console
        List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.getPessoas();
        System.out.println("Pessoas Físicas:");
        for (PessoaFisica pf : pessoasFisicas) {
            pf.exibir();
            System.out.println("-------------");
        }

        // Excluir a pessoa física do banco
        pessoaFisicaDAO.excluir(pessoaFisica.getIdPessoa());

        // Instanciar e persistir uma pessoa jurídica no banco
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaJuridica pessoaJuridica = new PessoaJuridica(0, "Empresa XYZ", "Av. XYZ, 456", "Rio de Janeiro", "RJ", "777-888-9999", "empresa@xyz.com", "12.345.678/0001-00");
        pessoaJuridicaDAO.incluir(pessoaJuridica);

        // Alterar os dados da pessoa jurídica no banco
        pessoaJuridica.setTelefone("888-777-6666");
        pessoaJuridicaDAO.alterar(pessoaJuridica);

        // Consultar todas as pessoas jurídicas e listar no console
        List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.getPessoas();
        System.out.println("Pessoas Jurídicas:");
        for (PessoaJuridica pj : pessoasJuridicas) {
            pj.exibir();
            System.out.println("-------------");
        }

        // Excluir a pessoa jurídica do banco
        pessoaJuridicaDAO.excluir(pessoaJuridica.getIdPessoa());

    }
}
