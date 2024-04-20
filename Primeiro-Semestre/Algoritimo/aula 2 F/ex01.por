programa 
{
	funcao inicio()
	{
		real quant_qw, valor_qw, valor_sal, valor_total, valor_des
		
		escreva("Informe o salário mínimo: R$")
		leia(valor_sal)
		escreva("Informe a quantidade de quilowatts gasto ")
		leia(quant_qw)
		
		valor_qw = valor_sal / 5
		valor_total = valor_qw * quant_qw
		valor_des = valor_total - (valor_total * 0.15)
		
		escreva("\nO valor de cada quilowatt é R$:"+valor_qw)
		escreva("\nO valor a ser pago é R$:"+valor_total)
		escreva("\nO valor a ser pago com desconto de 15% é R$"+valor_des)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 528; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */