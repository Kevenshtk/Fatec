#include<stdio.h>
#include<stdlib.h>

int main(){
	char nomeV[20];
	float preco = 0;
	
	printf("Informe o nome do veiculo: ");
	scanf("%s", nomeV);
	printf("Informe o preco de fabricacao do veiculo: $");
	scanf("%f", &preco);
	
	float valorImp = preco * 0.45;
	float valorComi = preco * 0.28;
	float total = preco + valorImp + valorComi;
	
	printf("Nome: %s", nomeV);
	printf("\nPreço de fabricacao: $%.2f", preco);
	printf("\nValor do imposto: $%.2f", valorImp);
	printf("\nTotal da comissao: $%.2f", valorComi);
	printf("\nPreco final: $%.2f", total);
	
	system("pause");
	return 0;
}
