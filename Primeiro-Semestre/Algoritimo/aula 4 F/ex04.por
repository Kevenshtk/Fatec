programa
{
	
	funcao inicio()
	{
		real lado1, lado2, lado3
		
		escreva ("informe o primeiro lado do triângulo\n")
		leia(lado1)
		
		escreva ("\ninforme o segundo lado do triângulo\n")
		leia(lado2)
		
		escreva ("\ninforme o terceiro lado do triângulo\n")
		leia(lado3)
		
		se((lado1 < lado2+lado3) e (lado2 < lado1+lado3) e (lado3 < lado1+lado2)){
			
			se(lado1 == lado2 e lado1 == lado3){
				
				escreva("\ntriângulo equilátero")
			
			} senao se(lado1 != lado2 e lado1 != lado3){
				
				 escreva ("\ntriângulo escaleno")
				 
			} senao {
				
				escreva ("\ntriângulo isósceles")
			}
			
			} senao {
				
				escreva("\nNão e um triangulo")
			}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 558; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */