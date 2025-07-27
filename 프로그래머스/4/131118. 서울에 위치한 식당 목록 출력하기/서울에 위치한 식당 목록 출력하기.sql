-- 코드를 입력하세요
SELECT ri.rest_id, ri.rest_name, ri.food_type, ri.favorites, ri.address, round(avg(rr.review_score), 2)
from rest_info ri 
join rest_review rr on ri.rest_id = rr.rest_id
where ri.address like '서울%'
GROUP BY ri.rest_id
order by 6 desc, 4 desc