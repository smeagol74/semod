package ru.kvb74.semod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * <p>Элемент или связь не были указаны в спецификации, но неявно проявляют себя через примеры использования</p>
 * <p>Element or relationship was not found in specificaiton, but were mentioned in examples</p>
 */
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MissedInSpec {
}
