programa
{
	
	funcao inicio()
	{
	real num_1, num_2, result
	caracter op, opt = 's'
	
		escreva("CALCULADORA\n\n")

		enquanto(opt == 's'){
			escreva("Informe o primeiro número: ")
			leia(num_1)
			escreva("Informe a operação (+) - Adição | (-) - Subtração | (*) - Multiplicação | (/) - Adição: ")
			leia(op)
			escreva("Informe o segundo número: ")
			leia(num_2)

			escolha(op){
				caso '+':
					result = num_1 + num_2
					escreva(num_1+" + "+num_2+" = "+result)
					escreva("\n\nDeseja realizar outra operação s/n: \n")
					leia(opt)
				pare

				caso '-':
					result = num_1 - num_2
					escreva(num_1+" - "+num_2+" = "+result)
					escreva("\n\nDeseja realizar outra operação s/n: \n")
					leia(opt)
				pare

				caso '*':
					result = num_1 * num_2
					escreva(num_1+" x "+num_2+" = "+result)
					escreva("\n\nDeseja realizar outra operação s/n: \n")
					leia(opt)
				pare

				caso '/':
					se(num_1 == 0){
						escreva("Dividendo = 0, informe outro dividendo diferente de 0: ")
						leia(num_1)
						result = num_1 / num_2
						escreva(num_1+" / "+num_2+" = "+result)
						escreva("\n\nDeseja realizar outra operação s/n: \n")
						leia(opt)
				
					} senao {
						result = num_1 / num_2
						escreva(num_1+" / "+num_2+" = "+result)
						escreva("\n\nDeseja realizar outra operação s/n: \n")
						leia(opt)
					}
				pare

				caso contrario:
					escreva("\n\nOperação inválida\n")	
				pare
			}
		}

		escreva("\n\nFim.")
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1437; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */