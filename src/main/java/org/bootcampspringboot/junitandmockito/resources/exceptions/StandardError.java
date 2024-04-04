package org.bootcampspringboot.junitandmockito.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
@Getter
@AllArgsConstructor
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Instant timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;



}
