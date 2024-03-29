package com.wet.wired.jrc.frame.capture;

import java.awt.Dimension;

import junit.framework.TestCase;

import com.wet.wired.jrc.frame.Frame;

public class ScreenGrabberTest extends TestCase {

	public void testScreenSizeReturned() throws FrameCaptureException {
		Dimension screenSize = new ScreenGrabber().getFrameSize();
		
		assertNotNull(screenSize);
		if(screenSize.width==0 || screenSize.height==0) {
			fail( "Screen size must not be 0 width or height" );
		}
	}
	
	public void testFrameReturned() throws FrameCaptureException {
		Frame frame = new ScreenGrabber().grabFrame();
		
		assertNotNull(frame);
		
		if(frame.getDataSize()==0) {
			fail("Frame data size must not be 0");
		}
		Dimension frameSize = frame.getFrameSize();
		if(frameSize.width==0 || frameSize.height==0) {
			fail( "Frame size must not be 0 width or height" );
		}
	}
	
	public void testFrameSizeMatchesScreenSize() throws FrameCaptureException {
		ScreenGrabber screenGrabber = new ScreenGrabber();
		Frame frame = screenGrabber.grabFrame();
		Dimension screenSize = screenGrabber.getFrameSize();
		Dimension frameSize = frame.getFrameSize();
		
		if(frameSize.width!=screenSize.width || frameSize.height!=screenSize.height) {
			fail( "Frame size must match Screen size" );
		}
	}
}
