DocStream-CleanArch

DocStream-CleanArch é um serviço de ingestão de documentos (XML e CSV) para armazenamento e processamento assíncrono, utilizando Quarkus, MongoDB, AWS S3 e Kafka. O projeto segue os princípios da Clean Architecture, promovendo uma estrutura modular, testável e de fácil manutenção.

🚀 Funcionalidades

Recepção de Arquivos: Permite o upload de arquivos XML e CSV via endpoints REST.

Processamento Assíncrono: Processa os arquivos de forma assíncrona, garantindo alta performance.

Armazenamento de Dados: Armazena os dados extraídos no MongoDB.

Armazenamento de Arquivos: Armazena os arquivos brutos no AWS S3.

Publicação de Eventos: Publica eventos de processamento no Kafka para integração com outros sistemas.

🧩 Arquitetura

O projeto segue os princípios da Clean Architecture, com a seguinte estrutura:

src/main/java/com/lipe/docstream
│
├── domain/             # Entidades de negócio puras e interfaces (ports)
│   ├── model/          # Entidades de domínio
│   └── repository/     # Interfaces de persistência
│
├── application/        # Casos de uso (UseCases) e lógica de negócio
│
├── infra/              # Implementações concretas (Mongo, S3, Kafka, parsers)
│   ├── persistence/    # Repositórios Mongo
│   ├── storage/        # Upload S3
│   ├── messaging/      # Kafka Producers / Consumers
│   └── parser/         # XML / CSV parsers
│
└── presentation/       # Controllers REST
├── XmlController.java
└── CsvController.java

⚙️ Tecnologias Utilizadas

Java 17

Quarkus 3.x

MongoDB (via Quarkus Panache)

Kafka (SmallRye Reactive Messaging)

AWS S3 (SDK Java)

JAXB (XML parsing)

OpenCSV (CSV parsing)

JUnit5 + RestAssured (Testes)

🐳 Ambiente Local

Para rodar o ambiente localmente, utilize o Docker Compose para subir os serviços do MongoDB e Kafka:

docker-compose up -d


MongoDB: mongodb://root:root@localhost:27017

Kafka: localhost:29092

Zookeeper: localhost:2181

⚙️ Configurações

As configurações de MongoDB, Kafka e S3 estão localizadas em:

src/main/resources/application.properties


Inclui:

Strings de conexão MongoDB

Bootstrap servers Kafka

Serializers / Deserializers

Config AWS S3 (bucket, region, credentials)

📦 Rodando o Projeto

Suba os containers Docker (Mongo + Kafka)

Compile e rode o projeto Quarkus:

./mvnw clean compile quarkus:dev


Endpoints disponíveis:

POST /xml/upload → recebe XML

POST /csv/upload → recebe CSV

🧪 Testes

Unitários com JUnit5

Integração REST com RestAssured

Testes de integração podem usar o MongoDB e Kafka rodando no Docker

📚 Conceitos

Arquitetura limpa (Clean Architecture)

Separação de responsabilidades: Controller → UseCase → Gateway → Infra

Entidade de domínio isolada de frameworks e tecnologia de persistência