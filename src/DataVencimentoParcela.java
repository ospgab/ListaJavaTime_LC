/*
    Um sistema ecommerce precisa criar uma nova funcionalidade de parcelamento das compras em até 12x sem juros.

    A partir da data atual e a quantidade de parcelas escolhidas, imprimir o valor e a data de vencimento da
    parcela.

    A data de vencimento não pode ser no fim de semana. Se cair no fim de semana ajustar a data para a
    proxima segunda-feira.

    ** utilizar a API java.time

        Saida: Numero da parcela - Data de vencimento - Valor parcela
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DataVencimentoParcela {
    public static void main(String[] args) {

        BigDecimal valorTotal = BigDecimal.valueOf(4899.90);
        int quantidadeParcelas = 12;
        BigDecimal valorParcela = valorTotal.divide(BigDecimal.valueOf(quantidadeParcelas), RoundingMode.HALF_DOWN);

        LocalDate base = LocalDate.now();
        BigDecimal acumulador = new BigDecimal(0);
        for(int contador = 0; contador < quantidadeParcelas; contador++) {

            LocalDate nova = base.plusMonths(contador + 1);

            if (nova.getDayOfWeek().getValue() == 6 || nova.getDayOfWeek().getValue() == 7) {
                System.out.println("Parcela " + (contador + 1) + " valor " + valorParcela + "  vencimento " + nova + " " + nova.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).getDayOfWeek());
            } else {
                System.out.println("Parcela " + (contador + 1) + " valor " + valorParcela + "  vencimento " + base.plusMonths(contador + 1) + " " + base.plusMonths(contador+1).getDayOfWeek());
            }
            //System.out.println(acumulador);
        }

    }
}
