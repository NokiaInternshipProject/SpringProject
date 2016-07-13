package ali.firat.elvin.tr.portal.intern.web.jsf;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: guvenck
 * Date: 11/29/12
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class IECompatibilityPhaseListener implements PhaseListener {


        @Override
        public void afterPhase(PhaseEvent arg0){}

        @Override
        public void beforePhase(PhaseEvent event){
            final FacesContext facesContext = event.getFacesContext();
            final HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            response.addHeader("X-UA-Compatible", "IE=edge");
        }

        @Override
        public PhaseId getPhaseId() {
            return PhaseId.RENDER_RESPONSE;
        }

}
