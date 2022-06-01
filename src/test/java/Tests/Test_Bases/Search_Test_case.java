package Tests.Test_Bases;

import Screens.Search_screen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search_Test_case extends Test_Base{

    Search_screen search;

    // this test for enter search value cairo and assert that direction button appears
    @Test
    public void search_for_location(String cairo)
    {
        search=new Search_screen(driver);
        search.open_search_suggestion();
        search.enter_search_value(cairo);
        Assert.assertTrue(search.direction_button.isDisplayed());
    }
}
