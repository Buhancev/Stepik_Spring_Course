package Spring_Hibernate.hibernate_one_to_one.hibernate_many_to_many;

import Spring_Hibernate.hibernate_one_to_one.hibernate_many_to_many.entity.Section;
import Spring_Hibernate.hibernate_one_to_one.hibernate_many_to_many.entity.Child;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Child child = new Child("Malysh", 11);
//            Section section1 = new Section("Chess");
//            Section section2 = new Section("Swimming");
//            Section section3 = new Section("Polo");
//
//            child.addSection(section1);
//            child.addSection(section2);
//            child.addSection(section3);
//
//            //если тут добавить секции, то
//            //IllegalStateException, тк удалили REMOVE из CascadeType
//            /*
//            save и persist - разные методы, hibernate реализует их по разному
//            До этого был ALL, и каскад поддерживал ВСЕ операции, а сейчас
//            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH
//            поэтому save не доступен для cascade
//            ПОЭТОМУ ЛУЧШЕ ИСПОЛЬЗОВАТЬ PESIST ВЕЗДЕ!
//             */
//            session.persist(child);
//
//            /*
//            если хотим все же использовать save, то...:
//
//            ПОСЛЕ СОХРАНЕНИЯ РЕБЕНКА!
//            child.addSection(section1);
//            child.addSection(section2);
//            child.addSection(section3);
//
//            session.save(section1);
//            session.save(section2);
//            session.save(section3);
//
//             */


//            Section section = session.get(Section.class, 12);
//            //теперь нет КАСКАДНОГО удаления
//            session.delete(section);

            Child child = session.get(Child.class, 15);
            //теперь нет КАСКАДНОГО удаления
            session.delete(child);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
