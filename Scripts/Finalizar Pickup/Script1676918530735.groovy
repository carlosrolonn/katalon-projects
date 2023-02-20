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

Mobile.startExistingApplication('com.artico.delivery.pedidos')

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.widget.ImageView Banner Comida'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - Pasar a buscar'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.widget.EditText - Buscar en todas las categoras'), 
    0)

Mobile.setText(findTestObject('Object Repository/Finalizar Pickup/android.widget.EditText - Buscar en todas las categoras'), 
    'alberdin' + '\\n', 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.getText(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - Alberdin'), 0)

Mobile.tap(findTestObject('Finalizar Pickup/android.widget.TextView - Alberdin'), 0)

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - 2.34 Km. - Alberdin Villa Morra'), 
    0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.view.ViewGroup primer producto'), 0)

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - Agregar'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - Carrito'), 0)

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - Pago y Facturacin'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.widget.ImageView selector pago'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - Efectivo'), 0)

'obtiene monto total del finalize'
String extractFinalize = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total finalize sin cupon'), 
    0).replaceAll('[^0-9]', '')

'imprime monto (solo numero)'
println(extractFinalize)

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - Finalizar Orden'), 0)

Mobile.getText(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - Desea confirmar la orden'), 
    0)

Mobile.getText(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - Su pedido para PICK UP de Alberdin, estar disponible en'), 
    0)

Mobile.tap(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - Confirmar'), 0)

'Verifica proceso de pago'
Mobile.getText(findTestObject('Finalizar con Cupon/android.widget.TextView - Ya casi estamos, procesando pago'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'Verifica pedido finalizado'
Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Recibido'), 0)

Mobile.getText(findTestObject('Finalizar con Cupon/android.widget.TextView - CONTANOS TU EXPERIENCIA'), 0)

Mobile.getText(findTestObject('Finalizar Efectivo/android.widget.TextView - Pago en Efectivo'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'obtiene monto total en estado de pedido'
String extractEstado = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Estado Total'), 
    0).replaceAll('[^0-9]', '')

'imprime monto total estado (solo numero)'
println(extractEstado)

'validacion de monto en finalize y estado de pedido (exito)'
if (extractFinalize == extractEstado) {
    KeywordUtil.markPassed(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL ESTADO DE LA ORDEN:') + 
        ' ') + extractEstado) + ' ') + 'COINCIDEN CORRECTAMENTE')
} else {
    KeywordUtil.markFailedAndStop(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL ESTADO DE LA ORDEN:') + 
        ' ') + extractEstado) + ' ') + 'NO COINCIDEN')
}

Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Estado Total'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'obtiene monto total del detalle de orden de la cabecera'
String extractTotalDetalleCabecera = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total cabecera detalle'), 
    0).replaceAll('[^0-9]', '')

'imprime monto total del detalle de orden (solo numero)'
println(extractTotalDetalleCabecera)

'validacion de monto total y descuento en detalle de orden de la cabecera'
if (extractFinalize == extractTotalDetalleCabecera) {
    KeywordUtil.markPassed(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN EN CABECERA:') + 
        ' ') + extractTotalDetalleCabecera) + ' ') + 'COINCIDEN CORRECTAMENTE')
} else {
    KeywordUtil.markFailedAndStop(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN EN CABECERA:') + 
        ' ') + extractTotalDetalleCabecera) + ' ') + 'NO COINCIDEN')
}

'obtiene monto total del detalle de orden'
String extractTotalDetalle = Mobile.getText(findTestObject('Object Repository/Finalizar Pickup/android.widget.TextView - total detalle de orden pickup'), 
    0).replaceAll('[^0-9]', '')

'imprime monto total del detalle de orden (solo numero)'
println(extractTotalDetalle)

'validacion de monto total y descuento en detalle de orden'
if (extractFinalize == extractTotalDetalle) {
    KeywordUtil.markPassed(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN:') + 
        ' ') + extractTotalDetalle) + ' ') + 'COINCIDEN CORRECTAMENTE')
} else {
    KeywordUtil.markFailedAndStop(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN:') + 
        ' ') + extractTotalDetalle) + ' ') + 'NO COINCIDEN')
}

'atras para volver al estado de la orden'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Ir atras'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'atras para volver a la home'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Ir atras'), 0)

