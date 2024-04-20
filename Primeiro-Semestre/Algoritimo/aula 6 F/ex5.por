programa
{
	
	funcao inicio()
	{
		inteiro op
		real valor_compra, valor_avista = 0, valor_aprazo = 0, total_compras, primeira_parcela = 0

		para(inteiro cont = 1; cont <= 25; cont++){
			escreva("Informe a forma de pagamento:\n\n")
			escreva("1 - À vista\n")
			escreva("2 - À prazo\n\n")
			leia(op)

			se(op > 2){
				escreva("\n\nForma de pagamento inválida\n\n")
				escreva("Informe a forma de pagamento:\n\n")
				escreva("1 - À vista\n")
				escreva("2 - À prazo\n\n")
				leia(op)
			}
			
			escolha(op){
				
				caso 1:
					escreva("\nInforme o valor da compra: $ ")
					leia(valor_compra)
					escreva("Código da transação: "+cont+"\n")
					
					valor_avista = valor_avista + valor_compra
				pare

				caso 2:
					escreva("\nInforme o valor da compra: $ ")
					leia(valor_compra)
					escreva("Código da transação: "+cont)
					
					valor_aprazo = valor_aprazo + valor_compra
					valor_compra = valor_compra / 3
					primeira_parcela = primeira_parcela + valor_compra
					
					escreva("\nSua compra ficou em 3x de $ "+valor_compra+"\n\n")
				pare
			}
		}
		
		total_compras = valor_avista + valor_aprazo
		
		escreva("\n\nValor total das compras à vista é: $ "+valor_avista)
		escreva("\nValor total das compras a prazo é: $ "+valor_aprazo)
		escreva("\nValor total das compras efetuadas é: $ "+total_compras)
		escreva("\nValor a receber pelas compras a prazo, isto é, primeira parcela: $ "+primeira_parcela+"\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 557; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */