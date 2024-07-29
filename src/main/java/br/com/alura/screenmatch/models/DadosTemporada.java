package br.com.alura.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(@JsonAlias("Season") Integer numero,
//                             o jackson ja entende que o episodios é uma record e ja converte sem precisar de mais codigos
                             @JsonAlias("Episodes") List<DadosEpisodio> episodios) {
}
