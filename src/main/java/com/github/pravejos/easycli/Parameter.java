package com.github.pravejos.easycli;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Parameter {
  int position();

  String desc() default "";

  String defaultValue() default "";

  boolean required() default false;
}
