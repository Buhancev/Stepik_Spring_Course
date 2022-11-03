package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
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

//            Section section = new Section("Football");
//            Child child1 = new Child("Glad", 5);
//            Child child2 = new Child("Meme", 1);
//            Child child3 = new Child("AnyAnya", 6);
//
//            section.addChild(child1);
//            section.addChild(child2);
//            section.addChild(child3);
//            session.beginTransaction();
//
//            session.save(section);
//            //*************************************************************

//            session.beginTransaction();
//
//            Child child = new Child("Rebenochek", 11);
//            Section section1 = new Section("Chess");
//            Section section2 = new Section("Basetboll");
//            Section section3 = new Section("Swimming");
//
//            child.addSection(section1);
//            child.addSection(section2);
//            child.addSection(section3);
//
//            session.save(child);
//
//            session.getTransaction().commit();
//            //*************************************************************

            session.beginTransaction();
//            //            //*************************************************************
//
//            Section section = session.get(Section.class, 4);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//            //            //*************************************************************

            //            //*************************************************************
            Child child = session.get(Child.class, 10);
            System.out.println(child);
            System.out.println(child.getSections());

            session.getTransaction().commit();


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
