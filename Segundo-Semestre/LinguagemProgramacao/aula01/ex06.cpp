#include<stdio.h>
#include<stdlib.h>

int main(){
	int i = 1, num[3];
	float media;
	
	while(i <= 3){
		printf("Informe o %i numero: ", i);
		scanf("%i", &num[i]);
		
		media = media + num[i];
		i++;
	}
	
	media /= 3;
	printf("A media e %f", media);
	
	return 0;
}

