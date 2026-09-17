package com.tca.generator;

import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {

		Random r=new Random();
		int a=r.nextInt(9);
		int b=r.nextInt(9);
		
		return "RBT"+a+b;
	}

}
