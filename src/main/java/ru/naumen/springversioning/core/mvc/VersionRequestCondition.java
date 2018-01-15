package ru.naumen.springversioning.core.mvc;

import com.sun.istack.internal.Nullable;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import ru.naumen.springversioning.core.model.ApiVersion;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Condition. Used as {@link java.util.function.Predicate} for filtering {@link ApiVersion}
 *
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
