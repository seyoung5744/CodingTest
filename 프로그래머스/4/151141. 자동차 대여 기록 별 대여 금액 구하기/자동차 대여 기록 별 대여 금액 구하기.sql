-- 코드를 입력하세요
# SELECT history_id, 
#     case 
#         when day >= 7 then floor(daily_fee * (1 - 5 / 100)) * day
#         when day >= 30 then floor(daily_fee * (1 - 7 / 100)) * day
#         when day >= 70 then floor(daily_fee * (1 - 10 / 100)) * day
#         else daily_fee * day
#     end as fee
# from (
#     SELECT a.history_id, b.daily_fee, datediff(end_date, start_date) as day
#     from car_rental_company_rental_history a
#     join car_rental_company_car b on a.car_id = b.car_id
#     where b.car_type = '트럭'
# ) sub
# order by 2 desc, 1 desc

select 
    h.history_id,
    ROUND(((DATEDIFF(h.end_date, h.start_date) + 1) * c.daily_fee) *
    (1 - (IFNULL(p.discount_rate, 0) / 100)), 0) AS fee
from car_rental_company_rental_history h
join car_rental_company_car c 
    on h.car_id = c.car_id
left join car_rental_company_discount_plan p 
    ON CASE WHEN (DATEDIFF(h.end_date, h.start_date) + 1) >= 90 THEN '90일 이상'
            WHEN (DATEDIFF(h.end_date, h.start_date) + 1) >= 30 THEN '30일 이상'
            WHEN (DATEDIFF(h.end_date, h.start_date) + 1) >= 7 THEN '7일 이상' END
        = p.duration_type
    AND c.car_type = p.car_type
where c.car_type = '트럭'
order by fee desc, h.history_id desc