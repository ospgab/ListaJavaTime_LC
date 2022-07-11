/*
    A partir de uma lista de pessoas (nome e data de nascimento no formarto yy-mm-dd), calcular a idade de cada pessoa e
    também quem é o mais novo e o mais velho.

    Imprimir a lista de pessoas no formato:

    Nome - data de nascimento (dd/mm/yyyy) - dia da semana do nascimento - idade.

    ** Utilizar a API java.time

    Exemplo:

        Pessoas: [Roberto:21-07-08,Ricardo:20-07-08]
        Saida:
        Roberto - 08/07/2021 - Quinta Feira - 1 ano
        Ricardo - 08/07/2020 - Quarta Feira - 2 anos
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.DelayQueue;

public class CalculoIdade {
    public static void main(String[] args) {


        String entrada = "[Roberto:21-07-08,Ricardo:20-07-08]";
        entrada = entrada.replace("[","");
        entrada = entrada.replace("]", "");

        String[] entradaIntermediaria = entrada.split(",");

        ArrayList<Pessoa> entradaSeparada = new ArrayList<>();


        for(String pessoa : entradaIntermediaria){
            String[] pessoaSeparado = pessoa.split(":");
            Pessoa pessoa1 = new Pessoa();
            pessoa1.setNome(pessoaSeparado[0]);
            pessoa1.setDataNascimento(pessoaSeparado[1]);
            entradaSeparada.add(pessoa1);

        }
        /*
        entradaSeparada.get(0).getDiaDaSemana();
        entradaSeparada.get(1).getDiaDaSemana();
        System.out.println(entradaSeparada.get(0).getIdade());
        System.out.println(entradaSeparada.get(1).getIdade());

         */
        for(Pessoa pessoa : entradaSeparada){
            pessoa.getInfo();
        }
    }
}

class Pessoa{
    public enum DiasDaSemana{
        SEGUNDA(1, "Segunda"), TERCA(2,"Terça"), QUARTA(3, "Quarta"), QUINTA(4, "Quinta"),
        SEXTA(5, "Sexta"), SABADO(6, "Sábado"), DOMINGO(7, "Domingo");

        private final int valor;
        private final String descricao;

        DiasDaSemana(int valor, String descricao) {
            this.valor = valor;
            this.descricao = descricao;
        }

        public int getValor() {
            return valor;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    private String nome;
    private LocalDate dataNascimento;
    DiasDaSemana diaDaSemana;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento.toString();
    }

    public void setDataNascimento(String dataNascimento) {
        LocalDate data;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd");
        data = LocalDate.parse(dataNascimento, dtf);
        this.dataNascimento = data;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    public String getDiaDaSemana(){
        int dia = this.dataNascimento.getDayOfWeek().getValue();
        switch (dia){
            case 1:
                return DiasDaSemana.SEGUNDA.descricao;
            case 2:
                return DiasDaSemana.TERCA.descricao;
            case 3:
                return DiasDaSemana.QUARTA.descricao;
            case 4:
                return DiasDaSemana.QUINTA.descricao;
            case 5:
                return DiasDaSemana.SEXTA.descricao;
            case 6:
                return DiasDaSemana.SABADO.descricao;
            case 7:
                return DiasDaSemana.DOMINGO.descricao;
        }
        return null;
    }

    public long getIdade(){
        return this.dataNascimento.until(LocalDate.now(), ChronoUnit.YEARS);
    }


    public void getInfo(){
        System.out.println(this.getNome() + " - " + this.getDataNascimento() + " - " + getDiaDaSemana() + " - " + this.getIdade() + " anos");
    }

}
