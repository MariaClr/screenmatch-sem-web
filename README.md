
---

# Series API Consumer

**Status do Projeto:** ✔️ Concluído

## Tópicos

- [Descrição do Projeto](#descrição-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Pré-requisitos](#pré-requisitos)
- [Como Rodar a Aplicação](#como-rodar-a-aplicação)
- [Casos de Uso](#casos-de-uso)
- [JSON](#json)
- [Iniciando/Configurando Banco de Dados](#iniciando-configurando-banco-de-dados)
- [Linguagens, Dependências e libs Utilizadas](#linguagens-dependencias-e-libs-utilizadas)
- [Resolvendo Problemas](#resolvendo-problemas)
- [Tarefas em Aberto](#tarefas-em-aberto)
- [Desenvolvedores/Contribuintes](#desenvolvedorescontribuintes)

## Descrição do Projeto

O projeto **Series API Consumer** utiliza a API gratuita do OMDb para fornecer informações sobre séries de TV. A aplicação retorna detalhes como temporadas, episódios de cada temporada e avaliações. Além disso, permite ao usuário filtrar episódios pelo nome caso deseje. O projeto foi desenvolvido utilizando recursos básicos do Spring, Stream e Jackson para manipulação e processamento dos dados.

## Funcionalidades

✔️ Consulta de informações sobre temporadas

✔️ Listagem de episódios de cada temporada

✔️ Exibição de avaliações das séries

✔️ Filtro de episódios pelo nome

## Pré-requisitos

⚠️ Java JDK 11 ou superior

⚠️ Maven 3.8 ou superior

⚠️ Biblioteca Jackson para processamento de JSON

## Como Rodar a Aplicação ▶️

No terminal, clone o projeto:

```bash
git clone https://github.com/MariaClr/screen-match-alura.git
cd screen-match-alura
mvn spring-boot:run
```

A aplicação será iniciada e você poderá interagir com o menu para consultar informações sobre séries.

## Casos de Uso

- **Consulta de Séries**: Utilize o menu para buscar informações sobre temporadas, episódios e avaliações de séries. Filtre episódios pelo nome para uma pesquisa mais precisa.

## JSON 💾

Exemplo de resposta da API:

```json
{
  "series": [
    {
      "title": "Serie Exemplo",
      "seasons": [
        {
          "seasonNumber": 1,
          "episodes": [
            {
              "episodeNumber": 1,
              "title": "Episódio Exemplo",
              "rating": 8.5
            }
          ]
        }
      ]
    }
  ]
}
```

## Iniciando/Configurando Banco de Dados

Não é necessário configurar um banco de dados para este projeto.

## Linguagens, Dependências e libs Utilizadas 📚

- Java
- Spring Boot
- Maven
- Jackson


## Tarefas em Aberto

📝 Adicionar suporte a múltiplas temporadas e episódios

📝 Melhorar a interface do menu para uma navegação mais intuitiva

## Desenvolvedores/Contribuintes :robot:

- [Maria Clara](https://github.com/MariaClr)

---

