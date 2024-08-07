package assocication.section01.manytoone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuFindService {

    private MenuRepository menuRepository;

    @Autowired
    public MenuFindService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Transactional
    public Menu findMenuByMenuCode(int menuCode) {
        return menuRepository.findMenuByMenuCode(menuCode);
    }
}
