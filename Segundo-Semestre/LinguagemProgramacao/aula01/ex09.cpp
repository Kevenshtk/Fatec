#include<stdio.h>
#include<stdlib.h>

int main(){
	char nomeP[2][10];
	float total, totalDesc, preco[2], desc = 0.20;
	
	for(int cont = 1; cont <= 2; cont++){
		printf("Informe o nome do produto: ");
		fflush(stdin);
		scanf("%s", nomeP[cont]);
		printf("\nInforme o preco do produto: $");
		scanf("%f", &preco[cont]);
		
		system("cls");
	}
	
	for(int i = 1; i <= 2; i++){
		total = total + preco[i];
		totalDesc = total - (preco[i] - (preco[i] * desc)); 
		printf("%s ,preco $%.2f\n", nomeP[i], preco[i]);
	}
	
	printf("\nO total a pagar e $%.2f com o desconto fica $%.2f\n", total, totalDesc);
	
	system("pause");
	return 0;
}
