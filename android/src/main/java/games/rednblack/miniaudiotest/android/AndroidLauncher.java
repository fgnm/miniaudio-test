package games.rednblack.miniaudiotest.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import games.rednblack.miniaudiotest.IPlatform;
import games.rednblack.miniaudiotest.MiniAudioTest;

/** Launches the Android application. */
public class AndroidLauncher extends AndroidApplication implements IPlatform {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration configuration = new AndroidApplicationConfiguration();
		initialize(new MiniAudioTest(this), configuration);
	}

	@Override
	public Object getAssetsManager() {
		return getAssets();
	}
}