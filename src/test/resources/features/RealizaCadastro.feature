#language: pt
@realizaCadastroAll
Funcionalidade: Realizar Cadastro no Advantage Shopping

  Contexto: 
    Dado que eu acesse o site para cadastro "http://advantageonlineshopping.com/#/"
    E clico no icone de login para cadastrar
    Quando clico em 'Create new Account'

  @realizarCadastroSucesso
  Esquema do Cenario: Realizar Cadastro - Sucesso
    E preencho os detalhes da conta com username "<username>" email "<email>" e senha "<senha>"
    E preencho os campos de nome "<primeiroNome>" sobrenome "<sobrenome>" e telefone "<telefone>"
    Quando clico na checkbox de I Agree
    E clico em 'Register'
    Entao valido que a conta foi criada com sucesso com login "<username>"

    Exemplos: 
      | username        | email                      | senha    | primeiroNome | sobrenome | telefone   |
      | teste12beAnjos1 | teste123beAnjos4@melao.com | Teste123 | BeAnjos2     | Teste1    | 1194257894 |
      | teste12beAnjos3 | teste123beAnjos2@melao.com | Teste123 | BeAnjos3     | Teste2    | 1194257892 |
      | teste12beAnjos4 | teste123beAnjos3@melao.com | Teste123 | BeAnjos4     | Teste3    | 1194257893 |

  @realizarCadastroFalhaEmail
  Esquema do Cenario: Realizar Cadastro - Falha - Email vazio
    E preencho os detalhes da conta com username "<username>" email "<email>" e senha "<senha>"
    E preencho os campos de nome "<primeiroNome>" sobrenome "<sobrenome>" e telefone "<telefone>"
    Quando clico na checkbox de I Agree
    Entao valido que falhou pois o campo email e obrigatorio

    Exemplos: 
      | username       | email | senha    | primeiroNome | sobrenome | telefone   |
      | teste13beAnjos |       | Teste123 | BeAnjos3     | Teste4    | 1194257895 |
