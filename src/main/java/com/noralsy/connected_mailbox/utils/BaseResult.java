package com.noralsy.connected_mailbox.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResult<T> implements Serializable{
    private String msg;
    private T data;
}
