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

'click en tres puntos'
Mobile.tap(findTestObject('Object Repository/Edicion direccion/android.view.ViewGroup - Tres puntos 2'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'click en lapiz'
Mobile.tap(findTestObject('Object Repository/Edicion direccion/android.view.ViewGroup - Lapiz edicion'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'siguiente confirma ubicacion'
Mobile.tap(findTestObject('Object Repository/Edicion direccion/android.widget.TextView - Siguiente'), 0)

'edicion de calle principal'
Mobile.setText(findTestObject('Object Repository/Edicion direccion/android.widget.EditText - Calle principal (1)'), 'Calle principal editado', 
    0)

'edicion de calle secundaria'
Mobile.setText(findTestObject('Object Repository/Edicion direccion/android.widget.EditText - Calle secundaria'), 'Calle secundaria editado', 
    0)

'edicion de nro de calle'
Mobile.setText(findTestObject('Object Repository/Edicion direccion/android.widget.EditText - 123'), '456', 0)

'edicion de referencia'
Mobile.setText(findTestObject('Object Repository/Edicion direccion/android.widget.EditText - Referencia (1)'), 'Referencia editado', 
    0)

'edicion logo'
Mobile.tap(findTestObject('Object Repository/Edicion direccion/android.view.ViewGroup - Logo Edicion'), 0)

'edicion de nombre direccion'
Mobile.setText(findTestObject('Object Repository/Edicion direccion/android.widget.EditText - Direccion prueba'), 'Direccion prueba editado', 
    0)

'guardar edicion direccion'
Mobile.tap(findTestObject('Object Repository/Edicion direccion/android.widget.TextView - Guardar'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'abrir modal direccion'
Mobile.tap(findTestObject('Object Repository/Perfil/android.view.ViewGroup - Menu cupon'), 0)

Mobile.tap(findTestObject('Edicion direccion/android.widget.TextView - Direcciones'), 0)

'validacion de direccion editado'
Mobile.getText(findTestObject('Object Repository/Edicion direccion/android.widget.TextView - Direccion prueba editado'), 
    0)

Mobile.pressBack()

