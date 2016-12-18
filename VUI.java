package Undergraduate_Project;

import java.io.*;
import javax.sound.sampled.*;

public class VUI {
		
    private File fl1_clip = new File("../Elevator_Main/src/resources/arriving_floor_one.wav");
    private File fl2_clip = new File("../Elevator_Main/src/resources/arriving_floor_two.wav");
    private File fl3_clip = new File("../Elevator_Main/src/resources/arriving_floor_three.wav");
    private File fl4_clip = new File("../Elevator_Main/src/resources/arriving_floor_four.wav");
    private File fl5_clip = new File("../Elevator_Main/src/resources/arriving_floor_five.wav");
    private File emerg_clip = new File("../Elevator_Main/src/resources/emergency_alert.wav");
    private File weight_clip = new File("../Elevator_Main/src/resources/weight_alert.wav");
    private File obstru_clip = new File("../Elevator_Main/src/resources/door_obstru.wav");

    public VUI() {
    
    }

    //opens and starts play the wav files
    private void play(File file) 
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            Clip play = AudioSystem.getClip(); 

            play.open(ais);
            play.start();
            
            
            while (!play.isRunning())
                Thread.sleep(10);
            while (play.isRunning())
                Thread.sleep(10);

            BooleanControl muteControl = (BooleanControl) play.getControl(BooleanControl.Type.MUTE);
            if(muteControl != null){
                muteControl.setValue(true); // True to mute the line, false to unmute
            }
            
            play.stop();
            play.loop(0);
            play.flush();
            play.close();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }
     
    // plays the selected clip based on the number
    // 1-5 correspond to the arrival at floor messages
    // 6 corresponds to emergency message
    // 7 corresponds to the weight limit message
    public void play_clip(int clip_number){
    	switch(clip_number) {
    	case 1:
    		this.play(fl1_clip);
    		break;
    	case 2:
    		this.play(fl2_clip);
    		break;
    	case 3:
    		this.play(fl3_clip);
    		break;
    	case 4:
    		this.play(fl4_clip);
    		break;
    	case 5:
    		this.play(fl5_clip);
    		break;
    	case 6:
    		this.play(emerg_clip);
    		break;
    	case 7:
    		this.play(weight_clip);
    		break;
    	case 8:
    		this.play(obstru_clip);
    	default:
    		break;
    	}
        
    }
}