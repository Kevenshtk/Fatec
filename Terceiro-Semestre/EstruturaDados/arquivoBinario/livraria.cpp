#include <stdio.h>
#include<stdlib.h>
#include <string.h>
#include <ctype.h>

#define LIVROS "Livros.dat"
#define CLIENTES "Clientes.dat"
#define VENDAS "Vendas.dat"
#define AUTORES "Autor.dat"
#define LIVRO_AUTOR "Livro-Autor.dat"

struct reg_livro{
	int codigo;
	char titulo[30];
	float preco;
};

struct reg_cliente{
	int codigo;
	char nome[40], fone[16], email[30];
};

struct reg_venda{
	int codigo;
	int codcli;
	int codliv;
	int qtde;
	float desconto;
};

struct reg_autor{
	int codigo;
	char nome[40];
};

struct reg_livro_autor {
	int codigo;
	int codaut;
	int codliv;
};


void cadastrarAutor();
void cadastrarLivro();
void cadastrarCliente();
void efetuarVenda();
void relacionarAutorLivro();

void listarAutor();
void listarLivros();
void listarClientes();
void listarVendas();
void listarLivroSemAutor();

struct reg_autor buscarAutorPeloCodigo(int codbuscar);
struct reg_livro buscarLivroPeloCodigo(int codbuscar);
struct reg_cliente buscarClientePeloCodigo(int codbuscar);
struct reg_venda buscarVendaPeloCodigo(int codbuscar);

void consultarPeloCodigo();
void consultarPeloTitulo();
void consultarPalavraChaveTitulo();
void consultarLivroPorAutor();
void consultarClientePeloNome();

void alterarAutor();
void alterarLivro();
void alterarCliente();

void excluirLivro();
void excluirCliente();

void aplicarAumento();
void fecharCaixa();

void menuAutor();
void menuLivro();
void menuCliente();
void menuVenda();
void menuTrabalho();

main(){
	int op;

	do {
		printf("\n\n\n");
		printf("\n#########   Livraria Alma do Saber   ###########");
		printf("\n#########       MENU PRINCIPAL       ###########");
		printf("\n#                                              #");
		printf("\n# 1) Menu Livro                                #");
		printf("\n# 2) Menu Cliente                              #");
		printf("\n# 3) Menu Venda                                #");
		printf("\n# 4) Menu Trabalho                             #");
		printf("\n# 0) Sair                                      #");
		printf("\n#                                              #");
		printf("\n# Opcao-> ");

		fflush(stdin);
		scanf("%i",&op);

		switch(op) {
			case 1: //Menu Livros
				system("cls");
				menuLivro();
			break;

			case 2: //Menu Cliente
				system("cls");
				menuCliente();
			break;
				
			case 3: //Menu Venda
				system("cls");
				menuVenda();
			break;
			
			case 4: //Menu Trabalho
				system("cls");
				menuTrabalho();
			break;
		}
	} while (op!=0);
}

//Trabalho
void menuTrabalho(){
	int op;

	do {
		printf("\n\n\n");
		printf("\n#########   Livraria Alma do Saber   ###########");
		printf("\n#########         MENU TRABALHO      ###########");
		printf("\n#                                              #");
		printf("\n# 1) Fechar Venda Caixa                        #");
		printf("\n# 2) Aplicar Aumento Preco Livros              #");
		printf("\n# 3) Relacionar Livro com Autor                #");
		printf("\n# 4) Listar Todos os Livros                    #");
		printf("\n# 5) Consultar Livro por Autor                 #");
		printf("\n# 0) Sair                                      #");
		printf("\n#                                              #");
		printf("\n# Opcao-> ");

		fflush(stdin);
		scanf("%i",&op);

		switch(op) {
			case 1: //Fechar Venda Caixa
				system("cls");
				fecharCaixa();
			break;
			
			case 2: //Aplicar Aumento
				system("cls");
				aplicarAumento();
			break;
			
			case 3://Relacionar livro com autores
				system("cls");
				relacionarAutorLivro();
			break;
			
			case 4://Listar Todos os Livros
				system("cls");
				listarLivros();
			break;
			
			case 5://Consultar Livro por Autor
				system("cls");
				consultarLivroPorAutor();
			break;
		}
	} while (op!=0);

	system("cls");
}

//funções autor
void cadastrarAutor(){
	FILE *fpautor;
	struct reg_autor autor;
	char opc;
	int cod;
	
	printf("\nDigite o Codigo: ");
	fflush(stdin); 
	scanf("%d", &autor.codigo);
	printf("Nome: ");
	fflush(stdin); 
	gets(autor.nome);
	
	printf("\nGravar Autor? (S/N) ");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc != 's') && (opc != 'S')){
		printf("\nOperacao Cancelada !");
		return;
	}
	
	fpautor = fopen(AUTORES, "ab");
	
	fwrite(&autor,sizeof(autor),1,fpautor);
	
	fclose(fpautor);
	
	printf("\nAutor gravado com sucesso !");
}

struct reg_autor buscarAutorPeloCodigo(int codbuscar){
	FILE *fpautor;
	struct reg_autor autor;
	int achou=0;
	
	fpautor = fopen(AUTORES, "rb");

	while((achou == 0) && (fread(&autor, sizeof(autor),1,fpautor)==1)){
		if(autor.codigo == codbuscar){
			achou = 1;
		}
	}

	fclose(fpautor);	
	
	if(achou != 1){
		autor.codigo = -1;
	}
	
	return autor;
}

void listarAutor(){
	FILE *fpautor;
	struct reg_autor autor;
	
	fpautor = fopen(AUTORES, "rb");
	
	printf("\nRelatorio Todos os Autores:");
	printf("\n\nCodigo Nome");

	while(fread(&autor,sizeof(autor),1,fpautor)==1){
		printf("\n%-6i %-40s", autor.codigo, autor.nome);
	}

	fclose(fpautor);
}

void alterarAutor(){
	FILE *fpautor;
	struct reg_autor autor, aut;
	int cod, achou = 0;
	char opc;

	printf("\nDigite o codigo do autor para ser alterado: ");
	fflush(stdin); 
	scanf("%i", &cod);
	
	autor = buscarAutorPeloCodigo(cod);
	
	if(autor.codigo == -1) {
		printf("\nAutor nao localizado !");
		return;
	}
	
	printf("\nCodigo Nome");
	printf("\n%-6i %-40s", autor.codigo, autor.nome);
	
	printf("\n\nConfirma Autor? (S/N) ");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc == 'n')||(opc == 'N')) {
		printf("\nAutor NAO confirmado !");
		return;
	}
	
	printf("\nDeseja alterar o Nome? (S/N) ");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc == 's')||(opc == 'S')) {
		printf("\nDigite o novo Nome: ");
		fflush(stdin); 
		gets(autor.nome);
	}
	
	printf("\n\nGravar Alteracao? (S/N) ");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc == 'n')||(opc == 'N')) {
		printf("\nOperacao Cancelada !");
		return;
	}
	
	fpautor = fopen(AUTORES, "rb+");
	
	while((achou==0)&&(fread(&aut,sizeof(aut),1,fpautor)==1)){
		if(aut.codigo == cod){
			achou = 1;
		}
	}

	fseek(fpautor,-sizeof(autor),1);

	fwrite(&autor, sizeof(autor),1,fpautor);
	
	fclose(fpautor);
	
	printf("\n Autor alterado com sucesso !");
}

void relacionarAutorLivro(){
	FILE *fpautorLivro;
	struct reg_livro_autor autorLivro;
	struct reg_livro livro;
	struct reg_autor autor;
	char opc;
	int codvalido=0, cod;
	
	printf("\nDigite um Codigo: ");
	fflush(stdin); 
	scanf("%d", &cod);
		
	printf("\nDigite o Codigo do Livro: ");
	fflush(stdin); 
	scanf("%d", &autorLivro.codliv);
	
	livro = buscarLivroPeloCodigo(autorLivro.codliv);
	
	if(livro.codigo == -1) {
		printf("\nLivro nao localizado !");
		return;
	}
	
	printf("\n\nCodigo: %d - Titulo: %s", livro.codigo, livro.titulo);
	
	printf("\n\nConfirma Livro? (S/N) ");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc == 'n')||(opc == 'N')) {
		printf("\nLivro NAO confirmado !");
		return;
	}
	
	printf("\nDigite o Codigo do Autor: ");
	fflush(stdin); 
	scanf("%d", &autorLivro.codaut);
	
	autor = buscarAutorPeloCodigo(autorLivro.codaut);
	
	if(autor.codigo == -1) {
		printf("\nAutor nao localizado!!!");
		return;
	}
	
	printf("\n\nCodigo: %d - Nome: %s.", autor.codigo, autor.nome);
	
	printf("\n\nConfirma Autor? (S/N) ");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc == 'n')||(opc == 'N')) {
		printf("\nAutor NAO confirmado!!!");
		return;
	}
	
	printf("\nGravar Relacionamento desse autor com esse livro ? (S/N)");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc != 's') && (opc != 'S')) {
		printf("\nOperacao Cancelada!!!");
		return;
	}
	
	fpautorLivro = fopen(LIVRO_AUTOR, "ab");
	
	fwrite(&autorLivro, sizeof(autorLivro),1,fpautorLivro);
	
	fclose(fpautorLivro);
	
	printf("\nRelacionamento gravado com sucesso !");
}

void menuAutor(){
	int op;

	do {
		printf("\n\n\n");
		printf("\n#########   Livraria Alma do Saber   ###########");
		printf("\n#########         MENU AUTOR         ###########");
		printf("\n#                                              #");
		printf("\n# 1) Cadastrar Autor                           #");
		printf("\n# 2) Listar Todos os Autor                     #");
		printf("\n# 3) Alterar Autor                             #");
		printf("\n# 4) Relacionar Livro com Autor                #");
		printf("\n# 0) Sair                                      #");
		printf("\n#                                              #");
		printf("\n# Opcao-> ");

		fflush(stdin);
		scanf("%i",&op);

		switch(op) {
			case 1: //Cadastrar autor
				system("cls");
				cadastrarAutor();
			break;
			
			case 2: //Listar todos os autores
				system("cls");
				listarAutor();
			break;
			
			case 3://Alterar dados de um Autor
				system("cls");
				alterarAutor();
			break;
			
			case 4://Relacionar Autor com Livro
				system("cls");
				relacionarAutorLivro();
			break;
		}
	} while (op!=0);

	system("cls");
}


//funções livro
void converteParaMaiusculo(char string[]){
	int i;

	for (i=0; i<strlen(string); i++) {
		string[i] = toupper(string[i]);
	}
}

void cadastrarLivro(){
	FILE *fplivro;
	struct reg_livro livro;
	char opc;

	printf("\nDigite o Codigo:");
	fflush(stdin);
	scanf("%i",&livro.codigo);
	printf("Titulo: ");
	fflush(stdin);
	gets(livro.titulo);
	printf("Preco: ");
	fflush(stdin);
	scanf("%f", &livro.preco);

	printf("\nGravar Livro?(S/N)");
	fflush(stdin);
	scanf("%c",&opc);

	if ((opc!='s') && (opc!='S')) {
		printf("\nOperacao Cancelada!");
		return;
	}

	fplivro = fopen(LIVROS,"ab");

	fwrite(&livro,sizeof(livro),1,fplivro);

	fclose(fplivro);

	printf("\nLivro gravado com sucesso.");
}

void listarLivros(){
	FILE *fplivro, *fpautorLivro;
	struct reg_livro livro;
	struct reg_livro_autor autorLivro;
	struct reg_autor autor;
	int livroanterior = -1;
	
	fplivro = fopen(LIVROS, "rb");
	fpautorLivro = fopen(LIVRO_AUTOR, "rb");
	
	printf("\nRelatorio Todos os Livros:");
	printf("\n\nCodigo Titulo                         Autor                                    Preco");
	while(fread(&livro, sizeof(livro),1,fplivro)==1){
		while(fread(&autorLivro, sizeof(autorLivro), 1, fpautorLivro) == 1){
			if(livro.codigo == autorLivro.codliv){
				autor = buscarAutorPeloCodigo(autorLivro.codaut);
				
				if(livroanterior == livro.codigo){
					printf("\n                                      %-40s", autor.nome);
				} else {
					printf("\n%-6i %-30s %-40s %6.2f", livro.codigo, livro.titulo, autor.nome, livro.preco);
				}
				livroanterior = livro.codigo;
			}
		}
		fseek(fpautorLivro, 0, 0);
	}

	fclose(fplivro);
	fclose(fpautorLivro);
}

void listarLivroSemAutor(){
	FILE *fplivro;
	struct reg_livro livro;
	
	fplivro = fopen(LIVROS, "rb");
	
	printf("\nRelatorio Todos os Livros:");
	printf("\n\nCodigo Titulo                         Preco");
	while(fread(&livro,sizeof(livro),1,fplivro)==1){
		printf("\n%-6i %-30s %-5.2f", livro.codigo, livro.titulo, livro.preco);
	}

	fclose(fplivro);
}

void consultarPeloCodigo(){
	FILE *fplivro;
	struct reg_livro livro;
	int codbuscar, achou;

	//Entrada de Dados - Pedir o Código do Livro
	printf("\nDigite o Codigo do Livro a ser Localizado: ");
	fflush(stdin);
	scanf("%i",&codbuscar);

	//Abrir o Arquivo para Leitura
	fplivro = fopen(LIVROS,"rb");

	//Localizar e Mostrar o Livro
	achou=0;
	while((achou==0)&&(fread(&livro,sizeof(livro),1,fplivro)==1)) {
		//printf("\nEntrou");
		if (livro.codigo==codbuscar) { //Achei o Livro
			printf("\nCodigo: %i",livro.codigo);
			printf("\nTitulo: %s",livro.titulo);
			printf("\npreco: %5.2f",livro.preco);
			printf("\n--------------------------------------------");
			achou=1;
		}
	}

	if(achou==0) {
		printf("\nLivro Nao Localizado!");
	}
	//Fechar o Arquivo
	fclose(fplivro);
}

struct reg_livro buscarLivroPeloCodigo(int codbuscar){
	FILE *fplivro;
	struct reg_livro livro;
	int achou;

	//Abrir o Arquivo para Leitura
	fplivro = fopen(LIVROS,"rb");

	//Localizar o Livro
	achou=0;
	while((achou==0)&&(fread(&livro,sizeof(livro),1,fplivro)==1)) {
		if (livro.codigo==codbuscar) { //Achei o Livro
			achou=1;
		}
	}

	//Fechar o Arquivo
	fclose(fplivro);

	if(achou==1) {
		return livro;
	} else { //Livro NÃO Localizado
		livro.codigo = -1;
	}
}

void consultarPeloTitulo(){
	FILE *fplivro;
	struct reg_livro livro;
	int achou;
	char titbuscar[30];

	//Entrada de Dados - Pedir o Título do Livro
	printf("\nDigite o Titulo do Livro a ser Localizado: ");
	fflush(stdin);
	gets(titbuscar);

	converteParaMaiusculo(titbuscar);

	//Abrir o Arquivo para Leitura
	fplivro = fopen(LIVROS,"rb");

	//Localizar e Mostrar o Livro
	achou=0;
	while((achou==0)&&(fread(&livro,sizeof(livro),1,fplivro)==1)) {
		converteParaMaiusculo(livro.titulo);

		if (strcmp(livro.titulo,titbuscar)==0) { //Achei o Livro
			printf("\nCodigo: %i",livro.codigo);
			printf("\nTitulo: %s",livro.titulo);
			printf("\npreco: %5.2f",livro.preco);
			printf("\n--------------------------------------------");
			achou=1;
		}
	}

	if(achou==0) {
		printf("\nLivro Nao Localizado!");
	}
	//Fechar o Arquivo
	fclose(fplivro);
}

void consultarPalavraChaveTitulo(){
	FILE *fplivro;
	struct reg_livro livro;
	int achou;
	char palavra[30];

	printf("\nDigite a Palavra-Chave: ");
	fflush(stdin);
	gets(palavra);

	converteParaMaiusculo(palavra);

	fplivro = fopen(LIVROS,"rb");

	printf("\nRelatorio Livros com Palavra-Chave %s:",palavra);
	printf("\n\nCodigo Titulo                         Preco\n");

	achou=0;
	while(fread(&livro,sizeof(livro),1,fplivro)==1) {
		converteParaMaiusculo(livro.titulo);

		if (strstr(livro.titulo,palavra)!=NULL) {
			printf("%-6i %-30s %-5.2f",livro.codigo,livro.titulo,livro.preco);
			printf("\n");
			achou=1;
		}
	}

	if(achou==0) {
		printf("\nNenhum Livro com esta Palavra-Chave no Titulo!");
	}

	fclose(fplivro);
}

void consultarLivroPorAutor(){
	FILE *fpautorLivro;
	struct reg_livro livro;
	struct reg_autor autor;
	struct reg_livro_autor autorLivro;
	int cod;
	
	printf("\nDigite o codigo do Autor: ");
	fflush(stdin); 
	scanf("%i", &cod);
	
	autor = buscarAutorPeloCodigo(cod);
	
	if(autor.codigo == -1) {
		printf("\nAutor nao localizado!!!");
		return;
	}
	
	printf("\nAutor: ");
	printf("%-2i %-40s", autor.codigo, autor.nome);
	

	printf("\nCodigo Titulo                         Preco");

	fpautorLivro = fopen(LIVRO_AUTOR, "rb");
	
	while(fread(&autorLivro,sizeof(autorLivro),1,fpautorLivro)==1) {
		if(autor.codigo == autorLivro.codaut) {
			livro = buscarLivroPeloCodigo(autorLivro.codliv);
			printf("\n %-6i %-30s %6.2f", livro.codigo, livro.titulo, livro.preco);
		}
	}
	
	fclose(fpautorLivro);
}

void alterarLivro(){
  FILE *fplivro;
  struct reg_livro livro,liv;
  int cod,achou;
  char opc;
  
  printf("\nDigite o Codigo do Livro a ser Alterado: ");
  fflush(stdin); 
  scanf("%i",&cod);
  
  livro = buscarLivroPeloCodigo(cod);
  if (livro.codigo==-1){
  	printf("\nLivro NAO Localizado!");
  	return;
  }
  
  printf("\nCodigo: %i",livro.codigo);
  printf("\nTitulo: %s",livro.titulo);
  printf("\npreco: %5.2f",livro.preco);  
  
  printf("\nConfirna Livro(S/N)? ");
  fflush(stdin); 
  scanf("%c",&opc);
  
  if ((opc=='n')||(opc=='N')){
  	printf("\nLivro NAO confirmado!");
  	return;
  }
  
  printf("\nDeseja alterar o Titulo(S/N)? ");
  fflush(stdin); 
  scanf("%c",&opc);
  
  if ((opc=='s')||(opc=='S')){
  	printf("\nDigite o novo Titulo: ");
  	fflush(stdin); 
	gets(livro.titulo);
  }

  printf("\nDeseja alterar o Preco(S/N)? ");
  fflush(stdin); 
  scanf("%c",&opc);
  
  if ((opc=='s')||(opc=='S')){
  	printf("\nDigite o novo preco: ");
  	fflush(stdin); 
	scanf("%f",&livro.preco);
  }  
  
  printf("\nGravar Livro(S/N)? ");
  fflush(stdin); 
  scanf("%c",&opc);
  
  if ((opc=='n')||(opc=='N')){
  	printf("\nOperacao Cancelada!");
  	return;
  }  
  
  fplivro = fopen(LIVROS,"rb+");
  
  achou=0;
  while ((achou==0)&&(fread(&liv,sizeof(liv),1,fplivro)==1)){
  	if (liv.codigo==cod){
  		achou=1;
	  }
  }
  
  fseek(fplivro,-sizeof(livro),1);
  
  fwrite(&livro,sizeof(livro),1,fplivro);

  fclose(fplivro);
  
  printf("\nLivro alterado com sucesso !");
}

void excluirLivro(){
	FILE *fplivro, *fplivronew;
	struct reg_livro livro;
	int cod;
	char opc;

	printf("\nDigite o Codigo do Livro a ser Excluido: ");
	fflush(stdin);
	scanf("%i",&cod);

	livro = buscarLivroPeloCodigo(cod);
	if (livro.codigo==-1) {
		printf("\nLivro NAO Localizado!");
		return;
	}

	printf("\nCodigo: %i",livro.codigo);
	printf("\nTitulo: %s",livro.titulo);
	printf("\npreco: %5.2f",livro.preco);

	printf("\nConfirma Exclusao do Livro(S/N)? ");
	fflush(stdin);
	scanf("%c",&opc);

	if ((opc=='n')||(opc=='N')) {
		printf("\nExlusao NAO confirmada !");
		return;
	}

	fplivro = fopen(LIVROS,"rb");
	fplivronew = fopen("livrosnew.dat","wb");

	while (fread(&livro,sizeof(livro),1,fplivro)==1) {
		if (livro.codigo!=cod) {
			fwrite(&livro,sizeof(livro),1,fplivronew);
		}
	}
	fclose(fplivro);
	fclose(fplivronew);

	//Excluir o arquivo antigo livros.dat do sistema
	system("del livros.dat");

	//Renomear o novo arquivo (livrosnew.dat) para (livros.dat)
	system("ren livrosnew.dat livros.dat");

	printf("\nLivro excluido com sucesso.");

}

void aplicarAumento(){
	FILE *fplivro, *fplivronew;
  	struct reg_livro livro,liv;
	float porc;
	char opc;
	
	printf("Digite a porcentagem do aumento: ");
	fflush(stdin);
	scanf("%f", &porc);
	
	printf("\nConfirma o aumento de %.0f%% para todos os livros? (S/N) ", porc);
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc!= 's')&&(opc != 'S')) {
		printf("\nOperacao Cancelada !");
		return;
	}
	
	fplivro = fopen(LIVROS, "rb");
	fplivronew = fopen("livrosnew.dat", "wb");
	
	while(fread(&livro, sizeof(livro),1,fplivro)==1) {
		livro.preco = livro.preco + (livro.preco * porc / 100);
		fwrite(&livro, sizeof(livro), 1, fplivronew);	
	}
	
	fclose(fplivro);
	fclose(fplivronew);

	system("del livros.dat");
	system("ren livrosnew.dat livros.dat");
	
	printf("\nAumento efetuado com sucesso !");
}

void menuLivro(){
	int op;

	do {
		printf("\n\n\n");
		printf("\n#########   Livraria Alma do Saber   ###########");
		printf("\n#########         MENU LIVRO         ###########");
		printf("\n#                                              #");
		printf("\n# 1) Cadastrar Livro                           #");
		printf("\n# 2) Listar Todos os Livros com Autor          #");
		printf("\n# 3) Listar Todos os Livros sem Autor          #");
		printf("\n# 4) Consultar Livro pelo Codigo               #");
		printf("\n# 5) Consultar Livro pelo Titulo               #");
		printf("\n# 6) Consultar Livro por Palavra-Chave         #");
		printf("\n# 7) Consultar Livro pelo Autor                #");
		printf("\n# 8) Alterar Livro                             #");
		printf("\n# 9) Aplicar Aumento no Preco dos Livros       #");
		printf("\n# 10) Excluir Livro                            #");
		printf("\n# 11) Menu Autor                               #");
		printf("\n# 0) Sair                                      #");
		printf("\n#                                              #");
		printf("\n# Opcao-> ");

		fflush(stdin);
		scanf("%i",&op);

		switch(op) {
			case 1: //Cadastrar um novo Livro
				system("cls");
				cadastrarLivro();
			break;

			case 2: //Listar todos os Livros com Autor
				system("cls");
				listarLivros();
			break;

			case 3: //Listar todos os Livros sem Autor
				system("cls");
				listarLivroSemAutor();
			break;
			
			case 4: //Consultar Livro pelo Código
				system("cls");
				consultarPeloCodigo();
			break;

			case 5: //Consultar Livro pelo Titulo
				system("cls");
				consultarPeloTitulo();
			break;

			case 6: //Consultar Livro por Palavra-Chave no Titulo
				system("cls");
				consultarPalavraChaveTitulo();
			break;
			
			case 7: //Consultar Livro por Autor
				system("cls");
				consultarLivroPorAutor();
			break;

			case 8://Alterar dados de um Livro
				system("cls");
				alterarLivro();
			break;

			case 9://Aplicar aumento
				system("cls");
				aplicarAumento();
			break;
			
			case 10://Excluir um Livro
				system("cls");
				excluirLivro();
			break;
			
			case 11://Menu autor
				system("cls");
				menuAutor();
			break;
		}
	} while (op!=0);

	system("cls");
}


//funções cliente
void cadastrarCliente(){
	FILE *fpcliente;
	struct reg_cliente cliente;
	char opc;

	printf("\nDigite o Codigo:");
	fflush(stdin);
	scanf("%i",&cliente.codigo);
	printf("Nome do cliente: ");
	fflush(stdin);
	gets(cliente.nome);
	printf("Telefone: ");
	fflush(stdin);
	gets(cliente.fone);
	printf("Email: ");
	fflush(stdin);
	gets(cliente.email);

	printf("\nGravar Cliente?(S/N)");
	fflush(stdin);
	scanf("%c",&opc);

	if ((opc!='s') && (opc!='S')) {
		printf("\nOperacao Cancelada!");
		return; 
	}

	fpcliente = fopen(CLIENTES,"ab");

	fwrite(&cliente,sizeof(cliente),1,fpcliente);

	fclose(fpcliente);

	printf("\nCliente cadastrado com sucesso.");
}

void listarClientes(){
	FILE *fpcliente;
	struct reg_cliente cliente;

	fpcliente = fopen(CLIENTES,"rb");

	printf("\nRelatorio de Todos os Clientes: ");
	
	printf("\n\nCodigo  Nome           Telefone          Email\n");
	while(fread(&cliente,sizeof(cliente),1,fpcliente)==1) {
		printf("%-7i %-14s %-17s %s",cliente.codigo,cliente.nome,cliente.fone,cliente.email);
		printf("\n");
	}

	fclose(fpcliente);
}

struct reg_cliente buscarClientePeloCodigo(int codbuscar){
  FILE *fpcliente;
  struct reg_cliente cliente;
  int achou; 	
  
  fpcliente = fopen(CLIENTES,"rb");
  
  achou=0; 
  while((achou==0)&&(fread(&cliente,sizeof(cliente),1,fpcliente)==1)){
  	if (cliente.codigo==codbuscar){ 
	  achou=1;
	}
  }

  fclose(fpcliente);

	if(achou!=1){
   	 cliente.codigo = -1;	
   } 
    
   return cliente;
}

void consultarClientePeloNome(){
	FILE *fpcliente;
	struct reg_cliente cliente;
	char nombuscar[40], nomcopy[40];
	int achou=0;
	
	printf("\nDigite o nome do cliente para ser localizado: ");
	fflush(stdin); 
	gets(nombuscar);
	
	converteParaMaiusculo(nombuscar);
	
	fpcliente = fopen(CLIENTES, "rb");
	

	printf("\n\n Codigo Nome                                     Fone            Email");
	while((achou == 0) && (fread(&cliente, sizeof(cliente), 1, fpcliente) == 1)) {
		strcpy(nomcopy,cliente.nome);
		
		converteParaMaiusculo(nomcopy);
		
		if(strcmp(nomcopy,nombuscar) == 0) {
			printf("\n %-6i %-40s %-15s %-30s", cliente.codigo, cliente.nome, cliente.fone, cliente.email);
			achou = 1;
		}
	}
	if(achou == 0) {
		printf("\n\nCliente nao localizado!!!");
	}
	
	fclose(fpcliente);
	
}

void alterarCliente(){
	FILE *fpcliente;
	struct reg_cliente cliente, cli;
	int cod, achou = 0;
	char opc;
	
	printf("\nDigite o codigo do cliente para ser alterado: ");
	fflush(stdin); scanf("%i", &cod);
	
	cliente = buscarClientePeloCodigo(cod);
	
	if(cliente.codigo == -1) {
		printf("\nCliente nao localizado!!!");
		return;
	}
	
	printf("\n Codigo Nome                                     Fone            Email");
	printf("\n %-6i %-40s %-15s %-30s", cliente.codigo, cliente.nome, cliente.fone, cliente.email);
	
	printf("\n\nConfirma Cliente? (S/N) ");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc == 'n')||(opc == 'N')) {
		printf("\nCliente NAO confirmado!!!");
		return;
	}
	
	printf("\nDeseja alterar o Nome? (S/N) ");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc == 's')||(opc == 'S')) {
		printf("\nDigite o novo Nome: ");
		fflush(stdin); gets(cliente.nome);
	}
	
	printf("\nDeseja alterar o Fone? (S/N) ");
	fflush(stdin); scanf("%c", &opc);
	
	if((opc == 's')||(opc == 'S')) {
		printf("\nDigite o novo Fone (XX)XXXXX-XXXX: ");
		fflush(stdin); 
		gets(cliente.fone);
	}
	
	printf("\nDeseja alterar o Email? (S/N) ");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc == 's')||(opc == 'S')) {
		printf("\nDigite o novo Email: ");
		fflush(stdin); 
		gets(cliente.email);
	}
	
	printf("\n\nGravar Alteracao? (S/N) ");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc == 'n')||(opc == 'N')) {
		printf("\nOperacao Cancelada!!!");
		return;
	}
	
	fpcliente = fopen(CLIENTES, "rb+");
	
	while((achou == 0)&&(fread(&cli, sizeof(cli), 1, fpcliente) == 1)) {
		if(cli.codigo == cod) {
			achou = 1;
		}
	}

	fseek(fpcliente, -sizeof(cliente), 1);
	
	fwrite(&cliente, sizeof(cliente), 1, fpcliente);
	
	fclose(fpcliente);
	
	printf("\nCliente alterado com sucesso!!!");
	
}

void excluirCliente(){
	FILE *fpcliente, *fpclientenew;
	struct reg_cliente cliente;
	int cod;
	char opc;
	
	printf("\n Digite o codigo do cliente para ser excluido: ");
	fflush(stdin); 
	scanf("%i", &cod);
	
	cliente = buscarClientePeloCodigo(cod);
	
	if(cliente.codigo == -1) {
		printf("\n Cliente nao localizado!!!");
		return;
	}
	
	printf("\n Codigo Nome                                     Fone            Email");
	printf("\n %-6i %-40s %-15s %-30s", cliente.codigo, cliente.nome, cliente.fone, cliente.email);
	
	printf("\n\n Confirma Exclusao do Cliente? (S/N) ");
	fflush(stdin); 
	scanf("%c", &opc);
	
	if((opc == 'n')||(opc == 'N')) {
		printf("\n Exclusao NAO confirmada!!!");
		return;
	}
	
	fpcliente = fopen(CLIENTES, "rb");
	fpclientenew = fopen("clientesnew.dat", "wb");
	
	while(fread(&cliente, sizeof(cliente),1,fpcliente)==1) {
		if(cliente.codigo != cod) {
			fwrite(&cliente, sizeof(cliente), 1, fpclientenew);
		}
	}
	
	fclose(fpcliente);
	fclose(fpclientenew);
	
	system("del clientes.dat");
	
	system("ren clientesnew.dat clientes.dat");
	
	printf("\n Cliente excluido com sucesso!!!");
	
}

void menuCliente(){
	int op;

	do {
		printf("\n\n\n");
		printf("\n#########   Livraria Alma do Saber   ###########");
		printf("\n#########        MENU CLIENTE        ###########");
		printf("\n#                                              #");
		printf("\n# 1) Cadastrar Cliente                         #");
		printf("\n# 2) Listar Todos os Cliente                   #");
		printf("\n# 3) Consultar Cliente pelo Nome               #");
		printf("\n# 4) Alterar Cliente                           #");
		printf("\n# 5) Excluir Cliente                           #");
		printf("\n# 0) Sair                                      #");
		printf("\n#                                              #");
		printf("\n# Opcao-> ");

		fflush(stdin);
		scanf("%i",&op);

		switch(op) {
			case 1: //Cadastrar um novo Cliente
				system("cls");
				cadastrarCliente();
			break;

			case 2: //Listar todos os Clientes
				system("cls");
				listarClientes();
			break;
			
			case 3: //Consultar Clientes pelo Nome
				system("cls");
				consultarClientePeloNome();
			break;
			
			case 4: //Alterar Clientes
				system("cls");
				alterarCliente();
			break;
			
			case 5: //Excluir Clientes
				system("cls");
				excluirCliente();
			break;
		}
	} while (op!=0);

	system("cls");
}


// funções venda
void efetuarVenda(){
	FILE *fpvenda;
  	struct reg_livro livro;
  	struct reg_cliente cliente;
  	struct reg_venda venda;
  	int codcli, codliv;
  	char opc;
	
	printf("\nDigite o Codigo da Venda: ");
	fflush(stdin); 
	scanf("%i",&venda.codigo);
	printf("\nDigite o Codigo do Cliente: ");
	fflush(stdin); 
	scanf("%i",&codcli); 

	cliente = buscarClientePeloCodigo(codcli);
	  
	if (cliente.codigo==-1){
		printf("\nCliente Nao Localizado!");
	  	return;
	}
	  
	printf("\nCodigo: %i - Nome: %s",cliente.codigo,cliente.nome);
	  
	printf("\n\nDigite o Codigo do Livro: ");
	fflush(stdin); 
	scanf("%i",&codliv); 

	livro = buscarLivroPeloCodigo(codliv);
	  
	if (livro.codigo==-1){
	  	printf("\nLivro Nao Localizado!");
	  	return;
	}
	  
	printf("\nCodigo: %i - Titulo: %s",livro.codigo,livro.titulo);  
	
	printf("\n\nConfirma Cliente e Livro(S/N)? ");
	fflush(stdin); 
	scanf("%c",&opc);
	  
	if ((opc!='s')&&(opc!='S')){
	  	printf("\nNao confirmado.");
	  	return;
	}
	  
	printf("\nDigite a Quantidade: ");
	fflush(stdin); 
	scanf("%i",&venda.qtde);
	printf("\nDigite o Desconto: R$ ");
	fflush(stdin); 
	scanf("%f",&venda.desconto);
	   
	printf("\nTotal da venda: R$ %.2f", (venda.qtde*livro.preco)-venda.desconto);
	
	printf("\n\nGravar Venda(S/N)? ");
	fflush(stdin); 
	scanf("%c",&opc);
	  
	if ((opc!='s')&&(opc!='S')){
	  	printf("\nOperacao Cancelada!");
	  	return;
	}  	
	
	venda.codcli = cliente.codigo;
	venda.codliv = livro.codigo;
	  
	fpvenda = fopen(VENDAS,"ab");
	  
	fwrite(&venda,sizeof(venda),1,fpvenda);	
	  	
	fclose(fpvenda);
	  
	printf("\nVenda registrada com sucesso.");
}

void listarVendas(){
  FILE *fpvenda;
  struct reg_venda venda;
  struct reg_livro livro;
  struct reg_cliente cliente;
  int vendaanterior;
  
  fpvenda = fopen(VENDAS,"rb");

  printf("\nRelatorio Todos as Vendas:");
  printf("\n\nVenda Cliente                        Livro                        Preco      Desc      Qtde  Cobrado\n");
  vendaanterior = -1;
  while (fread(&venda,sizeof(venda),1,fpvenda)==1){
  	livro = buscarLivroPeloCodigo(venda.codliv);
    cliente = buscarClientePeloCodigo(venda.codcli);
  
  	if (venda.codigo==vendaanterior){
  		printf("                                     ");
	  	printf("%-1.i-%-27s",venda.codliv, livro.titulo);
		printf("R$ %-8.2f", livro.preco);
		printf("R$ %-7.2f",venda.desconto);
		printf("%-6i",venda.qtde);
		printf("R$ %-8.2f", (venda.qtde*livro.preco)-venda.desconto);
		printf("\n");
	} else {
		printf("%-5.i ",venda.codigo);
		printf("%-1i-%-29s",venda.codcli, cliente.nome);
		printf("%-1.i-%-27s",venda.codliv, livro.titulo);
		printf("R$ %-8.2f", livro.preco);
		printf("R$ %-7.2f",venda.desconto);
		printf("%-6i",venda.qtde);
		printf("R$ %-8.2f", (venda.qtde*livro.preco)-venda.desconto);
		printf("\n");
	}
	
	vendaanterior = venda.codigo;
  }

  fclose(fpvenda);
}

struct reg_venda buscarVendaPeloCodigo(int codbuscar){
  FILE *fpvenda;
  struct reg_venda venda;
  int achou; 	
  
  fpvenda = fopen(VENDAS,"rb");
  
  achou=0; 
  while((achou==0)&&(fread(&venda,sizeof(venda),1,fpvenda)==1)){
  	if (venda.codigo==codbuscar){ 
	  achou=1;
	}
  }

  fclose(fpvenda);

	if(achou!=1){
   	 venda.codigo = -1;	
   } 
    
   return venda;
}

void fecharCaixa(){
	FILE *fpvenda;
	struct reg_venda venda;
	struct reg_livro livro;
	struct reg_cliente cliente;
	int codVenda;
	float total = 0;
	  
	printf("Digite o codigo da venda: ");
	fflush(stdin);
	scanf("%i", &codVenda);
	
	fpvenda = fopen(VENDAS,"rb");
	
	printf("\nVenda: %i", codVenda);
	venda = buscarVendaPeloCodigo(codVenda);
	
	cliente = buscarClientePeloCodigo(venda.codcli);
	printf("\nCliente: %s", cliente.nome);
	
	printf("\nRelatorio de fechamento de Caixa:");
	printf("\nCodigo Titulo                        Qtde. Preco      Desconto  Valor Pago\n");
	while (fread(&venda,sizeof(venda),1,fpvenda)==1){
		if(venda.codigo == codVenda){
			livro = buscarLivroPeloCodigo(venda.codliv);
			
			printf("%-7.i",venda.codliv);
			printf("%-30s", livro.titulo);
			printf("%-6i",venda.qtde);
			printf("R$ %-8.2f", livro.preco);
			printf("R$ %-7.2f",venda.desconto);
			printf("R$ %-8.2f", (venda.qtde*livro.preco)-venda.desconto);
			printf("\n");
			
			total += (venda.qtde*livro.preco)-venda.desconto;
		}
		
	  }
	  printf("\nTotal: R$ %.2f", total);
	
	fclose(fpvenda);
}

void menuVenda(){
	int op;

	do {
		printf("\n\n\n");
		printf("\n#########   Livraria Alma do Saber   ###########");
		printf("\n#########        MENU VENDAS         ###########");
		printf("\n#                                              #");
		printf("\n# 1) Cadastrar Venda                           #");
		printf("\n# 2) Listar Vendas                             #");
		printf("\n# 3) Fechar Venda Caixa                        #");
		printf("\n# 0) Sair                                      #");
		printf("\n#                                              #");
		printf("\n# Opcao-> ");

		fflush(stdin);
		scanf("%i",&op);

		switch(op) {
			case 1: //Cadastrar um novo Cliente
				system("cls");
				efetuarVenda();
			break;

			case 2: //Listar todos os Clientes
				system("cls");
				listarVendas();
			break;
				
			case 3: //Fechar Venda Caixa
				system("cls");
				fecharCaixa();
			break;
		}
	} while (op!=0);

	system("cls");
}	