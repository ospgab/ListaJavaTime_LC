/*
    A partir de uma lista de datas de feriados, calcular e imprimir qual o dia da semana o feriado acontece e se for
    quinta-feira ou terça-feira informar que é "feriado prolongado".

    Imprimir as informações para os anos: anterior, atual e próximo.

    Datas: 07/09, 12/10, 02/11, 15/11, 25/12, 01/01.

        Saida:

    #Ano 2021: #07/09 - Terça feira * feriado prolongado #12/10 - Dia da semana ... #...

    #Ano 2022: #07/09 - Dia da semana ... #12/10 - Dia da semana ...

    #Ano 2023: #07/09 - Dia da semana ... #12/10 - Dia da semana ...

    ** Utilizar API java.time
 */

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Feriados {
    public static void main(String[] args) {
        Locale danish = new Locale("pt", "BR");

        String entrada = "07/09,12/10,02/11,15/11,25/12,01/01";
        String[] entradaSeparada = entrada.split(",");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");

        System.out.println("=========================================");
        for (String data : entradaSeparada) {
            int ano = 2021;
            data = data.trim();
            String[] auxiliar = data.split("/");
            for (int contador = 0; contador < 3; contador++) {
                LocalDate feriado = LocalDate.of(ano, Integer.parseInt(auxiliar[1]), Integer.parseInt(auxiliar[0]));
                System.out.print("Ano " + ano + " " + feriado.format(dtf) + " " + feriado.getDayOfWeek().getDisplayName(TextStyle.FULL, danish));
                if(feriado.getDayOfWeek().getValue() == 2 || feriado.getDayOfWeek().getValue() == 4){
                    System.out.print("  *Feriado prolongado");
                }
                System.out.println();
                ano++;
            }
            System.out.println("=========================================");
        }
    }
}
