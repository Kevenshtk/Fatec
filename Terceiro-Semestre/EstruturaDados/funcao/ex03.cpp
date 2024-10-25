/*
X 10. Faça uma função que lê e retorna um registro contendo código, descrição, preço e tipo (C-calça, Bblusa e G-gravata).
X 11. Faça uma função que recebe um registro e exibe seus dados.
X 12. Faça uma função que receba um vetor de registro, calcule e retorne o preço médio das calças.
X 13. Faça uma função que receba um vetor de registro e exiba todas as blusas com preço inferior a R$ 50,00.
X 14. Faça uma função que recebe um vetor de registro e retorna o registro com o produto mais caro
*/

#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

# define N 5

struct Registro {
	int cod;
	char desc[30], tipo;
	float preco;
};

Registro leRegistro() {
	Registro p;

	printf("Digite o codigo: ");
	fflush(stdin);
	scanf("%d", &p.cod);
	printf("Digite a descricao: ");
	fflush(stdin);
	scanf(" %[^\n]", p.desc);
	printf("Digite o preco: ");
	fflush(stdin);
	scanf("%f", &p.preco);
	printf("Digite o tipo (C para Calca, B para Blusa, G para Gravata): ");
	fflush(stdin);
	scanf(" %c", &p.tipo);

	printf("\n");
	system("cls");

	return p;
}

void exibeRegistro(Registro p[N], int i) {
	printf("\n\n");
	printf("Codigo do produto: %i",p[i].cod);
	printf("\nDescricao do produto: %s",p[i].desc);
	printf("\nPreco do produto: R$%.2f",p[i].preco);
	printf("\nTipo do produto: %c",p[i].tipo);
}

float precoMedioCalcas(Registro p[N]) {
	float media = 0;
	int cont = 0;

	for(int i=0; i<N; i++) {
		if(p[i].tipo == 'C' || p[i].tipo == 'c') {
			media = media + p[i].preco;
			cont++
		}
	}

	return (float)media / cont;
}

void exibeBlusas(Registro p[N]) {
	float valorMaximo = 0;

	printf("Informe o valor maximo da blusa: ");
	fflush(stdin);
	scanf("%f", &valorMaximo);

	printf("As blusas com preco inferior a R$ %f são:", valorMaximo);
	for(int i=0; i<N; i++) {
		if((p[i].tipo == 'B' || p[i].tipo == 'b') && p[i].preco <= valorMaximo) {
			exibeRegistro(p, i);
		}
	}

}

void produtoMaisCaro(Registro p[N]) {
	float maiorValor = p[0].preco;

	printf("O produto mais caro e:");
	for(int i=0; i<N; i++) {
		if(p[i].preco >= maiorValor) {
			maiorValor = p[i].preco;
		}
	}
	
	for(int i=0; i<N; i++) {
		if(p[i].preco == maiorValor) {
			exibeRegistro(p, i);
		}
	}
}

int main() {
	struct Registro p[N];

	for(int i=0; i<N; i++) {
		p[i] = leRegistro();
	}

	printf("Preco medio das calcas sao R$ %5.2f", precoMedioCalcas(p));
	exibeBlusas(p);
	produtoMaisCaro(p);
}