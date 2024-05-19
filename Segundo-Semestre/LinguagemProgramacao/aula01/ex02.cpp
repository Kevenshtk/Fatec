#include<stdio.h>
#include<stdlib.h>


int main(){
	float b, k, x, y;
	
	system("color b");
	printf("Dada a formula y = (2 * b + 5 + 3 * k) / 2 * x\n\n");
	
	printf("Digite o valor de b: ");
	scanf("%f", &b);
	printf("\nDigite o valor de k: ");
	scanf("%f", &k);
	printf("\nDigite o valor de x: ");
	scanf("%f", &x);
	
	y = (2 * b + 5 + 3 * k) / 2 * x;
	
	printf("\nO valor de y é %.2f", y);
	
	return 0;
}