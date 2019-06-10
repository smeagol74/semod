package ru.kvb74.semod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * <p>Ссылка на источник происхождения элемента или отношения</p>
 * <p>Describes the url which were the cause to create an element or relationship</p>
 */
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Origin {
	String value();
}
