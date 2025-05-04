package com.example.rfteachers.controller;

import com.example.rfteachers.model.Comentario;
import com.example.rfteachers.service.ComentarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comentario")
@CrossOrigin(origins= "*")
public class ComentarioRestController {
    @Autowired
    private ComentarioService comentarioService;
    
    @GetMapping("/jogo/{jogoId}")
    public List<Comentario> listarTodos(@PathVariable int jogoId) {
        return comentarioService.listarPorJogo(jogoId);
    }
    
    @GetMapping("/{id}")
    public Comentario buscarPorId(@PathVariable int id) {
        return comentarioService.buscarPorId(id);
    }
    
    @PostMapping
    public Comentario criarComentario(@RequestBody Comentario comentario) {
        return comentarioService.salvar(comentario);
    }
    
    @PutMapping("/{id}")
    public Comentario atualizarComentario(@PathVariable int id, @RequestBody Comentario comentarioAtualizado) {
        return comentarioService.salvar(comentarioAtualizado);
    }
    
    @DeleteMapping("/{id}")
    public void deletarComentario(@PathVariable int id) {
        comentarioService.excluir(id);
    }
}
