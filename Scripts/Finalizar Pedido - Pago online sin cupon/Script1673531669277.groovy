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

not_run: Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Seleccion de primer direccion'
not_run: Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.view.ViewGroup - Selector de direccion'), 
    0)

'Banner comida'
Mobile.tap(findTestObject('Object Repository/Finalizar POS/android.view.ViewGroup - Banner comida'), 30)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Filtro pago online'
Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Pago Online'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Entrar en campo de busqueda'
Mobile.tap(findTestObject('Object Repository/Finalizar POS/android.widget.EditText - Buscar en todas las categoras'), 0)

'busqueda de comercio'
Mobile.setText(findTestObject('Object Repository/Finalizar POS/android.widget.EditText - Buscar en todas las categoras'), 'masapan' + '\\n', 
    0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'entra en el comercio'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Titulo Masapan'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Entra en el primer producto'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup - Primer Producto'), 0)

'Suma cantidad'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - SumaProducto'), 0)

'Agrega al carrito'
Mobile.tap(findTestObject('Finalizar con Cupon/android.widget.TextView - Agregar a carrito'), 0)

'Va al carrito'
Mobile.tap(findTestObject('Finalizar con Cupon/android.widget.TextView - Carrito (1)'), 0)

'Pago y facturacion'
Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Pago y Facturacin'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Abre selector de metodo pago'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup - Selector de pago'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Seleccion de tarjeta'
Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - BANCARD - CHECK - ENT. PRUEBA 1'), 
    0)

'obtiene monto total del finalize'
String extractFinalize = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total finalize sin cupon'), 
    0).replaceAll('[^0-9]', '')

'imprime monto finalize (solo numero)'
println(extractFinalize)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Finalizar'
Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Finalizar Orden'), 0)

'Verifica proceso de pago'
Mobile.getText(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Ya casi estamos, procesando pago'), 
    0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

'Verifica estado recibido'
Mobile.getText(findTestObject('Finalizar con Cupon/android.widget.TextView - Recibido Estado de Pedido'), 0)

'Verifica descripcion de pago online'
Mobile.getText(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Pago Online'), 0)

Mobile.scrollToText('CONTANOS', FailureHandling.STOP_ON_FAILURE)

'Verifica banner de calificacion'
Mobile.getText(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - CONTANOS TU EXPERIENCIA'), 
    0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'obtiene monto total en estado de pedido'
String extractEstado = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total estado de pedido'), 
    0).replaceAll('[^0-9]', '')

'imprime monto total estado (solo numero)'
println(extractEstado)

'validacion de monto en finalize y estado de pedido (exito)'
if (extractFinalize == extractEstado) {
    KeywordUtil.markPassed(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL ESTADO DE LA ORDEN:') + 
        ' ') + extractEstado) + ' ') + 'COINCIDEN')
} else {
    KeywordUtil.markFailedAndStop(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL ESTADO DE LA ORDEN:') + 
        ' ') + extractEstado) + ' ') + 'NO COINCIDEN')
}

Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup - Desplegar detalle de orden 2'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'obtiene monto total del detalle de orden de la cabecera'
String extractTotalDetalleCabecera = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total cabecera detalle 2'), 
    0).replaceAll('[^0-9]', '')

'imprime monto total del detalle de orden (solo numero)'
println(extractTotalDetalleCabecera)

'validacion de monto total y descuento en detalle de orden de la cabecera'
if (extractFinalize == extractTotalDetalleCabecera) {
    KeywordUtil.markPassed(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN EN CABECERA:') + 
        ' ') + extractTotalDetalleCabecera) + ' ') + 'COINCIDEN')
} else {
    KeywordUtil.markFailedAndStop(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN EN CABECERA:') + 
        ' ') + extractTotalDetalleCabecera) + ' ') + 'NO COINCIDEN')
}

'obtiene monto total del detalle de orden'
String extractTotalDetalle = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total detalle sin cupon 2'), 
    0).replaceAll('[^0-9]', '')

'imprime monto total del detalle de orden (solo numero)'
println(extractTotalDetalle)

'validacion de monto total y descuento en detalle de orden'
if (extractFinalize == extractTotalDetalle) {
    KeywordUtil.markPassed(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN:') + 
        ' ') + extractTotalDetalle) + ' ') + 'COINCIDEN')
} else {
    KeywordUtil.markFailedAndStop(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalize) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN:') + 
        ' ') + extractTotalDetalle) + ' ') + 'NO COINCIDEN')
}

'atras para volver al estado de la orden'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Ir atras'), 0)
