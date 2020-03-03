Ideas:

1a. Set all the string to Varchar(150), zip code to INTEGER, atttibutes about amount to DOUBLE.

1c. Create index on dea_ny for the attributes which appear in the WHERE or GROUP BY.

2a. Correspond to the setting of dea_ny.

3a. First I need the sum of dosage_unit of every month. So using CTE, I create a table include the information described before. Then I can get the smooth result with window function.  

3b. First I need to have a table A include Sum of MME of each zip. Then join A with zippop table to obtain a table B to let me know how many population each zip has. Finally use CTE and RANK() function to get top 5 zip with most normalized mme.
