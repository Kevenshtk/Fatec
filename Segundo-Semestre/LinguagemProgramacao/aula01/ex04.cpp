#include<stdio.h>
#include<stdlib.h>

int main(){
	char nomeP[3][10];
	float total, preco[3], desc[3];
	
	for(int cont = 1; cont <= 3; cont++){
		printf("Informe o nome do produto: ");
		fflush(stdin);
		scanf("%s", nomeP[cont]);
		printf("\nInforme o preco do produto: $");
		scanf("%f", &preco[cont]);
		printf("\nInforme o percentual do desconto: ");
		scanf("%f", &desc[cont]);
		
		desc[cont] /= 100;
		
		system("cls");
	}
	
	for(int i = 1; i <= 3; i++){
		total = total + (preco[i] - (preco[i] * desc[i])); 
		printf("\n%s ,preco $%.2f, desconto %.0f o/o", nomeP[i], preco[i], desc[i]*100);
	}
	
	printf("\nO total a pagar e $%.2f", total);
	
	system("pause");
	return 0;
}
