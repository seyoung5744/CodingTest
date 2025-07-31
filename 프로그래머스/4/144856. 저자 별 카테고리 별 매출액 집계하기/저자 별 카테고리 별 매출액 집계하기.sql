-- 코드를 입력하세요

select a.author_id, a.author_name, b.category, sum(bs.sales * b.price) as total_sales
from book b
join book_sales bs on b.book_id = bs.book_id
join author a on b.author_id = a.author_id
where year(bs.sales_date) = '2022' and month(bs.sales_date) = '01'
group by a.author_name, b.category
order by 1, 3 desc
