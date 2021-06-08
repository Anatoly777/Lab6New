package com.lab6.dataTransfer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс стандартного ответа.
 * Сообщения передаются в messages
 * Статус запроса присваивается SUCCESS или ERROR
 * body хранит строковые поля
 * attachments хранит любые dataTransference
 */
public class Response implements Serializable {
    private static final long serialVersionUID = 55499976766756565L;
    public enum Status {
        OK,
        ERROR
    }

    public final ArrayList<String> messages;
    public final HashMap<String, DataTransference<?>> attachments;

    public Response(Status status, ArrayList<String> messages, HashMap<String, DataTransference<?>> attachments) {
        this.messages = messages;
        this.attachments = attachments;
    }


}