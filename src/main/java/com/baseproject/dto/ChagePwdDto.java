package com.baseproject.dto;

import javax.validation.constraints.NotBlank;

import com.baseproject.validator.ConfirmPassword;
import com.baseproject.validator.ChangePwd;
import com.baseproject.validator.ValidStrenghtPassword;

import lombok.Data;

@Data
@ChangePwd
public class ChagePwdDto {

	private String uuid;

	@ConfirmPassword
	@NotBlank
	private String oldPassword;

	@NotBlank
	@ValidStrenghtPassword
	private String newPassword;

	@NotBlank
	private String newPasswordConfirm;

}
