function iniciarJogo() {
    if (personagensSelecionados.jogador1 === null || personagensSelecionados.jogador2 === null) {
        alert("Cada jogador deve escolher um personagem!");
        return;
    } else {
        alert("Bora jogar");
    }

    // adicionar o código para iniciar o jogo com os personagens escolhidos

}


const cells = document.querySelectorAll('.cell');
const story = document.getElementById('story');

let currentCell = 1;

// Mapeamento de células e suas histórias correspondentes
const cellStories = {
  1: "Você está em uma floresta escura. O que você faz?",
  2: "Você encontrou uma clareira com uma cabana. O que você faz?",
  3: "Você entrou na cabana e encontrou um baú. O que você faz?",
  4: "Você abriu o baú e encontrou um tesouro! Parabéns!"
};

// Adiciona ouvintes de eventos às células
cells.forEach(cell => {
  cell.addEventListener('click', () => {
    const nextCell = parseInt(cell.id.split('-')[1]);
    if (nextCell === currentCell + 1 || nextCell === currentCell + 4) {
      currentCell = nextCell;
      updateStory();
    } else {
      alert("Escolha inválida!");
    }
  });
});

// Função para atualizar a história na tela
function updateStory() {
  story.textContent = cellStories[currentCell];
}

// Inicialização da história na primeira célula
updateStory();
