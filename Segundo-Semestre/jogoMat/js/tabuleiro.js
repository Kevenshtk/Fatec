import {perguntasInicio, perguntasPonte, perguntasFloresta, perguntasDeserto, perguntasVale, 
perguntasVulcao, perguntasLabirinto, perguntasCastelo, perguntasFinal} from "./perguntas.js";

document.getElementById('jogarDado').addEventListener('click', rollDado);

let playerAtual = 1;
let playerPositions = { 1: 0, 2: 0 };
let perguntas;
let boardAtual = 'inicio';

const playerColors = {
    1: 'blue',
    2: 'red'
};

function rollDado() {
    let diceResult;
    switch (boardAtual) {
        case 'inicio':
            diceResult = Math.floor(Math.random() * 3) + 1;
            break;
        case 'ponte':
            diceResult = Math.floor(Math.random() * 4) + 1;
            break;
        case 'floresta':
        case 'vale':
        case 'vulcao':
            diceResult = Math.floor(Math.random() * 6) + 1;
            break;
        case 'labirinto':
            diceResult = Math.floor(Math.random() * 2) + 1;
            break;
        case 'deserto':
            diceResult = Math.floor(Math.random() * 5) + 1;
            break;
        case 'final':
        case 'fim':
            diceResult = Math.floor(Math.random() * 1) + 1;
            break;
    }

    const diceImg = document.getElementById('dadoImg');
    diceImg.src = `img/imgDado/dado-${diceResult}.png`;

    const color = playerAtual === 1 ? 'blue' : 'red';
    movePlayer(color, diceResult);
}

function movePlayer(color, passos) {
    const boards = document.querySelectorAll('.board');
    const previousPosition = playerPositions[playerAtual];
    limparCell(boards, previousPosition, color);

    let newPosition = previousPosition + passos;
    const lastCellIndex = 44;
    newPosition = Math.min(lastCellIndex, newPosition);
    newPosition = Math.max(0, newPosition);

    playerPositions[playerAtual] = newPosition;

    boards.forEach(board => {
        const cellId = `#cell-${newPosition}`;
        const cell = board.querySelector(cellId);

        if (cell) {
            if (cell.style.backgroundColor !== '') {
                cell.style.border = `2px solid ${color}`;
            } else {
                cell.style.backgroundColor = color;
                cell.style.border = '';
            }
        }
    });

    getBoardAtual(newPosition);
    exibirCard(color);
}

function getBoardAtual(position) {
    if (position >= 0 && position <= 3) {
        boardAtual = 'inicio';
    } else if (position >= 4 && position <= 7) {
        boardAtual = 'ponte';
    } else if (position >= 8 && position <= 13) {
        boardAtual = 'floresta';
    } else if (position >= 14 && position <= 18) {
        boardAtual = 'deserto';
    } else if (position >= 19 && position <= 27) {
        boardAtual = 'vale';
    } else if (position >= 28 && position <= 33) {
        boardAtual = 'vulcao';
    } else if (position >= 34 && position <= 41) {
        boardAtual = 'labirinto';
    } else if (position >= 34 && position <= 42){
        boardAtual = 'final';
    } else {
        boardAtual = 'fim';
    }
}

function limparCell(boards, position, playerColor) {
    boards.forEach(board => {
        const cell = board.querySelector(`#cell-${position}`);
        if (cell) {
            if (cell.style.backgroundColor === playerColor) {
                cell.style.backgroundColor = '';
            }
        }
    });
}

function exibirCard(color) {
    const messageDiv = document.getElementById('gameCard');
    messageDiv.style.display = 'block';

    switch (boardAtual) {
        case 'inicio':
            perguntas = perguntasInicio;
            break;
        case 'ponte':
            perguntas = perguntasPonte;
            break;
        case 'floresta':
            perguntas = perguntasFloresta;
            break;
        case 'deserto':
            perguntas = perguntasDeserto;
            break;
        case 'vale':
            perguntas = perguntasVale;
            break;
        case 'vulcao':
            perguntas = perguntasVulcao;
            break;
        case 'labirinto':
            perguntas = perguntasLabirinto;
            break;
        case 'final':
            perguntas = perguntasCastelo;
            break;
        case 'fim':
            perguntas = perguntasFinal;
            break;
    }

    const randomIndex = Math.floor(Math.random() * perguntas.length);
    const { story, question, options } = perguntas[randomIndex];

    document.getElementById('story').textContent = story;
    document.getElementById('question').textContent = question;

    const optionsDiv = document.getElementById('options');
    optionsDiv.innerHTML = '';

    options.forEach((option, index) => {
        const label = document.createElement('label');
        const radioButton = document.createElement('input');
        radioButton.type = 'radio';
        radioButton.name = 'resposta';
        radioButton.value = option;
        radioButton.id = 'option-' + index;

        const span = document.createElement('span');
        span.textContent = option;

        label.appendChild(radioButton);
        label.appendChild(span);

        optionsDiv.appendChild(label);
    });

    const responderButton = document.createElement('button');
    responderButton.textContent = 'Responder';
    responderButton.addEventListener('click', () => checkPergunta(color));

    optionsDiv.appendChild(responderButton);
}

function checkPergunta(color) {
    const { correctAnswer } = perguntas.find((pergunta) => pergunta.question === document.getElementById('question').textContent);
    let newPosition = playerPositions[playerAtual];
    const selectedOption = document.querySelector('input[name="resposta"]:checked');
    
    if (selectedOption) {
        const resposta = selectedOption.value;

        if (resposta === correctAnswer) {
            if(boardAtual === 'fim'){
                const CardVitoria = document.querySelector('.cardVitoria');
                CardVitoria.classList.toggle('active');

            } else {
                alert('Resposta correta! Você avança um passo.');
                movePlayer(color, 1);
                newPosition += 1;
                playerAtual = playerAtual === 1 ? 2 : 1;
            }

        } else {
            if(boardAtual === 'fim'){
                alert('Resposta incorreta! Você volta um tabuleiro.');
                movePlayer(color, -4);
                newPosition -= 4;
                playerAtual = playerAtual === 1 ? 2 : 1;

            } else {
                alert('Resposta incorreta! Você volta um passo.');
                movePlayer(color, -1);
                newPosition -= 1;
                playerAtual = playerAtual === 1 ? 2 : 1;
            }
        }

        const gameCard = document.getElementById('gameCard');
        gameCard.style.display = 'none';
    } else {
        alert('Selecione uma resposta.');
    }
}