-- 코드를 입력하세요
SELECT fh.flavor
from first_half fh
join (
    select shipment_id, flavor, sum(total_order) as total_order
    from july
    group by flavor
) as total_july on total_july.shipment_id = fh.shipment_id
order by fh.total_order + total_july.total_order desc
limit 3

