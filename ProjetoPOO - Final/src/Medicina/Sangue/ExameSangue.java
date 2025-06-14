package Medicina.Sangue;

import Pacientes.Paciente;
import java.io.IOException; //Exceção
import java.nio.file.Files; //Files metodo
import java.nio.file.Paths; //Paths metodo
import java.nio.file.Path; //Path Atributo
import java.util.Scanner; //Scanner
import java.util.List; //Listas
import java.nio.file.StandardOpenOption; //Para juntar as strings la


public class ExameSangue {

    //Atributos/Instancias ====================================================================
    private float hemoglobina;
    private float glicose;
    private float colesterol;
    private float leucocitos;

    private final Scanner scan = new Scanner(System.in);
    //=========================================================================================



    //Pegar Sinais pelo arquivo  -------------------------------------------------------------
    public void analisePeloArquivo() {
        Path path = Paths.get("LeitorExames/preset2.txt");
        try {
            List<String> linhas = Files.readAllLines(path);

            if (linhas.size() < 4) {
                throw new RuntimeException("Arquivo incompleto!");
            }

            hemoglobina = Float.parseFloat(linhas.get(0)); //NumberFormatException
            glicose = Float.parseFloat(linhas.get(1));     //transforma string 3.14 em 3.14f (que é um float)
            colesterol = Float.parseFloat(linhas.get(2));  //ParseFloat metodo da classe float
            leucocitos = Float.parseFloat(linhas.get(3));  //Metodo estático

            System.out.println("Exame de sangue carregado com sucesso!\n");

        } catch (IOException | RuntimeException e) {
            System.out.println("Erro ao carregar exame: " + e.getMessage());
        }
    }
    //---------------------------------------------------------------------------------



    //Pegar os Sinais do Paciente  ----------------------------------------------------
    public void DigitarSinaisPacientes() {
        System.out.println("======================================================");
        System.out.println("[EXAME DE SANGUE - ENTRADA MANUAL]");
        System.out.println("Preencha os valores conforme solicitado.\n");

        hemoglobina = lerValor("Hemoglobina (g/dL)", 5, 20);
        glicose = lerValor("Glicose (mg/dL)", 30, 500);
        colesterol = lerValor("Colesterol Total (mg/dL)", 50, 500);
        leucocitos = lerValor("Leucócitos (mil/mm³)", 1000, 20000);
    }



    //Comparar Intervalos  -----------------------------------------------------------
    private float lerValor(String descricao, float minimo, float maximo) {
        float valor;
        do {
            System.out.print("Digite " + descricao + ": ");
            valor = scan.nextFloat();
            if (valor < minimo || valor > maximo) {
                System.out.println("Valor fora do intervalo aceitável. Tente novamente.");
            }
        } while (valor < minimo || valor > maximo);
        return valor;
    }
    //---------------------------------------------------------------------------------




    //Comparar Intervalos  -----------------------------------------------------------
    public void verificar(Paciente paciente) {
        String conteudo = "\n\n======================================================\n";
        conteudo += "            [RELATÓRIO DE EXAME DE SANGUE]\n";
        conteudo += "======================================================\n";



        // Hemoglobina  --------------------------------------------------------------
        conteudo += "------------------------------------------------------\n";
        conteudo += "[Hemoglobina: " + hemoglobina + " g/dL]\n";
        if (hemoglobina < 12) {
            conteudo += "→ Baixa: Pode indicar anemia.\n";
        } else if (hemoglobina > 17) {
            conteudo += "→ Alta: Possível desidratação ou distúrbios hematológicos.\n";
        } else {
            conteudo += "→ Dentro do normal.\n";
        }
        conteudo += "------------------------------------------------------\n\n";
        //----------------------------------------------------------------------------




        // Glicose  --------------------------------------------------------------
        conteudo += "------------------------------------------------------\n";
        conteudo += "[Glicose: " + glicose + " mg/dL]\n";
        if (glicose < 70) {
            conteudo += "→ Baixa: Hipoglicemia. Riscos de tontura e desmaios.\n";
        } else if (glicose > 100) {
            conteudo += "→ Alta: Pode indicar pré-diabetes ou diabetes.\n";
        } else {
            conteudo += "→ Dentro do normal.\n";
        }
        conteudo += "------------------------------------------------------\n\n";
        //----------------------------------------------------------------------------




        // Colesterol   --------------------------------------------------------------
        conteudo += "------------------------------------------------------\n";
        conteudo += "[Colesterol Total: " + colesterol + " mg/dL]\n";
        if (colesterol > 200) {
            conteudo += "→ Elevado: Risco aumentado de doenças cardiovasculares.\n";
        } else {
            conteudo += "→ Dentro do aceitável.\n";
        }
        conteudo += "------------------------------------------------------\n\n";
        //----------------------------------------------------------------------------



        // Leucócitos  --------------------------------------------------------------
        conteudo += "------------------------------------------------------\n";
        conteudo += "[Leucócitos: " + leucocitos + " mil/mm³]\n";
        if (leucocitos < 4000) {
            conteudo += "→ Baixo: Possível imunodeficiência ou infecção viral.\n";
        } else if (leucocitos > 11000) {
            conteudo += "→ Alto: Possível infecção ou inflamação.\n";
        } else {
            conteudo += "→ Dentro do normal.\n";
        }
        conteudo += "------------------------------------------------------\n\n";
        //----------------------------------------------------------------------------



        conteudo += "======================================================\n";
        conteudo += "        [FIM DO RELATÓRIO - EXAME DE SANGUE]\n";
        conteudo += "======================================================\n\n";


        //Salvar no arquivo --------------------------------------------------------------
        Path caminho = Paths.get("Clientes/" + paciente.getCpf() + ".txt");

        try {
            Files.writeString(caminho, conteudo, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao salvar relatório: " + e.getMessage());
        }
        //---------------------------------------------------------------------------------



        System.out.println(conteudo);
    }
}

