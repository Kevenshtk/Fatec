#include<stdio.h>
#include<stdlib.h>

int main(){
	char sexo;
	float h;
	
	printf("Informe seu sexo m-masculino, f-feminino: ");
	scanf("%c", &sexo);
	printf("Informe seu altura: ");
	scanf("%f", &h);
	
	switch(sexo){
		case 'm':
			printf("Seu peso ideal e %.2f", (72.7*h) - 58);
			return 0;
		break;
		
		case 'f':
			printf("Seu peso ideal e %.2f", (62.1*h) - 44.7);
			return 0;
		break;
	}
}