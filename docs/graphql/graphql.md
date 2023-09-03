 
* [docs](../../README.md) 
 * [Introdução](../graphql/graphql.md)
   * [fields](../fields/fields.md)
   * [resolver](../resolver/resolver.md)
   * [data-loader](../data-loader/data-loader.md)

# Introdução ao GraphQL

O GraphQL é uma linguagem de consulta (query language) criada pelo Facebook em 2012 e lançada publicamente em 2015. Ele se tornou uma alternativa poderosa ao modelo REST para a construção de APIs. Neste guia, vamos explorar o GraphQL e compará-lo ao REST para ajudá-lo a entender as diferenças e vantagens dessa tecnologia.


### GraphQL e REST não estão "amarrados" ao HTTP

É importante notar que tanto o GraphQL quanto o REST não estão presos ao protocolo HTTP. Eles são especificações que descrevem como as APIs devem funcionar, mas não ditam qual protocolo de transporte deve ser usado. Isso significa que você pode implementar tanto o GraphQL quanto o REST em outros protocolos, se necessário.

### Exemplo de Uso de GraphQL em Outros Protocolos

Suponha que você esteja construindo um sistema de comunicação para dispositivos IoT (Internet das Coisas) que não utiliza HTTP. Você ainda pode usar o GraphQL para definir consultas precisas e eficientes para acessar os dados desses dispositivos. Vejamos um exemplo simples:

```graphql
# Consulta GraphQL para Dispositivos IoT (usando protocolo customizado)
query {
  device(id: "123") {
    id
    status
    temperature
    humidity
  }
}
```

Neste exemplo, estamos usando o GraphQL para consultar informações de um dispositivo IoT com base em seu ID, mesmo que o protocolo subjacente seja personalizado e não seja HTTP.

Em resumo, o GraphQL oferece uma abordagem mais flexível e eficiente para a construção de APIs em comparação com o REST. Ele coloca o controle nas mãos do cliente, permite consultas precisas e evita o excesso de ou falta de dados. Com um único endpoint e consultas descritivas, o GraphQL se tornou uma ferramenta valiosa no mundo do desenvolvimento de APIs, e sua independência do protocolo de transporte o torna versátil para uma variedade de cenários de aplicação.


# GraphQL Não é o Mesmo que REST

Embora ambos sejam utilizados para criar APIs web, o GraphQL e o REST não são a mesma coisa.

## REST (Representational State Transfer)

- Arquitetura com métodos e endpoints específicos.
- Os recursos são acessados através de URLs.
- O servidor define a estrutura dos dados.
- N+1 Requisições: Às vezes, é necessário fazer várias requisições para diferentes endpoints para obter todos os dados necessários, resultando em um problema conhecido como N+1.

## GraphQL

- Linguagem de consulta flexível.
- Um único endpoint para todas as consultas.
- Os clientes definem suas próprias consultas.
- O servidor fornece apenas os dados solicitados pelo cliente.
- Elimina o problema de busca excessiva ou insuficiente de dados.

Em resumo, embora ambos tenham o mesmo objetivo de fornecer dados para aplicativos, o GraphQL oferece um nível de controle e eficiência que vai além das capacidades do REST.

