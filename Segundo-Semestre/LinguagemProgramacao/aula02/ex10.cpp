#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(){
	int id;
	char car[15];
	
	system("color 1");
	
	printf("1 - GOL    1000");
	printf("\n2 - GOL    CL");
	printf("\n3 - UNO    MILLE");
	printf("\n4 - UNO    ELX");
	printf("\n5 - UNO    1.6 R");
	printf("\n6 - CORSA  GL");
	
	printf("\n\nInforme o codigo do veiculo: ");
	scanf("%i", id);
	
	switch(id){
		case 1:
			strcopy(car, "GOL 1000");
		break;
		
		case 2:
			strcopy(car, "GOL CL");
		break;
		
		case 3:
			strcopy(car, "UNO MILLE");
		break;
		
		case 4:
			strcopy(car, "UNO ELX");
		break;
		
		case 5:
			strcopy(car, "UNO 1.6 R");
		break;
		
		case 6:
			strcopy(car, "CORSA GL");
		break;
		
		default:
			printf("Codigo invalido !!!");
			
		break;
	}
	
	printf("\nCarro: %s", car);
}
