-- 코드를 입력하세요
# SELECT rr.member_id, count(*), mp.member_name, rr.review_text, rr.review_date
# from member_profile mp
# join rest_review rr on mp.member_id = rr.member_id
# group by rr.member_id;

select mp.member_name, rr.review_text, date_format(rr.review_date, '%Y-%m-%d') as review_date
from member_profile mp
join rest_review rr on mp.member_id = rr.member_id
where rr.member_id = (
    select member_id
    from (
        select member_id, count(*) as review_count
        from rest_review
        group by member_id
        order by review_count desc
        limit 1
    ) a
)
order by review_date, review_text