-- 코드를 입력하세요
SELECT half.flavor
from FIRST_HALF as half
inner join ICECREAM_INFO as info
on half.flavor = info.flavor
where half.total_order > 3000 and info.INGREDIENT_TYPE = 'fruit_based'
