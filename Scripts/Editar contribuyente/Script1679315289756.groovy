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

Mobile.tap(findTestObject('Object Repository/Editar contribuyente/android.widget.TextView - Datos Contribuyentes'), 0)

Mobile.tap(findTestObject('Object Repository/Editar contribuyente/android.view.ViewGroup - Tres puntos contribuyente'), 0)

Mobile.tap(findTestObject('Object Repository/Editar contribuyente/android.view.ViewGroup - Lapiz contribuyente'), 0)

Mobile.tap(findTestObject('Object Repository/Editar contribuyente/android.widget.EditText - Razon Prueba'), 0)

Mobile.setText(findTestObject('Object Repository/Crear contribuyente/android.widget.EditText - Razn Social'), 'Razon Prueba Edit' + 
    '\\n', 0)

Mobile.tap(findTestObject('Object Repository/Editar contribuyente/android.widget.EditText - 123456-7'), 0)

Mobile.setText(findTestObject('Object Repository/Crear contribuyente/android.widget.EditText - 1234567-8'), '1234567-8' + 
    '\\n', 0)

Mobile.tap(findTestObject('Object Repository/Editar contribuyente/android.widget.TextView - Guardar'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.getText(findTestObject('Object Repository/Editar contribuyente/android.widget.TextView - Cambios guardados con exito'), 
    0)

Mobile.pressBack()

Mobile.tap(findTestObject('Object Repository/Perfil/android.view.ViewGroup - Menu cupon'), 0)

Mobile.tap(findTestObject('Object Repository/Editar contribuyente/android.widget.TextView - Datos Contribuyentes'), 0)

Mobile.getText(findTestObject('Object Repository/Editar contribuyente/android.widget.TextView - Razon Prueba Edit'), 0)

Mobile.getText(findTestObject('Object Repository/Editar contribuyente/android.widget.TextView - 1234567-8'), 0)

Mobile.tap(findTestObject('Object Repository/Editar contribuyente/android.view.ViewGroup'), 0)

