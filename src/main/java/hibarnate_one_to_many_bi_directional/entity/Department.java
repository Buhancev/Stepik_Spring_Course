package hibarnate_one_to_many_bi_directional.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "department",
            //по дефолту - зависит от типа связи
            /*
            one-to-one eager - тк мало инфы
            one-to-many lazy - тк много инфы может быть (many)
            many-to-one eager - у множества работников одна инфа
            many-to-many lazy - у множества множество инфы
             */
            fetch = FetchType.LAZY
            //нетерпеливая - сразу загружаем все связанные с сущностью - Hibernate делает один SELECT всего
            //ленивая - подгружаем по мере необходимости - Hibernate делает для каждого обращения SELECT
            // (выборка для департмента и выборка для работников)
    )
    //поле класса Employee, над котором прописывали аннотации
    private List<Employee> emps;

    public Department() {
    }

    public Department(String departmentName, int maxSalary, int minSalary) {
        this.departmentName = departmentName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public void addEmployeeToDepartment(Employee employee) {
        if(emps == null)
            emps = new ArrayList<>();
        emps.add(employee);
        employee.setDepartment(this); //прописываем двустороннюю связь
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}
