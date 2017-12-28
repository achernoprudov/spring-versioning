package ru.naumen.springversioning.versioning;

import com.sun.istack.internal.Nullable;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import ru.naumen.springversioning.ApiVersion;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author achernoprudov
 * @since 26/12/2017
 */
public class VersionRequestCondition implements RequestCondition<VersionRequestCondition>
{
    private final Set<ApiVersion> versions;

    public VersionRequestCondition(Collection<ApiVersion> versions)
    {
        this.versions = new HashSet<>(versions);
    }

    @Override
    public VersionRequestCondition combine(VersionRequestCondition other)
    {
        HashSet<ApiVersion> combined = new HashSet<>(versions);
        combined.addAll(other.versions);
        return new VersionRequestCondition(combined);
    }

    @Nullable
    @Override
    public VersionRequestCondition getMatchingCondition(HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        return versions.stream().anyMatch(api -> match(requestURI, api)) ? this : null;
    }

    private boolean match(String requestURI, ApiVersion api)
    {
        return requestURI.contains(api.getCode());
    }

    @Override
    public int compareTo(VersionRequestCondition other, HttpServletRequest request)
    {
        return versions.size() - other.versions.size();
    }
}
