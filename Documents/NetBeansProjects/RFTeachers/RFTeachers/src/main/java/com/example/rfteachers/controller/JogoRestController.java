package com.example.rfteachers.controller;

import com.example.rfteachers.model.Jogo;
import com.example.rfteachers.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
@CrossOrigin(origins = "*")
public class JogoRestController {

    @Autowired
    private JogoService jogoService;

    // codigo para listar todos os jogos
    @GetMapping
    public List<Jogo> listarJogos() {
        return jogoService.listarJogos();  
    }

    // Cadastra um novo jogo
    @PostMapping
    public Jogo cadastrarJogo(@RequestBody Jogo jogo) {
        return jogoService.salvarJogo(jogo);  
    }

    // detalhes de um jogo específico aqui
    @GetMapping("/{id}")
    public Jogo detalhesJogo(@PathVariable Long id) {
        return jogoService.buscarPorId(id); 
    }

    // exclui pelo id
    @DeleteMapping("/{id}")
    public void excluirJogo(@PathVariable Long id) {
        jogoService.excluirJogo(id);  
    }
}

