Task1:

In this task, I calculate the variance with the formula E[(x-(E[x])^2].
The way I try to calculate the standard deviation minimize the number of table scans:
1) I only scan the table once and store the salary into a Java ArrayList
2) Obtain the mean of the Salary
3) traverse the ArrayList to calculate the variance
4) Calculate standard deviation 

The program accepts four parameters, databasename, tablename, login, password.
databasename is used to form the database url, the port is 5000
tablename is used to form the SQL, select salary from this table
login and password is used to set the database connection
so the program can be run as "java .:"path2jdbcdriver" SalaryStdDev databasename tablename login password"


Task2:
In this task, I calculate the variance with the formula E[x^2]-(E[x])^2
The way I try to calculate the standard deviation and minimize the number of table scans:
1) The only parameter is the output, which is the standard deviation
2) In the cursor, within a LOOP function, I fetch each salary and calculate the sum of salary, sum of the square of salary and count the record
4) E[x] is the quotient of sum of salary and count of record
5) E[x^2] is the quotient of sum of the square of salary and the count of record
6) Standard deviation is the extraction of root of E[x^2]-(E[x])^2
7) Call the precedure

The program do not need any parameter, the end symbol is "@" and the call procedure command is also inside the file. 
So the program can run as "db2 -td@ -f stddev.sql"