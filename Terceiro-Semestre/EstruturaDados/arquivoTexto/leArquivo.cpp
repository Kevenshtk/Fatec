#include <stdio.h> 
#include <stdlib.h> 

main() { 
 FILE *fptr; 
 char ch; 
 
 if ((fptr = fopen("arqtext.txt","r"))==NULL) { // verifica se a fopen abriu o arquivo
 printf("Erro na abertura do arquivo."); 
 exit(0); //finaliza o programa
 } 
 
 while ((ch=getc(fptr)) != EOF) // lê os caracters do arquivo, EOF fim do arquivo
 printf("%c",ch); 
 
 fclose(fptr); 
}//Fim main