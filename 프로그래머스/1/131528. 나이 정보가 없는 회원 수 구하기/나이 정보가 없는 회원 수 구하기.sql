-- 코드를 입력하세요
SELECT count(distinct user_id) as 'USERS'
from user_info
where age is null
group by age