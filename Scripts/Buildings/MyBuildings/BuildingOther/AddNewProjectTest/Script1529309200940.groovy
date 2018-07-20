import internal.GlobalVariable as GlobalVariable


	try {
	
		CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsNavigation.navigateToBuilding'()
		CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsAddNewProject.buildingAddNewProject'(GlobalVariable.BuildingSheet, GlobalVariable.rowNumFive)		
	
	} catch (Throwable t) {
	
		System.out.println(t.getLocalizedMessage())
		Error e1 = new Error(t.getMessage())
		e1.setStackTrace(t.getStackTrace())
		e1.printStackTrace()
	}




