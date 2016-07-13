package ali.firat.elvin.tr.portal.intern.web.jsf.bean;

import org.springframework.stereotype.Component;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Created by ocekmez on 4/7/2016.
 */
@ManagedBean
@RequestScoped
public class ExceptionHandlerView {
    public void throwNullPointerException() {
        throw new NullPointerException("A NullPointerException!");
    }

    public void throwWrappedIllegalStateException() {
        Throwable t = new IllegalStateException("A wrapped IllegalStateException!");
        throw new FacesException(t);
    }

    public void throwViewExpiredException() {
        throw new ViewExpiredException("A ViewExpiredException!",
                FacesContext.getCurrentInstance().getViewRoot().getViewId());
    }
}
