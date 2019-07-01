//In order to use this library you need to install "themidibus" library
// use ableton to send TIMING_CLOCK to you midi port::: set it to 60BMP

import ppartitur.lib.*;// Main Library
import themidibus.*;

MidiBus bus;
Ppartitur partitur;

void setup(){
  size(1000,750, P2D);
  partitur = new Ppartitur(this, "REGISTER");// Create the enviroment
  // add staffs with a clef using the enum Clef
  //TRY DIFFERENT COMIBNATION
  
  /*
  //G clef and F clef
  partitur.createStaff(Clef.G);// from 60 to 83 
  partitur.createStaff(Clef.F);// from 40 to 59 
  partitur.insertData(60,new int[][]{{40},{59},{60},{83}},new int[]{1,1,1,1},new int[]{60,60,60,60},new int[]{10,10,10,10});
}
  */
  
   /*
  //G15 clef and G clef
  partitur.createStaff(Clef.G15);// from 84 to 107 
  partitur.createStaff(Clef.G);// from 60 to 83 
  partitur.insertData(60,new int[][]{{60},{83},{84},{107}},new int[]{1,1,1,1},new int[]{60,60,60,60},new int[]{10,10,10,10});
  */
  
   /*
  //F clef and F15 clef
  partitur.createStaff(Clef.F);// from 40 to 59 
  partitur.createStaff(Clef.F15);// from 21 to 39 
  partitur.insertData(60,new int[][]{{21},{39},{40},{59}},new int[]{1,1,1,1},new int[]{60,60,60,60},new int[]{10,10,10,10});
  */
  
  /*
  // C clef and G extended C
   partitur.createStaff(Clef.C_G);// from 72 to 83 
   partitur.createStaff(Clef.C);// from 48 to 71 
   partitur.insertData(60,new int[][]{{48},{71},{72},{83}},new int[]{1,1,1,1},new int[]{60,60,60,60},new int[]{10,10,10,10});
   */
   bus = new MidiBus(this, "Bus 1", -1);
  
}
void draw(){
  partitur.display();
}

void rawMidi(byte[]data){
  if (data[0] == (byte)0xF8) partitur.play();/// the method must be called every single clockMidi tick;
}
