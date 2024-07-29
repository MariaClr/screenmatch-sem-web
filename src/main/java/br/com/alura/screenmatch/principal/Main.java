package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.models.DadosEpisodio;
import br.com.alura.screenmatch.models.DadosSerie;
import br.com.alura.screenmatch.models.DadosTemporada;
import br.com.alura.screenmatch.models.Episodio;
import br.com.alura.screenmatch.services.ConsumoApi;
import br.com.alura.screenmatch.services.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO ="https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=438f5d24";
    public void exebiMEnu(){
        System.out.println("Nome da Serie: ");
        var nomeSerie = leitura.nextLine();
        String dados = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ","+") + API_KEY);
        DadosSerie serie = conversor.obterDados(dados, DadosSerie.class);
        System.out.println(serie);

        List<DadosTemporada> temporadas = new ArrayList<>();
		for(int i=1; i <= serie.totalTemporadas(); i++){
			dados = consumoApi.obterDados(ENDERECO+ nomeSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
			temporadas.add(conversor.obterDados(dados, DadosTemporada.class));
		}
		temporadas.forEach(System.out::println);
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<DadosEpisodio> dadosEpisodiosJuntos = temporadas.stream().flatMap(t ->t.episodios().stream()).collect(Collectors.toList());

        System.out.println("Top 5 episodios: /n");
        dadosEpisodiosJuntos.stream().filter(e -> !e.avaliacao().equalsIgnoreCase("n/a")).sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed()).limit(5).forEach(System.out::println);



        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());

        episodios.forEach(e -> System.out.println(e));



        System.out.println("Digite o Trecho Do titulo");
        String trechoTitulo = leitura.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream().filter(e->e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase())).findFirst();
        if(episodioBuscado.isPresent()){
            System.out.println("Episodio Encontrado");
            ;
        }else{
            System.out.println("Episodio não encontrado");
        }


        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("A partir de que ano voce deseja ver os episodios");
        var ano = leitura.nextInt();
        leitura.nextLine();
        LocalDate dataBusca = LocalDate.of(ano, 1 ,1);

         episodios.stream().filter(e -> e.getDataLancamento() !=null && e.getDataLancamento().isAfter(dataBusca)).forEach(e -> System.out.println(
                "Temporada: " + e.getTemporada() +
                        " Episódio: " + e.getTitulo() +
                        " Data lançamento: " + e.getDataLancamento().format(formatador)
        ));

        Map<Integer, Double> avaliacoesTemporada = episodios.stream()
                .filter(e-> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(e -> e.getTemporada(),
                        Collectors.averagingDouble(e -> e.getAvaliacao())));
        System.out.println(avaliacoesTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e-> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
        System.out.println(est);


    }

}
