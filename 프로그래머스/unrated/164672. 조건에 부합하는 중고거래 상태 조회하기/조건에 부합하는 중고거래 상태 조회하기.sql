-- 코드를 입력하세요
SELECT 
    BOARD_ID,
    WRITER_ID,
    TITLE,
    PRICE,
    case
        when STATUS='SALE' then '판매중'
        when STATUS='RESERVED' then '예약중'
        else '거래완료'
    end as STATUS

from USED_GOODS_BOARD 
where created_date = '2022-10-05'
order by board_id desc