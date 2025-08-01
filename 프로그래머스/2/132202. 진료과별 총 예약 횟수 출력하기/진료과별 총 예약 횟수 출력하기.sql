-- 코드를 입력하세요
SELECT mcdp_cd as '진료과코드', count(*) as '5월예약건수'
from appointment
where date_format(apnt_ymd, '%Y-%m') = '2022-05'
group by mcdp_cd
order by 2 asc, 1 asc;