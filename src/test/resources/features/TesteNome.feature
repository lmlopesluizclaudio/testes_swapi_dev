#language:pt
  Funcionalidade: Listar nome de pessoas no endpoint People
    Cenario: Fazer consulta de pessoa | com sucesso
      Dado que exista o endpoint: "https://swapi.dev/api/people"
      Quando fizer uma requisi��o do tipo GET na pessoa com c�digo: 1
      Entao valido que o codigo de retorno �: 200
      E valido que a resposta contem o nome: "Luke Skywalker"

    Cenario: Fazer consulta de pessoa | com sucesso
      Dado que exista o endpoint: "https://swapi.dev/api/people"
      Quando fizer uma requisi��o do tipo GET na pessoa com c�digo: 3
      Entao valido que o codigo de retorno �: 200
      E valido que a resposta contem o nome: "R2-D2"

    Cenario: Fazer consulta de pessoa | com sucesso
      Dado que exista o endpoint: "https://swapi.dev/api/people"
      Quando fizer uma requisi��o do tipo GET na pessoa com c�digo: 80000000
      Entao valido que o codigo de retorno �: 404

