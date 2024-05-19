#include<stdio.h>
#include<stdlib.h>
#include <locale.h>

int main(){
	setlocale(LC_ALL, "Portuguese_Brazil.1252");
	
	char nome[10];
	char sexo;
	float alt, peso;
	int idade;
	
	printf("Informe seu nome: ");
	fflush(stdin);
	scanf("%s", nome);
	printf("Informe seu sexo m-masculino | f-feminino: ");
	fflush(stdin);
	scanf("%c", &sexo);
	printf("Informe sua altura: ");
	fflush(stdin);
	scanf("%f", &alt);
	printf("Informe sua idade: ");
	fflush(stdin);
	scanf("%i", &idade);
	
	switch(sexo){
		case 'm':
			if(alt > 1.70){
				
				if(idade <= 20){
					peso =  (72.7 * alt) - 58;
					printf("1");
				} else {
					peso =  (72.7 * alt) - 45;
					printf("2");
				}
				
			} else {
				
				if(idade <= 40){
					peso =  (72.7 * alt) - 50;
					printf("3");
				} else {
					peso =  (72.7 * alt) - 58;
					printf("4");
				}
				
			}
		break;
		
		case 'f':
			if(alt > 1.50){
				
				peso =  (62.1 * alt) - 44;
				printf("1f");
			} else {
				
				if(idade >= 35){
					peso =  (62.1 * alt) - 45;
					printf("2f");
				} else {
					printf("3f");
					peso =  (62.1 * alt) - 49;
				}
				
			}
		break;
	}
	
	printf("Seu peso ideal é %.2f", peso);
}
