package com.bellrajin.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

public class Application {
    public static void main(String[] args) {

        /** I18N (Internationalization) - 소프트웨어의 국제화 (국제화 말고 현지화 개념도 있음 - Localization)
         *  국제화는 글로벌 서비스를 만들때 사용 / 언어 및 화폐 등을 통칭함 > 사용자의 로컬 환경에 맞게 메세지 전송
         *  현지화는 현지에 적용할 수 있는 문화가 맞는지 확인
         */

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        
        String error404MessageKR = context.getMessage("error.404", null, Locale.KOREA);
        String error404MessageUS = context.getMessage("error.404", null, Locale.US);
        System.out.println("error404MessageKR = " + error404MessageKR);
        System.out.println("error404MessageUS = " + error404MessageUS);

        String error500MessageKR = context.getMessage("error.500", new Object[] {"여러분", new Date()}, Locale.KOREA);
        String error500MessageUS = context.getMessage("error.500", new Object[] {"You", new Date()}, Locale.US);
        System.out.println("error500MessageKR = " + error500MessageKR);
        System.out.println("error500MessageUS = " + error500MessageUS);
    }
}
