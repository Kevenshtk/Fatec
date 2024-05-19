#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<locale.h>

int main(){
	 setlocale(LC_ALL, "Portuguese_Brazil.1252");
	
	char nome[10], txtCredito[90];
	float quantMes, total;
	int id;
	
	printf("Informe seu nome: ");
	scanf("%s", nome);
	printf("Informe o codigo do curso: ");
	scanf("%i", &id);
	printf("Informe o número de mêses que você ira cursar: ");
	scanf("%f", &quantMes);
	 
	 switch(id){
	 	case 1:
	 		total = 12 * quantMes;
	 		strcpy(txtCredito, "PD, o valor a ser pago é");
	 	break;
	 	
	 	case 2:
	 		total = 10 * quantMes;
	 		strcpy(txtCredito, "ADM, O valor a ser pago é");
	 	break;
	 		
	 	case 3:
	 		total = 15 * quantMes;
	 		strcpy(txtCredito, "CONTAB, o valor a ser pago é");
	 	break;
	 	
	 	case 4:
	 		total = 8 * quantMes;
	 		strcpy(txtCredito, "CIÊNCIAS, o valor a ser pago é ");
	 	break;
	 	
	 	default:
	 		printf("Código invalido !!!");
	 	break;
	 }
	 
	 printf("O aluno %s, seu curso e %s %.2f créditos\n", nome, txtCredito, total);
	 
	 return 0;
}
