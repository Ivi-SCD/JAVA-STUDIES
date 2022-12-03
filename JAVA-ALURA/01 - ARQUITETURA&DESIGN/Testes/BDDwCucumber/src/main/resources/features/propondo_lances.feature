# language : pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance valido
 Dado Um lance valido
 Quando Propoe ao leilao
 Entao O lance e aceito
	
Cenario: Propondo varios lances validos
 Dado um lance de 10.0 reais do usuario "fulano"
 E um lance de 15.0 reais do usuario "beltrano"
 Quando propoe varios lances ao leilao
 Entao os lances sao aceitos