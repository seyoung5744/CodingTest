-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum((p.PRICE * o.SALES_AMOUNT)) as SALES
from PRODUCT as p
join OFFLINE_SALE as o
on p.PRODUCT_ID = o.PRODUCT_ID
group by p.PRODUCT_CODE
order by SALES desc , PRODUCT_CODE