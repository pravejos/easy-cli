package com.github.pravejos.easycli;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Option {
  char shortName() default 0;

  String longName() default "";

  String desc() default "";

  String defaultValue() default "";
}
