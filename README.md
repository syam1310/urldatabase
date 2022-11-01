# urldatabase
this project is designed to cater below feature
Listen to user command and take the below actions.
1. The command storeurl shall take a URL as a parameter and save that into a table with a unique short key and a count(usage count) initialized to 0.
       a. Use local variables instead of a database to store the data.:- Using HashMap to store the url details, the reason behind choosing the hashmap data structure is fast lookup as most of the operation is releated to lookup
       b. Use any appropriate logic to generate the unique short key.: We are using in-memory counter to generate the unique url id
2. The command get shall take a URL as a parameter and return the unique short key after incrementing the usage count.
3. The command count shall take a URL as a parameter and should return the latest usage count.
4. The command list should return all urls and counts. The return value is in JSON.
5. The command exit should terminate the program

-> How to run this project 
-> clone this. 
-> do mvn clean install to build the project as its maven project
-> then navigate to target folder and run this command java -cp target/urldatabase-1.0-SNAPSHOT-jar-with-dependencies.jar url.UrlDataBase
