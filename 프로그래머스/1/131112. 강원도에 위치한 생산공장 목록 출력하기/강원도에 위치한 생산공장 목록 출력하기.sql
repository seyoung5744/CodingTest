-- 코드를 입력하세요
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
from FOOD_FACTORY
where substring(ADDRESS, 1, 3) = '강원도';