package Medicina.Sangue;

import Medicina.Processador;
import Pacientes.Paciente;

public class ProcessadorExameSangue extends Processador {

    //Instancias ===============================================================================
    private ExameSangue exameLaboratorial; //Private?
    //=========================================================================================



    //Construtores ############################################################################
    public ProcessadorExameSangue(Paciente paciente) {
        super(paciente);
        this.exameLaboratorial = new ExameSangue();
    }
    //##########################################################################################



    //Métodos obrigatórios
    //---------------------------------------------------------------------------------
    @Override
    public void fazerExame() {
        exameLaboratorial.DigitarSinaisPacientes();
    }
    //---------------------------------------------------------------------------------



    //---------------------------------------------------------------------------------
    @Override
    public void lerInformacoesDoExame() {
        exameLaboratorial.analisePeloArquivo();
    }
    //---------------------------------------------------------------------------------



    //---------------------------------------------------------------------------------
    @Override
    public void recomendarTratamento() {
        exameLaboratorial.verificar(paciente);
    }
    //---------------------------------------------------------------------------------

}
