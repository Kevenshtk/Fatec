#include<stdio.h>
#include<stdlib.h>

int main(){
	float valor, total;
	
	printf("Informe o valor da compra: ");
	scanf("%f", &valor);
	
	if(valor >= 500){
		total = valor - (valor * 0.2);
		printf("valor da compra foi $ %f, o desconto obitido foi de 20 porcento, o valor a pagar e $ %.2f", valor, total);
	} else {
		total = valor - (valor * 0.15);
		printf("valor da compra foi $ %f, o desconto obitido foi de 15 porcento, o valor a pagar e $%.2f", valor, total);
	}
}