create index month on cse532.dea_ny(year(transaction_date), month(transaction_date));
create index buyer_zip on cse532.dea_ny(buyer_zip);