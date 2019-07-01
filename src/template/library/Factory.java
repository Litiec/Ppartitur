package ppartitur.lib;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PShape;

final class Factory {
	static PShape createNoteHead(int index,Ppartitur p) {
		PShape noteHead = p.applet.createShape(PConstants.ELLIPSE,0,0,6,5);
		noteHead.setFill(p.applet.color(0));
		noteHead.scale(1.5f);
		noteHead.translate(0, p.node().vNode[index]);
		return noteHead;
		
	}
	static PShape createDash(int index,Ppartitur p) {
		PShape dash = p.applet.createShape(PConstants.LINE,0,0,12,0);
		dash.setStrokeWeight(1.5f);
		dash.scale(1.5f);
		dash.translate(-9, p.node().vNode[index]);
		return dash;
	}
	static PShape createSharp(int index,Ppartitur p) {
		PShape sharp = p.applet.loadShape("sharp.svg");
		sharp.scale(1.5f);
		sharp.translate(-22, p.node().vNode[index]-13.5f);
		return sharp;
		
	}
	static PShape createNote(int index, boolean sharp,Ppartitur p) {
		PShape tmp = p.applet.createShape(PConstants.GROUP);
		if(index == -1) {
			tmp.setVisible(false);
		}
		else if(index == 0 || index == 1) {
			switch(index) {
			case 0:
				tmp.addChild(createDash(1,p));
				tmp.addChild(createNoteHead(index,p));
				if(sharp) tmp.addChild(createSharp(index,p));
				break;
			case 1:
				tmp.addChild(createDash(index,p));
				tmp.addChild(createNoteHead(index,p));
				if(sharp) tmp.addChild(createSharp(index,p));
			}
		}
		else if(index>1&&index <=12) {
			tmp.addChild(createNoteHead(index,p));
			if(sharp) tmp.addChild(createSharp(index,p));
		}
		else if(index>12) {
			tmp.addChild(createDash(13,p));
			tmp.addChild(createNoteHead(index,p));
			if(sharp)tmp.addChild(createSharp(index,p));
		}
		return tmp;
	}
	static PFont bravuraFont(Ppartitur p, int size) {
		PFont bravura = p.applet.createFont("Bravura.otf", size);
		return bravura;	
	}
}

