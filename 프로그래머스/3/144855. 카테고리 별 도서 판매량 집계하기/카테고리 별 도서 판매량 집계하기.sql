-- 코드를 입력하세요
SELECT b.category, sum(bs.sales) as TOTAL_SALES
from book b
join book_sales bs on b.book_id = bs.book_id
where date_format(sales_date, '%Y-%m')='2022-01'
group by category
order by category