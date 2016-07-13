import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 10.02.2014
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
public class ClassPathTest extends TestCase {

    public void testAppContext() throws Exception {
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext-core.xml");
        Object usersDao = context.getBean("usersDao");
    }
}
