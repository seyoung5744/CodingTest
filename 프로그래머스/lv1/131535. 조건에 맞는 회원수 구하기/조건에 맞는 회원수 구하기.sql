# -- 코드를 입력하세요
# SELECT *
# from user_info
# where year(joined) = 2021

select count(*)
from (
    SELECT *
    from user_info
    where year(joined) = 2021
) as a
where age between 20 and 29