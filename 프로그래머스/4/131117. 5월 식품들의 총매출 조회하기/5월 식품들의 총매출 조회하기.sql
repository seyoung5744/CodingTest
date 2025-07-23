-- 코드를 입력하세요
SELECT fp.product_id, fp.product_name, (fp.price * sum(fo.amount)) as TOTAL_SALES
from food_product fp
join food_order fo on fp.product_id = fo.product_id
where date_format(fo.produce_date, '%Y-%m') = '2022-05'
group by fp.product_id
order by 3 desc, 1 asc