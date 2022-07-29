package games.rednblack.miniaudiotest.ios;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;

import games.rednblack.miniaudiotest.IPlatform;
import games.rednblack.miniaudiotest.MiniAudioTest;

/** Launches the iOS (RoboVM) application. */
public class IOSLauncher extends IOSApplication.Delegate implements IPlatform {
	@Override
	protected IOSApplication createApplication() {
		IOSApplicationConfiguration configuration = new IOSApplicationConfiguration();
		return new IOSApplication(new MiniAudioTest(this), configuration);
	}

	public static void main(String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, IOSLauncher.class);
		pool.close();
	}

	@Override
	public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
		return super.didFinishLaunching(application, launchOptions);
	}

	@Override
	public Object getAssetsManager() {
		return null;
	}
}