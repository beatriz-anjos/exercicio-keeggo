#language: pt
@realizarLoginAll
Funcionalidade: Realizar Login no Advantage Shopping

  Contexto: 
    Dado que eu acesse o site para login "http://advantageonlineshopping.com/#/"

  @realizarLoginSucesso
  Esquema do Cenario: Realizar Login - Sucesso
    E clico no icone de login 
    Quando insiro username "<username>" e senha "<senha>"
    E clico em 'Sign In'
    Entao valido que o Login foi efetuado com sucesso com o "<username>"
    
    Exemplos: 
      | username    | senha      |
      | testBeAnjos | Senha1234* |
      
  @realizarLoginFalha
  Esquema do Cenario: Realizar Login - Falha
    E clico no icone de login 
    Quando insiro username "<username>" e senha "<senha>" incorretos
    E clico em 'Sign In'
    Entao valido que o Login nao pode ser efetuado com a mensagem 'Incorrect user name or password.'
    
    Exemplos: 
      | username    | senha          |
      | loginRandom | SenhaRandom123 |