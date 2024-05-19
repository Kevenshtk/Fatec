#include<stdlib.h>
#include<stdio.h>

int main(){
	int result = 1;
	
	for(int i = 1; i <= 10; i++){
		result *= 2;
	}
	
	printf("%i", result);
	return 0;
}