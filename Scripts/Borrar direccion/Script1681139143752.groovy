import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.startExistingApplication('com.artico.delivery.pedidos')

'abrir modal de direccion'
Mobile.tap(findTestObject('Object Repository/Perfil/android.view.ViewGroup - Menu cupon'), 0)

Mobile.tap(findTestObject('Edicion direccion/android.widget.TextView - Direcciones'), 0)

'click en direccion oficina'
Mobile.tap(findTestObject('Object Repository/Edicion direccion/android.widget.TextView - Oficina'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'abrir modal de direcciones'
Mobile.tap(findTestObject('Object Repository/Crear direccion/android.view.ViewGroup Selector Direccion Home 2'), 0)

'click en tres puntos'
Mobile.tap(findTestObject('Object Repository/Edicion direccion/android.view.ViewGroup - Tres puntos borrado'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'click en borrar direccion'
Mobile.tap(findTestObject('Object Repository/Edicion direccion/android.view.ViewGroup - Borrar direccion'), 0)

'confirmar borrar direccion'
Mobile.tap(findTestObject('Object Repository/Edicion direccion/android.widget.TextView - S, eliminar'), 0)

'abrir modal de direcciones'
Mobile.tap(findTestObject('Object Repository/Crear direccion/android.view.ViewGroup Selector Direccion Home 2'), 0)

Mobile.verifyElementNotExist(findTestObject('Object Repository/Edicion direccion/android.widget.TextView - Direccion prueba editado'), 
    7)

Mobile.pressBack()

