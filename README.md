# Projeto Silver's Bank

Projeto criado para colocar em prática alguns tópicos relacionados a linguagem de programação Kotlin com o foco em desenvolvimento Android.

## Estrutura do projeto


![](https://user-images.githubusercontent.com/109437880/221369690-168bc237-b5ba-4c4d-bdb3-b6d4035bf944.png)

Inicialmente o projeto não segue nenhuma arquitetura de mercado como MVP ou MVVM, mas futuramente eu pretendo refazer este projeto utilizando o padrão MVVM.

## Telas iniciais

- Login

   A primeira tela apresentada é a de Login.
   
   Existe duas verificações dentro do Login, a primeira consiste em verificar no banco de dados se o usuário e a senha estão registrados, se a condição for verdadeira
   o usuário é direcionado para a tela de "Detalhes" se a condição for falsa um alerta avisando que o usuário não foi encontrado sera exibido no console.

![login](https://user-images.githubusercontent.com/109437880/221370207-e4dd0b92-7c35-4ed1-b868-c5695f4bc1b8.PNG)


- Cadastro
  
  A tela de cadastro só será exibida caso o usuário clique no botão "Cadastre-se".
  
  Junto com o sistema de cadastro eu criei algumas validações, como: verificar se o nome de usuário informado já esta cadastrado no banco de dados, verificar se as duas
  senhas informadas são semelhantes e se a senha/nome de usuário são nulos ou contem espaços (esta validação precisa de correções).
  
![cadastro](https://user-images.githubusercontent.com/109437880/221370735-068c3780-8a1e-40b2-a56f-e89e6894151b.PNG)

- Detalhes

  Para ter acesso a tela de login o usuário precisa ser autenticado no login.
  
  Dentro da tela de "Detalhes" será exibido o nome/saldo do usuário e com a opção de "Transferência" e "Pagamento"

![detalhes](https://user-images.githubusercontent.com/109437880/221371781-28083930-c0ac-4915-a45f-27f2191bfd4a.PNG)

## Funcionalidades

- Transferência 

   A transferência tem como objetivo enviar uma certa quantidade de dinheiro para uma outra conta.
   
   Inicialmente a "Transferência" não tem como base o saldo inicial do usuário.
   
   Para realizar uma transferência o usuário precisa inserir um número de conta valido, caso o usuário insira uma conta invalida, aparecerá um alerta avisando que a
   conta informada não foi localizada via console.

 ![transferencia](https://user-images.githubusercontent.com/109437880/221372269-cbe9f03d-85b8-4974-aae8-101a3e6d3d65.PNG)

- Pagamento

  O pagamento tem como objetivo pagar uma conta pendente.
  
  Diferentemente da funcionalidade "Transferência" o pagamento tem ligação direta com o saldo da conta, existindo uma pequena validação para saber se o usuário possui
  o saldo necessário para o pagamento(Ainda é preciso fazer umas correções na formatação das casas decimais)
  
  O campo "Número do boleto" é meramente ilustrativo e por enquanto não possui nenhuma função.

 ![pagamento](https://user-images.githubusercontent.com/109437880/221380727-aa6e1189-bd35-456b-96c8-81c53e99f0e9.PNG)
 
 # Topicos abordados neste projeto
 
 - Adapter para RecyclerView( os dados foram inseridos manualmente)



