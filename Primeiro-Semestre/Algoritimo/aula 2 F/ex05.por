programa 
{
	funcao inicio()
	{
		cadeia nome_auto
		real preco_fab, preco_imp, comissao, preco_final

		escreva("Digite o nome do automovel\n")
		leia(nome_auto)
		escreva("Informe o preço de fabrica R$")
		leia(preco_fab)

		preco_imp = preco_fab * 0.45
		comissao = preco_fab * 0.28
		preco_final = preco_fab + preco_imp + comissao

		escreva("\nO preço final do(a) "+nome_auto+" é R$"+preco_final)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 242; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */