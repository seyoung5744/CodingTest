-- 코드를 입력하세요
select cart_id
from (
    SELECT *
    from cart_products
    where name in ('Milk', 'Yogurt')
) a
group by cart_id
having count(distinct name) > 1