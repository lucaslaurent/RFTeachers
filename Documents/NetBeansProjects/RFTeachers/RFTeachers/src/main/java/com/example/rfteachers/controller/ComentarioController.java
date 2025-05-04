package com.example.rfteachers.controller;

import com.example.rfteachers.model.Comentario;
import com.example.rfteachers.model.Jogo;
import com.example.rfteachers.service.ComentarioService;
import com.example.rfteachers.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private JogoService jogoService;
    
    @Autowired
    private ComentarioService comentarioService;
    
    @PostMapping("/gravar/{jogoId}")
    public String adicionarComentario(@PathVariable long jogoId, @ModelAttribute Comentario novoComentario) {
        Jogo jogo = jogoService.buscarPorId(jogoId);
        if (jogo != null) {
            jogo.adicionarComentario(novoComentario);
            jogoService.salvarJogo(jogo);
        }
        return "redirect:/jogo/detalhes/" + jogoId;
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        comentarioService.excluir(id);
        return "redirect:/jogo/lista";
    }    
}
