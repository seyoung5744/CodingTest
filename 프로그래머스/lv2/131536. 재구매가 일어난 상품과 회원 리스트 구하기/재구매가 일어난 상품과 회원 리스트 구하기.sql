-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
from online_sale
group by USER_ID, PRODUCT_ID
having count(USER_ID) > 1
order by USER_ID asc, PRODUCT_ID desc