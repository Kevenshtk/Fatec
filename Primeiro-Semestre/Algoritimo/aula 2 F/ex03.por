programa 
{
	funcao inicio()
	{
		real width, height, area, quant, lata

		escreva("Informe a largura da parede em metros\n")
		leia(width)
		escreva("\nInforme a altura da parede em metros\n")
		leia(height)
		
		area = width * height
		quant = area * 3
		lata = quant / 2
		
		escreva("\nSerão necessárias "+lata+" latas para pintar a parede")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 350; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */