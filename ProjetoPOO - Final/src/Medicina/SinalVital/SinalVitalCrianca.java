package Medicina.SinalVital;

import Pacientes.Paciente;
import java.io.IOException; //Excecao
import java.nio.file.Files; //Files metodo
import java.nio.file.Paths; //Paths metodo
import java.nio.file.Path; //Path Atributo
import java.nio.file.StandardOpenOption; //Para juntar as strings la

//Esta classe sever para VERIFICAR se o paciente CRIANÇA está bem, de acordo com os parametros de CRIANÇAS

public class SinalVitalCrianca extends SinalVital {

    //Construtores ############################################################################
    public SinalVitalCrianca(int frequenciaCardiaca, int frequenciaRespiratoria, int pressaoSistolica, int pressaoDiastolica, int temperatura, int saturacaoOxigenio) {
        super(frequenciaCardiaca, frequenciaRespiratoria, pressaoSistolica, pressaoDiastolica, temperatura, saturacaoOxigenio);
    }

    public SinalVitalCrianca() {

    }
    //##########################################################################################



    //Métodos obrigatórios, vai verificar se a CRIANCA está ok
    @Override
    public void verificar(Paciente paciente) {


        String conteudo = "\n\n======================================================\n" +
                "          [RELATÓRIO DE SINAIS VITAIS - CRIANÇA]\n" +
                "======================================================\n";

        //Verificar Frequencia Cardiaca ---------------------------------------------------
        conteudo += "------------------------------------------------------\n";
        conteudo += "[Relatório Cardíaco:]\n";
        if (this.frequenciaCardiaca < 70) {
            conteudo += "→ Frequência Cardíaca está BAIXA para uma criança.\n";
            conteudo += "- Bradicardia: Avaliar causas e monitorar.\n";
        } else if (this.frequenciaCardiaca > 120) {
            conteudo += "→ Frequência Cardíaca está ALTA para uma criança.\n";
            conteudo += "- Taquicardia: Avaliar febre, dor, ansiedade \n e desidratação.\n";
        } else {
            conteudo += "→ Frequência Cardíaca está NORMAL.\n";
        }
        conteudo += "------------------------------------------------------\n\n";
        //---------------------------------------------------------------------------------



        //Verificar Frequencia Respiratoria -----------------------------------------------
        conteudo += "------------------------------------------------------\n";
        conteudo += "[Relatório Respiratório:]\n";
        if (this.frequenciaRespiratoria <= 20) {
            conteudo += "→ Frequência Respiratória está BAIXA para uma criança.\n";
            conteudo += "- Bradipneia: Avaliar necessidade de suporte ventilatório.\n";
        } else if (this.frequenciaRespiratoria >= 30) {
            conteudo += "→ Frequência Respiratória está ALTA para uma criança.\n";
            conteudo += "- Taquipneia: Investigar causas como infecção ou asma.\n";
        } else {
            conteudo += "→ Frequência Respiratória está NORMAL.\n";
        }
        conteudo += "------------------------------------------------------\n\n";
        //---------------------------------------------------------------------------------



        //Verificar Temperatura -----------------------------------------------------------------
        conteudo += verificarTemperatura();
        //---------------------------------------------------------------------------------



        //Verificar Pressao ---------------------------------------------------------------------
        conteudo += "------------------------------------------------------\n";
        conteudo += "[Relatório de Pressão Arterial:]\n";
        if (pressaoSistolica <= 80 || pressaoDiastolica <= 50) {
            conteudo += "→ Pressão está BAIXA para uma criança.\n";
            conteudo += "- Hipotensão: Hidratação e suporte.\n";
        } else if (pressaoSistolica >= 110 || pressaoDiastolica >= 70) {
            conteudo += "→ Pressão está ALTA para uma criança.\n";
            conteudo += "- Hipertensão: Monitorar e investigar causas.\n";
        } else {
            conteudo += "→ Pressão está NORMAL para uma criança.\n";
        }
        conteudo += "------------------------------------------------------\n\n";
        //---------------------------------------------------------------------------------



        //Verificar Saturacao -------------------------------------------------------------
        conteudo += verificarSaturacao();
        //---------------------------------------------------------------------------------

        conteudo += "======================================================\n";
        conteudo += "        [FIM DO RELATÓRIO - SINAIS VITAIS]\n";
        conteudo += "======================================================\n\n";

        Path caminho = Paths.get("Clientes/" + paciente.getCpf() + ".txt");

        try {
            Files.writeString(caminho, conteudo, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao salvar Relatorio no arquivo: " + e.getMessage());
        }

        System.out.println(conteudo);
    }
}
