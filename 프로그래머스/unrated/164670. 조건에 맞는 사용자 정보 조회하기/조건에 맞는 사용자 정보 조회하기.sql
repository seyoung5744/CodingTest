# -- 코드를 입력하세요
SELECT 
    USER_ID, 
    NICKNAME, 
    CONCAT_WS(" ", CITY, STREET_ADDRESS1, STREET_ADDRESS2) AS "전체주소", 
    CONCAT_WS("-", substr(TLNO, 1, 3), substr(TLNO, 4, 4), substr(TLNO, 8, 4) ) AS "전화번호"
from USED_GOODS_BOARD as ugb
    join USED_GOODS_USER as ugu
    on ugb.WRITER_ID = ugu.USER_ID
group by WRITER_ID
having count(WRITER_ID) >= 3
order by USER_ID desc
