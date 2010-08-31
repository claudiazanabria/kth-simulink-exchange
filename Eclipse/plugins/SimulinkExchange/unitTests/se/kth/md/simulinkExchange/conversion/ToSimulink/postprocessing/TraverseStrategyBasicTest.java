package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;

import static java.util.Arrays.asList;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.System;
import Simulink.SystemReference;

/**
 * @author alex
 *
 */
@RunWith(JMock.class)
public abstract class TraverseStrategyBasicTest {

	Mockery context 		= new JUnit4Mockery();
	Model	modelMock	= context.mock(Model.class);
	System  systemMock  = context.mock(System.class);
	SystemReference systemReferenceMock = context.mock(SystemReference.class);
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
	Line lineMock = context.mock(Line.class);
	
	Sequence aSequence 	= context.sequence("aSequence");
	
	ITraverserDelegate delegateMock = context.mock(ITraverserDelegate.class);
	
	// This is defined in subclasses
	ITraverserStrategy traverseStrategy;
	
	@Test
	public abstract void sequenceTest();
	
	@Test
	public void allPartsAreVisitedTest() {
		
		context.checking(new Expectations() {{
			
			oneOf (delegateMock).doIt(with(modelMock));
				inSequence(aSequence);

			oneOf (modelMock).getRoot();
				will(returnValue( systemMock ));
				inSequence(aSequence);
				
			oneOf (delegateMock).doIt(with(systemMock));
				inSequence(aSequence);

			ignoring (systemMock);
			ignoring (delegateMock);
		}} );		
		
		traverseStrategy.doIt(modelMock, delegateMock);
	}

	@Test
	public void systemVisitsItsChildrenTest() {
		
		context.checking(new Expectations() {{
			
			oneOf (delegateMock).doIt(with(systemMock));
				inSequence(aSequence);

			oneOf (systemMock).getChildren();
				will(returnValue(asEList(systemReferenceMock,systemReferenceMock)));
				inSequence(aSequence);
				
			exactly(2).of (delegateMock).doIt(with(systemReferenceMock));
				inSequence(aSequence);

			ignoring (systemMock);
			ignoring (systemReferenceMock);
			ignoring (delegateMock);
		}} );		
		
		traverseStrategy.doIt(systemMock, delegateMock);
	}

	@Test
	public void systemReferenceVisitItsTargetTest() {
		
		context.checking(new Expectations() {{
			
			oneOf (delegateMock).doIt(with(systemReferenceMock));
				inSequence(aSequence);

			oneOf (systemReferenceMock).getTarget();
				will(returnValue( systemMock ));
				inSequence(aSequence);
				
			oneOf (delegateMock).doIt(with(systemMock));
				inSequence(aSequence);

			ignoring (systemMock);
			ignoring (systemReferenceMock);
			ignoring (delegateMock);
		}} );		
		
		traverseStrategy.doIt(systemReferenceMock, delegateMock);
	}
	
	
	@Test
	public void systemVisistItsPorts() {
		
		context.checking(new Expectations() {{
			
			oneOf (systemMock).getInports();
				will(returnValue(asEList(inportMock,inportMock)));
				inSequence(aSequence);
				
			exactly(2).of (delegateMock).doIt(with(inportMock));
				inSequence(aSequence);

			oneOf (systemMock).getOutports();
				will(returnValue(asEList(outportMock,outportMock)));
				inSequence(aSequence);
				
			exactly(2).of (delegateMock).doIt(with(outportMock));
				inSequence(aSequence);

			ignoring (systemMock);
			ignoring (delegateMock);
		}} );		
		
		traverseStrategy.doIt(systemMock, delegateMock);		
	}

	@Test
	public void systemVisistItsLines() {
		
		context.checking(new Expectations() {{
			
			oneOf (systemMock).getLines();
				will(returnValue(asEList(lineMock,lineMock)));
				inSequence(aSequence);
				
			exactly(2).of (delegateMock).doIt(with(lineMock));
				inSequence(aSequence);

			ignoring (systemMock);
			ignoring (delegateMock);
		}} );		
		
		traverseStrategy.doIt(systemMock, delegateMock);		
	}	
	
	//FIXME move this to a more general place
	public static <T> EList<T> asEList(T... a) {
		List<T> aList = asList(a);
		return new BasicEList<T>(aList);
	}
}
