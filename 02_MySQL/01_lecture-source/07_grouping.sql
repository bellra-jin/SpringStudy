select
    category_code
  , sum(menu_price)
from
    tbl_menu
group by
    category_code;

-- 카테고리별 메뉴의 합계, 평균, 숫자, 최소가격, 최대가격을 조회하세요
-- sum, avg, count, min, max 함수 사용

select
    category_code
  , sum(menu_price)
  , avg(menu_price)
  , count(menu_price)
  , min(menu_price)
  , max(menu_price)
from
    tbl_menu
group by
    category_code;

select
    menu_price
  , category_code
from
    tbl_menu
group by
    menu_price
  , category_code
having
    category_code >= 5 and category_code <= 8;

-- 카테고리별 메뉴의 합계 금액을 조회
-- 단, 메뉴의 합계 금액이 30000원을 초과하는 카테고리에 대해 조회
select
    category_code
  , sum(menu_price)
from
    tbl_menu
group by
    category_code
having
    sum(menu_price) > 30000;

-- 카테고리별 메뉴의 합계 금액이 가장 놓은 카테고리의
-- 카테고리코드, 메뉴의 합계 금액을 조회하세요

select
   category_code
  , sum(menu_price)
from
    tbl_menu
group by
  category_code
order by
    sum(menu_price) desc
limit 1;
