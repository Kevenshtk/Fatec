programa
{
	funcao inicio ()
	{
		caracter sexo, opt = 's'
		cadeia olhos, cabelo
		inteiro idade, guard_i = 0
		real num_p_total, num_p_pesquisa, result
		
		escreva("PESQUISA\n\n")

		enquanto(opt == 's'){
			escreva("\nInforme o sexo (m - masculino | f - feminino): ")
			leia(sexo)
			escreva("\nInfomer a cor dos olhos (azuis, verdes, castanhos e pretos): ")
			leia(olhos)
			escreva("\nInforme a cor dos cabelos (loiros, castanhos e pretos): ")
			leia(cabelo)
			escreva("\nInforme a idade: ")
			leia(idade)
			num_p_total++
			
			se (idade > guard_i){
				guard_i = idade
			}

			se((sexo == 'f' e olhos == "verdes" e cabelo == "loiros") e (idade > 18 e idade < 35)){
				num_p_pesquisa++
			}
			escreva("\nDeseja continuar s - sim | n - não: ")
			leia(opt)
		}

		result = (num_p_pesquisa / num_p_total) * 100

		escreva(num_p_total)
		escreva(num_p_pesquisa)
		escreva("\nA maior idade dos habitantes é: "+guard_i+"\n")
		escreva("\nA porcentagem de pessoas do sexo feminino cuja\n"+ 
		"idade está entre 18 e 35 anos, tem olhos verdes e cabelos louros é : "+result+" %\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 110; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */