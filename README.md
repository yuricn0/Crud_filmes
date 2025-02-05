# Crud_Filmes

Esse projeto é uma aplicação que permite realizar operações de CRUD (Create, Read, Update, Delete) em uma lista de filmes. Desenvolvido em Java utilizando o framework Spring Boot, a aplicação é uma api RESTful que gerencia informações de filmes.

## Funcionalidades

- **Adicionar Filme**: Permite a inclusão de novos filmes no sistema.
- **Listar Filmes**: Exibe todos os filmes cadastrados.
- **Listar Filme por ID**: Exibe o filme escolhido pelo ID.
- **Atualizar Filme**: Possibilita a edição das informações de um filme existente.
- **Excluir Filme**: Remove um filme do sistema.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para simplificar a configuração e o desenvolvimento da aplicação.
- **Maven**: Gerenciador de dependências e automação de build.
- **Banco de Dados**: H2 (banco em memória).
- **Eclipse**: IDE Ambiente de desenvolvimento.
- **Postman**: Ferramenta desenvolvimento e teste de APIs. 

## Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- **Java**: [Link de instalação](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- **Maven**: [Link de instalação](https://maven.apache.org/download.cgi)
- **Eclipse**: [Link de instalação](https://eclipseide.org/)

## Instalação

### Clone o repositório:
git clone https://github.com/yuricn0/Crud_filmes.git

### Configure o Banco de Dados:

- Atualize as configurações de conexão no arquivo application.properties localizado em src/main/resources/ com as credenciais do seu banco de dados.
- Compile e execute a aplicação

### Estrutura do Projeto

- **src/main/java**: Contém o código-fonte da aplicação.
  - **controllers**: Classes responsáveis pelos endpoints da API.
  - **services**: Contém a lógica de negócios.
  - **repositories**: Interfaces para acesso ao banco de dados.
  - **models**: Definição da entidade do projeto.
  - **exceptions**: Classes para tratamento de exceções personalizadas.
- **src/main/resources**: Contém arquivos de configuração.
  - **application.properties**: Configurações da aplicação, incluindo detalhes do banco de dados.

## Contato
Para mais informações ou suporte, entre em contato. 


