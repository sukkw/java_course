package com.sirma.itt.javacourse.decorators;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ServerMessages;

/**
 * This class is used to create different message decorator using factory
 * pattern. Depending on the server message different decorator is instantiated.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class DecoratorFactory {

	/**
	 * Instantiate decorator.
	 * 
	 * @param message - server messge
	 * @param attrSet - decorated element
	 * @return decorator object
	 */
	public ICustomMsgDecorator getDecorator(Message message,
			CustomMsgDecorator attrSet) {

		// server message decorator is created
		if (message.sender.equals(ServerMessages.SERVER)) {

			// important message decorator is created
			if (message.type.equals(ServerMessages.IMPORTANT)) {
				return new ImportantMsgDecorator(
						new ServerMsgDecorator(attrSet));
			}
			return new ServerMsgDecorator(attrSet);
		}

		// private message decorator is created
		if (message.type.equals(ServerMessages.PRIVATE_MESSAGE)) {
			return new PrivateMsgDecorator(attrSet);

		}

		return new ClientMsgDecorator(attrSet);
	}
}
