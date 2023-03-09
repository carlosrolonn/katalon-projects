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

'abrir modal de direcciones'
Mobile.tap(findTestObject('Object Repository/Crear direccion/android.widget.TextView - Selector Direccion Home'), 0)

'nueva direccion'
Mobile.tap(findTestObject('Object Repository/Crear direccion/android.widget.TextView - Aadir nueva direccin'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'siguiente confirmar ubicacion '
Mobile.tap(findTestObject('Crear direccion/android.widget.TextView - Siguiente'), 0)

'calle principal'
Mobile.setText(findTestObject('Object Repository/Crear direccion/android.widget.EditText - Calle Principal'), 'Calle principal', 
    0)

'calle secundaria'
Mobile.setText(findTestObject('Object Repository/Crear direccion/android.widget.EditText - Calle Secundaria'), 'Calle secundaria', 
    0)

'numero de casa'
Mobile.setText(findTestObject('Object Repository/Crear direccion/android.widget.EditText - Nmero de Casa'), '123', 0)

'referencia'
Mobile.setText(findTestObject('Object Repository/Crear direccion/android.widget.EditText - Referencia (Color del portn, etc.)'), 
    'Referencia', 0)

'logo'
Mobile.tap(findTestObject('Object Repository/Crear direccion/android.widget.ImageView Logo Direcciones'), 0)

'nombre de direccion'
Mobile.setText(findTestObject('Object Repository/Crear direccion/android.widget.EditText - Casa, Oficina'), 'Direccion prueba', 
    0)

'crear direccion'
Mobile.tap(findTestObject('Object Repository/Crear direccion/android.widget.TextView - Agregar'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'validacion de direccion creada'
Mobile.getText(findTestObject('Object Repository/Crear direccion/android.widget.TextView - Enviar a Direccion prueba'), 
    0)

not_run: Mobile.tap(findTestObject('Crear direccion/android.widget.TextView - Enviar a Direccion prueba'), 0)

