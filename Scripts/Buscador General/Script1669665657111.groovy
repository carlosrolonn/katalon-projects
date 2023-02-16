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

Mobile.tap(findTestObject('Buscador General/android.widget.EditText - Buscador home'), 0)

'texto para buscar'
Mobile.setText(findTestObject('Buscador General/android.widget.EditText - Buscador home'), 'masapan' + '\\n', 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'Validacion de resultado exitoso'
Mobile.getText(findTestObject('Object Repository/Buscador General/android.widget.TextView - Encontramos esto para vos'), 
    0)

'Validacion de comercio'
Mobile.getText(findTestObject('Buscador General/android.widget.TextView - Masapan (1)'), 0)

Mobile.tap(findTestObject('Buscador General/android.widget.EditText - Bucador de locales'), 0)

'texto para buscar'
Mobile.setText(findTestObject('Buscador General/android.widget.EditText - Bucador de locales'), 'alberdin' + '\\n', 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'Validacion de resultado exitoso'
Mobile.getText(findTestObject('Object Repository/Buscador General/android.widget.TextView - Encontramos esto para vos'), 
    0)

'validacion de comercio'
Mobile.getText(findTestObject('Buscador General/android.widget.TextView - Alberdin (1)'), 0)

Mobile.tap(findTestObject('Buscador General/android.widget.EditText - Bucador de locales'), 0)

'texto para buscar'
Mobile.setText(findTestObject('Buscador General/android.widget.EditText - Bucador de locales'), 'nutritiva store' + '\\n', 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'Validacion de resultado exitoso'
Mobile.getText(findTestObject('Object Repository/Buscador General/android.widget.TextView - Encontramos esto para vos'), 
    0)

'validacion de comercio'
Mobile.getText(findTestObject('Buscador General/android.widget.TextView - Nutritiva Store (1)'), 0)

'atras buscador'
Mobile.tap(findTestObject('Object Repository/Buscador General/android.widget.TextView - ir atras buscador'), 0)
