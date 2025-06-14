package Medicina.SinalVital;

import Pacientes.Paciente;
import java.io.IOException; //Excecao
import java.nio.file.Files; //Files metodo
import java.nio.file.Paths; //Paths metodo
import java.nio.file.Path; //Path Atributo
import java.nio.file.StandardOpenOption; //Para juntar as strings la


// Esta classe serve para VERIFICAR se o paciente ADULTO está bem, de acordo com os parâmetros de ADULTOS

public class SinalVitalAdulto extends SinalVital {

    // Construtores ######################################################################
    public SinalVitalAdulto(int frequenciaCardiaca, int frequenciaRespiratoria, int pressaoSistolica,
                            int pressaoDiastolica, int temperatura, int saturacaoOxigenio) {
        super(frequenciaCardiaca, frequenciaRespiratoria, pressaoSistolica,
                pressaoDiastolica, temperatura, saturacaoOxigenio);
    }

    public SinalVitalAdulto() {
        // Construtor vazio, caso necessário
    }

    // Método obrigatório: verifica se o ADULTO está com sinais vitais normais
    @Override
    public void verificar(Paciente paciente) {

        String conteudo = "\n\n======================================================\n";
        conteudo += "           [RELATÓRIO DE SINAIS VITAIS - ADULTO]\n";
        conteudo += "======================================================\n";

        // Frequência Cardíaca ----------------------------------------------------------
        conteudo += "------------------------------------------------------\n";
        conteudo += "[Relatório Cardíaco:]\n";
        if (this.frequenciaCardiaca <= 60) {
            conteudo += "→ Frequência cardíaca está BAIXA para um adulto.\n";
            conteudo += "- Bradicardia: Avaliar uso de marcapasso,\n observação se assintomático.\n";
        } else if (this.frequenciaCardiaca >= 100) {
            conteudo += "→ Frequência cardíaca está ALTA para um adulto.\n";
            conteudo += "- Taquicardia: Avaliar causas (ansiedade, febre, \n desidratação). Considerar betabloqueadores.\n";
        } else {
            conteudo += "→ Frequência cardíaca está NORMAL.\n";
        }
        conteudo += "------------------------------------------------------\n\n";
        //---------------------------------------------------------------------------------



        // Frequência Respiratória -------------------------------------------------------
        conteudo += "------------------------------------------------------\n";
        conteudo += "[Relatório Respiratório:]\n";
        if (this.frequenciaRespiratoria <= 12) {
            conteudo += "→ Frequência respiratória está BAIXA para um adulto.\n";
            conteudo += "- Bradipneia: Suporte ventilatório pode ser \n necessário.\n";
        } else if (this.frequenciaRespiratoria >= 20) {
            conteudo += "→ Frequência respiratória está ALTA para um adulto.\n";
            conteudo += "- Taquipneia: Investigar hipóxia, dor, acidose; \n oxigenoterapia pode ser indicada.\n";
        } else {
            conteudo += "→ Frequência respiratória está NORMAL.\n";
        }
        conteudo += "------------------------------------------------------\n\n";
        //---------------------------------------------------------------------------------



        // Temperatura -------------------------------------------------------------------
        conteudo += verificarTemperatura();
        //---------------------------------------------------------------------------------



        // Pressão Arterial --------------------------------------------------------------
        conteudo += "------------------------------------------------------\n";
        conteudo += "[Relatório de Pressão Arterial:]\n";
        if (pressaoSistolica <= 90 || pressaoDiastolica <= 60) {
            conteudo += "→ Pressão arterial está BAIXA para um adulto.\n";
            conteudo += "- Hipotensão: Hidratação venosa, vasopressores se necessário.\n";
        } else if (pressaoSistolica >= 120 || pressaoDiastolica >= 80) {
            conteudo += "→ Pressão arterial está ALTA para um adulto.\n";
            conteudo += "- Hipertensão: Repouso, monitoramento; considerar \n uso de anti-hipertensivo (ex: captopril).\n";
        } else {
            conteudo += "→ Pressão arterial está NORMAL.\n";
        }
        conteudo += "------------------------------------------------------\n\n";
        //---------------------------------------------------------------------------------



        // Saturação de Oxigênio ---------------------------------------------------------
        conteudo += verificarSaturacao();
        //---------------------------------------------------------------------------------



        conteudo += "======================================================\n";
        conteudo += "         [FIM DO RELATÓRIO - SINAIS VITAIS]\n";
        conteudo += "======================================================\n\n";

        Path caminho = Paths.get("Clientes/" + paciente.getCpf() + ".txt");

        try{
            Files.writeString(caminho,conteudo,StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao salvar Relatorio no arquivo: " + e.getMessage());
        }

        System.out.println(conteudo);
    }
}
