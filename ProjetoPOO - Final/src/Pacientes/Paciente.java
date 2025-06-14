package Pacientes;

//Esta classe - DEFINE um paciente

public class Paciente {

    //Atributos ===============================================================================
    private String nome;
    private int idade;
    private String sexo;
    private String cpf;
    private String sintomas;
    //=========================================================================================



    //Construtores ############################################################################
    public Paciente(String nome, int idade, String sexo, String cpf, String sintomas) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.cpf = cpf;
        this.sintomas = sintomas;
    }



    public int getIdade() { //Getter para pegar idade dentro dos exames para ser é >/< 18 anos
        return idade;
    }

    public String getCpf() { //Getter para pegar idade dentro dos exames para ser é >/< 18 anos
        return cpf;
    }
    //##########################################################################################

}
