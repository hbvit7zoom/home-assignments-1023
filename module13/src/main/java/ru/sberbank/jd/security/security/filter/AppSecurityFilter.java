package ru.sberbank.jd.security.security.filter;

import jakarta.servlet.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.sberbank.jd.security.security.model.AppAuthentication;
import ru.sberbank.jd.security.security.model.Role;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AppSecurityFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String login = getLogin(request);
        Set<Role> roles = getRoles(request);

        AppAuthentication appAuthentication = new AppAuthentication(true, login, roles);
        SecurityContextHolder.getContext().setAuthentication(appAuthentication);

        chain.doFilter(request, response);
    }

    private Set<Role> getRoles(ServletRequest request) {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ADMIN);
        return roles;
    }

    private String getLogin(ServletRequest request) {
        return "Nikita";
    }

}
