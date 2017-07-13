package com.github.diegopacheco.aws.xray.main;

import java.net.URL;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorder;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.entities.Segment;
import com.amazonaws.xray.entities.TraceID;
import com.amazonaws.xray.plugins.EC2Plugin;
import com.amazonaws.xray.strategy.FixedSegmentNamingStrategy;
import com.amazonaws.xray.strategy.SegmentNamingStrategy;
import com.amazonaws.xray.strategy.sampling.LocalizedSamplingStrategy;

public class MainRunner {
	
	private static SegmentNamingStrategy segmentNamingStrategy;
	private static AWSXRayRecorder recorder =  AWSXRay.getGlobalRecorder();
	
	static{
		AWSXRayRecorderBuilder builder = AWSXRayRecorderBuilder.standard().withPlugin(new EC2Plugin());
		URL ruleFile = MainRunner.class.getResource("/sampling-rules.json");
		builder.withSamplingStrategy(new LocalizedSamplingStrategy(ruleFile));
		AWSXRay.setGlobalRecorder(builder.build());
		segmentNamingStrategy = new FixedSegmentNamingStrategy("aws-xray-poc");
	}
	
	public static void approachA() throws Exception{
		
		String segmentName = segmentNamingStrategy.nameForRequest(null);
		Segment segment = recorder.beginSegment(segmentName, new TraceID(), null);
		
		Thread.sleep(2000);
		
		if (segment.end()) {
			 recorder.sendSegment(segment);
		}
		
		System.out.println("Approach A - DONE");
		
	}
	
	public static void main(String[] args) {
		try{
			approachA();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
