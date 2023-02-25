# Projeto Silver's Bank

Projeto criado para colocar em prática alguns topicos relacionados a linguagem de programação Kotlin com o foco em desenvolvimento Android.

## Estrutura do projeto


![](https://user-images.githubusercontent.com/109437880/221369690-168bc237-b5ba-4c4d-bdb3-b6d4035bf944.png)

Inicialmente o projeto não segue nenhuma arquitetura de mercado como MVP ou MVVM, mas futuramente eu pretendo refazer este projeto utilizando o padão MVVM.

## Telas iniciais

- Login

   A primeira tela apresentada é a de Login.
   
   Existe duas verificações dentro do Login, a primeira consiste em verificar no banco de dados se o usuario e a senha estão registrados, se a condição for verdadeira
   o usuario é direcionado para a tela de "Detalhes" se a condição for falsa um alerta avisando que o usuario não foi encontrado sera exibido no console.

![login](https://user-images.githubusercontent.com/109437880/221370207-e4dd0b92-7c35-4ed1-b868-c5695f4bc1b8.PNG)


- Cadastro
  
  A tela de cadastro só sera exibida caso o usuario clique no botão "Cadastre-se".
  
  Junto com o sistema de cadastro eu criei algumas validações, como: verificar se o nome de usuario informado já esta cadastrado no banco de dados, verificar se as duas
  senhas informadas são semelhantes e se a senha/nome de usuario são nulos ou contem espaços (esta validação precisa de correções).
  
![cadastro](https://user-images.githubusercontent.com/109437880/221370735-068c3780-8a1e-40b2-a56f-e89e6894151b.PNG)

- Detalhes

  Para ter acesso a tela de login o usuario precisa ser autenticado no login.
  
  Dentro da tela de "Detalhes" sera exibido o nome/saldo do usuario e com a opção de "Transferencia" e "Pagamento"

![detalhes](https://user-images.githubusercontent.com/109437880/221371781-28083930-c0ac-4915-a45f-27f2191bfd4a.PNG)

## Funcionalidades

- Transferencia 

   Transferencia tem como objetivo enviar uma certa quantidade de dinheiro para uma outra conta.
   
   Inicialmente a "Transferencia" não tem como base o saldo inicial do usuario.
   
   Para realizar uma transferencia o usuario precisa inserir um número de conta valído, caso o usuario insira uma conta invalida, um alerta avisando que a conta
   informada não foi localizada via console.

 ![transferencia](https://user-images.githubusercontent.com/109437880/221372269-cbe9f03d-85b8-4974-aae8-101a3e6d3d65.PNG)




