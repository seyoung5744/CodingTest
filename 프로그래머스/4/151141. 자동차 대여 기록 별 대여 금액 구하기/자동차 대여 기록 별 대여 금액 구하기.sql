select 
    h.history_id,
    floor(c.daily_fee * (datediff(h.end_date, h.start_date) + 1)  * (1 - (ifnull(p.discount_rate, 0) / 100)) )  as fee
from car_rental_company_rental_history h
join car_rental_company_car c 
    on h.car_id = c.car_id
left join car_rental_company_discount_plan p 
    on c.car_type = p.car_type
    and (
            (p.duration_type = '7일 이상' and datediff(h.end_date, h.start_date) >= 7 and datediff(h.end_date, h.start_date) < 30)
        or  (p.duration_type = '30일 이상' and datediff(h.end_date, h.start_date) >= 30 and datediff(h.end_date, h.start_date) < 90)
        or  (p.duration_type = '90일 이상' and datediff(h.end_date, h.start_date) >= 90)
    )
where c.car_type = '트럭'
order by fee desc, h.history_id desc