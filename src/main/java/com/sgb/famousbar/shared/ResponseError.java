package com.sgb.famousbar.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sebastián Gamboa
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponseError {
    
    private int status;
    private String message;
}
