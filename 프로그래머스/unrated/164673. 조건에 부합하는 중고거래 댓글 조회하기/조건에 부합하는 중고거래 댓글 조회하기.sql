-- 코드를 입력하세요
SELECT  
    BOARD.TITLE,
    BOARD.BOARD_ID,
    REPLAY.REPLY_ID,
    REPLAY.WRITER_ID,
    REPLAY.CONTENTS,
    date_format(REPLAY.created_date, '%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD as BOARD
    inner join USED_GOODS_REPLY as REPLAY
    on BOARD.board_id = REPLAY.board_id
where date_format(BOARD.CREATED_DATE, '%Y-%m') = '2022-10'
order by REPLAY.CREATED_DATE, TITLE