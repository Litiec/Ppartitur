package ppartitur.lib;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

final class Notation {
	
	private List<Parameter> notation;
	private List<Float> bandmaster;
	private int index = 2;
	protected float speed;
	private Ppartitur p;
	protected Notation(Ppartitur p, float speed) {
		this.p = p;
		this.speed = speed;
		notation = new ArrayList<Parameter>();
		
	}
	protected void create(int duration,int velocity, int...chord) {
		
		if(index<p.node().hNode.length) {
			notation.add(new Parameter(p,index++,duration, velocity, chord));
		}
		else {
			PApplet.println("Notation WindowSizeOutOfRangeException");
			throw new ArrayIndexOutOfBoundsException();
			
		} 
	}
	protected void setBandmaster(int...gesture) {
		bandmaster = new ArrayList<Float>();
		bandmaster = Bandmaster.bandmaster(gesture);
	}
	protected List<Float> getBandmaster(){
		return bandmaster;
	}
	protected List<Parameter> getNotation(){
		return notation;
	}
}
