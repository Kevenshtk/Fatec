#include<stdlib.h>
#include<stdio.h>

int main(){
	int num, maior, menor, guard;
	
	for(int i = 1; i <= 4; i++){
		printf("Informe um numero: ");
		scanf("%i", &num);
		
		if(num >= maior){
			maior = num;
		} 
		
		if(num <= menor) {
			menor = num;
		}
	}
	
	printf("O maior numero foi %i e o menor foi %i", maior, menor);
	return 0;
}