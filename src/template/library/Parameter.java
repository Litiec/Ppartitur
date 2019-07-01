package ppartitur.lib;

import processing.core.PApplet;

final class Parameter {
	protected int index;
	protected int duration;
	protected int velocity;
	protected Pitch[] chord;
	protected Parameter(Ppartitur p, int index,int duration, int velocity,int...chord){
		this.index = index;
		this.duration = duration;
		this.velocity = (int)PApplet.map(velocity, 0, 127, 0, 80);
		this.chord = new Pitch[chord.length];
		for(int i = 0; i < chord.length; i++) {
			this.chord[i] = p.pcset().pitch(chord[i]);
		}
	}
}
