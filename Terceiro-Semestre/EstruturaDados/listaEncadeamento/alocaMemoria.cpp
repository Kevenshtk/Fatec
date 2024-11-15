#include <stdio.h> 
#include <stdlib.h> 

struct no { 
	int val; 
 	struct no *prox; 
}; 

void main() { 
 struct no *p, *q; 
 p = (struct no *) malloc(sizeof(struct no)); // converte malloc para ponteiro de nó 
 q = (struct no *) malloc(sizeof(struct no));  // malloc pega quantos bytes da strunc nó
 
 if ((p==NULL) || (q==NULL)) { 
 	printf("\nErro de Alocacao Memoria!\n"); 
 	exit(0); 
 } 
 
 p->val = 10; 
 p->prox = q; // armazena o endereço do proximo nó
 q->val = 20; 
 q->prox = NULL;
  
 printf("%d %d %d", p->val, q->val, p->prox->val);
 free(p); // libera a memória 
 free(q); 
}//Fim main