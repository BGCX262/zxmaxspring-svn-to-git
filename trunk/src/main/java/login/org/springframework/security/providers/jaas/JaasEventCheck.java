package login.org.springframework.security.providers.jaas;



import org.springframework.security.providers.jaas.event.JaasAuthenticationFailedEvent;
import org.springframework.security.providers.jaas.event.JaasAuthenticationSuccessEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;


/**
 * DOCUMENT ME!
 *
 * @author Ray Krueger
 * @version $Id: JaasEventCheck.java 2217 2007-10-27 00:45:30Z luke_t $
 */
public class JaasEventCheck implements ApplicationListener {
    //~ Instance fields ================================================================================================

    JaasAuthenticationFailedEvent failedEvent;
    JaasAuthenticationSuccessEvent successEvent;

    //~ Methods ========================================================================================================

    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof JaasAuthenticationFailedEvent) {
            failedEvent = (JaasAuthenticationFailedEvent) event;
        }

        if (event instanceof JaasAuthenticationSuccessEvent) {
            successEvent = (JaasAuthenticationSuccessEvent) event;
        }
    }
}
