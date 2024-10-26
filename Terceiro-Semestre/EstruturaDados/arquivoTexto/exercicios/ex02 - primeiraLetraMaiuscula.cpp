// gera um arquivo texto com a primeira letra do nome em maiúsculo

#include<stdio.h>
#include<ctype.h> // para usar o toupper e tolower
#include<conio.h>

main(){
	FILE *arquivo1, *arquivo2; // declaração dos arquivos
	char ch, chAnterior, chMinusculo;
	
	chAnterior = ' ';
	arquivo1 = fopen("arquivoTex.txt", "r"); // abre o arquivo 1
	arquivo2 = fopen("arquivoM.txt", "w"); // abre o arquivo 2
	
	while ((ch=getc(arquivo1)) != EOF){ // lê o arquivo 1 até o final
		if(chAnterior == ' ' || chAnterior == '\n'){
			chMinusculo = tolower(ch);
			
			if(ch == chMinusculo){
				ch = toupper(ch);
			}
		}
		
		putc(ch,arquivo2); // grava o caracter no arquivo
		printf("%c",ch);
		chAnterior = ch;
	}
 
 	fclose(arquivo1);
 	fclose(arquivo2); 
}