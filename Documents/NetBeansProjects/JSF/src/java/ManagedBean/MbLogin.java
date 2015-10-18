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
public class MbLogin {
    private  String usuario;
    private String contrasenia;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    
    public MbLogin() {
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
    }
    public String login()
    {
        if(usuario.equals("fco") && contrasenia.equals("123"))
        {
            httpServletRequest.getSession().setAttribute("sessionUsuario", usuario);
            facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
            faceContext.addMessage(null, facesMessage);
            return "acceso";
        }
        else
        {
            facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto", null);
            faceContext.addMessage(null, facesMessage);
            return "index";
        }
    }
 
    public String getUsuario() {
        return usuario;
    }
 
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
 
    public String getContrasenia() {
        return contrasenia;
    }
 
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }    
} 

