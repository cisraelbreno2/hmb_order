package br.com.hmb_client.dto;

import lombok.Data;

@Data
public class StateDto {

    private String nome;
    private String sigla;
    private String[] cidades;
}
