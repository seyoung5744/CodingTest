-- 코드를 입력하세요
SELECT ugb.writer_id, ugu.nickname, 
    concat(ugu.city, " ", ugu.street_address1, " ", ugu.street_address2) as "전체주소", 
    concat(substring(ugu.tlno, 1, 3), "-", substring(ugu.tlno, 4, 4), "-", substring(ugu.tlno, 8, 11)) as "전화번호"
from used_goods_board ugb
join used_goods_user ugu on ugb.writer_id = ugu.user_id
group by ugb.writer_id
having count(ugb.board_id) >= 3
order by 1 desc