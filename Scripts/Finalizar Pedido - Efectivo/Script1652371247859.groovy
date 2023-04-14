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
Mobile.tap(findTestObject('Object Repository/Buscador General/android.widget.EditText - Busca locales o productos'), 0)

Mobile.setText(findTestObject('Object Repository/Buscador General/android.widget.EditText - Busca locales o productos'), 'masapan' + 
    '\\n', 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Verifica resultado solo para santa fe'
Mobile.getText(findTestObject('Finalizar Efectivo/android.widget.TextView - Titulo Masapan'), 0)

'Entra en el comercio solo santa fe'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Titulo Masapan'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Entra en el primer producto'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup - Primer Producto'), 0)

'obtiene precio del producto antes de sumar'
String precioProductoAntes = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Precio dentro de producto'),
	0).replaceAll('[^0-9]', '')

'imprime precio producto antes (solo numero)'
println(precioProductoAntes)

'Suma la cantidad del producto +1'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - SumaProducto'), 0)

'obtiene precio del producto despues de sumar'
String precioProductoDespues = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Precio dentro de producto'),
	0).replaceAll('[^0-9]', '')

'imprime precio producto despues (solo numero)'
println(precioProductoDespues)

'calculo de sumar producto'
int calculoSumarProdcuto = (precioProductoAntes.toInteger() * 2)

'imprime calculo de sumar producto'
println(calculoSumarProdcuto)

'validacion de sumar producto dentro del detalle de producto'
if (precioProductoDespues == calculoSumarProdcuto.toString()) {
	KeywordUtil.markPassed(((((((('EL CALCULO DE SUMAR PRODUCTO:' + ' ') + calculoSumarProdcuto.toString()) + ' ') +
		'Y EL MONTO SUMADO:') + ' ') + precioProductoDespues) + ' ') + 'COINCIDEN')
} else {
	KeywordUtil.markFailedAndStop(((((((('EL CALCULO DE SUMAR PRODUCTO:' + ' ') + calculoSumarProdcuto.toString()) + ' ') +
		'Y EL MONTO SUMADO:') + ' ') + precioProductoDespues) + ' ') + 'NO COINCIDEN')
}

'Agregar al carrito'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Agregar a carrito'), 0)

'Abrir carrito'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Carrito (1)'), 0)

'obtiene subtotal carrito antes de sumar'
String SubtotalAntes = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Subtotal carrito'),
	0).replaceAll('[^0-9]', '')

'imprime subtotal carrito antes (solo numero)'
println(SubtotalAntes)

'obtiene total carrito antes de sumar'
String TotalAntes = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total carrito'),
	0).replaceAll('[^0-9]', '')

'imprime total carrito antes (solo numero)'
println(TotalAntes)

'Suma la cantidad del producto en el carrito +1'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Suma carrito'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'obtiene subtotal carrito despues de sumar'
String SubtotalSuma = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Subtotal carrito'),
	0).replaceAll('[^0-9]', '')

'imprime subtotal carrito despues (solo numero)'
println(SubtotalSuma)

'obtiene total carrito despues de sumar'
String TotalSuma = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total carrito'),
	0).replaceAll('[^0-9]', '')

'imprime total carrito despues (solo numero)'
println(TotalSuma)

'calculo de sumar subtotal carrito'
int calculoSumarSubtotalCarrito = (SubtotalAntes.toInteger() + precioProductoAntes.toInteger())

'imprime calculo de sumar subtotal carrito'
println(calculoSumarSubtotalCarrito)

'calculo de sumar total carrito'
int calculoSumarTotalCarrito = (TotalAntes.toInteger() + precioProductoAntes.toInteger())

'imprime calculo de sumar total carrito'
println(calculoSumarTotalCarrito)

'validacion de sumar subtotal en el carrito'
if (SubtotalSuma == calculoSumarSubtotalCarrito.toString()) {
	KeywordUtil.markPassed(((((((('EL CALCULO DE SUMAR SUBTOTAL EN EL CARRITO:' + ' ') + calculoSumarSubtotalCarrito.toString()) + ' ') +
		'Y EL MONTO SUMADO:') + ' ') + SubtotalSuma) + ' ') + 'COINCIDEN')
} else {
	KeywordUtil.markFailedAndStop(((((((('EL CALCULO DE SUMAR SUBTOTAL EN EL CARRITO:' + ' ') + calculoSumarSubtotalCarrito.toString()) + ' ') +
		'Y EL MONTO SUMADO:') + ' ') + SubtotalSuma) + ' ') + 'NO COINCIDEN')
}

'validacion de sumar total en el carrito'
if (TotalSuma == calculoSumarTotalCarrito.toString()) {
	KeywordUtil.markPassed(((((((('EL CALCULO DE SUMAR TOTAL EN EL CARRITO:' + ' ') + calculoSumarTotalCarrito.toString()) + ' ') +
		'Y EL MONTO SUMADO:') + ' ') + TotalSuma) + ' ') + 'COINCIDEN')
} else {
	KeywordUtil.markFailedAndStop(((((((('EL CALCULO DE SUMAR TOTAL EN EL CARRITO:' + ' ') + calculoSumarTotalCarrito.toString()) + ' ') +
		'Y EL MONTO SUMADO:') + ' ') + TotalSuma) + ' ') + 'NO COINCIDEN')
}

'Resta la cantidad del producto en el carrito -1'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Resta carrito'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'obtiene subtotal carrito despues de restar'
String SubtotalResta = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Subtotal carrito'),
	0).replaceAll('[^0-9]', '')

'imprime subtotal carrito despues (solo numero)'
println(SubtotalResta)

'obtiene total carrito despues de restar'
String TotalResta = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total carrito'),
	0).replaceAll('[^0-9]', '')

'imprime total carrito despues (solo numero)'
println(TotalResta)

'calculo de restar subtotal carrito'
int calculoRestarSubtotalCarrito = (SubtotalSuma.toInteger() - precioProductoAntes.toInteger())

'imprime calculo de restar subtotal carrito'
println(calculoRestarSubtotalCarrito)

'calculo de restar total carrito'
int calculoRestarTotalCarrito = (TotalSuma.toInteger() - precioProductoAntes.toInteger())

'imprime calculo de restar total carrito'
println(calculoRestarTotalCarrito)

'validacion de restar subtotal en el carrito'
if (SubtotalResta == calculoRestarSubtotalCarrito.toString()) {
	KeywordUtil.markPassed(((((((('EL CALCULO DE RESTAR SUBTOTAL EN EL CARRITO:' + ' ') + calculoRestarSubtotalCarrito.toString()) + ' ') +
		'Y EL MONTO RESTADO:') + ' ') + SubtotalResta) + ' ') + 'COINCIDEN')
} else {
	KeywordUtil.markFailedAndStop(((((((('EL CALCULO DE RESTAR SUBTOTAL EN EL CARRITO:' + ' ') + calculoRestarSubtotalCarrito.toString()) + ' ') +
		'Y EL MONTO RESTADO:') + ' ') + SubtotalResta) + ' ') + 'NO COINCIDEN')
}

'validacion de restar total en el carrito'
if (TotalResta == calculoRestarTotalCarrito.toString()) {
	KeywordUtil.markPassed(((((((('EL CALCULO DE RESTAR TOTAL EN EL CARRITO:' + ' ') + calculoRestarTotalCarrito.toString()) + ' ') +
		'Y EL MONTO RESTADO:') + ' ') + TotalResta) + ' ') + 'COINCIDEN')
} else {
	KeywordUtil.markFailedAndStop(((((((('EL CALCULO DE RESTAR TOTAL EN EL CARRITO:' + ' ') + calculoRestarTotalCarrito.toString()) + ' ') +
		'Y EL MONTO RESTADO:') + ' ') + TotalResta) + ' ') + 'NO COINCIDEN')
}

'Pasar a pago y facturación'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Pago y Facturacin'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Abrir selector de método de pagos'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup - Selector de pago'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Seleccionar Efectivo'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Efectivo'), 0)

'obtiene monto total del finalize'
String extractFinalize = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total finalize sin cupon'), 
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

