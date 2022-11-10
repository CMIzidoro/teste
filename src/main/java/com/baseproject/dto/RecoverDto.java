package com.baseproject.dto;

import javax.validation.constraints.NotBlank;

import com.baseproject.validator.ValidStrenghtPassword;

import lombok.Data;

@Data
public class RecoverDto {

	private String uuid;

	@NotBlank
	@ValidStrenghtPassword
	private String password;

	@NotBlank
	private String passwordConfirm;

}
