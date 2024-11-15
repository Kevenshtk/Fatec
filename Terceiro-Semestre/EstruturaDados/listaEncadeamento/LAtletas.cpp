#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct no{
	char nome[30];
 	float altura; 
	struct no *prox; //Guarda o endereço do próximo nó da lista
};

struct no * inserirNoInicio(struct no *L,char nome[],float altura){
  	struct no *p;
  	
  	//Alocar espaço de memória para o novo nó
  	p = (struct no *) malloc(sizeof(struct no));
  	//Colocar a informação no novo nó
  	strcpy(p->nome,nome);
  	p->altura = altura;
  	
  	//Fazer o Encadeamento do novo nó no início da Lista
  	//O novo nó deve apontar para o primeiro nó, o qual será o segundo
  	p->prox = L;
  	//E fazer o Lista (L) apontar para o novo nó que passa a ser o Primeiro
  	L = p;  	
  	
  	return L; //Atualiza o Lista do programa Principal
  }//Fim inserirNoInicio()

void mostrarLista(struct no *L){
	struct no *p;

    if (L==NULL){
    	printf("Lista Vazia!");
    	return;
	}

    //Aponta p para o primeiro nó da Lista
    p = L;
  	
  	while (p!=NULL){
	  	//Imprimir a informação do nó apontado por p
  		printf("(%s,%1.2f)-> ",p->nome,p->altura);
  		//passar o p para o próximo nó
  		p= p->prox;
  	}	
}//Fim mostrarLista()

struct no * inserirNoFim(struct no *L, char nome[], float altura){
	struct no *n, *p;
	
	//Alocar memória para o novo nó
	n = (struct no *) malloc(sizeof(struct no));
	//inserir a informação no novo nó

  strcpy(n->nome,nome);
  n->altura = altura;
	//Colocar NULL no prox desse novo ó, pois ele será o último
	n->prox = NULL;
	
	if (L==NULL){ //caso Lista Vazia
		L=n; //Aponta L para o novo nó que será o último e também o primeiro
	}else{
		//Fazer o Encadeamento
		//Posicionar um ponteiro p no último nó
		p = L;
		while(p->prox!=NULL){
			p = p->prox; //Anda o p para o próximo nó
		}
		//colocar o endereço do novo nó no nó apontado por p
		p->prox = n;
	}
	return L;
}//Fim inserirNoFim()

int comprimento(struct no *L){
	struct no *p;
	int cont=0;
	
	p=L;
	while (p!=NULL){
		cont++;
		p = p->prox;
	}
	return cont;
}//Fim comprimento()

void exibeMaiores(struct no *L, float altmin){
	struct no *p;
	
	p = L;
	printf("\nAtletas com Altura superior a %1.2f:",altmin);
	printf("\nNome            Altura");
	while(p!=NULL){
		if (p->altura>altmin){
			printf("\n%-15s %1.2f",p->nome,p->altura);
		}
		p = p->prox;
	}
	
}//Fim exibeMaiores()

void dividirLista(struct no *LAtletas,struct no **LMaior,struct no **LMenor,float alt){
	struct no *p;
	
	p = LAtletas;
	while (p!=NULL){
		if (p->altura>alt){
			*LMaior = inserirNoFim(*LMaior,p->nome,p->altura);
		}else{
			*LMenor = inserirNoFim(*LMenor,p->nome,p->altura);
		}
		p = p->prox;
	}
	
}//Fim dividirLista()

void dividirListaInLoco(struct no *LAtletas,struct no **LMaior,struct no **LMenor,float alt){
	struct no *p,*pmenor,*pmaior;

  p = LAtletas;
  while (p!=NULL){
  	if (p->altura>alt){
  		if (*LMaior==NULL){
  			*LMaior = p; //Esse vai ser o primeiro
  			pmaior = p; //pmaior aponta para o último nó da Lista LMaior
			}else { //A lista LMaior já tem elementos
				pmaior->prox = p; //Insere no fim da LMaior
				pmaior = p; //Aponta pmaior para o último inserido na LMaior
			}
		}else{
			if (*LMenor==NULL){ 
				*LMenor = p; //Esse vai ser o primeiro
				pmenor = p; //pmenr aponta para o último nó da Lista LMaior
			}else{ //A lista LMenor já tem elementos
				pmenor->prox = p;
				pmenor = p;
			}		
		}
  	p = p->prox;
	}
	
	pmaior->prox = NULL;
	pmenor->prox = NULL;

}//Fim dividirListaInLoco()

main(){
	struct no *LAtletas,*LMaior,*LMenor; //Guarda o endereço do Primeiro nó da Lista
	int op,retorno;
	char nome[30];
	float altura;
	
	LAtletas = NULL; //Lista vazia
	LMaior = LMenor = NULL; 
	
	do{
		printf("\n\n###### Lista de Atletas ########");
		printf("\n# 1) Inserir no Inicio            #");
		printf("\n# 2) Mostrar Lista                #");
		printf("\n# 3) Inserir no Fim               #");
		printf("\n# 4) Nro de Atletas na Lista      #");
		printf("\n# 5) Exibe Maiores que uma Altura #");
		printf("\n# 6) Dividir a Lista alocando novo espaço #");
		printf("\n# 7) Dividir a Lista 'in loco'    #");
		printf("\n# 0) Sair                         #");
		
		printf("\nOpcap-> ");
		fflush(stdin); scanf("%i",&op);
		
		switch(op){
			case 1: //Inserir no Início da Lista
				printf("\nInserir No Inicio:");
				printf("\nDigite o nome do Atleta: ");
				fflush(stdin); gets(nome);
				printf("Digite a altura do Atleta: ");
				fflush(stdin); scanf("%f",&altura);
				LAtletas = inserirNoInicio(LAtletas,nome,altura);
				break;
			case 2: //Mostrar a Lista
				printf("\n\nLatletas-> ");
				mostrarLista(LAtletas);
				break;
			case 3: //Inserir no Fim da Lista
				printf("\nInserir No Fim:");
				printf("\nDigite o nome do Atleta: ");
				fflush(stdin); gets(nome);
				printf("Digite a altura do Atleta: ");
				fflush(stdin); scanf("%f",&altura);
				LAtletas = inserirNoFim(LAtletas,nome,altura);
				break;	
			case 4: //Nro de Atletas na Lista
				printf("\nNro. de Atletas: %i",comprimento(LAtletas));
				break;
			case 5: //Exibe Atletas com altura maior que uma altura mínima				
				printf("\nDigite a altura minima: ");
				fflush(stdin); scanf("%f",&altura);
				exibeMaiores(LAtletas,altura);
				break;
			case 6: //Dividir a Lista Alocando novo espaço para os nós
				printf("\nDigite a altura para dividir a Lista: ");
				fflush(stdin); scanf("%f",&altura);
				dividirLista(LAtletas,&LMaior,&LMenor,altura);
				printf("\n\nLatletas-> ");
				mostrarLista(LAtletas);
				printf("\n\nLMaior-> ");
				mostrarLista(LMaior);	
				printf("\n\nLMenor-> ");
				mostrarLista(LMenor);	
				break;
			case 7: //Dividir a Lista in loco - Sem alocar novo espaço de memória
				printf("\nDigite a altura para dividir a Lista: ");
				fflush(stdin); scanf("%f",&altura);
				dividirListaInLoco(LAtletas,&LMaior,&LMenor,altura);
				printf("\n\nLatletas-> ");
				mostrarLista(LAtletas);
				printf("\n\nLMaior-> ");
				mostrarLista(LMaior);	
				printf("\n\nLMenor-> ");
				mostrarLista(LMenor);	
				break;				
		}
	}while(op!=0);
	
}//Fim 