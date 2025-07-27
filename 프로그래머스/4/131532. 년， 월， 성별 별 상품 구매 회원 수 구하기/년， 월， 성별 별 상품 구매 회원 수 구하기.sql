-- 코드를 입력하세요
SELECT year(os.sales_date), month(os.sales_date), ui.gender, count(distinct os.user_id)
from user_info ui
join online_sale os on ui.user_id = os.user_id
where ui.gender is not null
group by year(os.sales_date), month(os.sales_date), ui.gender
order by 1, 2, 3;

# select *
# from user_info ui
# join online_sale os on ui.user_id = os.user_id
# where ui.gender is not null;
