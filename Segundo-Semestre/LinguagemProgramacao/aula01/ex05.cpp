#include<stdio.h>
#include<stdlib.h>

int main(){
	float altura, base;
	
	printf("Informe a base do triangulo: ");
	scanf("%f", &base);
	printf("Informe a altura do triangulo: ");
	scanf("%f", &altura);
	
	float area = (base * altura)/2;
	
	printf("A base %.2f, altura %.2f e a area %.2f do triangulo\n\n", base, altura, area);
	
	system("pause");
	return 0;
}
