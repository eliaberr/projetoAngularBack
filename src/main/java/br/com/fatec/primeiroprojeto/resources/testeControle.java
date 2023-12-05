package br.com.fatec.primeiroprojeto.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testeControle {
    
    @GetMapping("teste")
    public String teste(){
        return "teste";
    }
    
}
