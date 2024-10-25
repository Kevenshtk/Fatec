//Le caracteres do teclado e escreve um caractere por vez no arquivo 
#include <stdio.h> 
#include <conio.h>

main() 
{ 
 FILE *fptr; // guarda o endereço do arquivo
 char ch; 
 
 fptr = fopen("arqtext.txt","w"); // abre o arquivo

 while ((ch=getche()) != '\r') // espera precionar uma tecla, \r significa o enter
 	putc(ch,fptr); // grava o caracter no arquivo
 	
 	fclose(fptr); // fecha o arquivo
 	
}//Fim main