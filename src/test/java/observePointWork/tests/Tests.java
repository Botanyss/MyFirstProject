package observePointWork.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import observePointWork.beforeAfter.BaseTest;

public class Tests extends BaseTest {

	@Test
	public void CreationWebJourney() throws InterruptedException  {


    	myCards.clickOnCreateNewButton();
    	myCards.selectWebJourneyCard();
    	createWebJourneyWindow.pageIsOpened();
        createWebJourneyWindow.feelAllMandatoryFieldsCreateNewWebJourney("CreationWebJourneyTest",
                                                                     "CreationWebJourneyTestFolder",
                                                                    "http://qa.jpstyle.us");
        myCards.closeSuccessModalWindow();
        myCards.searchFromMyCards("CreationWebJourneyTest");


        Assert.assertTrue(myCards.isCardVisible("CreationWebJourneyTest123456765433"), " Card was not displayed");
    }



}




