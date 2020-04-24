**1. Seed data inserted for the customerId : 12345 for testing purposes**

**2. Curl to get rewards for a specific customer in the last 3 months:**

curl --location --request GET 'http://localhost:8080/rewards/12345' \
--header 'Content-Type: application/json' \
--data-raw ''

**3. Curl to add a transaction record to the data base for a specific customer**

Note: transactionDate should be in the MM-dd-yyyy format

curl --location --request POST 'http://localhost:8080/transaction/add' \
--header 'Content-Type: application/json' \
--header 'Content-Type: text/plain' \
--data-raw '{
    "amount": "200",
    "customerId": 12345,
    "transactionDate": "04-15-2020"
}'

4. Curl to get all the transactions for a specific customer

curl --location --request GET 'http://localhost:8080/transaction/12345' \
--header 'Content-Type: application/json' \
--data-raw ''

