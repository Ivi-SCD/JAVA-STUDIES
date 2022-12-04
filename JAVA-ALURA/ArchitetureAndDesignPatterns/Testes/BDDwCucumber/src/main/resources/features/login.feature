# language : pt
Funcionalidade: Apenas usuarios cadastrados podem logar
 Cenario: Um usuario valido consegue se logar
	Dado um usuario valido
	Quando realiza login
	Entao e redirecionado para a pagina de leiloes

 Cenario: Um usuario invalido nao consegue se logar
	Dado um usuario invalido
	Quando tenta realizar login
	Entao continua na pagina de lgin
