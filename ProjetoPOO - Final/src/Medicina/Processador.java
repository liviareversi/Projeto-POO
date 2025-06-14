package Medicina;

import Pacientes.Paciente;

//Esta classe define COMO UM EXAME DEVE ser feito e suas obrigações

public abstract class Processador {

    //Atributos ====================================================================
    protected Paciente paciente;
    //===============================================================================



    //Construtor para para passar o paciente, preciso saber a idade dele (>/<18 anos)
    public Processador(Paciente paciente) {
        this.paciente = paciente;
    }
    // ##############################################################################



    //Métodos para serem implementados em cada subclasse ----------------------------
    public abstract void fazerExame();
    public abstract void lerInformacoesDoExame();
    public abstract void recomendarTratamento();
    //---------------------------------------------------------------------------------


}
