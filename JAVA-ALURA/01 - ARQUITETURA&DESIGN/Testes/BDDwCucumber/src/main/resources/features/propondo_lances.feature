Feature: Propondo lances ao leilao

Scenario: Propondo um unico lance valido
	Given (Dado): Um lance valido
	When (Quando): Propoe ao leilao
	Then (Entao): O lance e aceito
	
Scenario: Propondo varios lances validos
	Given (Dado): varios lances validos
	When (Quando): propoe varios lances ao leilao
	Then (Entao): os lances sao aceitos