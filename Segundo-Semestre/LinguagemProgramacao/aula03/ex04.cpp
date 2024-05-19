#include<stdlib.h>
#include<stdio.h>

int main (){
	int soma = 0;
	
	for(int i = 10; i <= 60; i++){
		
		if(i % 2 == 0){
			printf("%i ", i);
			soma = soma + i;	
		}
	}
	
	printf("\nA soma e: %i", soma);
	return 0;
}