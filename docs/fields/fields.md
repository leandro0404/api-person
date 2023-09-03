 
* [docs](../../README.md) 
 * [Introdução](../graphql/graphql.md)
   * [fields](../fields/fields.md)
   * [resolver](../resolver/resolver.md)
   * [data-loader](../data-loader/data-loader.md)


# Campos (Fields) no GraphQL

## O Conceito de Campos

No GraphQL, os campos (fields) são a unidade básica usada para solicitar dados de um tipo específico. Quando você cria uma consulta GraphQL, você especifica os campos que deseja recuperar de um tipo de objeto. Os campos representam os dados que você está interessado em receber.

## Solicitação Precisa de Dados

Uma das características mais poderosas do GraphQL é a precisão nas solicitações de dados. Em uma consulta GraphQL, você especifica exatamente quais campos deseja recuperar e em que profundidade você deseja acessar os dados.

## Exemplo de Uso de Campos

Vamos considerar um exemplo simples. Suponha que você tenha um tipo `Person` em sua API GraphQL que tem os campos `id`, `name`, `email`, `age`, e `address`. Ao criar uma consulta, você pode escolher os campos específicos que deseja recuperar, conforme suas necessidades.

```graphql
query {
  person(id: 1) {
    id
    name
    age
  }
}

```

Neste exemplo, a consulta solicita apenas os campos id, name e age do objeto Person, economizando largura de banda e melhorando o desempenho da consulta.

Relacionamentos entre Campos
Campos em GraphQL também podem representar relacionamentos entre tipos de objetos. Por exemplo, você pode solicitar campos aninhados para acessar dados relacionados a partir do objeto principal. Isso permite que você recupere dados de maneira eficiente e estruturada.

```graphql
query {
  person(id: 1) {
    id
    name
    address {
      city
      street
    }
  }
}

```
Neste caso, a consulta está solicitando não apenas os campos da pessoa, mas também os campos do objeto address associado.

Em resumo, campos no GraphQL são uma parte crucial para criar consultas personalizadas e eficientes, permitindo que os clientes obtenham exatamente os dados de que precisam, sem mais nem menos.