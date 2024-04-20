programa
{
	
	funcao inicio()
	{
		inteiro idade
		inteiro num_grupo_r = 0
		cadeia grupo_r

		esvreva("Companhia de Seguros\n\n")
		
		escreva("Informe sua idade\n")
		leia(idade)
		escreva("\nInforme seu grupo de risco B, M ou A\n")
		leia(grupo_r)

		se(idade < 18 ou idade > 70){
			
			escreva("Você não pode adquirir o seguro")
			
			} senao se(idade <= 24 e grupo_r == "B"){
					
					num_grupo_r = 7
						
			} senao se(idade <= 24 e grupo_r == "M"){

					num_grupo_r = 8
						
			} senao se(idade <=24 e grupo_r == "A"){
						
					num_grupo_r = 9
						
			} senao se(idade <= 40 e grupo_r == "B"){

					num_grupo_r = 4
						
			} senao se(idade <= 40 e grupo_r == "M"){

					num_grupo_r = 5
						
			} senao se(idade <= 40 e grupo_r == "A"){
						
					num_grupo_r = 6
						
			 } senao se(idade <= 70 e grupo_r == "B"){

					num_grupo_r = 1
						
			} senao se(idade <= 70 e grupo_r == "M"){

					num_grupo_r = 2
						
			} senao se(idade <= 70 e grupo_r == "A"){
						
					num_grupo_r = 3
	
			}

			escreva("\n\nIdade: "+idade+" Grupo: "+grupo_r+" Número grupo: "+num_grupo_r)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 128; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */