package com.sdnadigital.consultaCnpj;

import com.sdnadigital.consultaCnpj.utils.Util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ConsultaCnpjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaCnpjApplication.class, args);
	}

	@GetMapping("/consultaCnpj")
	public String consultarCnpj(@RequestParam String cnpj) {
//TODO Adicionar resposta em json se erro
		if (Util.isCNPJ(cnpj)) {
			cnpj = Util.cnpjFormater(cnpj);
			// Faz a chamada para a API externa usando o CNPJ fornecido
			String apiUrl = "https://api-publica.speedio.com.br/buscarcnpj?cnpj=" + cnpj;
			RestTemplate restTemplate = new RestTemplate();
			String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
			return jsonResponse;
		}
		return "CNPJ inválido";
	}

	@GetMapping("/")
	public String status() {
		return "Serviço ligado!";
	}


}
