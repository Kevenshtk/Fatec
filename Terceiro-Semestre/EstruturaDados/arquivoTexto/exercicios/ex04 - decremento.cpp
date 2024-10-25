// cria um arquivo texto com o caracter * de forma decrescente

#include <stdio.h>

int main() {
    FILE *output;
    int i, j, quantCaracter, espacos = 0;
    
    printf("Informe a quantidade de caracteres da primeira linha: ");
    fflush(stdin);
    scanf("%i", &quantCaracter);
    
    output = fopen("arquivo.txt", "w");
    
    for (i = 0; i < quantCaracter; i++) {
        for (j = 0; j < espacos; j++) {
            putc(' ', output);
        }
        
        for (j = 0; j < quantCaracter - i; j++) {
            putc('*', output);
        }
        
        putc('\n', output);
        espacos++;
    }
    
    fclose(output);
}