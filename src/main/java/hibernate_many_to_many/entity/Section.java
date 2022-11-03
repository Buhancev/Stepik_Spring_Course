package hibernate_many_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(name = "child_section", //какая таблица join table
            joinColumns = @JoinColumn(name = "section_id"), //с помощью какого столбца join table будет связана sectuion
            inverseJoinColumns = @JoinColumn(name = "child_id")) // помощью какого столбца будет связана join table child таблицы
    private List<Child> children;

    public void addChild(Child child) {
        if(children == null)
            children = new ArrayList<>();
        children.add(child);
    }

    public Section() {
    }

    public Section(String name) {
        this.name = name;
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

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
