#include<stdlib.h>
#include<stdio.h>

int main(){
	int n, p, result = 1;
	
	printf("Informe um numero: ");
	scanf("%i", &n);
	
	printf("Informe a pontencia: ");
	scanf("%i", &p);
	
	for(int i = 1; i <= p; i++){
		result *= n;
	}
	
	printf("%i", result);
	return 0;
}