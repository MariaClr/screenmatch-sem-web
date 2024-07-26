package br.com.alura.screenmatch.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConverteDados {
//    T para generico e foi passado dois parametos pq é justamente para converter de uma string json para um determinado tipo
    <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException;
}
