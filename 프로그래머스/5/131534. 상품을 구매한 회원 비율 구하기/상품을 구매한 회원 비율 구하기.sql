# SELECT 
#     year(u.joined) as year, 
#     month(u.joined) as month, 
#     count(distinct u.user_id) as purchased_users, 
#     round(count(distinct u.user_id) / (select count(*) from user_info where year(joined) = 2021), 1) as puchased_ratio
# from user_info u
# join online_sale o on u.user_id = o.user_id
# where year(u.joined) = 2021
# group by year, month
# order by year, month

SELECT DATE_FORMAT(O.SALES_DATE, '%Y') AS YEAR,
       DATE_FORMAT(O.SALES_DATE, '%m') AS MONTH,
       COUNT(DISTINCT U.USER_ID) AS PURCHASED_USERS,
       ROUND(COUNT(DISTINCT U.USER_ID)/(SELECT COUNT(*) FROM USER_INFO WHERE joined LIKE '2021%'), 1) AS PURCHASED_RATIO
FROM USER_INFO U JOIN ONLINE_SALE O ON U.USER_ID = O.USER_ID
WHERE U.JOINED LIKE '2021%'
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH