#include<stdio.h>
#include<stdlib.h>

int main(){
	float num;
	
	printf("Digite um valor inteiro: ");
	scanf("%f", &num);
	
	printf("Seu triplo e %.0f, seu quadrado e %.0f e seu meio é %.2f", num* num*num, num*num, num/2);
	
	return 0;
}
