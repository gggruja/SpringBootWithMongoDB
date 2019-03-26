package com.goran.interv.play.service.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD})
@Documented
public @interface Log {
}

