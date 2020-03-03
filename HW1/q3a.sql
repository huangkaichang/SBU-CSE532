-- select year(transaction_date) as year, month(transaction_date) as month, count(dosage_unit) as count
-- from cse532.dea_ny
-- group by year(transaction_date), month(transaction_date)
-- order by year(transaction_date) desc;

-- select sum(dosage_unit) as monthly_count
-- from cse532.dea_ny
-- group by year(transaction_date), month(transaction_date);

-- select sum(dosage_unit) as monthly_count,
-- sum(dosage_unit) over
-- (order by yeardate rows between 1 preceding and 1 following) as smooth_count
-- from cse532.dea_ny;



with dea_ny_monthly as 
(select cast(sum(dosage_unit) as int) as monthly_sum_dosage_unit, 
	year(transaction_date) as year, 
	month(transaction_date) as month, 
	concat(year(transaction_date), month(transaction_date)) as yeardate
from cse532.dea_ny
group by year(transaction_date), month(transaction_date)
)
select yeardate, monthly_sum_dosage_unit as monthly_count,
avg(monthly_sum_dosage_unit) over
(order by year, month rows between 1 preceding and 1 following) as smooth_count
from dea_ny_monthly;
