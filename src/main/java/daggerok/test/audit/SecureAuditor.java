package daggerok.test.audit;

import lombok.val;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class SecureAuditor implements AuditorAware<String> {

  @Override
  public String getCurrentAuditor() {

    val ctx = SecurityContextHolder.getContext();
    if (isNull(ctx)) return null;

    val authentication = ctx.getAuthentication();
    if (isNull(authentication) || !authentication.isAuthenticated()) {
      return null;
    }

    val usedDetails = (UserDetails) authentication.getPrincipal();
    if (isNull(usedDetails)) return null;

    return usedDetails.getUsername();
  }
}
