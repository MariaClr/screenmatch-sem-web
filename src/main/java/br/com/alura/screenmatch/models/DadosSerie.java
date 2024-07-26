package br.com.alura.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//jsonalias (pode usr o @JsonProperty) tmb é para dizer a referencia que vamos pegar e so funciona por conta da dependencia jackson e estamos usando ela e nao o Gson do google
//na do gson google usariamos o serialize name
@JsonIgnoreProperties(ignoreUnknown = true)
//ignorar oq nao foi pedido oq nao encotnrar
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao ) {
}
