-- 코드를 입력하세요
SELECT half.FLAVOR
from first_half as half
inner join icecream_info as info
on info.flavor=half.flavor
where total_order > 3000 and INGREDIENT_TYPE="fruit_based"

