-- 코드를 입력하세요
SELECT
    (case
        when price < 10000 then 0
        else TRUNCATE(price, -4)
     end) as PRICE_GROUP, 
     count(product_id) as PRODUCTS
from PRODUCT
group by PRICE_GROUP
order by PRICE_GROUP