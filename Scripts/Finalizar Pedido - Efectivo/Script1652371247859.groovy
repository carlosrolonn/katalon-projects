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

'Abre la app'
Mobile.startExistingApplication('com.artico.delivery.pedidos', FailureHandling.STOP_ON_FAILURE)

not_run: Mobile.delay(15, FailureHandling.STOP_ON_FAILURE)

'Selección de dirección'
not_run: Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup - SeleccionaDireccion'), 
    0)

not_run: Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'Click en campo de búsqueda'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.EditText - Busc locales o productos (1)'), 0)

Mobile.setText(findTestObject('Finalizar Efectivo/android.widget.EditText - Busc locales o productos (1)'), 'masapan' + 
    '\\n', 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Verifica resultado solo para santa fe'
Mobile.getText(findTestObject('Finalizar Efectivo/android.widget.TextView - Titulo Masapan'), 0)

'Entra en el comercio solo santa fe'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Titulo Masapan'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Entra en el primer producto'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup Seleccion de primer producto'), 0)

'Suma la cantidad del producto +1'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - SumaProducto'), 0)

'Agregar al carrito'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Agregar a carrito'), 0)

'Abrir carrito'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Carrito (1)'), 0)

Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Suma en el carrito'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - - Resta en el carrito'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Pasar a pago y facturación'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Pago y Facturacin'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Abrir selector de método de pagos'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.ImageView abrir selector de pago'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Seleccionar Efectivo'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Efectivo'), 0)

'obtiene monto total del finalize'
String extractFinalize = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Finalize sin cupon Total'), 
    0).replaceAll('[^0-9]', '')

'imprime monto (solo numero)'
println(extractFinalize)

'Finalizar orden'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Finalizar Orden'), 0)

'Verifica proceso de pago'
Mobile.getText(findTestObject('Finalizar con Cupon/android.widget.TextView - Ya casi estamos, procesando pago'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'Verifica pedido finalizado'
Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Recibido'), 0)

Mobile.scrollToText('CONTANOS', FailureHandling.STOP_ON_FAILURE)

Mobile.getText(findTestObject('Finalizar con Cupon/android.widget.TextView - CONTANOS TU EXPERIENCIA'), 0)

Mobile.getText(findTestObject('Finalizar Efectivo/android.widget.TextView - Pago en Efectivo'), 0)

Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Llamar al local'), 0)

Mobile.verifyElementExist(findTestObject('Finalizar Efectivo/android.widget.FrameLayout'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()

Mobile.pressBack()

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Chat con soporte'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.getText(findTestObject('Object Repository/Soporte en Linea/android.widget.TextView - Cmo podemos ayudarte'), 0)

Mobile.tap(findTestObject('Object Repository/Soporte en Linea/android.view.View'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'obtiene monto total en estado de pedido'
String extractEstado = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total estado de pedido 2'), 
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

Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.ImageView - Desplegar detalle de orden'), 0)

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
String extractTotalDetalle = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total detalle sin cupon'), 
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

