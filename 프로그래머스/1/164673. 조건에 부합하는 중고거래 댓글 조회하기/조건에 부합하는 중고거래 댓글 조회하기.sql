-- 코드를 입력하세요
SELECT ugb.title, ugb.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, date_format(ugr.created_date, '%Y-%m-%d')
from used_goods_board ugb
join used_goods_reply ugr on ugb.board_id = ugr.board_id
where date_format(ugb.created_date, '%Y-%m') = '2022-10'
order by 6, 1