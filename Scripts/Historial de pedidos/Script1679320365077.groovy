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

Mobile.tap(findTestObject('Object Repository/Historial de pedidos/android.view.ViewGroup Menu con cupon'), 0)

Mobile.tap(findTestObject('Object Repository/Historial de pedidos/android.widget.TextView - Historial de Pedidos'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.getText(findTestObject('Object Repository/Historial de pedidos/android.widget.TextView - Historial de Pedidos (1)'), 
    0)

Mobile.tap(findTestObject('Object Repository/Historial de pedidos/android.widget.TextView - Ver Detalles'), 0)

Mobile.getText(findTestObject('Object Repository/Historial de pedidos/android.widget.TextView - Detalles del Pedido'), 0)

Mobile.tap(findTestObject('Object Repository/Historial de pedidos/android.widget.TextView - Calificar Orden'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.getText(findTestObject('Object Repository/Historial de pedidos/android.widget.TextView - 1.Cmo califics la experiencia de tu ltima compra'), 
    0)

Mobile.tap(findTestObject('Object Repository/Historial de pedidos/android.widget.Button - SALIR'), 0)

Mobile.pressBack()

Mobile.tap(findTestObject('Object Repository/Historial de pedidos/android.widget.TextView - Calificar Orden (1)'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.getText(findTestObject('Object Repository/Historial de pedidos/android.widget.TextView - 1.Cmo califics la experiencia de tu ltima compra'),
	0)

Mobile.tap(findTestObject('Object Repository/Historial de pedidos/android.widget.Button - SALIR'), 0)

Mobile.pressBack()

