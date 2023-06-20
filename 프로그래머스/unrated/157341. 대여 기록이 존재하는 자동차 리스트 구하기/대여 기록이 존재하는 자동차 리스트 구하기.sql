-- 코드를 입력하세요
SELECT distinct c.car_id
from CAR_RENTAL_COMPANY_CAR as c
inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY  as r
on c.CAR_ID = r.CAR_ID
where c.car_type='세단' and month(r.start_date) = '10'
order by c.car_id desc