package com.baseproject.dto;

import java.util.List;

import com.baseproject.model.Parametro;

import lombok.Data;

@Data
public class SessionDto {
	private String nomeUser;
	private Long idUser;
	private List<Parametro> parametros;
}
