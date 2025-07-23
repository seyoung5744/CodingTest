-- 코드를 입력하세요
SELECT food_type, rest_id, rest_name, FAVORITES
from rest_info
where favorites in (
    select max(favorites)
    from rest_info
    group by food_type
) 
group by food_type
order by 1 desc;


# select *
# from rest_info;