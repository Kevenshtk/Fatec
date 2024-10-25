#include<stdio.h>
#include<conio.h>

main() {
	FILE *arquivo1, *arquivo2;
	char ch;
	int cont = 0;

	arquivo1 = fopen("arquivoTex.txt", "r");
	arquivo2 = fopen("dadosAluno.txt", "w");

	while ((ch=getc(arquivo1)) != EOF) {
		if(ch == ';' || ch == '\n') {
			cont++;
		}

		if(cont == 1 || cont == 3) {
			if(ch != ';') {
				putc(ch, arquivo2);
			}
		}
		
		if(cont == 3 && ch == ';'){
			putc(' ', arquivo2);
			putc('<', arquivo2);
		} 
		
		if(cont == 4){
			cont = 0;
			putc('>', arquivo2);
			putc('\n', arquivo2);
		}
	}

	fclose(arquivo1);
	fclose(arquivo2);
}