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

Mobile.tap(findTestObject('Object Repository/Perfil/android.view.ViewGroup - Menu cupon'), 0)

Mobile.tap(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.TextView - Quejas y Sugerencias'), 
    0)

Mobile.getText(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.EditText - Dejanos un comentario'), 
    0)

Mobile.pressBack()

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Perfil/android.view.ViewGroup - Menu cupon'), 0)

Mobile.tap(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.TextView - Sugerir un Local'), 0)

Mobile.getText(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.TextView - Sugerir un Local (1)'), 
    0)

Mobile.getText(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.EditText - Nombre'), 0)

Mobile.getText(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.EditText - Direccin'), 0)

Mobile.getText(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.EditText - Observaciones'), 0)

Mobile.pressBack()

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Perfil/android.view.ViewGroup - Menu cupon'), 0)

Mobile.tap(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.TextView - Quiero estar en Monchis'), 
    0)

Mobile.getText(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.TextView - Quiero estar en MONCHIS (1)'), 
    0)

Mobile.getText(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.EditText - Nombre del Local'), 
    0)

Mobile.getText(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.EditText - Nmero de Telfono'), 
    0)

Mobile.getText(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.EditText - Nombre del Contacto'), 
    0)

Mobile.pressBack()

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Perfil/android.view.ViewGroup - Menu cupon'), 0)

Mobile.tap(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.TextView - Trminos y Condiciones'), 
    0)

Mobile.getText(findTestObject('Object Repository/Ultimas opciones del menu/android.widget.TextView - Para continuar por favor acepte los Trminos y Condiciones'), 
    0)

Mobile.pressBack()
