#include<stdlib.h>
#include<stdio.h>

int main(){
	int num, result;
	
	printf("Informe um numero: ");
	scanf("%i", &num);
	
	for(int i = 0; i <= 10; i++){
	
		printf("%i X %i = %i \n", i, num, i*num); 	
	}
	
	return 0;
}