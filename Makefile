package:
	@ mvn clean  install -DskipTests=true

docker-image-build: package
	@ docker build -t lprates/aplicacao-ahoy-back .

run: docker-image-build
	docker-compose -f docker-compose-mysql.yml up -d
	docker-compose -f docker-compose-aplicacao.yml up -d

stop:
	@ docker-compose -f docker-compose-aplicacao.yml -f docker-compose-mysql.yml down -v

