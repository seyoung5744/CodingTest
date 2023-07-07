-- 코드를 입력하세요
SELECT USER_ID,NICKNAME, SUM(PRICE) AS TOTAL_SALES
from USED_GOODS_BOARD as b
    join USED_GOODS_USER as u
    on b.WRITER_ID = u.USER_ID
where STATUS = 'DONE'
group by user_id
having TOTAL_SALES >= 700000
order by total_sales 