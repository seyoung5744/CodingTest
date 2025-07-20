-- 코드를 입력하세요
SELECT p.product_code, sum(p.price * os.sales_amount)
from product p
join offline_sale os on p.product_id=os.product_id
group by p.product_code
order by 2 desc, 1 asc