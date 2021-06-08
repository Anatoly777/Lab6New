package com.lab6.dataTransfer;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Класс стандартного ответа.
 * body хранит строковые поля
 * attachments хранит любые dataTransference
 */
public class Request implements Serializable {
    private static final long serialVersionUID = 554999767675365L;
    public final String method;
    public final HashMap<String, DataTransference<?>> attachments;

    public Request( String method , HashMap<String, DataTransference<?>> attachments)  {

        this.method = method;
        this.attachments = attachments;
    }


}
