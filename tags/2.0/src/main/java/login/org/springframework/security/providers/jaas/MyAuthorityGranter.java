
package login.org.springframework.security.providers.jaas;

import java.security.Principal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.providers.jaas.AuthorityGranter;


/**
 * DOCUMENT ME!
 *
 * @author Ray Krueger
 * @version $Id: TestAuthorityGranter.java 2217 2007-10-27 00:45:30Z luke_t $
 */
public class MyAuthorityGranter implements AuthorityGranter {
    //~ Methods ========================================================================================================

    public Set grant(Principal principal) {
        Set rtnSet = new HashSet();

        if (principal.getName().equals("TEST_PRINCIPAL")) {
            rtnSet.add("ROLE_TEST1");
            rtnSet.add("ROLE_TEST2");
        }

        return rtnSet;
    }
}
