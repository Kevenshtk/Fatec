#include<stdio.h>
#include<stdlib.h>

#define N 4

void lerValores(int numeros[N]){
	for(int i = 0; i<N; i++){
		printf("Informe um valor: ");
		fflush(stdin);
		scanf("%i", &numeros[i]);
	}
}

int maiorValor(){
	int numeros[N], maior = numeros[0];
	
	lerValores(numeros);
	
	for(int i = 1; i < N; i++){
		if(numeros[i] > maior){
			maior = numeros[i];
		}
	}
	
	return maior;
}

int main(){
	int maior;
	
	maior = maiorValor();
	
	printf("O maior valor informado foi %i", maior);
	
}