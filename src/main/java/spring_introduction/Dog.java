package spring_introduction;

//@Component
//@Scope
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean created");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }

    //@PostConstruct
    protected void init() {
        System.out.println("Class Dog: init method");
    }
    //@PreDestroy
    private void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
