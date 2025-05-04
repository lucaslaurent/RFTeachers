package com.example.rfteachers.service;

import com.example.rfteachers.model.Comentario;
import com.example.rfteachers.repository.ComentarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    public List<Comentario> listarPorJogo(int jogoId) {
        return comentarioRepository.findByJogoId(jogoId);
    }
    
    public Comentario salvar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }
    
    public void excluir(int id) {
        comentarioRepository.deleteById(id);
    }
    
    public Comentario buscarPorId(int id) {
        return comentarioRepository.findById(id).orElse(null);
    }
}
