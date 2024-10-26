#include<stdio.h>
#include<string.h>
#include <conio.h>

main(){
	FILE *fptr;
	char ch, chAnterior;
	int contCar = 0;
	int contLinha = 0;
	int contPalavra = 0;
	
	fptr = fopen("arquivoTex.txt", "r");
	
	chAnterior = ' ';
	
	while((ch=getc(fptr)) != EOF){
		if(ch != '\n'){ // conta caracter 
			contCar++;
		}
		
		if(ch == '\n'){ // conta linhas
			contLinha++;
		}
		
		if((ch == '\n' || ch == ' ') && (chAnterior == ' ' || chAnterior == '\n')){
			contPalavra++;
		}
		
		chAnterior = ch; //guarda o ch
	}
	
	if(chAnterior != '\n'){
		contLinha++;
	}
	
	if(chAnterior != '\n' && chAnterior != ' '){
		contPalavra++;
	}
	
	fclose(fptr);
	printf("O arquivo tem: %i caracter(s)", contCar);
	printf("\nO arquivo tem: %i linha(s)", contLinha);
	printf("\nO arquivo tem: %i palavras(s)", contPalavra);
}