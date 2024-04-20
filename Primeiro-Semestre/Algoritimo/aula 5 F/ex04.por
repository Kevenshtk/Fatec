programa 
{
	funcao inicio()
	{
		real media = 0
		inteiro num, cont = 0
		caracter opt = 's'

		escreva("Algoritmo que calcula a média\n\n")
		
		faca{
			escreva("Infome um número: ")
			leia(num)
			
			media = media + num
			cont++
			
			escreva("Deseja continuar S/N ")
			leia(opt)
			
		} enquanto (opt == 's' ou opt == 'S')
		
		media = media / cont
		escreva("a media dos números digitados é "+media)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 415; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */