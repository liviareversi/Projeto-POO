package Medicina.SinalVital;

import Medicina.Processador;
import Pacientes.Paciente;

//Esta é a classe para você FAZER um EXAME de SINAIS VITAIS
//Ela vai distinguir a sua idade e CHAMAR o exame correto

public class ProcessadorExameSinaisVitais extends Processador {

    //Instancias ===============================================================================
    SinalVitalAdulto sinalVitalAdulto = new SinalVitalAdulto();
    SinalVitalCrianca sinalVitalCrianca = new SinalVitalCrianca();
    //=========================================================================================



    //Construtores ############################################################################
    public ProcessadorExameSinaisVitais(Paciente paciente) {
        super(paciente);
    }
    //##########################################################################################



    //Métodos obrigatórios

    //---------------------------------------------------------------------------------
    //Se o paciente>18 anos, vai PEGAR os valores e SALVAR na instancia de adultos
    @Override
    public void fazerExame() {
        if (paciente.getIdade() >= 18) {
            sinalVitalAdulto.DigitarSinaisPacientes();
        }
        else {
            sinalVitalCrianca.DigitarSinaisPacientes();
        }
    }
    //---------------------------------------------------------------------------------



    //---------------------------------------------------------------------------------
    //Se o paciente>18 anos, vai PEGAR os valores  dentro de um arquivo e SALVAR na instancia de adultos
    @Override
    public void lerInformacoesDoExame() {

        if (paciente.getIdade() >= 18) {
            sinalVitalAdulto.analisePeloArquivo();
        }
        else {
            sinalVitalCrianca.analisePeloArquivo();
        }

    }
    //---------------------------------------------------------------------------------



    //---------------------------------------------------------------------------------
    //Compara os valores para dizer se o adulto ou criança está bem
    @Override
    public void recomendarTratamento() {
        if (paciente.getIdade() >= 18) {
            sinalVitalAdulto.verificar(paciente);
        }
        else {
            sinalVitalCrianca.verificar(paciente);
        }
    }
    //---------------------------------------------------------------------------------

}
