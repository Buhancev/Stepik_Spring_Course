package hibernate_test2.entity;

/*JPA - Java Persistence API - стандартная спецификация, которая описывает систему
для управления сохранением Java-object в таблицы БД

Hibernate - самая популярная РЕАЛИЗАЦИЯ спецификации JPA

jpa - описывает правила, hibernate - реализует эти правила
Поэтому используем аннотации JPA (даже команда хайбернейт это рекомендует)
Hibernate - реализует JPA.
 */
import jakarta.persistence.*;

@Entity //класс который имеет отображение в БД в виде таблицы
@Table(name="employees") //к какой таблице привязываем класс, если бы названия были одинаковы
//то можно было бы не писать
public class Employee {
    @Id //данное поле является отображение PrimaryKey в таблице
    //Описывает стратегию для генерации столбца PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    IDENTITY - автоматическое увеличение стобца по правила, описанных в БД
    SEQUENCE - полагается на работу Sequence в БД (в MySQL такого нет)
    TABLE - устаревший способ, полагается на уникальность (наибольшее значение +1)
    то есть сохраняет прошлое значение (скам) полагает на столбец в БД
    AUTO - default GenerationType. Выбор стратегии будет зависеть от БД (лучше самому прописывать)
     */

    @Column(name="id") //к какому именно столбцу привязываем
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="department")
    private String department;
    @Column(name="salary")
    private int salary;

    //Между классом Employee и Detail отношениее OneToOne
    @OneToOne(cascade = CascadeType.ALL) //если что-то сделали из одной таблицы, то это производится во всех связанных
    @JoinColumn(name = "details_id")
    private Detail empDetail;

    public Employee() {
    }

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Detail getEmpDetail() {
        return empDetail;
    }

    public void setEmpDetail(Detail empDetail) {
        this.empDetail = empDetail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
