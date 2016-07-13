
import ali.firat.elvin.tr.portal.intern.core.model.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: monster
 * Date: 2/7/14
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-core.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class DaoTest {
    @Autowired
//    UsersDao usersDao;

    @Test
    public void testUsers() throws Exception {
        Users users = new Users();
        users.setAdslNo("1234123412");
        users.setAdslUsername("testing");
//        usersDao.save(users);
        //List<Users> list = (List<Users>) usersDao.findAll();
        //Assert.notEmpty(list);
    }

    @Test
    public void testSAve() throws Exception {


    }
}
