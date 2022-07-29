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
	private SpriteBatch batch;
	private Texture image;
	private MiniAudio miniAudio;
	private MASound maSound;
	private MAGroup maGroup;
	private MADelayNode delayNode;
	private IPlatform platform;
	private float angle;

	public MiniAudioTest(IPlatform platform) {
		this.platform = platform;
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		image = new Texture("libgdx.png");
		miniAudio = new MiniAudio();
		miniAudio.setupAndroid(platform.getAssetsManager());
		maGroup = miniAudio.createGroup();
		maGroup.setSpatialization(true);
		//int res = miniAudio.playSound("game.ogg");
		//System.out.println(res);
		maSound = miniAudio.createSound("audio/file_example_OOG_5MG.ogg", (short) 0, maGroup);
		delayNode = new MADelayNode(miniAudio, 0.2f, 0.5f);
		/*miniAudio.attachToEngineOutput(delayNode, 0);
		delayNode.attachToThisNode(maGroup, 0);*/
		MASplitter splitter = new MASplitter(miniAudio);
		MALowPassFilter lowPassFilter = new MALowPassFilter(miniAudio, 550, 8);
		MAReverbNode delayNode = new MAReverbNode(miniAudio);
		miniAudio.attachToEngineOutput(lowPassFilter, 0);
		miniAudio.attachToEngineOutput(delayNode, 0);
		lowPassFilter.attachToThisNode(splitter, 0);
		delayNode.attachToThisNode(splitter, 1);
		//splitter.attachToThisNode(maGroup, 0);
		maSound.loop();
		System.out.println(maSound.getLength());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(image, 140, 210);
		batch.end();
		//System.out.println(maSound.getCursorPosition());
		angle += MathUtils.PI / 4f / 100f;
		//maGroup.setPosition(MathUtils.sin(angle), 0f, -MathUtils.cos(angle));
	}

	@Override
	public void pause() {
		miniAudio.stopEngine();
		super.pause();
	}

	@Override
	public void resume() {
		miniAudio.startEngine();
		super.resume();
	}

	@Override
	public void dispose() {
		batch.dispose();
		image.dispose();
		maSound.dispose();
		delayNode.dispose();
		miniAudio.dispose();
	}
}