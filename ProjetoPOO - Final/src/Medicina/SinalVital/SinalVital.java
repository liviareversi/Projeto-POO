package Medicina.SinalVital;


import java.util.Scanner;
import Pacientes.Paciente;
import java.util.List; //Lista
import java.io.IOException; //Excecao
import java.nio.file.Files; //Files metodo
import java.nio.file.Paths; //Paths metodo



//Esta classe - DEFINE oque é um sinal vital - PEGA os sinais do paciente

public abstract class SinalVital {

    //Atributos/Instancias ====================================================================
    protected int frequenciaCardiaca;
    protected int frequenciaRespiratoria;
    protected int pressaoSistolica;
    protected int pressaoDiastolica;
    protected float temperatura;
    protected int saturacaoOxigenio;
    Scanner scan = new Scanner(System.in);
    //=========================================================================================



    //Construtores ############################################################################
    public SinalVital(int frequenciaCardiaca, int frequenciaRespiratoria, int pressaoSistolica, int pressaoDiastolica, int temperatura, int saturacaoOxigenio) {
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.frequenciaRespiratoria = frequenciaRespiratoria;
        this.pressaoSistolica = pressaoSistolica;
        this.pressaoDiastolica = pressaoDiastolica;
        this.temperatura = temperatura;
        this.saturacaoOxigenio = saturacaoOxigenio;
    }

    public SinalVital() {
    }
    //##########################################################################################



    //Pegar Sinais pelo arquivo  -------------------------------------------------------------
    public void analisePeloArquivo(){
        try {

            String caminho = "LeitorExames/preset1.txt";

            List<String> linhas = Files.readAllLines(Paths.get(caminho));

            if (linhas.size() < 6) {
                throw new RuntimeException("Arquivo incompleto!");
            }

            this.frequenciaCardiaca      = Integer.parseInt(linhas.get(0)); //NumberFormatException
            this.frequenciaRespiratoria  = Integer.parseInt(linhas.get(1)); //Se colocar um float ou abc da erro
            this.pressaoSistolica        = Integer.parseInt(linhas.get(2)); //ParseInt metodo da classe integer
            this.pressaoDiastolica       = Integer.parseInt(linhas.get(3)); //Metodo estático
            this.temperatura             = Integer.parseInt(linhas.get(4));
            this.saturacaoOxigenio       = Integer.parseInt(linhas.get(5));

            System.out.println(" Exame carregado do arquivo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
    //---------------------------------------------------------------------------------



    //Pegar os Sinais do Paciente  -------------------------------------------------------------
    public void DigitarSinaisPacientes() {

        System.out.println("======================================================");
        System.out.println("[Exame de Sangue:]");

        // Pegar informação CARDIACA ------------------------------------------------------
        do {
            System.out.print("Digite sua frequência cardíaca (bpm): ");
            this.frequenciaCardiaca = scan.nextInt();
            if (this.frequenciaCardiaca < 20 || this.frequenciaCardiaca > 250) {
                System.out.println("Valor inválido. Digite um valor entre 20 e 250.");
            }
        } while (this.frequenciaCardiaca < 20 || this.frequenciaCardiaca > 250);
        //---------------------------------------------------------------------------------



        System.out.println("======================================================");
        System.out.println("[Exame Respiratório:]");

        // Pegar informação RESPIRATORIA  -------------------------------------------------
        do {
            System.out.print("Digite sua frequência respiratória (rpm): ");
            this.frequenciaRespiratoria = scan.nextInt();
            if (this.frequenciaRespiratoria < 5 || this.frequenciaRespiratoria > 60) {
                System.out.println("Valor inválido. Digite um valor entre 5 e 60.");
            }
        } while (this.frequenciaRespiratoria < 5 || this.frequenciaRespiratoria > 60);
        //---------------------------------------------------------------------------------



        System.out.println("======================================================");
        System.out.println("[Exame de Pressão:]");

        // Pegar informação PRESSAO SISTOLICA ---------------------------------------------
        do {
            System.out.print("Digite sua pressão sistólica (mmHg): ");
            this.pressaoSistolica = scan.nextInt();
            if (this.pressaoSistolica < 50 || this.pressaoSistolica > 250) {
                System.out.println("Valor inválido. Digite um valor entre 50 e 250.");
            }
        } while (this.pressaoSistolica < 50 || this.pressaoSistolica > 250);
        //---------------------------------------------------------------------------------



        // Pegar informação PRESSAO DIASTOLICA ------------------------------------------
        do {
            System.out.print("Digite sua pressão diastólica (mmHg): ");
            this.pressaoDiastolica = scan.nextInt();
            if (this.pressaoDiastolica < 30 || this.pressaoDiastolica > 150) {
                System.out.println("Valor inválido. Digite um valor entre 30 e 150.");
            }
        } while (this.pressaoDiastolica < 30 || this.pressaoDiastolica > 150);
        //-------------------------------------------------------------------------------



        System.out.println("======================================================");
        System.out.println("[Exame de Temperatura:]");

        // Pegar informação TEMPERATURA -------------------------------------------------
        do {
            System.out.print("Digite sua temperatura (°C): ");
            this.temperatura = scan.nextInt();
            if (this.temperatura < 30 || this.temperatura > 45) {
                System.out.println("Valor inválido. Digite um valor entre 30 e 45.");
            }
        } while (this.temperatura < 30 || this.temperatura > 45);
        //---------------------------------------------------------------------------------



        System.out.println("======================================================");
        System.out.println("[Exame da Saturação de Oxigênio:]");

        // Pegar informação SATURACAO OXIGENIO -------------------------------------------
        do {
            System.out.print("Digite sua saturação de oxigênio (%): ");
            this.saturacaoOxigenio = scan.nextInt();
            if (this.saturacaoOxigenio < 50 || this.saturacaoOxigenio > 100) {
                System.out.println("Valor inválido. Digite um valor entre 50 e 100.");
            }
        } while (this.saturacaoOxigenio < 50 || this.saturacaoOxigenio > 100);
        //---------------------------------------------------------------------------------
        System.out.println("======================================================");

    }
    //---------------------------------------------------------------------------------



    //---------------------------------------------------------------------------------
    //As subclasses obrigatoriamente vão ter que fazer a implementação
    //de acordo com a idade do paciente
    public abstract void verificar(Paciente paciente);
    //---------------------------------------------------------------------------------



    //---------------------------------------------------------------------------------
    //As faixas de temperatura e saturação de oxigenio, são as mesmas para Adultos ou crianças
    //Logo criei elas aqui, ao invés de criar 2 vezes (uma para adulto, outra para criança)
    //---------------------------------------------------------------------------------

    //Verficar Temperatura -------------------------------------------------------------
    public String verificarTemperatura() {
        String resultado = "";
        resultado += "------------------------------------------------------\n";
        resultado += "[Relatório da Temperatura:]\n";

        if (this.temperatura < 36) {
            resultado += "→ Temperatura está baixa!\n";
            resultado += "- Hipotermia: Aquecer gradualmente, monitorar.\n";
        } else if (this.temperatura > 37.5) {
            resultado += "→ Temperatura está alta!\n";
            resultado += "- Febre: Antitérmico (ex: dipirona, paracetamol), \n investigar infecção.\n";
        } else {
            resultado += "Temperatura está ok!\n";
        }

        resultado += "------------------------------------------------------\n\n";
        return resultado;
    }
    // ---------------------------------------------------------------------------------



    //Verficar Saturacao Oxigenio ------------------------------------------------------
    public String verificarSaturacao() {
        String resultado = "";
        resultado += "------------------------------------------------------\n";
        resultado += "[Relatório da Saturação de Oxigênio:]\n";

        if (this.saturacaoOxigenio < 95) {
            resultado += "→ Saturação de oxigênio está baixa (" + saturacaoOxigenio + "%).\n";
            resultado += "- Pode indicar hipóxia. Considerar oxigenoterapia \n e investigação da causa.\n";
        } else {
            resultado += "→ Saturação de oxigênio está normal (" + saturacaoOxigenio + "%).\n";
        }

        resultado += "------------------------------------------------------\n\n";
        return resultado;
    }
    //---------------------------------------------------------------------------------


}
