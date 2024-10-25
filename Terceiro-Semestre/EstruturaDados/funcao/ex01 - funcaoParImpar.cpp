#include <stdio.h> 
int verificaValor(int valor) { 
	if(valor % 2 ==0 ){
		return 0;
	} else {
		return 1;
	}
} 

int main() { 
 int valor, teste; 
 
 printf("Digite um valor inteiro: "); 
 fflush(stdin);
 scanf("%i", &valor);
 
 teste = verificaValor(valor);
 
 if(teste == 0) {
 	printf("O valor digitado e par!"); 	
 } else {
 	printf("O valor digitado e impar!"); 
 }
}