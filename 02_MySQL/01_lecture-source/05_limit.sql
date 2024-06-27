select
    menu_code
    , menu_name
    , menu_price
from
    tbl_menu
order by
    menu_price desc
limit 5;

select
    menu_code
     , menu_name
     , menu_price
from
    tbl_menu
order by
    menu_price desc
limit 1, 5;