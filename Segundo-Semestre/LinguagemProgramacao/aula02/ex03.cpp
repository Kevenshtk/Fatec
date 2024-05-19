#include<stdio.h>
#include<stdlib.h>

int main(){
	float venda, salario;
	
	printf("Informe o total das vendas: ");
	scanf("%f", &venda);
	
	if(venda > 20000){
		salario = venda - (venda * 0.10);
	} else {
		salario = venda - (venda * 0.075);
	}
	
	printf("O valor ganho pelo vendador e $ %.2f", salario);
}