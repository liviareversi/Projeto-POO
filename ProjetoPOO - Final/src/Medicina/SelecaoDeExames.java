package Medicina;

import java.util.Scanner; //Para colocar o Scanner

//Esta classe serve para o paciente ESCOLHER o exame que ele quer fazer (na main), feito aqui para não poluir a main

public class SelecaoDeExames {

    //Atributos ===============================================================================
    int entradaExame = 0;
    //=========================================================================================



    //Instancias ===============================================================================
    Scanner sc = new Scanner(System.in);
    Boolean[] exames = new Boolean[2];
    //=========================================================================================



    //Verifica qual exame e salva em um array de booleanos
    public Boolean[] selecaoExame() {

        System.out.println("======================================================");
        System.out.println("Qual exame deseja fazer? [(1) - Sim / (0) - Não]");
        System.out.println("======================================================");



        //Deseja fazer exame de sangue?--------------------------------------------
        System.out.print("[Exame de Sangue:] ");
        do
        {
            entradaExame = sc.nextInt();
        }
        while (entradaExame != 1 && entradaExame != 0);
        exames[0] = (entradaExame == 1);  // Armazena true se 1, false se 0
        //--------------------------------------------------------------------------



        //Deseja fazer exame de Sinais Vitais?---------------------------------------
        System.out.print("[Exame de Sinais Vitais:] ");
        do
        {
            entradaExame = sc.nextInt();
        }
        while (entradaExame != 1 && entradaExame != 0);
        exames[1] = (entradaExame == 1); // armazena true se 1, false se 0
        //--------------------------------------------------------------------------

            return exames; //Retorna um array booleano de exames
    }
    //------------------------------------------------------------------------------
}
