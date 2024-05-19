#include<stdlib.h>
#include<stdio.h>

int main(){
	int num, fat = 1;
	
	printf("Informe um numero: ");
	scanf("%i", &num);
	
	if(num == 0){
		fat = 1;
	}
	
	for(int i = num; i >= 1; i--){
		fat = fat * i;
	}	
	printf("O fatorial e: %i", fat);
	
	return 0;
}