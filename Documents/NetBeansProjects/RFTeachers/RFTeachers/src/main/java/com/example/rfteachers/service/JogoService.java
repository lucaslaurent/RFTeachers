package com.example.rfteachers.service;

import com.example.rfteachers.model.Comentario;
import com.example.rfteachers.model.Jogo;
import com.example.rfteachers.repository.JogoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    // salva ou atualiza um jogo
    public Jogo salvarJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    // lista todos os jogos
    public List<Jogo> listarJogos() {
        return jogoRepository.findAll();
    }

    // busca um jogo por id
    public Jogo buscarPorId(Long id) {
        return jogoRepository.findById(id).orElse(null);  
    }

    // exclui  pelo id
    public void excluirJogo(Long id) {
        jogoRepository.deleteById(id);
    }

    
    public void adicionarComentarioAoJogo(Long jogoId, Comentario comentario) {
        Jogo jogo = buscarPorId(jogoId);  
        if (jogo != null) {
            jogo.adicionarComentario(comentario);  // método para adicionar o comentário ao jogo
            salvarJogo(jogo);  
        }
    }
}





