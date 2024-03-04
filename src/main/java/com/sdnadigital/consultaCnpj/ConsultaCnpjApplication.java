package com.sdnadigital.consultaCnpj;

import com.sdnadigital.consultaCnpj.utils.Util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsultaCnpjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaCnpjApplication.class, args);
	}

}
