package ru.naumen.springversioning;

import java.lang.annotation.*;

/**
 * @author achernoprudov
 * @since 26/12/2017
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestVersion
{
    ApiVersion[] version();
}
