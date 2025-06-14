import Medicina.Sangue.ExameSangue;
import Pacientes.CadastrarPaciente;
import Pacientes.Paciente;
import Medicina.SelecaoDeExames;
import Medicina.SinalVital.ProcessadorExameSinaisVitais;

import java.util.Scanner; //Para usar o scanner

public class Main {
    public static void main(String[] args) {

        //Atributos ====================================================================
        int FazerOuCarregar = 2;
        Boolean[] exames;
        //===============================================================================



        //Instancias ====================================================================
        CadastrarPaciente cadastrarPaciente = new CadastrarPaciente();
        SelecaoDeExames selecaoDeExames = new SelecaoDeExames();
        Scanner sc = new Scanner(System.in);
        Paciente paciente2;
        //===============================================================================



                                            //Começo do Código\\



            System.out.println("                    BioAnalyzer");



            //Cadastrar o Paciente
            System.out.println("======================================================");
            System.out.println("[Cadastro de Pacientes:]");
            paciente2 = cadastrarPaciente.cadastro();
            //------------------------------------------------------------------------------



            //Qual exame deseja fazer?
            exames = selecaoDeExames.selecaoExame();
            //------------------------------------------------------------------------------



            // Fazer exame de sangue? -------------------------------------------------------
            if (exames[0] == true) {
                ExameSangue exameSangue = new ExameSangue();

                System.out.println("======================================================");
                System.out.println("[Exame de Sangue:]");
                System.out.println("Deseja fazer exame (1) ou carregar um exame (0)?");
                FazerOuCarregar = sc.nextInt();

                if (FazerOuCarregar == 1) {
                    exameSangue.DigitarSinaisPacientes();
                } else {
                    exameSangue.analisePeloArquivo();
                }

                exameSangue.verificar(paciente2);
            }
            // ------------------------------------------------------------------------------



            //Fazer exame de Sinais Vitais? ------------------------------------------------
            if (exames[1] == true) {
                //fazer exame sinais vitais
                ProcessadorExameSinaisVitais processadorExameSinaisVitais = new ProcessadorExameSinaisVitais(paciente2);

                System.out.println("======================================================");
                System.out.println("[Exame SinaisVitais:]");
                System.out.println("Deseja fazer exame (1) ou carregar um exame (0)?");
                FazerOuCarregar = sc.nextInt();


                if(FazerOuCarregar == 1){
                    processadorExameSinaisVitais.fazerExame();
                }
                else {
                    processadorExameSinaisVitais.lerInformacoesDoExame();
                }
                processadorExameSinaisVitais.recomendarTratamento();

            }
            //------------------------------------------------------------------------------



            //Nenhum exame selecionado! ----------------------------------------------------
            if (exames[0] == false && exames[1] == false) {
                System.out.println("Erro, nenhum exame selecionado!");
                //return 0? end?
            }
            //------------------------------------------------------------------------------

        }
}
