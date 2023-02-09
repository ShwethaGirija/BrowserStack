import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	
	@Test
	public void login()
	{
		driver.get("https://www.google.com");
		System.out.println("Title is "+driver.getTitle());
	}
	
}
