package cntt1.ss13.repository.impl;

import cntt1.ss13.model.Person;
import cntt1.ss13.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional // Khi sử dụng getCurrentSession
@RequiredArgsConstructor // Tiêm thông qua constructors
public class PersonRepositoryImpl implements IPersonRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List<Person> findAll() {

        // Mở phiên để tương tác với database
        Session session = sessionFactory.getCurrentSession();
        // HQL - Làm việc với đối tượng
        return session.createQuery(
                "FROM Person",
                Person.class
        ).list();
    }

    @Override
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
        // save | persist
        // update | merge
        // delete | remove
    }
}
