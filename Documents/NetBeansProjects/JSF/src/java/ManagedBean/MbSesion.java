
package ManagedBean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author MHFCO_000
 */
@ManagedBean
@RequestScoped
public class MbSesion {
private String usuario;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;

    /**
     * Creates a new instance of MbSesion
     */
    public MbSesion() {
         faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            usuario=httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
    }
     public String cerrarSession()
    {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, facesMessage);
        return "index";
    }
 
    public String getUsuario() {
        return usuario;
    }
 
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }    
}
