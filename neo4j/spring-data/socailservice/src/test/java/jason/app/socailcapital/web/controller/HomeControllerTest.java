package jason.app.socailcapital.web.controller;

import jason.app.socailcapital.web.controller.HomeController;
import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class HomeControllerTest {

	@Test
	@Ignore
	public void testController() {
		HomeController controller = new HomeController();
		Model model = new ExtendedModelMap();
		Assert.assertEquals("home",controller.home(model));
		
		Object message = model.asMap().get("controllerMessage");
		Assert.assertEquals("This is the message from the controller!",message);		
	}
}
