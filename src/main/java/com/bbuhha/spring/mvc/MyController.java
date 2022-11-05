package com.bbuhha.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller //контроллер - специальный компонент
// (наследования у аннотаций нет, но можно сказать, что контроллер - разновидность компонента)
public class MyController {

    //Когда VIEW должен возвращаться ? - по url
    @RequestMapping("/") //прописываем на url
    public String showFirstView() {
        return "firstView"; //имя VIEW, благодаря конфигурации:
        // в начале добавится - где находится VIEW, а в конце - расширение VIEW
    }

    @RequestMapping("/askDetails")
    public String askEmpDetails() {
        return "askEmpDetailsView";
    }

//    @RequestMapping("/showDetails")
//    //как получить данные? - используем параметры контроллера, httpServletRequest содержит разные данные в т.ч и имя работника
//    public String showEmpDetails(HttpServletRequest request,
//                                 Model model) {
//        //та самая почти переменная в нашем html файле - employeeName
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. " + empName;
//
//        //чтобы поменять имя, добавим имя в модель (модель - контейнер для КАКИХ УГОДНО данных)
//        //имя атрибута, значение атрибута
//        model.addAttribute("nameAttribute", empName);
//
//        model.addAttribute("testAtribute", "Kakoe-to znachenie dlya testa containera");
//
//        return "showEmpDetailsView";
//    }



    //Есть 2 более удобный и широкий метод чтения данных из поля формы - @RequestParam(имя поля формы)
    @RequestMapping("/showDetails")
    public String showEmpDetails(@RequestParam("employeeName") String empName,
                                 Model model) {
        empName = "Mr. " + empName;

        //чтобы поменять имя, добавим имя в модель (модель - контейнер для КАКИХ УГОДНО данных)
        //имя атрибута, значение атрибута
        model.addAttribute("nameAttribute", empName);

        return "showEmpDetailsView";
    }
}
