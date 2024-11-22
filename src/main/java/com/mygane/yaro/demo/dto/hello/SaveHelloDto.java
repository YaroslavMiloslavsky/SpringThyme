package com.mygane.yaro.demo.dto.hello;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record SaveHelloDto(
		@NotBlank(message = "Message must not be blank") @Length(min = 1, max = 256, message = "Message must be between 1 and 256") String msg) {

}
