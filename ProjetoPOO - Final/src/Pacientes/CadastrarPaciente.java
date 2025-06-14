package Pacientes;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

//Esta classe serve para CADASTRAR um paciente (na main), com intuito de deixar a main mais limpa

public class CadastrarPaciente {

    //Atributos ===============================================================================
    private String nome;
    private int idade;
    private String cpf;
    private String sexo;
    private String sintomas;
    //=========================================================================================


    //Instancias ===============================================================================
    Scanner sc = new Scanner(System.in);
    //=========================================================================================


    //Se criar com msm nome o arquivo é substituido
    //Metodo para criar arquvio do paciente ----------------------------------------------
    private void salvarEmArquivo() {

        String conteudo =
                "======================================================\n" +
                "              [Cadastro do Paciente]         \n" +
                "======================================================\n" +
                "[Nome:]       "     + nome     + "\n" +
                "[Idade:]      "     + idade    + "\n" +
                "[Sexo:]       "     + sexo     + "\n" +
                "[CPF:]        "     + cpf      + "\n" +
                "[Sintomas:]   "     + sintomas + "\n" +
                "======================================================\n" +
                "                 [Exames]             \n" +
                "======================================================\n";

        Path caminho = Paths.get("Clientes/" + cpf + ".txt");

        try {
            // Cria a pasta Clientes se não existir
            Files.createDirectories(Paths.get("Clientes"));

            //Criar o arquivo se não existir
            // Escreve o conteúdo no arquivo
            Files.writeString(caminho, conteudo);

            System.out.println("[Cadastro Realizado com sucesso!] " + caminho.toString());
        } catch (IOException e) { //Se acontecer qualquer erro de entrada/saída o programa não trava e exibe a mensagem
            System.out.println("Erro ao salvar paciente no arquivo: " + e.getMessage());
        }
    }
    //--------------------------------------------------------------------------



    //Metodo para cadastrar paciente ----------------------------------------------
    public Paciente cadastro() {
        System.out.print("[Digite o seu Nome:] ");
        nome = sc.nextLine();

        System.out.print("[Digite a sua Idade:] ");
        idade = sc.nextInt();
        sc.nextLine(); // <-- consome o '\n' deixado pelo nextInt(), se tirar isso buga

        System.out.print("[Digite o seu Sexo:] ");
        sexo = sc.nextLine();

        System.out.print("[Digite o CPF:] ");
        cpf = sc.nextLine();

        System.out.print("[Digite os sintomas:] ");
        sintomas = sc.nextLine();

        salvarEmArquivo();

        return new Paciente(nome, idade, sexo, cpf, sintomas); //Retorna um paciente
    }
    //--------------------------------------------------------------------------
}
