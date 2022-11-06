package com.bbuhha.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//Если у нас есть два контроллера, которые обрабатывают ОДИНАКОВЫЕ url-запросы (адрес ссылки),
// то генерируется исключение Ambiguous mapping - очевидно, Spring не знает как решить эту неоднозначность


@Controller //контроллер - специальный компонент
// (наследования у аннотаций нет, но можно сказать, что контроллер - разновидность компонента)
//Controller Mapping
@RequestMapping("/employee") //url для всего контроллера,
// то есть теперь все остальные RequestMapping в классе будуту вызывать как /employee + их адрес
public class MyController {


    //Когда VIEW должен возвращаться ? - по url
    //Method Mapping
    @RequestMapping("/") //прописываем на url
    public String showFirstView() {
        return "firstView"; //имя VIEW, благодаря конфигурации:
        // в начале добавится - где находится VIEW, а в конце - расширение VIEW
    }

    @RequestMapping("/askDetails")
    public String askEmpDetails(Model model) {
        Employee employee = new Employee();
        employee.setName("Ivan");
        employee.setSurname("Petrov");
        employee.setSalary(100);
        //создаем наш атрибут
        model.addAttribute("employee", employee);

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

    @RequestMapping("/showDetails")
    //получаем из модели атрибут - дает доступ к конкретному атрибуту Модели
    //@Valid - атрибут employee проходит валидацию
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp,
                                 //результат валидации, должен идти в самом конце
                                 BindingResult bindingResult) {
        System.out.println(emp.getSurname().length());

        if(bindingResult.hasErrors()) //если были ошибки, то возвращаем ту же страницу, но с ошибкой
            return "askEmpDetailsView";

        return "showEmpDetailsView";
    }
}
