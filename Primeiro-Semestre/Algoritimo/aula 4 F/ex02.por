programa 
{
	funcao inicio()
	{
		inteiro idade, ano_nas
		
		escreva("Digite seu ano de nascimento\n")
		leia(ano_nas)
		
		idade = 2023 - ano_nas
		
		se(idade >= 16){
			se(idade >= 18){
				
				escreva("Você tem "+idade+" anos pode votar e ter CNH")
				
			} senao{
				
				escreva("Você tem "+idade+" anos pode votar")
			}
			
		} senao {
			
			escreva("Você tem "+idade+" anos apenas")
		
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 408; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */