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

'Inicio de app'
Mobile.startExistingApplication('com.artico.delivery.pedidos')

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Verifica logo en inicio de sesión'
Mobile.verifyElementExist(findTestObject('Login email/android.widget.ImageView Logo inicio'), 0)

'Ingresar con email'
Mobile.tap(findTestObject('Object Repository/Login email/android.widget.TextView - Ingresar con E-mail'), 0)

'Ingreso de usuario'
Mobile.setText(findTestObject('Object Repository/Login email/android.widget.EditText - Correo'), 'carlosrolon@monchis.com.py', 
    0)

'Ingreso de pass'
Mobile.setText(findTestObject('Object Repository/Login email/android.widget.EditText - Contrasea'), '123456', 0)

'click en ingresar'
Mobile.tap(findTestObject('Login email/android.widget.TextView - Boton Ingresar'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'validacion de modal direccion'
Mobile.getText(findTestObject('Object Repository/Login email/android.widget.TextView - A dnde enviamos tu pedido'), 0)

'extrae texto del titulo de direccion'
String tituloDireccion = Mobile.getText(findTestObject('Login email/android.widget.TextView - Titulo de direccion Selector'), 0)

'imprime texto del titulo de direccion'
println(tituloDireccion)

'extrae texto de calles'
String tituloCalles = Mobile.getText(findTestObject('Login email/android.widget.TextView - Descripcion de calles Selector'), 0)

'imprime texto de las calles'
println(tituloCalles)

'seleccion de direccion'
Mobile.tap(findTestObject('Object Repository/Login email/android.widget.TextView - direccion'), 0)
