package se.kth.md.simulinkExchange.conversion.ToSimulink.tasks;


import static org.junit.Assert.*;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import se.kth.md.simulinkExchange.conversion.ToSimulink.tasks.ListCreatorDelegate;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.System;
import Simulink.SystemReference;

public class ListCreatorDelegateTest {

	ListCreatorDelegate delegate;
	Mockery context 		= new JUnit4Mockery();
	Model	modelMock	= context.mock(Model.class);
	System  systemMock  = context.mock(System.class);
	SystemReference sysRefMock = context.mock(SystemReference.class);
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
	Line lineMock = context.mock(Line.class);
	
	@Before
	public void setUp() throws Exception {
		delegate = new ListCreatorDelegate();
	}

	@Test
	public void allElementsAddedToListTest() {
		delegate.doIt(modelMock);
		delegate.doIt(systemMock);
		delegate.doIt(sysRefMock);
		delegate.doIt(inportMock);
		delegate.doIt(outportMock);
		delegate.doIt(lineMock);
		assertEquals(6, delegate.allElementsList().size());
	}
}
