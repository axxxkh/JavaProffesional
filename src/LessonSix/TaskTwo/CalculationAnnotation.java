package LessonSix.TaskTwo;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.LOCAL_VARIABLE,
        ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CalculationAnnotation {

    /**
     * firstNumber to use in calculation
     */
    int firstNumber();

    /**
     * secondNumber to use in calculation
     */
    int secondNumber() default 1;
}

