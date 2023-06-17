-- 코드를 입력하세요
# SELECT distinct count(*)
# from animal_ins
# where name is not null

select count(distinct name)
from animal_ins
where name is not null