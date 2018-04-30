package gr.kiladze.grarticles;

import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

@Configuration
public class ConfigureJSF implements ServletContextAware {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
    }

//    @Bean
//    public ServletRegistrationBean facesServletRegistration() {
//        return new JsfServletRegistrationBean();
//    }
//
//    public class JsfServletRegistrationBean extends ServletRegistrationBean {
//
//        public JsfServletRegistrationBean() {
//            super();
//        }
//
//        @Override
//        public void onStartup(ServletContext servletContext) throws ServletException {
//
//            FacesInitializer facesInitializer = new FacesInitializer();
//
//            Set<Class<?>> clazz = new HashSet<Class<?>>();
//            clazz.add(ConfigureJSF.class);
//            facesInitializer.onStartup(clazz, servletContext);
//        }
//    }

//    @Configuration
//    static class ConfigureJSFContextParameters implements ServletContextInitializer {
//
//        @Override
//        public void onStartup(ServletContext servletContext)
//                throws ServletException {
//
//            servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX",
//                    ".xhtml");
//            servletContext.setInitParameter(
//                    "javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
//            servletContext.setInitParameter("javax.faces.PROJECT_STAGE",
//                    "Development");
//            servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
//            servletContext.setInitParameter(
//                    "javax.faces.FACELETS_REFRESH_PERIOD", "1");
//
//        }
//    }
}