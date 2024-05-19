function escolhaJodador1() {
    if (personagensSelecionados.jogador1 == null) {
        const personagens = document.querySelectorAll('.personagem');

        personagens.forEach((personagem) => {

            personagem.addEventListener('mouseenter', () => {

                const idSelecionado = personagem.attributes.id.value;

                const personagemSelecionado = document.querySelector('.selecionado');
                personagemSelecionado.classList.remove('selecionado');

                personagem.classList.add('selecionado');

                const imagemJogador1 = document.getElementById('personagem-jogador-1');
                imagemJogador1.src = `img/imgPersona/${idSelecionado}.png`;

                const nomejogador1 = document.getElementById('nome-jogador-1');
                const nomeSelecionado = personagem.getAttribute('data-name');

                nomejogador1.innerHTML = nomeSelecionado;

            })
        })
    }
}

function escolhaJodador2() {
    if (personagensSelecionados.jogador1 != null) {
        const personagens = document.querySelectorAll('.personagem-2');

        personagens.forEach((personagem) => {

            personagem.addEventListener('mouseenter', () => {

                const idSelecionado = personagem.attributes.id.value;

                const personagemSelecionado = document.querySelector('.jogador-2-selecionado');
                personagemSelecionado.classList.remove('jogador-2-selecionado');

                personagem.classList.add('jogador-2-selecionado');

                const imagemJogador2 = document.getElementById('personagem-jogador-2');
                imagemJogador2.src = `img/imgPersona/${idSelecionado}.png`;

                const nomejogador2 = document.getElementById('nome-jogador-2');
                const nomeSelecionado = personagem.getAttribute('data-name');

                nomejogador2.innerHTML = nomeSelecionado;

            })
        })
    }

}

let personagensSelecionados = {
    jogador1: null,
    jogador2: null
};

function escolherPersonagem(jogador, personagem) {
    personagensSelecionados[jogador] = personagem;
    alert(jogador + " " + personagem)
    document.getElementById(jogador + "Selecionado").innerText = "Selecionado";
}

function iniciarJogo() {
    if (personagensSelecionados.jogador1 === null || personagensSelecionados.jogador2 === null) {
        alert("Cada jogador deve escolher um personagem!");
        return;
    } else {
        alert("Bora jogar");
        window.location.href = 'tabuleiro.html';
    }
}