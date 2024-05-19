#include<stdio.h>
#include<stdlib.h>

int main(){
	float salario, imposto;
	
	printf("IMPOSTO DE RENDA\n\n");
	printf("Informe seu salario: $");
	scanf("%f", &salario);
	
	if(salario <= 1164){
		printf("Voce e isento");
	
	} else if(salario >= 1164.01 && salario <= 2326){
		imposto = salario * 0.15 - 174.6;
		
	} else {
		imposto = salario * 0.275 - 465.35;
		
	}
	
	if(imposto != 0){
		printf("\nO total a ser pago de imposto e: $%.2f", imposto);
	}
	
	return 0;
}
