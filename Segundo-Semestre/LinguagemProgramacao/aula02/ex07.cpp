#include<stdio.h>
#include<stdlib.h>


int main(){
	char nome[10];
	float salario, salarioN, temp;
	int dep;
	
	printf("Informe seu nome: ");
	fflush(stdin);
	scanf("%s", nome);
	printf("Informe seu salario: $");
	scanf("%f", &salario);
	printf("Informe a quantidade de dependentes: ");
	scanf("%i", &dep);
	printf("Informe seu tempo de servico: ");
	scanf("%f", &temp);
	
	if(temp > 4 && dep > 3 && salario < 500){
		printf("Voce tem direito ao aumento.");
		salarioN = salario * 1.48;
		printf("\nFuncionario: %s", nome);
		printf("\nSalario antigo: $%.2f", salario);
		printf("\nSalario novo: $%.2f", salarioN);
	} else {
		printf("Voce nao tem direito ao aumento.");
		
	}
	
	return 0;
}