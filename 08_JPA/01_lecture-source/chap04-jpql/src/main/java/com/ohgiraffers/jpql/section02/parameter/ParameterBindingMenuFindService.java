package com.ohgiraffers.jpql.section02.parameter;

import com.ohgiraffers.jpql.section01.simple.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterBindingMenuFindService {

    private ParameterBindingMenuRepository parameterBindingMenuRepository;

    public ParameterBindingMenuFindService(ParameterBindingMenuRepository parameterBindingMenuRepository) {
        this.parameterBindingMenuRepository = parameterBindingMenuRepository;
    }

    public Menu bindParameterWithName(int menuCode) {

        return parameterBindingMenuRepository.bindParameterWithName(menuCode);
    }

    public Menu bindingParameterWithOrder(int menuCode) {

        return parameterBindingMenuRepository.bindParameterWithOrder(menuCode);
    }
}
