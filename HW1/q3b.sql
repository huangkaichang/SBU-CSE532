with normalized_mme as 
(
select A.buyer_zip as zip, 
rank() over (order by A.sum_mme/cast(B.zpop as int) desc) as rank_in_mme
from
(select buyer_zip, cast(sum(MME) as int) as sum_mme
from cse532.dea_ny
group by buyer_zip) as A
join 
cse532.zippop as B
on A.buyer_zip = B.zip
where B.zpop <> 0
)
select zip
from normalized_mme
where rank_in_mme < 6;