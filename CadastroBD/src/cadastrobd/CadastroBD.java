/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastrobd;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaJuridicaDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jsq
 */
public class CadastroBD {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        // Instanciando os DAO
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

        // Menu
        Scanner input = new Scanner(System.in);
        OUTER:
        while (true) {
            System.out.println("===============================================");
            System.out.println("               Menu de Opções                  ");
            System.out.println("===============================================");
            System.out.println("1. Incluir Pessoa");
            System.out.println("2. Alterar Pessoa");
            System.out.println("3. Excluir Pessoa");
            System.out.println("4. Busca pelo ID");
            System.out.println("5. Exibir Todos");
            System.out.println("0. Finalizar Programa");
            System.out.println("===============================================");
            String option = input.nextLine();

            switch (option) {
                case "1": { // Incluir Pessoa
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {

                        System.out.println("Digite o Nome da Pessoa Física");
                        String PessoaFisicaNome = input.nextLine();

                        System.out.println("Digite o Logradouro da Pessoa Física");
                        String PessoaFisicaLogradouro = input.nextLine();

                        System.out.println("Digite o Cidade da Pessoa Física");
                        String PessoaFisicaCidade = input.nextLine();

                        System.out.println("Digite o Estado da Pessoa Física");
                        String PessoaFisicaEstado = input.nextLine();

                        System.out.println("Digite o Telefone da Pessoa Física");
                        String PessoaFisicaTelefone = input.nextLine();

                        System.out.println("Digite o E-mail da Pessoa Física");
                        String PessoaFisicaEmail = input.nextLine();

                        System.out.println("Digite o CPF da Pessoa Física");
                        String PessoaFisicaCpf = input.nextLine();

                        PessoaFisica pf = new PessoaFisica(0, PessoaFisicaNome, PessoaFisicaLogradouro, PessoaFisicaCidade, PessoaFisicaEstado, PessoaFisicaTelefone, PessoaFisicaEmail, PessoaFisicaCpf);
                        pessoaFisicaDAO.incluir(pf);
                    } else {

                        System.out.println("Digite o Nome da Pessoa Jurídica");
                        String PessoaJuridicaNome = input.nextLine();

                        System.out.println("Digite o Logradouro da Pessoa Jurídica");
                        String PessoaJuridicaLogradouro = input.nextLine();

                        System.out.println("Digite o Cidade da Pessoa Jurídica");
                        String PessoaJuridicaCidade = input.nextLine();

                        System.out.println("Digite o Estado da Pessoa Jurídica");
                        String PessoaJuridicaEstado = input.nextLine();

                        System.out.println("Digite o Telefone da Pessoa Jurídica");
                        String PessoaJuridicaTelefone = input.nextLine();

                        System.out.println("Digite o E-mail da Pessoa Jurídica");
                        String PessoaJuridicaEmail = input.nextLine();

                        System.out.println("Digite o CNPJ da Pessoa Jurídica");
                        String PessoaJuridicaCnpj = input.nextLine();

                        PessoaJuridica pj = new PessoaJuridica(0, PessoaJuridicaNome, PessoaJuridicaLogradouro, PessoaJuridicaCidade, PessoaJuridicaEstado, PessoaJuridicaTelefone, PessoaJuridicaEmail, PessoaJuridicaCnpj);
                        pessoaJuridicaDAO.incluir(pj);
                    }
                    break;
                }
                case "2": { // Alterar Pessoa
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        System.out.print("Digite o ID da Pessoa Física\n");
                        String PessoaFisicaId = input.nextLine();

                        System.out.println("Digite o Nome da Pessoa Física");
                        String PessoaFisicaNome = input.nextLine();

                        System.out.println("Digite o Logradouro da Pessoa Física");
                        String PessoaFisicaLogradouro = input.nextLine();

                        System.out.println("Digite o Cidade da Pessoa Física");
                        String PessoaFisicaCidade = input.nextLine();

                        System.out.println("Digite o Estado da Pessoa Física");
                        String PessoaFisicaEstado = input.nextLine();

                        System.out.println("Digite o Telefone da Pessoa Física");
                        String PessoaFisicaTelefone = input.nextLine();

                        System.out.println("Digite o E-mail da Pessoa Física");
                        String PessoaFisicaEmail = input.nextLine();

                        System.out.println("Digite o CPF da Pessoa Física");
                        String PessoaFisicaCpf = input.nextLine();

                        PessoaFisica pf = new PessoaFisica(Integer.parseInt(PessoaFisicaId), PessoaFisicaNome, PessoaFisicaLogradouro, PessoaFisicaCidade, PessoaFisicaEstado, PessoaFisicaTelefone, PessoaFisicaEmail, PessoaFisicaCpf);
                        pessoaFisicaDAO.alterar(pf);
                    } else {
                        System.out.print("Digite o ID da Pessoa Jurídica\n");
                        String PessoaJuridicaId = input.nextLine();

                        System.out.println("Digite o Nome da Pessoa Jurídica");
                        String PessoaJuridicaNome = input.nextLine();

                        System.out.println("Digite o Logradouro da Pessoa Jurídica");
                        String PessoaJuridicaLogradouro = input.nextLine();

                        System.out.println("Digite o Cidade da Pessoa Jurídica");
                        String PessoaJuridicaCidade = input.nextLine();

                        System.out.println("Digite o Estado da Pessoa Jurídica");
                        String PessoaJuridicaEstado = input.nextLine();

                        System.out.println("Digite o Telefone da Pessoa Jurídica");
                        String PessoaJuridicaTelefone = input.nextLine();

                        System.out.println("Digite o E-mail da Pessoa Jurídica");
                        String PessoaJuridicaEmail = input.nextLine();

                        System.out.println("Digite o CNPJ da Pessoa Jurídica");
                        String PessoaJuridicaCnpj = input.nextLine();

                        PessoaJuridica pj = new PessoaJuridica(Integer.parseInt(PessoaJuridicaId), PessoaJuridicaNome, PessoaJuridicaLogradouro, PessoaJuridicaCidade, PessoaJuridicaEstado, PessoaJuridicaTelefone, PessoaJuridicaEmail, PessoaJuridicaCnpj);
                        pessoaJuridicaDAO.alterar(pj);
                    }
                    break;
                }
                case "3": { // Remover pelo ID
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        System.out.print("Digite o ID da Pessoa Física\n");
                        String PessoaFisicaId = input.nextLine();
                        pessoaFisicaDAO.excluir(Integer.parseInt(PessoaFisicaId));
                    } else {
                        System.out.print("Digite o ID da Pessoa Jurídica\n");
                        String PessoaJuridicaId = input.nextLine();
                        pessoaJuridicaDAO.excluir(Integer.parseInt(PessoaJuridicaId));
                    }
                    break;
                }
                case "4": { // Obter pelo ID
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        System.out.print("Digite o ID da Pessoa Física\n");
                        String PessoaFisicaId = input.nextLine();
                        PessoaFisica pessoaf = pessoaFisicaDAO.getPessoa(Integer.parseInt(PessoaFisicaId));
                        System.out.println("===============================================");
                        System.out.println("               Pessoa Física                   ");
                        System.out.println("===============================================");
                        pessoaf.exibir();
                    } else {
                        System.out.print("Digite o ID da Pessoa Jurídica\n");
                        String PessoaJuridicaId = input.nextLine();
                        PessoaJuridica pessoaj = pessoaJuridicaDAO.getPessoa(Integer.parseInt(PessoaJuridicaId));
                        System.out.println("===============================================");
                        System.out.println("               Pessoa Jurídica                 ");
                        System.out.println("===============================================");
                        pessoaj.exibir();
                    }
                    break;
                }
                case "5": { // Obter Todos
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.getPessoas();
                        System.out.println("===============================================");
                        System.out.println("               Pessoas Físicas                 ");
                        System.out.println("===============================================");
                        for (PessoaFisica pf : pessoasFisicas) {
                            pf.exibir();
                        }
                        System.out.println("===============================================");
                    } else {
                        List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.getPessoas();
                        System.out.println("===============================================");
                        System.out.println("               Pessoas Jurídicas               ");
                        System.out.println("===============================================");
                        for (PessoaJuridica pj : pessoasJuridicas) {
                            pj.exibir();
                        }
                        System.out.println("===============================================");
                    }
                    break;
                }
                default: {
                    break OUTER;
                }
            }

        }

    }

}
