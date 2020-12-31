#language: pt

Funcionalidade: Efetuar cadastro de um novo negócio dentro do sistema Vendee

Cenário de Fundo:
Dado que possuo cadastro com o email "douglas.queiroz+qa1@nkey.com.br" e a senha "123123"
E que desejo acessar minha conta no site Vendee
Quando acessar o site
Então devo realizar o login
E validar que acessei minha conta

@CT01
Delineação do Cenário: Cadastrar novo negócio na etapa de Oportunidades
Dado que desejo cadastrar um novo negócio na etapa "Oportunidades"
Quando acessar aba Negócios
E selecionar o Funil Padrão
Então devo selecionar a opção referente a etapa desejada
E devo preencher os dados desse novo negócio de nome "Teste novo negocio" e clicar em salvar
E validar que o novo negócio foi criado

@CT02
Delineação do Cenário: Cadastrar novo negócio na etapa de Qualificação
Dado que desejo cadastrar um novo negócio na etapa "Qualificação"
Quando acessar aba Negócios
E selecionar o Funil Padrão
Então devo selecionar a opção referente a etapa desejada
E devo preencher os dados desse novo negócio de nome "Teste novo negocio" e clicar em salvar
E validar que o novo negócio foi criado

@CT03
Delineação do Cenário: Cadastrar novo negócio na etapa de Reunião
Dado que desejo cadastrar um novo negócio na etapa "Reunião"
Quando acessar aba Negócios
E selecionar o Funil Padrão
Então devo selecionar a opção referente a etapa desejada
E devo preencher os dados desse novo negócio de nome "Teste novo negocio" e clicar em salvar
E validar que o novo negócio foi criado

@CT04
Delineação do Cenário: Cadastrar novo negócio na etapa de Negociação
Dado que desejo cadastrar um novo negócio na etapa "Negociação"
Quando acessar aba Negócios
E selecionar o Funil Padrão
Então devo selecionar a opção referente a etapa desejada
E devo preencher os dados desse novo negócio de nome "Teste novo negocio" e clicar em salvar
E validar que o novo negócio foi criado
