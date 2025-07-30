-- 코드를 입력하세요
SELECT concat('/home/grep/src/', ugf.board_id, '/', ugf.file_id, ugf.file_name, ugf.file_ext) as file_path
from used_goods_board ugb
join used_goods_file ugf on ugb.board_id = ugf.board_id
where ugb.views = (
    select max(views)
    from used_goods_board
)
order by ugf.file_id desc;

