This is a test run of pipl api.

1. Clone repository and install maven dependencies.
2. Start the app from the cli by running mvn exec:java -Dexec.args="arg1 arg2" where
    a. arg1 is a valid email address
    b. arg2 is a flag, indicating the type of query: business, social or contact information
    c. thus, the command to start the app will be: mvn exec:java -Dexec.args="valid-email-address business" for example        