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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

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

'extrae titulo de la primera direccion en el selector'
String DireccionSelector = Mobile.getText(findTestObject('Object Repository/Login email/android.widget.TextView - Primera direccion'), 0)

'imprime titulo de la primera direccion en el selector'
println(DireccionSelector)

'extrae calle de la primera direccion en el selector'
String CallesSelector = Mobile.getText(findTestObject('Object Repository/Login email/android.widget.TextView - Calles Primera Direccion'), 0)

'imprime calle de la primera direccion en el selector'
println(CallesSelector)

'seleccion de direccion'
Mobile.tap(findTestObject('Object Repository/Login email/android.widget.TextView - direccion'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'extrae titulo de la direccion en la home'
String DireccionHome = Mobile.getText(findTestObject('Object Repository/Login email/android.widget.TextView - Direccin Home'), 0).replace("Enviar a ", "").replaceAll("\\s", "")

'imprime titulo de la direccion en la home'
println(DireccionHome)

'extrae calle de la direccion en la home'
String CallesHome = Mobile.getText(findTestObject('Object Repository/Login email/android.widget.TextView - Calles Direccin home'), 0)

'imprime texto de la direccion en la home'
println(CallesHome)

'validacion de dirección seleccionada'
if (DireccionSelector == DireccionHome) {
	KeywordUtil.markPassed(((((((('LA DIRECCION SELECCIONADA:' + ' ') + DireccionSelector) + ' ') + 'Y LA DIRECCION APLICADA DESDE LA HOME:') +
		' ') + DireccionHome) + ' ') + 'COINCIDEN CORRECTAMENTE')
} else {
	KeywordUtil.markFailedAndStop(((((((('LA DIRECCION SELECCIONADA:' + ' ') + DireccionSelector) + ' ') + 'Y LA DIRECCION APLICADA DESDE LA HOME:') +
		' ') + DireccionHome) + ' ') + 'NO COINCIDEN')
}

'validacion de las calles de la dirección seleccionada'
if (CallesSelector == CallesHome) {
	KeywordUtil.markPassed(((((((('LAS CALLES DE LA DIRECCION SELECCIONADA:' + ' ') + CallesSelector) + ' ') + 'Y LAS CALLES DE LA DIRECCION APLICADA DESDE LA HOME:') +
		' ') + CallesHome) + ' ') + 'COINCIDEN CORRECTAMENTE')
} else {
	KeywordUtil.markFailedAndStop(((((((('LAS CALLES DE LA DIRECCION SELECCIONADA:' + ' ') + CallesSelector) + ' ') + 'Y LAS CALLES DE LA DIRECCION APLICADA DESDE LA HOME:') +
		' ') + CallesHome) + ' ') + 'NO COINCIDEN')
}