#include <stdio.h>
#include <stdlib.h>

struct no{
	int info;
	struct no *prox;
};

struct no * inserirNoInicio(struct no *L, int v){
  	struct no *p;
  	//alocar espaço de memória para o novo nó
  	p = (struct no *) malloc(sizeof(struct no));
  	
  	//colocar a informação no novo nó
  	p->info = v;
  	
  	//fazer o encadeiamento do novo nó no início da lista
  	// o novo nó deve apontar para o primeiro nó, o qual será o segundo
  	p->prox = L;
  	
  	//fazer o Lista (L) apontar para o novo nó que passa a ser o Primeiro
  	L = p;
  	
  	return L; // retorna a lista atualizada
}

void mostrarLista(struct no *L){
	struct no *p;
	
	if(L == NULL){
		printf("Lista vazia!");
		return;
	}
	
	// aponta p para o primeiro nó da Lista
	p = L;
		
	while(p != NULL){
		printf("%i-> ", p->info);
		
		// passar o p para o próximo nó
		p = p->prox;
	}
}

struct no * inserirNoFim(struct no *L, int v){
	struct no *n, *p;
	
 	// alocar memória para o novo nó
 	n = (struct no *) malloc(sizeof(struct no));
 	
 	// inserir a informação no novo nó
 	n->info = v;
 	
 	// colocar NULL no prox donovo nó
 	n->prox = NULL;
 	
 	if(L == NULL){ // caso lista vazia
 		L = n; // aponta o L para o novo nó que será o ultimo
	 } else {
	 	// fazer o encadeamento
	 	// posicionar um ponteirop no ultimo nó
	 	p = L;
	 	while(p->prox != NULL){
	 		p = p->prox; // anda o p para o próximo nó
		 }
	 	
	 	// colocar o endereço do novo nó no nó apontado por p
	 	p->prox = n;
	 }
 	
 	return L;
}

struct no * removerInicio(struct no *L, int *v){
	struct no *p;
	
	// colocar a informação do nó a ser removido no v
	*v = L->info;
	
	// fazer o encadeamento
	// guardar o endereço do primeiro nó em p
	p = L;
	
	// fazer o L apontar para o segundo nó, que vai passa a ser o primeiro
	L = L->prox;
	
	// remover/deslocar a memória do nó sendo removido
	free(p);
	
	return L;
}

struct no * removerFim(struct no *L, int *v){
	struct no *p, *q;
	
	// encontrar o ultimo nó d lista
	p = L;
	while(p->prox != NULL){
		p = p->prox;
	}
	//colocar a informação do nó a ser removido em v
	*v = p->info;
	
	// caso especial - lista só tem 1 nó
	if(L->prox == NULL){
		L = NULL;
	} else {
		// posicionar um outro ponteiro q antes do p
		q = L;
		while(q->prox !=p){
			q = q->prox;
		}
		// coloca NULL no prox no nó apontado por q
		q->prox = NULL;
	}

	// remover/deslocar a memória do nó sendo removido
	free(p);
	
	return L;
}

int comprimento(struct no *L){
	struct no *p;
	int cont = 0;
	
	if(L == NULL){
		return 0;
	}
	
	p = L;
		
	while(p != NULL){
		cont++;
		p = p->prox;
	}
	
	return cont;
}

int existe(struct no *L, int v){
	struct no *p;
	
	p = L;
		
	while(p != NULL){
		if(p->info == v){
		return 1;
	}
		p = p->prox;
	}
	
	return 0;
}

struct no * inserirOrdemCrescente(struct no *L, int v){
	struct no *n, *p, *q;
	
	n = (struct no *) malloc(sizeof(struct no));
	n->info = v;
	
	if (L==NULL){ //Lista Vazia
		n->prox = NULL;
		L=n;
		return L;
	}
	
	if (L->info >= v){ //Inserir no inicio
		n->prox = L;
		L = n;
		return L;
	}
	
	//Localizar a posição a ser inserido o novo nó
	p = L;
	while((p->prox!=NULL)&&(p->info<v)){
		p = p->prox;
	}
	if ((p->prox==NULL)&&(v>=p->info)){ //Inserir o novo nó no fim
		p->prox = n;
		n->prox = NULL;
	}else{
		//Posicionar q no nó anterior ao p
		q=L;
		while(q->prox!=p){
			q=q->prox;
		}
		//Fazer o encadeamento
		q->prox = n;
		n->prox=p;
	}
	return L;
	
}

int iguais(struct no *L1, struct no *L2){
 	struct no *p1, *p2;
	
	//Verificar se tem o mesmo comprimento
	if (comprimento(L1)!=comprimento(L2)){
		return 0; //Listas diferentes
	}
	
	//Verificar o valor em cada nó correspondente
	p1 = L1;
	p2 = L2;
	
	while ((p1!=NULL)&&(p1->info==p2->info)){
		p1=p1->prox;
		p2=p2->prox;
	}
	
	if (p1==NULL){ //atingiu o final das duas listas
		return 1;
	}else{
		return 0; //Achou um posição com valores diferentes
	}
 }

main(){
	struct no *Lista; // guarda o endereço do Primeiro nó da lista
	struct no *L1, *L2;
	int op, opl, val, retorno;
	
	Lista = NULL; // lista vazia
	L1 = NULL;
	L2 = NULL;
	
	do{
		printf("\n\nLista Encadeada");
		printf("\n 1) Inserir no Inicio");
		printf("\n 2) Mostrar Lista");
		printf("\n 3) Inserir no Fim");
		printf("\n 4) Remover do Inicio");
		printf("\n 5) Remover do Fim");
		printf("\n 6) Comprimento da Lista");
		printf("\n 7) Buscar valor");
		printf("\n 8) Inserir por ordem crescente");
		printf("\n 9) Verificar listas iguais");
		printf("\n 0) Sair");
		
		printf("\nOpcao-> ");
		fflush(stdin);
		scanf("%i", &op);
		
		switch(op){
			case 1:
				printf("\nInserir no inicio");
				printf("\nInforme o valor: ");
				fflush(stdin);
				scanf("%i", &val);
				printf("Escolha Lista (0-Lista, 1-L1, 2-L2): ");
				fflush(stdin);
				scanf("%i", &opl);
				
				if (opl == 0){
					printf("oi");
					Lista = inserirNoInicio(Lista,val);
				}else if (opl == 1){
					L1 = inserirNoInicio(L1,val);
				}else if (opl == 2){
					L2 = inserirNoInicio(L2,val);
				}else {
					printf("\nLista Invalida!");
				}
			break;
			
			case 2:
				printf("\n\nLista-> ");
				mostrarLista(Lista);
				
				printf("\n\nL1-> ");
				mostrarLista(L1);
				
				printf("\n\nL2-> ");
				mostrarLista(L2);
			break;
			
			case 3:
				printf("\nInserir No Fim");
				printf("\nInforme o valor: ");
				fflush(stdin);
				scanf("%i", &val);
					
				printf("Escolha Lista (0-Lista, 1-L1, 2-L2): ");
				fflush(stdin);
				scanf("%i", &opl);
				
				if (opl == 0){
					Lista = inserirNoFim(Lista, val);
				}else if (opl == 1){
					L1 = inserirNoFim(L1, val);
				}else if (opl == 2){
					L2 = inserirNoFim(L2, val);
				}else {
					printf("\nLista Invalida!");
				}
			break;
			
			case 4:
				printf("\nRemover o no do Inicio");
				printf("Escolha Lista (0-Lista, 1-L1, 2-L2): ");
				fflush(stdin);
				scanf("%i", &opl);
				
				if(opl == 0){
					if(Lista == NULL){
						printf("\nLista vazia. Impossivel remover");
					} else {
						Lista = removerInicio(Lista, &val);
						printf("\nInformacao do no removido: %i", val);
					}
				} else if(opl == 1){
					if(L1 == NULL){
						printf("\nLista vazia. Impossivel remover");
					} else {
						L1 = removerInicio(L1, &val);
						printf("\nInformacao do no removido: %i", val);
					}	
				} else if(opl == 2){
					if(L2 == NULL){
						printf("\nLista vazia. Impossivel remover");
					} else {
						Lista = removerInicio(L2, &val);
						printf("\nInformacao do no removido: %i", val);
					}	
				}
			break;
			
			case 5:
				printf("\nRemover o no do Fim");
				printf("Escolha Lista (0-Lista, 1-L1, 2-L2): ");
				fflush(stdin);
				scanf("%i", &opl);
				
					if(opl == 0){
					if(Lista == NULL){
						printf("\nLista vazia. Impossivel remover");
					} else {
						Lista = removerFim(Lista, &val);
						printf("\nInformacao do no removido: %i", val);
					}
				} else if(opl == 1){
					if(L1 == NULL){
						printf("\nLista vazia. Impossivel remover");
					} else {
						L1 = removerFim(L1, &val);
						printf("\nInformacao do no removido: %i", val);
					}	
				} else if(opl == 2){
					if(L2 == NULL){
						printf("\nLista vazia. Impossivel remover");
					} else {
						Lista = removerFim(L2, &val);
						printf("\nInformacao do no removido: %i", val);
					}	
				}
			break;
			
			case 6:
				printf("\nComprimento da Lista");
				printf("\nQuantidade de elementos da lista: %i", comprimento(Lista));
				printf("\nQuantidade de elementos da L1: %i", comprimento(L1));
				printf("\nQuantidade de elementos da L2: %i", comprimento(L2));
			break;
			
			case 7:
				printf("\nDigite o valor a ser verificado: ");
				fflush(stdin); 
				scanf("%i",&val);
				retorno = existe(Lista,val);
				
				if (retorno){
					printf("\nO valor %i existe na lista Lista.",val);
				}else{
					printf("\nO valor %i NAO existe na lista Lista.",val);
				}
				
				retorno = existe(L1,val);
				
				if (retorno){
					printf("\nO valor %i existe na lista L1.",val);
				}else{
					printf("\nO valor %i NAO existe na lista L1.",val);
				}	
				
				retorno = existe(L2,val);
				
				if (retorno){
					printf("\nO valor %i existe na lista L2.",val);
				}else{
					printf("\nO valor %i NAO existe na lista L2.",val);
				}
			break;
			
			case 8:
				printf("\nDigite o valor a ser inserido: ");
				fflush(stdin);
				scanf("%i",&val);
				printf("Escolha a Lista(0-Lista, 1-L1, 2-L2): ");
				fflush(stdin);
				scanf("%i",&opl);
				if (opl==0){
					Lista = inserirOrdemCrescente(Lista,val);
				}else if (opl==1){
					L1 = inserirOrdemCrescente(L1,val);
				}else if (opl==2){
					L2 = inserirOrdemCrescente(L2,val);
				}else {
					printf("\nLista Invalida!");
				}
			break;
			
			case 9:
				retorno = iguais(L1,L2);
				if (retorno){
					printf("\nL1 IGUAL a L2");
				}else{
					printf("\nL1 DIFERENTE de L2");
				}
			break;
		}
		
	} while(op !=0);
}