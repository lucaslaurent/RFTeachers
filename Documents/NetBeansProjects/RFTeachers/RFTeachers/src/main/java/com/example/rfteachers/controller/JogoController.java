package com.example.rfteachers.controller;

import com.example.rfteachers.model.Jogo;
import com.example.rfteachers.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jogo") // Luke, agora todas as rotas de jogos seguem esse prefixo
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;

    // Listagem 
    @GetMapping("/listagem")
    public String listarJogos(Model model) {
        List<Jogo> jogos = jogoRepository.findAll();
        model.addAttribute("jogos", jogos);
        return "jogo-listagem";
    }

    // cadastro
    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("jogo", new Jogo());
        return "jogo-cadastro";
    }

    // envio do form do cadastro
    @PostMapping("/cadastro")
    public String cadastrarJogo(@ModelAttribute Jogo jogo) {
        jogoRepository.save(jogo);
        return "redirect:/jogo/listagem";
    }

    // detalhes 
    @GetMapping("/detalhes/{id}")
    public String detalhesJogo(@PathVariable Long id, Model model) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        if (jogo.isPresent()) {
            model.addAttribute("jogo", jogo.get());
            return "detalhes";
        } else {
            return "redirect:/jogo/listagem";
        }
    }
   
    // delete
    @GetMapping("/excluir/{id}")
    public String excluirJogo(@PathVariable Long id) {
        jogoRepository.deleteById(id);
        return "redirect:/jogo/listagem";
    }

    
}
