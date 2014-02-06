package org.jboss.windup.config.parser.xml;

import static org.joox.JOOX.$;

import java.util.List;

import org.jboss.windup.config.actions.ForeachAction;
import org.jboss.windup.config.parser.ConfigurationException;
import org.jboss.windup.config.parser.ElementHandler;
import org.jboss.windup.config.parser.HandlerManager;
import org.jboss.windup.config.parser.NamespaceElementHandler;
import org.w3c.dom.Element;

@NamespaceElementHandler(elementName="foreach", namespace="http://windup.jboss.org/v1/xml")
public class ForeachHandler implements ElementHandler<ForeachAction<?>> {

	@Override
	public ForeachAction<?> processElement(HandlerManager handlerManager, Element element) throws ConfigurationException {
		ForeachAction and = new ForeachAction();
		List<Element> children = $(element).children().get();
		for(Element child : children) {
			Object obj = handlerManager.processElement(child);
			and.getActions().add(obj);
		}
		return and;
	}

}