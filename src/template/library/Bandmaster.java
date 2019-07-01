package ppartitur.lib;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PConstants;

final class Bandmaster {
	protected static float[][] yValues;
	static {
		yValues = new float[5][];
		yValues[0] = new float[60];
		float x = 0;
		float yArc = PConstants.TWO_PI/120;
		yValues[1] = new float[60];
		for(int i = 0; i < yValues[0].length; i++) {
			yValues[0][i] = 0;
			yValues[1][i] = PApplet.abs(PApplet.sin(x+=yArc)*79)*-1;
		}
		x = 0;
		yArc = PConstants.TWO_PI/240;
		yValues[2] = new float[120];
		for(int i = 0; i<yValues[2].length;i++) {
			yValues[2][i] = PApplet.abs(PApplet.sin(x+=yArc)*79)*-1;
		}
		x = 0;
		yArc = PConstants.TWO_PI/360;
		yValues[3] = new float[180];
		for(int i = 0; i<yValues[3].length;i++) {
			yValues[3][i] = PApplet.abs(PApplet.sin(x+=yArc)*79)*-1;
		}
		x = 0;
		yArc = PConstants.TWO_PI/480;
		yValues[4] = new float[240];
		for(int i = 0; i<yValues[4].length;i++) {
			yValues[4][i] = PApplet.abs(PApplet.sin(x+=yArc)*79)*-1;
		}
	}
	protected static List<Float> bandmaster(int...gesture){
		List<Float> tmp = new ArrayList<Float>();
		for(int i:gesture) {
			for(int k = 0; k<yValues[i].length;k++) {
				tmp.add(yValues[i][k]);
			}
		}
		return tmp;
	}
}

