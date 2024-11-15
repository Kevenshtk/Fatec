#include <stdio.h>
#include <stdlib.h>

struct no{
	int info;
	struct no *prox;
};

void push(struct no **Pilha,int v){
  	struct no *p;
  	
  	p = (struct no *) malloc(sizeof(struct no));
  	p->info = v;
  	p->prox = *Pilha;
  	
  	*Pilha = p;  	
}

int pop(struct no **Pilha){
	struct no *p;
	int v;
	
	v = (*Pilha)->info;
	p = *Pilha;

	*Pilha = p->prox;
	free(p);

	return v;
}

void mostrarPilha(struct no **Pilha){
	struct no *PAux=NULL;
	int val;

    if (*Pilha==NULL){
    	printf("Pilha Vazia!");
    	return;
		}

		val = pop(Pilha);
	    printf("\n        %i",val);
	    push(&PAux,val);
	  	
	  	while (*Pilha!=NULL){
				val = pop(Pilha);
		    printf("\n        %i",val);
	 		  push(&PAux,val);
	  	}
  	 
		while (PAux!=NULL) {
			val = pop(&PAux);
			push(Pilha,val);
		}	
  	  	  	  	
}

struct no * inserirNoFim(struct no *L, int v){
  	struct no *n, *p;
	
 	n = (struct no *) malloc(sizeof(struct no));
 	n->info = v;
 	n->prox = NULL;
 	
 	if(L == NULL){
 		L = n;
	 } else {
	 	p = L;
	 	while(p->prox != NULL){
	 		p = p->prox;
		 }
	
	 	p->prox = n;
	 }
 	
 	return L;
}

struct no * removerFim(struct no *L, int *v){
	struct no *p, *q;
	
	p = L;
	while(p->prox != NULL){
		p = p->prox;
	}

	*v = p->info;
	
	if(L->prox == NULL){
		L = NULL;
	} else {
		q = L;
		while(q->prox !=p){
			q = q->prox;
		}
		q->prox = NULL;
	}

	free(p);
	
	return L;
}

void mostrarLista(struct no *L){
	struct no *p;
	
	if(L == NULL){
		printf("Lista vazia!");
		return;
	}
	
	p = L;
		
	while(p != NULL){
		printf("%i-> ", p->info);
		
		p = p->prox;
	}
}

int removerMaiorDaPilha(struct no **Pilha) {
	struct no *PAux = NULL;
	int val, maior;
	
	val = pop(Pilha);
	push(&PAux, val);
	maior = val;
	
	while(*Pilha!=NULL) {
		val = pop(Pilha);
		push(&PAux, val);
		if(maior < val) {
			maior = val;
		}
	}
	
	while(PAux!=NULL) {
		val = pop(&PAux);
		if(val != maior) {
			push(Pilha, val);
		}	
	}
	
	return maior;
}

void invertePilhaUsandoLista(struct no **Pilha) {
   	struct no *aux = NULL;
    int val;

    while (*Pilha != NULL) {
        val = pop(Pilha);
        aux = inserirNoFim(aux, val);
    }

    while (aux != NULL) {
        val = aux->info;
        push(Pilha, val);
        aux = aux->prox;
    }
    
    mostrarPilha(Pilha);
}

void clonaImparLista(struct no *L) {
    struct no *p = L, *newNode;

    while (p != NULL) {
        if (p->info % 2 != 0) {
            newNode = (struct no *)malloc(sizeof(struct no));
            newNode->info = p->info;
            newNode->prox = p->prox;
            p->prox = newNode;
            p = newNode->prox;
        } else {
            p = p->prox;
        }
    }
}

void removeRepetidos(struct no *L) {
    struct no *p, *prev, *q, *prevQ;

    if (L == NULL) return;

    p = L;
    while (p != NULL && p->prox != NULL) {
        prev = p;
        q = p->prox;
        prevQ = p;

        while (q != NULL) {
            if (p->info == q->info) {
                prevQ->prox = q->prox;
                free(q);
                q = prevQ->prox;
                
            } else {
                prevQ = q;
                q = q->prox;
            }
        }

        p = p->prox;
    }
}

main(){
	struct no *Pilha;
	struct no *Lista;
	int op,val;
	
	Pilha = NULL;
	Lista = NULL;
	
	do{
		printf("\n\n########   TRABALHO  ################");
		printf("\n# 1) Inserir na pilha (push)            #");
		printf("\n# 2) Remover da pilha (pop)             #");
		printf("\n# 3) Mostrar pilha                      #");
		printf("\n# 4) Inserir do fim da lista            #");
		printf("\n# 5) Remover do fim da lista            #");
		printf("\n# 6) Mostrar lista                      #");
		printf("\n# 7) Remover maior numero da pilha      #");
		printf("\n# 8) Inverte pilha usando lista         #");
		printf("\n# 9) Clona numero impar lista           #");
		printf("\n# 10) Remove numeros repetidos lista    #");
		printf("\n# 0) Sair                               #");
		
		printf("\nOpcao-> ");
		fflush(stdin); 
		scanf("%i",&op);
		
		switch(op){
			case 1:
				printf("\nInserir na Pilha:");
				printf("\nDigite o valor: ");
				fflush(stdin);
				scanf("%i",&val);
				push(&Pilha,val);
				system("cls");
			break;
			
			case 2:
				printf("\nRemover da Pilha:");
				if (Pilha==NULL){
					printf("\nPilha Vazia. Impossivel remover!\n");
				}else{
					val = pop(&Pilha);
					printf("\nInformacao do no removido: %i\n",val);
				}
				system("pause");
				system("cls");
			break;
				
			case 3:
				printf("\n\nPilha-> ");
				mostrarPilha(&Pilha);
				printf("\n");
				system("pause");
				system("cls");
			break;
			
			case 4:
				printf("\nInserir no fim");
				printf("\nInforme o valor: ");
				fflush(stdin);
				scanf("%i", &val);
				Lista = inserirNoFim(Lista,val);
				system("cls");
			break;
			
			case 5:
				printf("\nRemover do fim");
				if(Lista == NULL){
					printf("\nLista vazia. Impossivel remover\n");
				} else {
					Lista = removerFim(Lista, &val);
					printf("\nInformacao do no removido: %i\n", val);
				}
				system("pause");
				system("cls");
			break;
			
			case 6:
				printf("\n\nLista-> ");
				mostrarLista(Lista);
				printf("\n");
				system("pause");
				system("cls");
			break;
			
			case 7:
				printf("\nRemover maior numero da Pilha:");
                val = removerMaiorDaPilha(&Pilha);
                if (val != -1) {
                    printf("\nMaior numero removido: %i\n", val);
                }
                system("pause");
				system("cls");
			break;
			
			case 8:
				printf("\nInverter Pilha Usando Lista:\n");
                invertePilhaUsandoLista(&Pilha);
                printf("\nPilha invertida!\n");
                system("pause");
				system("cls");
			break;
			
			case 9:
				 printf("\nClonando numeros impares na Lista:");
                clonaImparLista(Lista);
                printf("\nLista com numeros impares clonados!\n");
                system("pause");
				system("cls");
			break;
			
			case 10:
                printf("\nRemover valores repetidos na Lista:");
                removeRepetidos(Lista);
                printf("\nValores repetidos removidos!\n");
                system("pause");
				system("cls");
            break;
		}
		
	}while(op!=0);
}