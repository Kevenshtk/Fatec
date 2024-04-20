programa
{
	funcao inicio ()
	{
		real altura, peso
		caracter sexo
		
		escreva("Informe sua altura\n")
		leia(altura)
		escreva("Informe seu sexo M-masculino, F-feminino\n")
		leia(sexo)
		
		se(sexo == 'M' ou sexo == 'm'){
			peso = 72.7 * altura - 58
			escreva("Seu peso ideal e "+peso)
				
		} senao se(sexo == 'F' ou sexo == 'f'){
			peso = 62.1 * altura - 44.7
			escreva("Seu peso ideal e "+peso)
				
		} senao {
			escreva("opção invalida")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 0; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */