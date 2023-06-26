-- 코드를 입력하세요
SELECT  date_format(datetime, '%H') as hour, count(animal_id) as count
from ANIMAL_OUTS
group by hour
having hour >= 9 and hour <= 19
order by hour