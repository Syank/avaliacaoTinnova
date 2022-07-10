# Avaliação Tinnova

Cada um dos cinco testes foram separados em seus respectivos diretórios, sendo um independente do outro.

##### Pré-requisitos para execução dos exercícios
- Java 8+ devidamente configurado em sua máquina
- Node.Js previamente instalado
- Maven instalado (Para execução dos testes)
- IDEs para execução. Recomenda-se utilizar *Eclipse*/*InteliJ*

Todos os exercícios possuem testes unitários. Para realizar a execução do teste, abra o terminal e navegue para o diretório raiz do exercício em questão, onde se encontra o arquivo *pom.xml*. Após isso, execute no terminal o comando ***mvn test***. Note que para que a execução do teste seja bem sucedida, deve-se ter instalado previamente em sua máquina o *Maven*.
*Nota: Para o exercício 5, apenas a parte do server possuí testes*

#### Execução dos exercícios de 1 a 4

Utilizando a IDE de sua preferência, abra o teste em questão e através do *Maven*, realize o processo de *build* do mesmo.
IDEs como *Eclipse* e *InteliJ* realizam esse processo automáticamente após o projeto ser aberto.
Todos possuem uma classe de entrada **Main**, para visualizar a execução da aplicação, basta executa-lá.


#### Execução do exercício 5
O exercício 5 é dividido em duas partes, a aplicação *client* e a *server*

##### Execução do server
Dentro de ***exercise5/server*** encontra-se um diretório chamado ***carsCrud***, abra-o da mesma forma que foi feito para os outros exercícios e realize o processo de *build*.
Após finalizado, execute a classe de entrada ***CarsCrudApplication*** para que o servidor se inicialize.
O servidor será acessado pela rota *http://localhost:8080*.

##### Execução do client
Dentro de ***exercise5/client*** encontra-se um diretório chamado ***cars_crud***. Para abri-lo, recomenda-se utilzar o *Visual Studio Code (VSCode)*.
Através do terminal, navegue para o diretório do ***client*** no mesmo nível onde se encontra o arquivo ***package.json***. Feito isso, execute o comando ***npm install*** para que as dependências sejam baixadas. Após a conclusão, execute ***npm start***.
Quando a compilação finalizar, será aberto em seu navegador padrão a página da aplicação.
Caso o navegador não abra sozinho, você pode acessar a URL *http://localhost:3000*.

##### Observações
O repositório conta com o ***CI*** fornecido pelo ***GitHub Actions***, onde, após cada commit ou pull request, os testes unitários de todos os exercícios são executados para garantir a validação e integridade do código.

Para o exercício 5, foi utilizado o banco de dados **H2 Database** para a persistência dos dados, dessa forma não é necessário mais nenhuma configuração de ambiente extra a fim de simplificar o processo de execução dos exercícios.