programa 
{
	funcao inicio()
	{
		real quilo, grama, quant1, quant2, quant_res

		escreva("Digite o peso do saco de ração em Kg: ")
		leia(quilo)
		grama = quilo * 1000
		
		escreva("\nDigite a quantidade de ração para um gato em gramas: ")
		leia(quant1)
		escreva("\nDigite a quantidade de ração para o outro gato em gramas: ")
		leia(quant2)
		quant_res = (grama - (quant1 + quant2) * 5) / 1000
		
		escreva("\n\nReatará após 5 dias "+quant_res+"Kg de ração")
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