package spring_introduction;

import org.springframework.context.annotation.*;

//1 способ
//@Configuration //данный класс является конфигурацией
//@ComponentScan("com.bbuhha") //указываем пакет который будет сканирован на наличие бинов и аннотаций
//конфигурация с помощью Java code, а не xml-file





//2 способ не использует никакого сканирования -> аннотации не нужны (@Autowired)
//все бины описываются внутри конфигурации (класса), бины, DI
//зависимости прописываются вручную
//аннотация bean перехватывает обращение к бину и регулирует его создание

@PropertySource("classpath:myApp.properties") //данная аннотация укзаывает на проперти файл откуда берутся значения полей
public class MyConfig {



    @Bean //название метода = beanId, будем создавать бин вручную, аннотация перехватывает и видит, что singleton
    //то нет необходимости создавать еще 1 объект, ведь он уже есть в контейнере
    @Scope("singleton")
    public Pet catBean() {
        return new Cat();
    }

    //DI
    //если bean cat уже создан, то Spring достает его из контейнера( в случае если это синглтон)
    @Bean
    public Person personBean() {
        return new Person(catBean());
    }

}
