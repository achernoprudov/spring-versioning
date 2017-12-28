package ru.naumen.springversioning;

/**
 * @author achernoprudov
 * @since 26/12/2017
 */
public enum ApiVersion
{
    V1("v1"), V2("v2");

    private final String code;

    ApiVersion(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
}
