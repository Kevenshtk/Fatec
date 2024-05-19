#include<stdio.h>
#include<stdlib.h>


int main(){
	float a, b, x;
	float y;
	
	printf("Dada a formula y = (2 + a ) / ( b + 3 ) - 2x\n\n");
	
	printf("Digite o valor de a: ");
	scanf("%f", &a);
	printf("\nDigite o valor de b: ");
	scanf("%f", &b);
	printf("\nDigite o valor de x: ");
	scanf("%f", &x);
	
	y = ((2 + a) / (b + 3)) - 2 * x;
	
	printf("\nO valor de y é %f", y);
	
	return 0;
}