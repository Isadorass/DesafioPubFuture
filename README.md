# Pub Future
Este repositório foi feito para o desafio do programa de formação Pub Future.
### Tecnologias Utilizadas
* Java - 11
* Postgres - 11
* SpringBoot - 2.6.2

### Conexão com o Banco de Dados
Nesse projeto foi utilizado o banco relacional Postgres. O aquivo de configuração para a conexão com o banco pode ser encontrado no determinado caminho "**pub-future\src\main\resources/application.properties**", nele é neceessário colocar a **senha** e **usuário** do seu Postgres e por último é necessário criar um banco com o determinado nome "**pubfuture**". As tabelas serão criados sozinhas pelo Hibernate assim como todos os métods DML e DDL.

### Para testar aplicação
Este projeto é feito usando REST API, os endpoints foram testados usando Postman, no repositório contém um arquivo chamado **PubFuture.postman_collection.json** onde contém todas as requisições para as entidades.