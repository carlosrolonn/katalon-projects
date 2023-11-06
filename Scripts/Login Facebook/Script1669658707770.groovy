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

'inicio de app'
Mobile.startExistingApplication('com.artico.delivery.pedidos')

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Login email/V4/android.widget.ImageView - Logo de inicio'), 0)

'click en facebook'
Mobile.tap(findTestObject('Object Repository/Login Facebook/android.widget.TextView - Facebook'), 0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

'validacion de modal direccion'
Mobile.getText(findTestObject('Object Repository/Login Facebook/android.widget.TextView - A dnde enviamos tu pedido'), 0)

'seleccion de direccion'
Mobile.tap(findTestObject('Object Repository/Login Facebook/android.widget.TextView -'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'menu lateral'
Mobile.tap(findTestObject('Login Facebook/android.widget.TextView - menu lateral'), 0)

'cerrar sesion'
Mobile.tap(findTestObject('Login email/V4/android.widget.TextView - Cerrar Sesion'), 0)

