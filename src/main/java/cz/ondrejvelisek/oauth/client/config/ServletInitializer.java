package cz.ondrejvelisek.oauth.client.config;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author Ondrej Velisek <ondrejvelisek@gmail.com>
 */
public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        DelegatingFilterProxy oauth2Filter = new DelegatingFilterProxy("oauth2ClientContextFilter");
        return new Filter[]{oauth2Filter};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

}
