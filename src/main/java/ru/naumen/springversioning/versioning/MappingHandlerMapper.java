package ru.naumen.springversioning.versioning;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import ru.naumen.springversioning.ApiVersion;
import ru.naumen.springversioning.RestVersion;
import ru.naumen.springversioning.versioning.VersionRequestCondition;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author achernoprudov
 * @since 26/12/2017
 */
public class MappingHandlerMapper extends RequestMappingHandlerMapping
{
    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method)
    {
        RestVersion restVersion = AnnotationUtils.findAnnotation(method, RestVersion.class);
        if (null == restVersion)
        {
            return null;
        }
        List<ApiVersion> apiVersions = Arrays.asList(restVersion.version());
        return new VersionRequestCondition(apiVersions);
    }
}
