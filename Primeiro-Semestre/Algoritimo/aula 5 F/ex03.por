programa
{
	funcao inicio ()
	{
		inteiro num_p = 0, idade
		cadeia opt = "s"

		escreva("Quantidade de pessoas entre 15 e 24 anos\n\n")
		enquanto(opt == "s"){
			escreva("\nInforme a idade da pessoa: ")
			leia(idade)
			
			se(idade > 15 e idade < 24){
				num_p = num_p + 1
			}
			
			escreva("\nDeseja continuar s/n: ")
			leia(opt)
		}
		
		escreva("O numero de pessoas entre 15 e 24 anos e "+num_p)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 411; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */