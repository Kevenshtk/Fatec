#include <stdio.h>
#include <stdlib.h>

struct no{
	int info; //Guarda a informação
	struct no *prox; //Guarda o endereço do próximo nó da Pilha
};

void push(struct no **Pilha,int v){
  	struct no *p;
  	
  	//Alocar espaço de memória para o novo nó
  	p = (struct no *) malloc(sizeof(struct no));
  	//Colocar a informação no novo nó
  	p->info = v;
  	
  	//Fazer o Encadeamento do novo nó no início da Lista (Pilha)
  	//O novo nó deve apontar para o primeiro nó, o qual será o segundo
  	p->prox = *Pilha;
  	//E fazer o Pilha apontar para o novo nó que passa a ser o Primeiro
  	*Pilha = p;  	
}//Fim push()

int pop(struct no **Pilha){
	struct no *p;
	int v;
	
	//Colocar a informacao do nó a ser removido no v
	v = (*Pilha)->info;
	
	//Fazer o Encadeamento
	//Guardar o endereço do primeiro nó em p
	p = *Pilha;
	//Fazer o Pilha apontar para o segundo nó, que passa a ser o primeiro
	*Pilha = p->prox;
	//Remover/Desalocar a memória do nó sendo removido
	free(p);

	return v; //retorna a informação do nó removido
}//Fim pop()

void mostrarPilha(struct no **Pilha){
	struct no *PAux=NULL; //Pilha Auxiliar
	int val;

    if (*Pilha==NULL){
    	printf("Pilha Vazia!");
    	return;
		}

		val = pop(Pilha);	//retirei o primeiro da Pilha Original
    printf("%i",val);
    push(&PAux,val); //Guardei na Pilha Auxiliar
  	
  	while (*Pilha!=NULL){
			val = pop(Pilha);	//retira da Pilha Original
	    printf("\n        %i",val);
 		  push(&PAux,val); //Guardei na Pilha Auxiliar
  	}
  	 
		//Remover da Pilha Auxiliar e colocar na Pilha Original
		while (PAux!=NULL) {
			val = pop(&PAux); //Retira da Pilha Auxiliar
			push(Pilha,val);  //Coloca na Pilha Original
		}	
  	  	  	  	
}//Fim mostrarLista()

int qtdeMaiorQueMedia(struct no **Pilha){
	struct no *PAux=NULL; //Pilha Auxiliar
	int val, cont=0, soma=0;
	float media;
	
    if (*Pilha==NULL){
    	return 0;
		}
  	
  	while (*Pilha!=NULL){
			val = pop(Pilha);	//retira da Pilha Original
	    soma = soma + val;
	    cont++;
 		  push(&PAux,val); //Guardei na Pilha Auxiliar
  	}
  	 
  	media = (float)soma/cont; 
  	
  	cont=0;
		//Remover da Pilha Auxiliar e colocar na Pilha Original
		while (PAux!=NULL) {
			val = pop(&PAux); //Retira da Pilha Auxiliar
			if (val>media){ //maior que a média
				cont++; 
			}
			push(Pilha,val);  //Coloca na Pilha Original
		}	
  		
  	return cont;	
}//Fim qtdeMaiorQueMedia()

int localizaValorPilha(struct no **Pilha, int procurado){
	struct no *Paux=NULL;
	int posicao=0, achou=0,val;
	
	//Retirar da Pilha Original e colocar na Pilha auxiliar
	//enquanto não encontrar ou chegar no fim da Pilha
	while((!achou)&&(*Pilha!=NULL)){
		val = pop(Pilha);  //Retira da Pilha original
		posicao++;  //Incrementa a posição
		push(&Paux,val); //Guarda na Pilha Auxiliar
		if (val==procurado){
			achou=1;  //Encontrou
		}
	}
	
	//Voltar valores na Pilha auxiliar para a Pilha original
	while(Paux!=NULL){
		val=pop(&Paux); //Remove da Pilha Auxiliar
		push(Pilha,val); //Volta para a Pilha Original
	}	
	
	//Se encontrou retorna a posição
	if (achou!=0){
		return posicao;
	}else{ //Se não encontrou retorna 0
		return 0;
	}
	
}//Fim localizaValorPilha()

int contarItensPilha(struct no **Pilha){
	struct no *Paux=NULL;
	int contador=0, val;
	
	//Retirar da Pilha Original e colocar na Pilha auxiliar
	//enquanto não encontrar ou chegar no fim da Pilha
	while(*Pilha!=NULL){
		val = pop(Pilha);
		contador++;
		push(&Paux,val);
	}
	
	//Voltar valores na Pilha auxiliar para a Pilha original
	while(Paux!=NULL){
		val=pop(&Paux);
		push(Pilha,val);
	}	
	
	return contador;
	
}

main(){
	struct no *Pilha; //Guarda o endereço do Topo da Pilha
	int op,val,retorno;
	
	Pilha = NULL; //Lista vazia
	
	do{
		printf("\n\n########   P i l h a   ################");
		printf("\n# 1) Inserir na Pilha (push)            #");
		printf("\n# 2) Mostrar Pilha                      #");
		printf("\n# 3) Remover da Pilha (pop)             #");
		printf("\n# 4) Qtde maior que a Media na Pilha    #");
		printf("\n# 5) Verifica se um valor esta na Pilha #");
		printf("\n# 6) Verifica o tamanho da Pilha        #");
		printf("\n# 0) Sair                               #");
		
		printf("\nOpcao-> ");
		fflush(stdin); scanf("%i",&op);
		
		switch(op){
			case 1: //Inserir na Pilha - push()
				printf("\nInserir N Pilha:");
				printf("\nDigite o valor: ");
				fflush(stdin); scanf("%i",&val);
				push(&Pilha,val);
				break;
			case 2: //Mostrar a Pilha
				printf("\n\nPilha-> ");
				mostrarPilha(&Pilha);
				break;
			case 3: //Remover da Pilha - pop() 
				printf("\nRemover da Pilha:");
				if (Pilha==NULL){//Pilha vazia
					printf("\nPilha Vazia. Impossivel remover!");
				}else{
					val = pop(&Pilha);
					printf("\nInformacao do no removido: %i",val);
				}
				break;
			case 4: //Mostra qtde de elementos maiores que a Média
				printf("\nQtde elementos Maiores que a media: %i",qtdeMaiorQueMedia(&Pilha));
				break;
			case 5: //Verifica se um valor está na Pilha
				printf("\nDigite o valor a ser localizado: ");
				fflush(stdin); scanf("%i",&val);
				retorno = localizaValorPilha(&Pilha,val);
				if (retorno==0){
					printf("\nO valor %i NAO foi localizado na Pilha!",val);
				}else{
					printf("\nO valor %i foi localizado na posicao %i da Pilha.",val,retorno);
				}
				break;
			case 6:
				printf("\nQuantidade de iens da pilha: ");
				retorno = contarItensPilha(&Pilha);

				printf("\nA pilha possui %i item(s)!",retorno);

				break;
				
		}
	}while(op!=0);
	
}//Fim 				