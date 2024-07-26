package br.com.alura.screenmatch;

import br.com.alura.screenmatch.models.DadosSerie;
import br.com.alura.screenmatch.services.ConsumoApi;
import br.com.alura.screenmatch.services.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=lost&apikey=438f5d24");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie lost = conversor.obterDados(json, DadosSerie.class);
		System.out.println(lost);
	}
}
