select
    a.menu_code
  , a.menu_name
  , a.category_code
  , b.category_name
from
    tbl_menu a
join
    tbl_category b
on
    a.category_code = b.category_code;


select
    menu_code
  , menu_name
  , category_code
  , category_name
from
    tbl_menu
join
    tbl_category
using (category_code);

select
    a.category_name
  , b.menu_name
from
    tbl_category a
join
    tbl_menu b
on
    a.category_code = b.category_code;

select
    a.menu_name
  , b.category_name
from
    tbl_menu a
right join
    tbl_category b
on
    a.category_code = b.category_code;






