# Projeto-AHoy-Back-End


Dentro da pasta esta a collection do postman **AHoy.postman_collection** para testar 
o retorno dos serviços rest

Arquivo **banco_de_dados.sql** script de banco de dados 


Dentro do projeto ja existe os arquivos dockerFile e Dockercompose para subir a
aplicação como container .


Passo a passa da geração :
    1 - mvn clean  install -DskipTests=true
    2 - docker build -t lprates/aplicacao-ahoy-back .
    3 - docker-compose -f docker-compose-mysql.yml up -d
    4 - docker-compose -f docker-compose-aplicacao.yml up -d


O arquivo *MakeFile* automatiza ainda mais esse processo executando o comando :
**make run** para subir o backend .
