programa
{
	funcao inicio ()
	{
		inteiro num, guard
		caracter opt = 's'

		escreva("Programa que guarda o menor número digitado\n\n")
		
		faca{
			escreva("Digite um  numero: ")
			leia(num)
			
			se(num < guard){
				guard = num
			}
			
			escreva("Deseja continuar s/n: ")
			leia(opt)
		} enquanto (opt == 's')
		
		escreva("O menor numero e: "+guard)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 133; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */