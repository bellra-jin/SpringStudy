-- 민트미역국과 같은 카테고리의 메뉴들의 정보를 조회하세요
select
    category_code
  , menu_name
  , menu_price
  , category_code
  , orderable_status
from
    tbl_menu
where
    category_code = (
        select
            category_code
        from
            tbl_menu
        where
            menu_name = '민트미역국'
    );

-- from절에 SUBQUERY를 통한 조회는 inline view 라고 불린다.
SELECT
    MAX(count)
FROM
    (SELECT
         COUNT(*) AS 'count'
     FROM
         tbl_menu
     GROUP BY category_code) AS countmenu;





