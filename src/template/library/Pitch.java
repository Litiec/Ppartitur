package ppartitur.lib;
import processing.core.PShape;

final class Pitch {
	protected final int nodeIndex;
	protected final PShape pitchShape; 
	protected final int ordinal;
	
	protected Pitch(int ordinal,int nodeIndex, boolean sharp, Ppartitur p){
		this.ordinal = ordinal;
		this.nodeIndex = nodeIndex;
		pitchShape = Factory.createNote(nodeIndex, sharp,p);
	}
}
