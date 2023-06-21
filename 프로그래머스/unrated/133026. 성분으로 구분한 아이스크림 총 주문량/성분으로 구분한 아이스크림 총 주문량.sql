-- 코드를 입력하세요
SELECT info.INGREDIENT_TYPE, sum(half.total_order) as TOTAL_ORDER
from ICECREAM_INFO as info
inner join FIRST_HALF as half
on info.flavor = half.flavor
group by info.INGREDIENT_TYPE
order by TOTAL_ORDER