package ali.firat.elvin.tr.portal.intern.web.services;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * Created by ocekmez on 4/14/2016.
 */
@Component
public class SessionService {
    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(SessionService.class);

    @PostConstruct
    private void initialize() throws Exception {
    }
}
