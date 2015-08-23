package example;

 import java.util.Set;  
   
 import org.springframework.security.GrantedAuthority;  
 import org.springframework.security.GrantedAuthorityImpl;  
// import org.springframework.security.User;  
 import com.mycompany.app.model.User;   
 
 
 public class UserDetailsAdapter extends User { // 1  
     private final Long id;  
       
     public UserDetailsAdapter(User acct) {  
//         super(acct.getUsername(), acct.getPassword(), acct.isEnabled(),  
//                 true, true, true, toAuthorities( acct.getAuthorityNames()));  
         this.id = acct.getId();  
     }  
       
     private static GrantedAuthority[] toAuthorities(Set<String> authNames) {  
         GrantedAuthority[] auths = new GrantedAuthority[authNames.size()];  
         int i = 0;  
         for (String authName : authNames) {  
             auths[i++] = new GrantedAuthorityImpl(authName);  
         }  
         return auths;  
     }  
       
     public Long getId() {  
         return id;  
     }  
 }  