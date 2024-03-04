package com.sdnadigital.consultaCnpj;

import com.sdnadigital.consultaCnpj.utils.Util;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsultaCnpjController {

    @RequestMapping(value = "/consultaCnpj")
    @GetMapping
    public String consultarCnpj(@RequestParam String cnpj) {
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

    @GetMapping
    public String status() {
        System.out.println("Teste do live reloading!");
        return "Serviço ligado!";
    }
}
