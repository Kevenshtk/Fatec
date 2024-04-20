programa
{
	
	funcao inicio()
	{
		real saldo_apli, taxa_juro, valor_ren, valor_total

		escreva("Algoritmo que calcula o valor do rendimento e o valor total depois do rendimento\n\n")
		
		escreva("Digite o saldo de uma aplicação: ")
		leia(saldo_apli)
		escreva("\nDigite o valor da taxa de juros: ")
		leia(taxa_juro)
		valor_ren = saldo_apli * (taxa_juro / 100)
		valor_total = saldo_apli + valor_ren
		escreva("\nO valor do rendimento é: "+valor_ren+"\n")
		escreva("\nO valor total depois do rendimento é: "+valor_total)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 186; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */