import { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import MenuItem from "../components/MenuItem";
import boxStyle from './Menu.module.css';
import { searchMenu } from "../apis/MenuAPI";

function MenuSearchResult() {

    const [searchParam] = useSearchParams();
    const searchMenuName = searchParam.get('menuName');
    const [menuList, setMenuList] = useState([]);

    useEffect(
        () => {
            setMenuList(searchMenu(searchMenuName));
        },
        []
    );

    return (
        <>
        <h1>검색결과</h1>
        <div className={boxStyle.MenuBox}>
            {menuList.map(menu => <MenuItem key={menu.menuCode} menu={menu}/>)}
        </div>
        </>
    );
}

export default MenuSearchResult;