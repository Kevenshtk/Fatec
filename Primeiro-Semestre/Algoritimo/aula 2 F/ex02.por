programa 
{
	funcao inicio()
	{
		cadeia nome[2]
		real valor_p[2]
		inteiro x = 0
		real total_comp, total_des
		
		enquanto(x < 2){
			escreva("\nDigite o nome do produto\n")
			leia(nome[x])
			escreva("\nDigite o valor do produto\n")
			leia(valor_p[x])
			x++
		}
		
		total_comp = valor_p[0] + valor_p[1]
		total_des = total_comp - (total_comp * 0.20)
		
		escreva("\nO produto 1, "+nome[0]+", seu valor é R$:"+valor_p[0])
		escreva("\nO produto 2, "+nome[1]+", seu valor é R$:"+valor_p[1])
		escreva("\nO valor da compra é R$"+total_comp+" com o desconto fica R$"+total_des)
		
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 464; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */