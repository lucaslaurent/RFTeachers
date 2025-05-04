package com.example.rfteachers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("/")
    public String inicio() {
        return "index"; // templates/index.html
    }

    @GetMapping("/jogo/jogo-cadastro")
    public String cadastroJogo() {
        return "jogo-cadastro"; // templates/jogo-cadastro.html
    }

    @GetMapping("/jogo/jogo-detalhes")
    public String detalhesJogo() {
        return "jogo-detalhes"; // templates/jogo-detalhes.html
    }

    @GetMapping("/jogo/jogo-listagem")
    public String listagemJogos() {
        return "jogo-listagem"; // templates/jogo-listagem.html
    }
}

