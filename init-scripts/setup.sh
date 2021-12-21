echo 'Criando tabela no DynamoDB'

awslocal dynamodb create-table \
    --table-name movies \
    --attribute-definitions AttributeName=id,AttributeType=S \
    --key-schema AttributeName=id,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
    --region us-east-1

echo 'Verificando se a tabela foi criada no DynamoDB'
awslocal dynamodb scan \
    --region us-east-1 \
    --table-name movies