package org.sc.demo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author Sc
 * @date 2021/3/22
 */
@Getter
@Setter
public class SubStudent extends Student {

    @NotBlank
    private String name;
}
