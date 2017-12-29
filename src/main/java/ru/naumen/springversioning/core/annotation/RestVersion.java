package ru.naumen.springversioning.core.annotation;

import ru.naumen.springversioning.core.model.ApiVersion;

import java.lang.annotation.*;

/**
 * Annotation for controller methods.
 *
 * @author achernoprudov
 * @since 26/12/2017
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestVersion
{
    ApiVersion[] version();
}
