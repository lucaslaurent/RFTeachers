// arquivo: validacao.js
// este script realiza validação de formulários:
// - cadastro de jogos (nome, descrição, materiais)
// - comentários e notas nos detalhes dos jogos

// função para validar o formulário de cadastro de jogo
function validarFormulario(event) {
    // prevenir o envio padrão do formulário (recarregamento da página)
    event.preventDefault();

    // obteter os valores dos campos de entrada
    let nome = document.getElementById("nome").value.trim();
    let descricao = document.getElementById("descricao").value.trim();
    let materiais = document.getElementById("materiais").value.trim();

    // verificar aqui se algum campo está vazio
    if (nome === "" || descricao === "" || materiais === "") {
        alert("Por favor, preencha todos os campos antes de submeter!");
        return false;
    }

    // exibir uma mensagem de sucesso no próprio site
    let sucessoMessage = document.getElementById("mensagemSucesso");
    sucessoMessage.textContent = "Jogo cadastrado com sucesso!";
    sucessoMessage.style.color = "green";
    sucessoMessage.style.display = "block";

    // ocultar a mensagem após 5 segundos
    setTimeout(function() {
        sucessoMessage.style.display = "none";
    }, 5000);

    return true;
}

// função para validar os comentários e notas dos jogos
function validarComentario() {
    // obter os valores dos campos de entrada
    let comentario = document.getElementById("comentario").value.trim();
    let nota = document.getElementById("nota").value.trim();

    // verificar se algum campo está vazio
    if (comentario === "" || nota === "") {
        alert("Por favor, preencha tanto o comentário quanto a nota!");
        return false;
    }

    // converter a nota para um número inteiro
    nota = parseInt(nota);

    // verificando aqui se a nota está dentro do intervalo permitido (0 a 10)
    if (nota < 0 || nota > 10) {
        alert("A nota deve ser um número entre 0 e 10.");
        return false;
    }

    // e uma mensagem de sucesso após validação
    alert("Comentário enviado com sucesso! Obrigado pela contribuição.");
    return true;
}




