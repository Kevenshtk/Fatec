programa 
{
	funcao inicio()
	{
		real nota[4], media
		inteiro contador = 1
		
		enquanto (contador <= 3){
			escreva("Infome a "+contador+"° nota\n")
			leia(nota[contador])
			contador++	
		}
		
		media = (nota[1] + nota[2] + nota[3]) / 3
		
		se(media <= 5){
			
			escreva("Sua media foi "+media+" seu conceito e E")
			
		} senao se (media <= 6){
			
			escreva("Sua media foi "+media+" seu conceito e D")
			
		} senao se (media <= 7){
			
			escreva("Sua media foi "+media+" seu conceito e C")
			
		} senao se (media <= 8){
			
			escreva("Sua media foi "+media+" seu conceito e B")
			
		} senao {
			
			escreva("Sua media foi "+media+" seu conceito e A")
			
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 505; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */