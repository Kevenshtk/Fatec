#include<stdio.h>
#include<stdlib.h>
#include<windows.h>

int main(){
	SetConsoleOutputCP(CP_UTF8);
	
	int codDepart;
	char nome[10];
	float salario, salarioN, temp;
	
	printf("Informe o código do departamento");
	printf("\n1 - secretaria, 2 - tesouraria, 3 - depto pessoal, 4 - almoxarifado\n");
	scanf("%i", &codDepart);
	printf("Informe seu nome: ");
	fflush(stdin);
	scanf("%s", nome);
	printf("Informe seu salário: $");
	scanf("%f", &salario);
	printf("Informe o tempo de serviço:");
	scanf("%f", &temp);
	
	if(codDepart == 1 || codDepart == 2){
		
		if(temp <= 4){
			salarioN = salario * 1.5;
			
		} else {
			salarioN = salario * 1.6;
			
		}
	} else if(codDepart == 3){
		salarioN = salario * 1.3;
		
	} else if(codDepart == 4){
		if(temp < 2){
			salarioN = salario * 1.3;
			
		} else if(temp >= 2 && temp <= 4){
			salarioN = salario * 1.4;
			
		} else {
			salarioN = salario * 1.5;
		}
	}
	
	printf("\nFuncionário: %s", nome);
	printf("\nSalário antigo: $%.2f", salario);
	printf("\nSalário novo: $%.2f", salarioN);
	
	return 0;
}