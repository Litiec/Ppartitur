package ppartitur.lib;
import processing.core.PApplet;

final class Node {
	protected int[] hNode;
	protected int[] vNode;
	Node(PApplet applet){
		hNode = new int[applet.width/60];
		for(int x = 0; x<hNode.length; x++) hNode[x]=x*60;
		vNode = new int[15];
		for(int y = 0; y<vNode.length; y++) vNode[y]=y*5;
	}
}
