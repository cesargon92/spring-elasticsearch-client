# Getting Started

## Download and Run Elasticsearch

* docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.12.1

## Download and Run Kibana

* docker run --name kib01-test --net elastic -p 5601:5601 -e "ELASTICSEARCH_HOSTS=http://es01-test:9200" docker.elastic.co/kibana/kibana:7.12.1

## Go to Kibana Home

*http://localhost:5601

## Go to Dev Tools in Kibana Menu and run the following command

PUT /usuario-index
{
  "mappings": {
    "properties": {
      "nombreUsuario": {"type": "text"}, 
      "edad": {"type": "integer"},
      "genero": {"type": "text"},
      "cantidadVeces": {"type": "double"},
      "tieneTrabajo": {"type": "boolean"}
    }
  }
}

## Create Pattern index in Kibana

* Search in Kibana the Index Pattern option. Create the 'usuario-index' pattern

## Run this Application

* This application run in localhost:8080

## Import Postman Collection

* Import the postman collection. This file is in 'resource' directory of this project.

## Add Users to Created Index

* Use the collection and call add-user or add-users method to add new index
