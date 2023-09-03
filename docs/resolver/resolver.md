 
*[docs](../../README.md) 
 * [Introdução](../graphql/graphql.md)
   * [fields](../fields/fields.md)
   * [resolver](../resolver/resolver.md)
   * [data-loader](../data-loader/data-loader.md)
# Resolvers no GraphQL

Os resolvers desempenham um papel fundamental no funcionamento do GraphQL. Eles são responsáveis por buscar os dados solicitados em uma consulta GraphQL e retorná-los ao cliente. Os resolvers permitem que você especifique como os campos em um tipo de objeto devem ser resolvidos e quais dados devem ser retornados.

## Função dos Resolvers

- **Resolução de Campos**: Em uma consulta GraphQL, você especifica os campos que deseja recuperar. Cada campo precisa de um resolver correspondente que saiba como obter os dados para esse campo. Os resolvers determinam como os campos são preenchidos com dados.

- **Hierarquia de Resolvers**: Os resolvers também trabalham em uma hierarquia. Quando você faz uma consulta que envolve campos aninhados, os resolvers são chamados em cascata, resolvendo cada campo em profundidade.

## Estrutura de um Resolver

Um resolver é uma função que aceita os seguintes argumentos:

- **objeto pai (parent)**: O resultado do resolver do campo pai. Isso permite que os resolvers acessem os dados do objeto pai, se necessário.

- **argumentos (args)**: Os argumentos passados para o campo na consulta GraphQL. Resolvers podem usá-los para personalizar a busca de dados.

- **contexto (context)**: Um objeto que pode ser usado para compartilhar informações entre resolvers, como dados de autenticação ou informações de sessão.

- **informações (info)**: Contém informações sobre a consulta GraphQL atual, como a seleção de campos feita pelo cliente.

## Exemplo de Uso

Vamos considerar um exemplo simples. Suponha que você tenha um tipo `Person` com os campos `id`, `name`, `email`, e `age`. Abaixo está um exemplo de resolver para o campo `name`:

```javascript
const resolvers = {
  Person: {
    name: (parent, args, context, info) => {
      // Aqui, você pode buscar o nome da pessoa de alguma fonte de dados.
      return fetchNameFromDatabase(parent.id);
    },
  },
};

```

Neste exemplo, o resolver para o campo name busca o nome da pessoa com base em seu ID em algum sistema de banco de dados.

Flexibilidade e Personalização
Uma das vantagens do GraphQL é a flexibilidade que os resolvers oferecem. Você pode personalizar a lógica de resolução para atender às necessidades específicas da sua aplicação, buscando dados de bancos de dados, serviços externos ou qualquer outra fonte de dados.

Em resumo, os resolvers são o "cérebro" de uma API GraphQL, determinando como os campos são preenchidos com dados e permitindo consultas altamente personalizadas e eficientes.


