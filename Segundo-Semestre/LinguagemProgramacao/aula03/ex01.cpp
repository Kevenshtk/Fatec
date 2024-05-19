#include<stdio.h>
#include<stdlib.h>


int main(){
    int soma = 0;
    
    for(int i = 1; i <= 10; i++){
        soma = soma + i;            
    }
    
    printf("O total da soma e: %i", soma);
    
    return 0;
}
