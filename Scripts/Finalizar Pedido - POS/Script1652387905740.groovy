import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Abre la app'
Mobile.startExistingApplication('com.artico.delivery.pedidos')

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'Selección de dirección'
not_run: Mobile.tap(findTestObject('Finalizar Efectivo/android.view.ViewGroup - SeleccionaDireccion'), 0)

'extrae titulo de la direccion en la home'
String DireccionHome = Mobile.getText(findTestObject('Object Repository/Login email/V4/android.widget.TextView - Direccion Home'), 0).replace("Enviar a ", "").replaceAll("\\s", "")

'imprime titulo de la direccion en la home'
println(DireccionHome)

'Click en banner comida'
Mobile.tap(findTestObject('Object Repository/Finalizar POS/android.view.ViewGroup - Banner comida'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Seleccionar filtro POS'
Mobile.tap(findTestObject('Finalizar POS/android.widget.TextView - Pago con POS'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Entrar en campo de busqueda'
Mobile.tap(findTestObject('Object Repository/Finalizar POS/android.widget.EditText - Buscar en todas las categoras'), 
    0)

'busqueda de comercio'
Mobile.setText(findTestObject('Object Repository/Finalizar POS/android.widget.EditText - Buscar en todas las categoras'), 
    'masapan' + '\\n', 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'entrar en comercio'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Titulo Masapan'), 0)

'Entra en el comercio'
not_run: Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Titulo Masapan'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Entra en el primer producto'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup - Primer Producto'), 0)

'suma cantidad de producto'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - SumaProducto'), 0)

'Agrega el producto'
Mobile.tap(findTestObject('Finalizar POS/android.widget.TextView - Agregar a carrito'), 0)

'Abrir carrito'
Mobile.tap(findTestObject('Finalizar POS/android.widget.TextView - Carrito (1)'), 0)

'extrae titulo de la direccion en el carrito'
String DireccionCarrito = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Direccion Carrito'), 0)

'imprime titulo de la direccion en el carrito'
println(DireccionCarrito)

'Pasar a pago y facturación'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Pago y Facturacin'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'extrae titulo de la direccion en el finalize'
String DireccionFinalize = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Direccion Finalize'), 0)

'imprime titulo de la direccion en el finalize'
println(DireccionFinalize)

'Abrir selector de método de pagos'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup - Selector de pago'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Seleccionar POS'
Mobile.tap(findTestObject('Finalizar POS/android.widget.TextView - Seleccionar Pago con POS'), 0)

'obtiene monto total del finalize'
String extractFinalize = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total finalize sin cupon'), 
    0).replaceAll('[^0-9]', '')

'imprime monto (solo numero)'
println(extractFinalize)

'Finalizar orden'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Finalizar Orden'), 0)

'Verifica proceso de pago'
Mobile.getText(findTestObject('Finalizar con Cupon/android.widget.TextView - Ya casi estamos, procesando pago'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'extrae titulo de la direccion en el estado del pedido'
String DireccionEstado = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Direccion Estado Pedido'), 0)

'imprime titulo de la direccion en el estado del pedido'
println(DireccionEstado)

'validacion de las direcciones'
if (DireccionHome == DireccionCarrito && DireccionHome == DireccionFinalize && DireccionHome == DireccionEstado) {
	KeywordUtil.markPassed('LA DIRECCION EN LA HOME:' + ' ' + DireccionHome + '\n' +
						'LA DIRECCION EN EL CARRITO:' + ' ' + DireccionCarrito + '\n' +
						'LA DIRECCION EN EL FINALIZE:' + ' ' + DireccionFinalize + '\n'  +
						'LA DIRECCION EN EL ESTADO DE PEDIDO:' + ' ' + DireccionEstado + ' '  + 'COINCIDEN')
} else {
	KeywordUtil.markFailedAndStop('UNA DE LAS SIGUIENTES DIRECCIONES NO COINCIDE:\n' +
						'DIRECCION EN LA HOME:' + ' ' + DireccionHome + '\n' +
						'DIRECCION EN EL CARRITO:' + ' ' + DireccionCarrito + '\n' +
						'DIRECCION EN EL FINALIZE:' + ' ' + DireccionFinalize + '\n'  +
						'DIRECCION EN EL ESTADO DE PEDIDO:' + ' ' + DireccionEstado)
}

'Verifica pedido finalizado'
Mobile.getText(findTestObject('Finalizar Efectivo/android.widget.TextView - Recibido'), 0)

Mobile.scrollToText('CONTANOS', FailureHandling.STOP_ON_FAILURE)

'verifica banner de calificacion'
Mobile.getText(findTestObject('Finalizar con Cupon/android.widget.TextView - CONTANOS TU EXPERIENCIA'), 0)

Mobile.getText(findTestObject('Finalizar POS/android.widget.TextView - Pago con POS'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

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

