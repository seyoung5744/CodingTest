-- 코드를 입력하세요
select month(start_date) as Month, car_id, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where date_format(start_date, '%Y-%m') between '2022-08' and '2022-10' 
    and car_id in (
                    SELECT car_id
                    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    where date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'
                    group by car_id
                    having count(car_id) >= 5)
group by car_id, Month(start_date)
having records >= 1
order by Month, car_id desc