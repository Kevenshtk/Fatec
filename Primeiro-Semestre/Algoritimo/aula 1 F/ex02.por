programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{

		real l1, l2, hipo

		escreva("Algoritmo que calcula a hipotenusa de um triângulo\n\n")
		
		escreva("Informe o primeiro lado do triângulo: ")
		leia(l1)
		escreva("\nInforme o segundo lado do triângulo: ")
		leia(l2)
		hipo = mat.raiz(l1 * l1 + l2 * l2, 2.0)
		escreva("\nA hipotenusa é: "+hipo)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 296; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */