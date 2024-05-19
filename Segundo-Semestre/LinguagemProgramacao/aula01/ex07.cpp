#include<stdio.h>
#include<stdlib.h>

int main(){
	int num;
	
	printf("Informe um numero decimal: ");
	scanf("%i", &num);
	
	printf("Em hexadecimal: %x\n", num);
   	printf("Em octal: %o\n", num);

	return 0;
}
