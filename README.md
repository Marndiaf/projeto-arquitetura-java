
# Gestão de Equipes

Este projeto consiste em um sistema de gerenciamento de avaliações de desempenho para equipes de tecnologia. Ele permite a avaliação de habilidades técnicas por meio de autoavaliações e avaliações de gestores, com dados carregados a partir de arquivos de texto e armazenados em um banco de dados para análise e classificação.


## Estrutura do Projeto

O projeto utiliza as seguintes tecnologias e frameworks:

Java como linguagem principal.

Spring Boot para facilitar a configuração e a implementação da aplicação.

JPA/Hibernate para o mapeamento objeto-relacional e persistência de dados.

Banco de Dados PostgreSQL.

Maven como ferramenta de build.
## Pastas e Arquivos Importantes
src/main/java: Contém o código-fonte da aplicação.

src/main/resources/application.properties: Arquivo de configuração da aplicação, onde são especificadas as credenciais e configurações do banco de dados.

db/scriptInicial: Script SQL para a criação das tabelas e inserção dos dados iniciais no banco.
## Rodando localmente

Clone o projeto

```bash
git clone https://github.com/Marndiaf/projeto-arquitetura-java
```

Configure o arquivo application.properties:
No diretório src/main/resources, edite o arquivo application.properties para incluir as credenciais do banco de dados e outras configurações necessárias, como:

spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update

Rode o script de banco de dados:
Navegue até o diretório db e execute o script scriptInicial em seu banco de dados para criar as tabelas e inserir os dados iniciais.

Compile o projeto:
```
mvn clean install
```
Execute a aplicação:
```
mvn spring-boot:run

```



## Funcionalidades

- Cadastro e avaliação de funcionários: Armazenamento de informações de funcionários e suas avaliações.
- Cadastro de gestores: Registro de gestores e vínculo com seus funcionários.
- Avaliações detalhadas: Análise de habilidades e competências técnicas de acordo com as avaliações de gestores e autoavaliações.





## Estrutura do Banco de Dados

O banco de dados possui tabelas para:

Gestor

Funcionario

Cargo

Conhecimento

Trilha

Avaliacao
## Acesso à Aplicação
Após a execução bem-sucedida, a aplicação estará disponível para acesso e execução no console. 