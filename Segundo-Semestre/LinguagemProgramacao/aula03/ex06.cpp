#include<stdlib.h>
#include<stdio.h>

int main(){
	int n, i = 1;
	float h;
	
	printf("Informe um numero inteiro: ");
	scanf("%i", &n);
	
	while(i <= n){
		
		h = (1.0 / i) + h;
		i++;
	}
	
	printf("O valor de H e %.2f", h);
	return 0;
}