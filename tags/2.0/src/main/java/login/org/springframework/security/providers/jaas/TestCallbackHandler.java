/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package login.org.springframework.security.providers.jaas;

import org.springframework.security.Authentication;
import org.springframework.security.providers.jaas.JaasAuthenticationCallbackHandler;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;


/**
 * TestCallbackHandler
 *
 * @author Ray Krueger
 * @version $Id: TestCallbackHandler.java 2217 2007-10-27 00:45:30Z luke_t $
 */
public class TestCallbackHandler implements JaasAuthenticationCallbackHandler {
    //~ Methods ========================================================================================================

    public void handle(Callback callback, Authentication auth)
        throws IOException, UnsupportedCallbackException {
        if (callback instanceof TextInputCallback) {
            TextInputCallback tic = (TextInputCallback) callback;
            tic.setText(auth.getPrincipal().toString());
        }
    }
}
