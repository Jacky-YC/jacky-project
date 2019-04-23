package com.fastone.test.model;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class People {

    private Long id;
    private String name;
    private Integer age;
    private String company;

}
