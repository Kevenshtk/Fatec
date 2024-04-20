programa
{
	
	funcao inicio()
	{
		inteiro dia, mes, ano
		
		escreva ("Digite o dia: ")
		leia(dia)
		escreva ("Digite o mês: ")
		leia(mes)
		escreva ("Digite o ano: ")
		leia(ano)
		
		se((dia >= 1 e dia <= 31) e (mes >= 1 e mes <= 12) e (ano >= 2000 e ano <= 2022)){
			escreva ("data válida")
		} senao {
			escreva ("data inválida")
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 100; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */