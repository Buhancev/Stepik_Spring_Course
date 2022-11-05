package com.bbuhha.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //контроллер - специальный компонент
// (наследования у аннотаций нет, но можно сказать, что контроллер - разновидность компонента)
public class MyController {

    //Когда VIEW должен возвращаться ? - по url
    @RequestMapping("/") //прописываем на url
    public String showFirstView() {
        return "firstView"; //имя VIEW, благодаря конфигурации:
        // в начале добавится - где находится VIEW, а в конце - расширение VIEW
    }
}
