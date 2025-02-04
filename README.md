# Projeto de Comunicação Assíncrona
Projeto responsável pela implementação de sistema de aplicações java com implementação de comunicação assíncrona utilizando sistema de mensageria Apache Kafka.

# Requisitos
- Java 11
- Kafka 2.3.1

# Início Rápido
- Passo 1
[Clique aqui para baixar o Kafka 2.3.1](https://archive.apache.org/dist/kafka/2.3.1/kafka_2.12-2.3.1.tgz)
- Passo 2
Descompacte o arquivo tgz
- Passo 3
Dentro do diretório kafka_2.12-2.3.1, em duas abas separadas, execute os comandos:
```bash
  bin/zookeeper-server-start.sh config/zookeeper.properties
```
```bash
  bin/kafka-server-start.sh config/server.properties
```
- Passo 4
Com o Kafka ativado, está tudo pronto para executar as aplicações java.


