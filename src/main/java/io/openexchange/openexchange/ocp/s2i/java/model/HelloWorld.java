package io.openexchange.openexchange.ocp.s2i.java.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class HelloWorld {
    private long id;
    private String message;
}
