#include<stdio.h>
#include<stdlib.h>

int main(){
	char nome[10];
	float diaria, valorD, taxa, total;
	
	printf("Informe seu nome: ");
	fflush(stdin);
	scanf("%s", nome);
	printf("Informe o numero de diarias: ");
	scanf("%f", &diaria);
	
	valorD = diaria * 60;
	
	if(diaria > 15){
		taxa = diaria * 5.5;
		
	} else if(diaria == 15){
		taxa = diaria * 6;
		
	} else {
		taxa = diaria * 8;
		
	}
	
	total = taxa + valorD;
	
	printf("\nNome: %s", nome);
	printf("\nNumero de diarias: %.2f", diaria);
	printf("\nValor das diarias: $%.2f", valorD);
	printf("\nValor da taxa: $%.2f", taxa);
	printf("\nValor total a ser pago: $%.2f", total);
	

	return 0;
}