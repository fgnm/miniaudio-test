package games.rednblack.miniaudiotest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import games.rednblack.miniaudio.MAGroup;
import games.rednblack.miniaudio.MASound;
import games.rednblack.miniaudio.MiniAudio;
import games.rednblack.miniaudio.MAResult;
import games.rednblack.miniaudio.effect.MADelayNode;
import games.rednblack.miniaudio.effect.MAReverbNode;
import games.rednblack.miniaudio.filter.MALowPassFilter;
import games.rednblack.miniaudio.mix.MASplitter;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MiniAudioTest extends ApplicationAdapter {


	public MiniAudioTest(IPlatform platform) {

	}

	@Override
	public void create() {

	}

	float count;
	@Override
	public void render() {
		count += Gdx.graphics.getDeltaTime();
		if(count > 0.2F){
			long m = (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()) / 10000;
			System.out.println(m);
			if (m > 1000) {
				System.gc();
			}
			count = 0;
		}
	}

	@Override
	public void pause() {
		//miniAudio.stopEngine();
		super.pause();
	}

	@Override
	public void resume() {
		//miniAudio.startEngine();
		super.resume();
	}

	@Override
	public void dispose() {
		/*batch.dispose();
		image.dispose();
		maSound.dispose();
		delayNode.dispose();
		miniAudio.dispose();*/
	}
}