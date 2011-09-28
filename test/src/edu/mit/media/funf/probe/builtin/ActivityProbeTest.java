/**
 * Funf: Open Sensing Framework
 * Copyright (C) 2010-2011 Nadav Aharony, Wei Pan, Alex Pentland. 
 * Acknowledgments: Alan Gardner
 * Contact: nadav@media.mit.edu
 * 
 * This file is part of Funf.
 * 
 * Funf is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version. 
 * 
 * Funf is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with Funf. If not, see <http://www.gnu.org/licenses/>.
 */
package edu.mit.media.funf.probe.builtin;

import android.os.Bundle;
import edu.mit.media.funf.probe.Probe.SystemParameter;

public class ActivityProbeTest extends ProbeTestCase<ActivityProbe> {

	public ActivityProbeTest() {
		super(ActivityProbe.class);
	}

	public void testData() throws InterruptedException {
		Bundle params = new Bundle();
		params.putLong(SystemParameter.DURATION.name, 5L);
		params.putLong(SystemParameter.PERIOD.name, 0L);
		sendDataRequestBroadcast(params);
		Bundle data = getData(20);
		assertTrue(data.containsKey("TOTAL_INTERVALS"));
		assertTrue(data.containsKey("ACTIVE_INTERVALS"));
		//System.out.println("I: " + data.getInt("TOTAL_INTERVALS") + " A:" + data.getInt("ACTIVE_INTERVALS"));
	}
	
	public void testWithAccelerometerBroadcast() throws InterruptedException {
		sendDataRequestBroadcast(AccelerometerSensorProbe.class, new Bundle());
		
		Bundle params = new Bundle();
		params.putLong(SystemParameter.DURATION.name, 2L);
		params.putLong(SystemParameter.PERIOD.name, 0L);
		sendDataRequestBroadcast(params);
		Bundle data = getData(20);
		assertTrue(data.containsKey("TOTAL_INTERVALS"));
		assertTrue(data.containsKey("ACTIVE_INTERVALS"));
	}
}