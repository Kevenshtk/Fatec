/* le cada linha digitada via teclado e armazena no arquivo. 
O programa termina quando digita-se uma linha em branco */ 

#include <stdio.h> 
#include <string.h> 

main() { 
 FILE *fptr; 
 char string[81];
  
 fptr = fopen("arqtext.txt","w"); 
 
 while (strlen(gets(string)) > 0) { //lê a String
 fputs(string,fptr); //grava a String no arquivo
 fputs("\n",fptr); 
 } 
 fclose(fptr);
 
}//Fim main 