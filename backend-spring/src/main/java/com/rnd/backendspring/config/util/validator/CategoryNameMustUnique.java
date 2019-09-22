package com.rnd.backendspring.config.util.validator;



import com.rnd.backendspring.config.util.validator.impl.CategoryNameMustUniqueImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = {
        CategoryNameMustUniqueImpl.class
})
@Documented
public @interface CategoryNameMustUnique {

    String message() default "please category name must unique";

    Class<?>[] groups()
            default {};

    Class<? extends Payload>[] payload()
            default {};

    String[] path()
            default {};
}
